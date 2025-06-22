package dev.shiftsad.capag.entities;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}