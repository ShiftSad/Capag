package dev.shiftsad.capag.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "UF", length = 2, nullable = false)
    private String uf;

    @Column(name = "COD_UF", length = 2, nullable = false)
    private String codUf;

    @Column(name = "COD_MUNICIPIO", length = 5)
    private String codMunicipio;

    @Column(name = "MUNICIPIO", nullable = false)
    private String municipio;

    @Column(name = "POPULACAO", nullable = false)
    private Integer populacao;

    @Column(name = "ANO", nullable = false)
    private Integer ano;
}