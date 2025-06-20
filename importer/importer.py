import time

import pandas as pd
import psycopg2
from psycopg2.extras import execute_values

ibge_path = "ibge-pop.csv"
capag_path = "capag.csv"
startTime = time.time()

def connect_database():
    conn = psycopg2.connect(
        dbname="postgres",
        user="postgres",
        password="password",
        host="localhost"
    )
    return conn

def import_ibge(conn):
    df = pd.read_csv(
        ibge_path,
        sep=",",
        encoding="utf-8",
        dtype={"COD. UF": str, "COD. MUNIC": str},
        thousands="."
    )

    df = df.loc[:, ~df.columns.str.startswith("Unnamed:")]

    df["POP_ESTIMADA"] = (
        df["POPULAÇÃO ESTIMADA"]
        .astype(str)
        .str.replace(".", "", regex=False)
        .astype(int)
    )

    df["COD. UF"] = df["COD. UF"].str.zfill(2)
    df["COD. MUNIC"] = df["COD. MUNIC"].str.zfill(5)

    df = df.drop_duplicates(subset=["COD. MUNIC"], keep="first")
    df = df[df["POP_ESTIMADA"].notnull()]

    tuples = [
        (r.UF, r["COD. UF"], r["COD. MUNIC"], r["NOME DO MUNICÍPIO"],
         r.POP_ESTIMADA, 2024)
        for _, r in df.iterrows()
    ]

    with conn.cursor() as cur:
        cur.execute("TRUNCATE TABLE public.ibge_population;")
        execute_values(
            cur,
            """
            INSERT INTO public.ibge_population
              (uf, cod_uf, cod_municipio, municipio, populacao, ano)
            VALUES %s
            """,
            tuples,
            page_size=1000
        )
    conn.commit()

def import_capag(conn):
    df = pd.read_csv(
        capag_path,
        sep=",",
        encoding="utf-8",
        dtype={"Código Município Completo": str},
        decimal=",",
        quotechar='"'
    )
    df["Código Município Completo"] = df["Código Município Completo"].astype(str).str.zfill(7)

    tuples = []
    for _, r in df.iterrows():
        tuples.append((
            r["Código Município Completo"],
            r["Nome_Município"] if pd.notna(r["Nome_Município"]) else None,
            r["UF"] if pd.notna(r["UF"]) else None,
            r["CAPAG"] if pd.notna(r["CAPAG"]) else None,
            r["Indicador 1"] if pd.notna(r["Indicador 1"]) else None,
            r["Nota 1"] if pd.notna(r["Nota 1"]) else None,
            r["Indicador 2"] if pd.notna(r["Indicador 2"]) else None,
            r["Nota 2"] if pd.notna(r["Nota 2"]) else None,
            r["Indicador 3"] if pd.notna(r["Indicador 3"]) else None,
            r["Nota 3"] if pd.notna(r["Nota 3"]) else None,
            r["ICF"] if pd.notna(r["ICF"]) else None,
            r["Observação"] if pd.notna(r["Observação"]) else None,
            r["Origem da Nota Final"] if pd.notna(r["Origem da Nota Final"]) else None,
            r["Possui DCA 2024?"] if pd.notna(r["Possui DCA 2024?"]) else None,
            r["Indicador 3 Antigo"] if pd.notna(r["Indicador 3 Antigo"]) else None,
            r["Possui DCA 2023?"] if pd.notna(r["Possui DCA 2023?"]) else None,
            r["CAPAG rebaixada"] if pd.notna(r["CAPAG rebaixada"]) else None,
            r["Dedução Negativa"] if pd.notna(r["Dedução Negativa"]) else None,
            r["DCB zerada ou negativa"] if pd.notna(r["DCB zerada ou negativa"]) else None,
            r["OF negativa"] if pd.notna(r["OF negativa"]) else None,
            r["Publicou RGF"] if pd.notna(r["Publicou RGF"]) else None,
            r["Publicou RREO"] if pd.notna(r["Publicou RREO"]) else None
        ))

    with conn.cursor() as cur:
        cur.execute("TRUNCATE TABLE public.municipio_indicadores;")
        execute_values(
            cur,
            """
            INSERT INTO public.municipio_indicadores
              (codigo_municipio_completo, nome_municipio, uf, capag, 
              indicador_1, nota_1, indicador_2, nota_2, indicador_3, nota_3,
              icf, observacao, origem_nota_final, possui_dca_2024, 
              indicador_3_antigo, possui_dca_2023, capag_rebaixada, 
              deducao_negativa, dcb_zerada_ou_negativa, of_negativa, 
              publicou_rgf, publicou_rreo)
            VALUES %s
            """,
            tuples,
            page_size=1000
        )
    conn.commit()


if __name__ == "__main__":
    conn = connect_database()
    try:
        import_ibge(conn)
        import_capag(conn)
    finally:
        conn.close()
        print(f"Import completo em {time.time() - startTime:.2f} segundos.")