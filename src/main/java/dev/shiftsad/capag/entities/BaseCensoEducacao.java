package dev.shiftsad.capag.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate; // For date fields

@MappedSuperclass
@Data
@NoArgsConstructor
@SuperBuilder
public abstract class BaseCensoEducacao {

    // Shared identifying information
    @Column(name = "nu_ano_censo", nullable = false)
    private Integer nuAnoCenso; // NU_ANO_CENSO

    @Column(name = "no_regiao", length = 100, nullable = false)
    private String noRegiao; // NO_REGIAO

    @Column(name = "co_regiao", nullable = false)
    private Integer coRegiao; // CO_REGIAO

    @Column(name = "no_uf", length = 100, nullable = false)
    private String noUf; // NO_UF

    @Column(name = "sg_uf", length = 2, nullable = false)
    private String sgUf; // SG_UF

    @Column(name = "co_uf", nullable = false)
    private Integer coUf; // CO_UF

    @Column(name = "no_municipio", length = 200, nullable = false)
    private String noMunicipio; // NO_MUNICIPIO

    @Column(name = "co_municipio", nullable = false)
    private Long coMunicipio; // CO_MUNICIPIO

    @Column(name = "no_entidade", length = 255)
    private String noEntidade; // NO_ENTIDADE

    @Column(name = "co_entidade", nullable = false)
    private Long coEntidade; // CO_ENTIDADE (This is often the school ID)

    @Column(name = "tp_dependencia")
    private Integer tpDependencia; // TP_DEPENDENCIA

    @Column(name = "tp_localizacao")
    private Integer tpLocalizacao; // TP_LOCALIZACAO

    @Column(name = "tp_localizacao_diferenciada")
    private Integer tpLocalizacaoDiferenciada; // TP_LOCALIZACAO_DIFERENCIADA

    // New shared fields from the larger dataset that are logical for a base school entity
    @Column(name = "no_regiao_geog_interm", length = 100)
    private String noRegiaoGeogInterm; // NO_REGIAO_GEOG_INTERM

    @Column(name = "co_regiao_geog_interm")
    private Integer coRegiaoGeogInterm; // CO_REGIAO_GEOG_INTERM

    @Column(name = "no_regiao_geog_imed", length = 100)
    private String noRegiaoGeogImed; // NO_REGIAO_GEOG_IMED

    @Column(name = "co_regiao_geog_imed")
    private Integer coRegiaoGeogImed; // CO_REGIAO_GEOG_IMED

    @Column(name = "no_mesorregiao", length = 100)
    private String noMesorregiao; // NO_MESORREGIAO

    @Column(name = "co_mesorregiao")
    private Integer coMesorregiao; // CO_MESORREGIAO

    @Column(name = "no_microrregiao", length = 100)
    private String noMicrorregiao; // NO_MICRORREGIAO

    @Column(name = "co_microrregiao")
    private Integer coMicrorregiao; // CO_MICRORREGIAO

    @Column(name = "no_distrito", length = 200)
    private String noDistrito; // NO_DISTRITO

    @Column(name = "co_distrito")
    private Long coDistrito; // CO_DISTRITO
}