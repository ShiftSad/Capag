CREATE TABLE IF NOT EXISTS ibge_population (
    UF CHAR(2) NOT NULL,
    COD_UF CHAR(2) NOT NULL,
    COD_MUNICIPIO CHAR(5) NOT NULL,
    MUNICIPIO VARCHAR(255) NOT NULL,
    POPULACAO INT NOT NULL,
    ANO INT NOT NULL,
    PRIMARY KEY (COD_MUNICIPIO)
);

CREATE TABLE IF NOT EXISTS municipio_indicadores (
    codigo_municipio_completo CHAR(7) PRIMARY KEY,
    nome_municipio VARCHAR(255) NOT NULL,
    uf CHAR(2) NOT NULL,
    capag VARCHAR(10),
    indicador_1 VARCHAR(50),
    nota_1 VARCHAR(10),
    indicador_2 VARCHAR(50),
    nota_2 VARCHAR(10),
    indicador_3 VARCHAR(50),
    nota_3 VARCHAR(10),
    icf VARCHAR(10),
    observacao TEXT,
    origem_nota_final VARCHAR(255),
    possui_dca_2024 VARCHAR(50),
    indicador_3_antigo VARCHAR(50),
    possui_dca_2023 VARCHAR(50),
    capag_rebaixada VARCHAR(50),
    deducao_negativa VARCHAR(50),
    dcb_zerada_ou_negativa VARCHAR(50),
    of_negativa VARCHAR(50),
    publicou_rgf VARCHAR(50),
    publicou_rreo VARCHAR(50)
);

