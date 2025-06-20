package dev.shiftsad.capag.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "municipio_indicadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capag {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo_municipio_completo", length = 7)
    private String codigoMunicipioCompleto;

    @Column(name = "nome_municipio", nullable = false)
    private String nomeMunicipio;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @Column(name = "capag", length = 10)
    private String capag;

    @Column(name = "indicador_1", length = 50)
    private String indicador1;

    @Column(name = "nota_1", length = 10)
    private String nota1;

    @Column(name = "indicador_2", length = 50)
    private String indicador2;

    @Column(name = "nota_2", length = 10)
    private String nota2;

    @Column(name = "indicador_3", length = 50)
    private String indicador3;

    @Column(name = "nota_3", length = 10)
    private String nota3;

    @Column(name = "icf", length = 10)
    private String icf;

    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;

    @Column(name = "origem_nota_final")
    private String origemNotaFinal;

    @Column(name = "possui_dca_2024", length = 50)
    private String possuiDca2024;

    @Column(name = "indicador_3_antigo", length = 50)
    private String indicador3Antigo;

    @Column(name = "possui_dca_2023", length = 50)
    private String possuiDca2023;

    @Column(name = "capag_rebaixada", length = 50)
    private String capagRebaixada;

    @Column(name = "deducao_negativa", length = 50)
    private String deducaoNegativa;

    @Column(name = "dcb_zerada_ou_negativa", length = 50)
    private String dcbZeradaOuNegativa;

    @Column(name = "of_negativa", length = 50)
    private String ofNegativa;

    @Column(name = "publicou_rgf", length = 50)
    private String publicouRgf;

    @Column(name = "publicou_rreo", length = 50)
    private String publicouRreo;
}