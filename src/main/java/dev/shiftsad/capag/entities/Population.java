package dev.shiftsad.capag.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ibge_population")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Population {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "COD_MUNICIPIO", length = 5)
    private String codMunicipio;

    @Column(name = "UF", length = 2, nullable = false)
    private String uf;

    @Column(name = "COD_UF", length = 2, nullable = false)
    private String codUf;

    @Column(name = "MUNICIPIO", length = 255, nullable = false)
    private String municipio;

    @Column(name = "POPULACAO", nullable = false)
    private Integer populacao;

    @Column(name = "ANO", nullable = false)
    private Integer ano;
}