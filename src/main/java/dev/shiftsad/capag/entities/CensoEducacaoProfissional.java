package dev.shiftsad.capag.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "censo_educacao_profissional")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CensoEducacaoProfissional extends BaseCensoEducacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no_area_curso_profissional", length = 255)
    private String noAreaCursoProfissional; // NO_AREA_CURSO_PROFISSIONAL

    @Column(name = "id_area_curso_profissional")
    private Integer idAreaCursoProfissional; // ID_AREA_CURSO_PROFISSIONAL

    @Column(name = "no_curso_educ_profissional", length = 255)
    private String noCursoEducProfissional; // NO_CURSO_EDUC_PROFISSIONAL

    @Column(name = "co_curso_educ_profissional")
    private Long coCursoEducProfissional; // CO_CURSO_EDUC_PROFISSIONAL

    @Column(name = "qt_curso_tec")
    private Integer qtCursoTec; // QT_CURSO_TEC

    @Column(name = "qt_mat_curso_tec")
    private Integer qtMatCursoTec; // QT_MAT_CURSO_TEC

    @Column(name = "qt_curso_tec_ct")
    private Integer qtCursoTecCt; // QT_CURSO_TEC_CT (Concomitant Technical)

    @Column(name = "qt_mat_curso_tec_ct")
    private Integer qtMatCursoTecCt; // QT_MAT_CURSO_TEC_CT

    @Column(name = "qt_curso_tec_nm")
    private Integer qtCursoTecNm; // QT_CURSO_TEC_NM (New High School)

    @Column(name = "qt_mat_curso_tec_nm")
    private Integer qtMatCursoTecNm; // QT_MAT_CURSO_TEC_NM

    @Column(name = "qt_curso_tec_conc")
    private Integer qtCursoTecConc; // QT_CURSO_TEC_CONC (Concomitant)

    @Column(name = "qt_mat_curso_tec_conc")
    private Integer qtMatCursoTecConc; // QT_MAT_CURSO_TEC_CONC

    @Column(name = "qt_curso_tec_subs")
    private Integer qtCursoTecSubs; // QT_CURSO_TEC_SUBS (Subsequent)

    @Column(name = "qt_mat_tec_subs")
    private Integer qtMatTecSubs; // QT_MAT_TEC_SUBS

    @Column(name = "qt_curso_tec_eja")
    private Integer qtCursoTecEja; // QT_CURSO_TEC_EJA (EJA Technical)

    @Column(name = "qt_mat_tec_eja")
    private Integer qtMatTecEja; // QT_MAT_TEC_EJA
}