package dev.shiftsad.capag.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate; // For date fields

@Entity
@Table(name = "censo_educacao_completo")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CensoEducacaoCompleto extends BaseCensoEducacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for this specific entity table

    // General School Information
    @Column(name = "tp_categoria_escola_privada")
    private Integer tpCategoriaEscolaPrivada; // TP_CATEGORIA_ESCOLA_PRIVADA

    @Column(name = "ds_endereco", length = 500)
    private String dsEndereco; // DS_ENDERECO

    @Column(name = "nu_endereco", length = 50)
    private String nuEndereco; // NU_ENDERECO (Can be string if contains alphanumeric)

    @Column(name = "ds_complemento", length = 255)
    private String dsComplemento; // DS_COMPLEMENTO

    @Column(name = "no_bairro", length = 200)
    private String noBairro; // NO_BAIRRO

    @Column(name = "co_cep", length = 9) // E.g., XXXXX-XXX
    private String coCep; // CO_CEP

    @Column(name = "nu_ddd", length = 2)
    private String nuDdd; // NU_DDD

    @Column(name = "nu_telefone", length = 9)
    private String nuTelefone; // NU_TELEFONE

    @Column(name = "tp_situacao_funcionamento")
    private Integer tpSituacaoFuncionamento; // TP_SITUACAO_FUNCIONAMENTO

    @Column(name = "co_orgao_regional")
    private Long coOrgaoRegional; // CO_ORGAO_REGIONAL

    @Column(name = "dt_ano_letivo_inicio")
    private LocalDate dtAnoLetivoInicio; // DT_ANO_LETIVO_INICIO

    @Column(name = "dt_ano_letivo_termino")
    private LocalDate dtAnoLetivoTermino; // DT_ANO_LETIVO_TERMINO

    // Affiliation/Partnership Indicators
    @Column(name = "in_vinculo_secretaria_educacao")
    private Boolean inVinculoSecretariaEducacao; // IN_VINCULO_SECRETARIA_EDUCACAO

    @Column(name = "in_vinculo_seguranca_publica")
    private Boolean inVinculoSegurancaPublica; // IN_VINCULO_SEGURANCA_PUBLICA

    @Column(name = "in_vinculo_secretaria_saude")
    private Boolean inVinculoSecretariaSaude; // IN_VINCULO_SECRETARIA_SAUDE

    @Column(name = "in_vinculo_outro_orgao")
    private Boolean inVinculoOutroOrgao; // IN_VINCULO_OUTRO_ORGAO

    @Column(name = "in_poder_publico_parceria")
    private Boolean inPoderPublicoParceria; // IN_PODER_PUBLICO_PARCERIA

    @Column(name = "tp_poder_publico_parceria")
    private Integer tpPoderPublicoParceria; // TP_PODER_PUBLICO_PARCERIA

    // Partnership Forms (Federal)
    @Column(name = "in_forma_cont_termo_colabora")
    private Boolean inFormaContTermoColabora; // IN_FORMA_CONT_TERMO_COLABORA

    @Column(name = "in_forma_cont_termo_fomento")
    private Boolean inFormaContTermoFomento; // IN_FORMA_CONT_TERMO_FOMENTO

    @Column(name = "in_forma_cont_acordo_coop")
    private Boolean inFormaContAcordoCoop; // IN_FORMA_CONT_ACORDO_COOP

    @Column(name = "in_forma_cont_prestacao_serv")
    private Boolean inFormaContPrestacaoServ; // IN_FORMA_CONT_PRESTACAO_SERV

    @Column(name = "in_forma_cont_coop_tec_fin")
    private Boolean inFormaContCoopTecFin; // IN_FORMA_CONT_COOP_TEC_FIN

    @Column(name = "in_forma_cont_consorcio_pub")
    private Boolean inFormaContConsorcioPub; // IN_FORMA_CONT_CONSORCIO_PUB

    // Partnership Forms (Municipal)
    @Column(name = "in_forma_cont_mu_termo_colab")
    private Boolean inFormaContMuTermoColab; // IN_FORMA_CONT_MU_TERMO_COLAB

    @Column(name = "in_forma_cont_mu_termo_fomento")
    private Boolean inFormaContMuTermoFomento; // IN_FORMA_CONT_MU_TERMO_FOMENTO

    @Column(name = "in_forma_cont_mu_acordo_coop")
    private Boolean inFormaContMuAcordoCoop; // IN_FORMA_CONT_MU_ACORDO_COOP

    @Column(name = "in_forma_cont_mu_prest_serv")
    private Boolean inFormaContMuPrestServ; // IN_FORMA_CONT_MU_PREST_SERV

    @Column(name = "in_forma_cont_mu_coop_tec_fin")
    private Boolean inFormaContMuCoopTecFin; // IN_FORMA_CONT_MU_COOP_TEC_FIN

    @Column(name = "in_forma_cont_mu_consorcio_pub")
    private Boolean inFormaContMuConsorcioPub; // IN_FORMA_CONT_MU_CONSORCIO_PUB

    // Partnership Forms (State)
    @Column(name = "in_forma_cont_es_termo_colab")
    private Boolean inFormaContEsTermoColab; // IN_FORMA_CONT_ES_TERMO_COLAB

    @Column(name = "in_forma_cont_es_termo_fomento")
    private Boolean inFormaContEsTermoFomento; // IN_FORMA_CONT_ES_TERMO_FOMENTO

    @Column(name = "in_forma_cont_es_acordo_coop")
    private Boolean inFormaContEsAcordoCoop; // IN_FORMA_CONT_ES_ACORDO_COOP

    @Column(name = "in_forma_cont_es_prest_serv")
    private Boolean inFormaContEsPrestServ; // IN_FORMA_CONT_ES_PREST_SERV

    @Column(name = "in_forma_cont_es_coop_tec_fin")
    private Boolean inFormaContEsCoopTecFin; // IN_FORMA_CONT_ES_COOP_TEC_FIN

    @Column(name = "in_forma_cont_es_consorcio_pub")
    private Boolean inFormaContEsConsorcioPub; // IN_FORMA_CONT_ES_CONSORCIO_PUB

    // Private School Maintainer
    @Column(name = "in_mant_escola_privada_emp")
    private Boolean inMantEscolaPrivadaEmp; // IN_MANT_ESCOLA_PRIVADA_EMP

    @Column(name = "in_mant_escola_privada_ong")
    private Boolean inMantEscolaPrivadaOng; // IN_MANT_ESCOLA_PRIVADA_ONG

    @Column(name = "in_mant_escola_privada_oscip")
    private Boolean inMantEscolaPrivadaOscip; // IN_MANT_ESCOLA_PRIVADA_OSCIP

    @Column(name = "in_mant_escola_priv_ong_oscip")
    private Boolean inMantEscolaPrivOngOscip; // IN_MANT_ESCOLA_PRIV_ONG_OSCIP

    @Column(name = "in_mant_escola_privada_sind")
    private Boolean inMantEscolaPrivadaSind; // IN_MANT_ESCOLA_PRIVADA_SIND

    @Column(name = "in_mant_escola_privada_sist_s")
    private Boolean inMantEscolaPrivadaSistS; // IN_MANT_ESCOLA_PRIVADA_SIST_S

    @Column(name = "in_mant_escola_privada_s_fins")
    private Boolean inMantEscolaPrivadaSFins; // IN_MANT_ESCOLA_PRIVADA_S_FINS

    @Column(name = "nu_cnpj_escola_privada", length = 14)
    private String nuCnpjEscolaPrivada; // NU_CNPJ_ESCOLA_PRIVADA

    @Column(name = "nu_cnpj_mantenedora", length = 14)
    private String nuCnpjMantenedora; // NU_CNPJ_MANTENEDORA

    @Column(name = "tp_regulamentacao")
    private Integer tpRegulamentacao; // TP_REGULAMENTACAO

    @Column(name = "tp_responsavel_regulamentacao")
    private Integer tpResponsavelRegulamentacao; // TP_RESPONSAVEL_REGULAMENTACAO

    @Column(name = "co_escola_sede_vinculada")
    private Long coEscolaSedeVinculada; // CO_ESCOLA_SEDE_VINCULADA

    @Column(name = "co_ies_ofertante")
    private Long coIesOfertante; // CO_IES_OFERTANTE

    // Location/Premises Information
    @Column(name = "in_local_func_predio_escolar")
    private Boolean inLocalFuncPredioEscolar; // IN_LOCAL_FUNC_PREDIO_ESCOLAR

    @Column(name = "tp_ocupacao_predio_escolar")
    private Integer tpOcupacaoPredioEscolar; // TP_OCUPACAO_PREDIO_ESCOLAR

    @Column(name = "in_local_func_socioeducativo")
    private Boolean inLocalFuncSocioeducativo; // IN_LOCAL_FUNC_SOCIOEDUCATIVO

    @Column(name = "in_local_func_unid_prisional")
    private Boolean inLocalFuncUnidPrisional; // IN_LOCAL_FUNC_UNID_PRISIONAL

    @Column(name = "in_local_func_prisional_socio")
    private Boolean inLocalFuncPrisionalSocio; // IN_LOCAL_FUNC_PRISIONAL_SOCIO

    @Column(name = "in_local_func_galpao")
    private Boolean inLocalFuncGalpao; // IN_LOCAL_FUNC_GALPAO

    @Column(name = "tp_ocupacao_galpao")
    private Integer tpOcupacaoGalpao; // TP_OCUPACAO_GALPAO

    @Column(name = "in_local_func_salas_outra_esc")
    private Boolean inLocalFuncSalasOutraEsc; // IN_LOCAL_FUNC_SALAS_OUTRA_ESC

    @Column(name = "in_local_func_outros")
    private Boolean inLocalFuncOutros; // IN_LOCAL_FUNC_OUTROS

    @Column(name = "in_predio_compartilhado")
    private Boolean inPredioCompartilhado; // IN_PREDIO_COMPARTILHADO

    // Infrastructure: Water
    @Column(name = "in_agua_potavel")
    private Boolean inAguaPotavel; // IN_AGUA_POTAVEL

    @Column(name = "in_agua_rede_publica")
    private Boolean inAguaRedePublica; // IN_AGUA_REDE_PUBLICA

    @Column(name = "in_agua_poco_artesiano")
    private Boolean inAguaPocoArtesiano; // IN_AGUA_POCO_ARTESIANO

    @Column(name = "in_agua_cacimba")
    private Boolean inAguaCacimba; // IN_AGUA_CACIMBA

    @Column(name = "in_agua_fonte_rio")
    private Boolean inAguaFonteRio; // IN_AGUA_FONTE_RIO

    @Column(name = "in_agua_inexistente")
    private Boolean inAguaInexistente; // IN_AGUA_INEXISTENTE

    @Column(name = "in_agua_carro_pipa")
    private Boolean inAguaCarroPipa; // IN_AGUA_CARRO_PIPA

    // Infrastructure: Energy
    @Column(name = "in_energia_rede_publica")
    private Boolean inEnergiaRedePublica; // IN_ENERGIA_REDE_PUBLICA

    @Column(name = "in_energia_gerador_fossil")
    private Boolean inEnergiaGeradorFossil; // IN_ENERGIA_GERADOR_FOSSIL

    @Column(name = "in_energia_renovavel")
    private Boolean inEnergiaRenovavel; // IN_ENERGIA_RENOVAVEL

    @Column(name = "in_energia_inexistente")
    private Boolean inEnergiaInexistente; // IN_ENERGIA_INEXISTENTE

    // Infrastructure: Sewage
    @Column(name = "in_esgoto_rede_publica")
    private Boolean inEsgotoRedePublica; // IN_ESGOTO_REDE_PUBLICA

    @Column(name = "in_esgoto_fossa_septica")
    private Boolean inEsgotoFossaSeptica; // IN_ESGOTO_FOSSA_SEPTICA

    @Column(name = "in_esgoto_fossa_comum")
    private Boolean inEsgotoFossaComum; // IN_ESGOTO_FOSSA_COMUM

    @Column(name = "in_esgoto_fossa") // This field name looks redundant if others are specific
    private Boolean inEsgotoFossa; // IN_ESGOTO_FOSSA

    @Column(name = "in_esgoto_inexistente")
    private Boolean inEsgotoInexistente; // IN_ESGOTO_INEXISTENTE

    // Infrastructure: Waste
    @Column(name = "in_lixo_servico_coleta")
    private Boolean inLixoServicoColeta; // IN_LIXO_SERVICO_COLETA

    @Column(name = "in_lixo_queima")
    private Boolean inLixoQueima; // IN_LIXO_QUEIMA

    @Column(name = "in_lixo_enterra")
    private Boolean inLixoEnterra; // IN_LIXO_ENTERRA

    @Column(name = "in_lixo_destino_final_publico")
    private Boolean inLixoDestinoFinalPublico; // IN_LIXO_DESTINO_FINAL_PUBLICO

    @Column(name = "in_lixo_descarta_outra_area")
    private Boolean inLixoDescartaOutraArea; // IN_LIXO_DESCARTA_OUTRA_AREA

    @Column(name = "in_tratamento_lixo_separacao")
    private Boolean inTratamentoLixoSeparacao; // IN_TRATAMENTO_LIXO_SEPARACAO

    @Column(name = "in_tratamento_lixo_reutiliza")
    private Boolean inTratamentoLixoReutiliza; // IN_TRATAMENTO_LIXO_REUTILIZA

    @Column(name = "in_tratamento_lixo_reciclagem")
    private Boolean inTratamentoLixoReciclagem; // IN_TRATAMENTO_LIXO_RECICLAGEM

    @Column(name = "in_tratamento_lixo_inexistente")
    private Boolean inTratamentoLixoInexistente; // IN_TRATAMENTO_LIXO_INEXISTENTE

    // Facilities and Rooms
    @Column(name = "in_almoxarifado")
    private Boolean inAlmoxarifado; // IN_ALMOXARIFADO

    @Column(name = "in_area_verde")
    private Boolean inAreaVerde; // IN_AREA_VERDE

    @Column(name = "in_area_plantio")
    private Boolean inAreaPlantio; // IN_AREA_PLANTIO

    @Column(name = "in_auditorio")
    private Boolean inAuditorio; // IN_AUDITORIO

    @Column(name = "in_banheiro")
    private Boolean inBanheiro; // IN_BANHEIRO

    @Column(name = "in_banheiro_ei")
    private Boolean inBanheiroEi; // IN_BANHEIRO_EI (Early Childhood Education)

    @Column(name = "in_banheiro_pne")
    private Boolean inBanheiroPne; // IN_BANHEIRO_PNE (People with Special Needs)

    @Column(name = "in_banheiro_funcionarios")
    private Boolean inBanheiroFuncionarios; // IN_BANHEIRO_FUNCIONARIOS

    @Column(name = "in_banheiro_chuveiro")
    private Boolean inBanheiroChuveiro; // IN_BANHEIRO_CHUVEIRO

    @Column(name = "in_biblioteca")
    private Boolean inBiblioteca; // IN_BIBLIOTECA

    @Column(name = "in_biblioteca_sala_leitura")
    private Boolean inBibliotecaSalaLeitura; // IN_BIBLIOTECA_SALA_LEITURA

    @Column(name = "in_cozinha")
    private Boolean inCozinha; // IN_COZINHA

    @Column(name = "in_despensa")
    private Boolean inDespensa; // IN_DESPENSA

    @Column(name = "in_dormitorio_aluno")
    private Boolean inDormitorioAluno; // IN_DORMITORIO_ALUNO

    @Column(name = "in_dormitorio_professor")
    private Boolean inDormitorioProfessor; // IN_DORMITORIO_PROFESSOR

    @Column(name = "in_laboratorio_ciencias")
    private Boolean inLaboratorioCiencias; // IN_LABORATORIO_CIENCIAS

    @Column(name = "in_laboratorio_informatica")
    private Boolean inLaboratorioInformatica; // IN_LABORATORIO_INFORMATICA

    @Column(name = "in_laboratorio_educ_prof")
    private Boolean inLaboratorioEducProf; // IN_LABORATORIO_EDUC_PROF

    @Column(name = "in_patio_coberto")
    private Boolean inPatioCoberto; // IN_PATIO_COBERTO

    @Column(name = "in_patio_descoberto")
    private Boolean inPatioDescoberto; // IN_PATIO_DESCOBERTO

    @Column(name = "in_parque_infantil")
    private Boolean inParqueInfantil; // IN_PARQUE_INFANTIL

    @Column(name = "in_piscina")
    private Boolean inPiscina; // IN_PISCINA

    @Column(name = "in_quadra_esportes")
    private Boolean inQuadraEsportes; // IN_QUADRA_ESPORTES

    @Column(name = "in_quadra_esportes_coberta")
    private Boolean inQuadraEsportesCoberta; // IN_QUADRA_ESPORTES_COBERTA

    @Column(name = "in_quadra_esportes_descoberta")
    private Boolean inQuadraEsportesDescoberta; // IN_QUADRA_ESPORTES_DESCOBERTA

    @Column(name = "in_refeitorio")
    private Boolean inRefeitorio; // IN_REFEITORIO

    @Column(name = "in_sala_atelie_artes")
    private Boolean inSalaAtelieArtes; // IN_SALA_ATELIE_ARTES

    @Column(name = "in_sala_musica_coral")
    private Boolean inSalaMusicaCoral; // IN_SALA_MUSICA_CORAL

    @Column(name = "in_sala_estudio_danca")
    private Boolean inSalaEstudioDanca; // IN_SALA_ESTUDIO_DANCA

    @Column(name = "in_sala_multiuso")
    private Boolean inSalaMultiuso; // IN_SALA_MULTIUSO

    @Column(name = "in_sala_estudio_gravacao")
    private Boolean inSalaEstudioGravacao; // IN_SALA_ESTUDIO_GRAVACAO

    @Column(name = "in_sala_oficinas_educ_prof")
    private Boolean inSalaOficinasEducProf; // IN_SALA_OFICINAS_EDUC_PROF

    @Column(name = "in_sala_diretoria")
    private Boolean inSalaDiretoria; // IN_SALA_DIRETORIA

    @Column(name = "in_sala_leitura")
    private Boolean inSalaLeitura; // IN_SALA_LEITURA

    @Column(name = "in_sala_professor")
    private Boolean inSalaProfessor; // IN_SALA_PROFESSOR

    @Column(name = "in_sala_repouso_aluno")
    private Boolean inSalaRepousoAluno; // IN_SALA_REPOUSO_ALUNO

    @Column(name = "in_secretaria")
    private Boolean inSecretaria; // IN_SECRETARIA

    @Column(name = "in_sala_atendimento_especial")
    private Boolean inSalaAtendimentoEspecial; // IN_SALA_ATENDIMENTO_ESPECIAL

    @Column(name = "in_terreirao")
    private Boolean inTerreirao; // IN_TERREIRAO

    @Column(name = "in_viveiro")
    private Boolean inViveiro; // IN_VIVEIRO

    @Column(name = "in_dependencias_outras")
    private Boolean inDependenciasOutras; // IN_DEPENDENCIAS_OUTRAS

    // Accessibility Features
    @Column(name = "in_acessibilidade_corrimao")
    private Boolean inAcessibilidadeCorrimao; // IN_ACESSIBILIDADE_CORRIMAO

    @Column(name = "in_acessibilidade_elevador")
    private Boolean inAcessibilidadeElevador; // IN_ACESSIBILIDADE_ELEVADOR

    @Column(name = "in_acessibilidade_pisos_tateis")
    private Boolean inAcessibilidadePisosTateis; // IN_ACESSIBILIDADE_PISOS_TATEIS

    @Column(name = "in_acessibilidade_vao_livre")
    private Boolean inAcessibilidadeVaoLivre; // IN_ACESSIBILIDADE_VAO_LIVRE

    @Column(name = "in_acessibilidade_rampas")
    private Boolean inAcessibilidadeRampas; // IN_ACESSIBILIDADE_RAMPAS

    @Column(name = "in_acessibilidade_sinal_sonoro")
    private Boolean inAcessibilidadeSinalSonoro; // IN_ACESSIBILIDADE_SINAL_SONORO

    @Column(name = "in_acessibilidade_sinal_tatil")
    private Boolean inAcessibilidadeSinalTatil; // IN_ACESSIBILIDADE_SINAL_TATIL

    @Column(name = "in_acessibilidade_sinal_visual")
    private Boolean inAcessibilidadeSinalVisual; // IN_ACESSIBILIDADE_SINAL_VISUAL

    @Column(name = "in_acessibilidade_inexistente")
    private Boolean inAcessibilidadeInexistente; // IN_ACESSIBILIDADE_INEXISTENTE

    @Column(name = "in_acessibilidade_sinalizacao")
    private Boolean inAcessibilidadeSinalizacao; // IN_ACESSIBILIDADE_SINALIZACAO

    // Room Quantities
    @Column(name = "qt_salas_utilizadas_dentro")
    private Integer qtSalasUtilizadasDentro; // QT_SALAS_UTILIZADAS_DENTRO

    @Column(name = "qt_salas_utilizadas_fora")
    private Integer qtSalasUtilizadasFora; // QT_SALAS_UTILIZADAS_FORA

    @Column(name = "qt_salas_utilizadas")
    private Integer qtSalasUtilizadas; // QT_SALAS_UTILIZADAS

    @Column(name = "qt_salas_utiliza_climatizadas")
    private Integer qtSalasUtilizaClimatizadas; // QT_SALAS_UTILIZA_CLIMATIZADAS

    @Column(name = "qt_salas_utilizadas_acessiveis")
    private Integer qtSalasUtilizadasAcessiveis; // QT_SALAS_UTILIZADAS_ACESIVEIS

    // Equipment
    @Column(name = "in_equip_parabolica")
    private Boolean inEquipParabolica; // IN_EQUIP_PARABOLICA

    @Column(name = "in_computador")
    private Boolean inComputador; // IN_COMPUTADOR

    @Column(name = "in_equip_copiadora")
    private Boolean inEquipCopiadora; // IN_EQUIP_COPIADORA

    @Column(name = "in_equip_impressora")
    private Boolean inEquipImpressora; // IN_EQUIP_IMPRESSORA

    @Column(name = "in_equip_impressora_mult")
    private Boolean inEquipImpressoraMult; // IN_EQUIP_IMPRESSORA_MULT

    @Column(name = "in_equip_scanner")
    private Boolean inEquipScanner; // IN_EQUIP_SCANNER

    @Column(name = "in_equip_nenhum")
    private Boolean inEquipNenhum; // IN_EQUIP_NENHUM

    @Column(name = "in_equip_dvd")
    private Boolean inEquipDvd; // IN_EQUIP_DVD

    @Column(name = "qt_equip_dvd")
    private Integer qtEquipDvd; // QT_EQUIP_DVD

    @Column(name = "in_equip_som")
    private Boolean inEquipSom; // IN_EQUIP_SOM

    @Column(name = "qt_equip_som")
    private Integer qtEquipSom; // QT_EQUIP_SOM

    @Column(name = "in_equip_tv")
    private Boolean inEquipTv; // IN_EQUIP_TV

    @Column(name = "qt_equip_tv")
    private Integer qtEquipTv; // QT_EQUIP_TV

    @Column(name = "in_equip_lousa_digital")
    private Boolean inEquipLousaDigital; // IN_EQUIP_LOUSA_DIGITAL

    @Column(name = "qt_equip_lousa_digital")
    private Integer qtEquipLousaDigital; // QT_EQUIP_LOUSA_DIGITAL

    @Column(name = "in_equip_multimidia")
    private Boolean inEquipMultimidia; // IN_EQUIP_MULTIMIDIA

    @Column(name = "qt_equip_multimidia")
    private Integer qtEquipMultimidia; // QT_EQUIP_MULTIMIDIA

    @Column(name = "in_desktop_aluno")
    private Boolean inDesktopAluno; // IN_DESKTOP_ALUNO

    @Column(name = "qt_desktop_aluno")
    private Integer qtDesktopAluno; // QT_DESKTOP_ALUNO

    @Column(name = "in_comp_portatil_aluno")
    private Boolean inCompPortatilAluno; // IN_COMP_PORTATIL_ALUNO

    @Column(name = "qt_comp_portatil_aluno")
    private Integer qtCompPortatilAluno; // QT_COMP_PORTATIL_ALUNO

    @Column(name = "in_tablet_aluno")
    private Boolean inTabletAluno; // IN_TABLET_ALUNO

    @Column(name = "qt_tablet_aluno")
    private Integer qtTabletAluno; // QT_TABLET_ALUNO

    // Internet Connectivity
    @Column(name = "in_internet")
    private Boolean inInternet; // IN_INTERNET

    @Column(name = "in_internet_alunos")
    private Boolean inInternetAlunos; // IN_INTERNET_ALUNOS

    @Column(name = "in_internet_administrativo")
    private Boolean inInternetAdministrativo; // IN_INTERNET_ADMINISTRATIVO

    @Column(name = "in_internet_aprendizagem")
    private Boolean inInternetAprendizagem; // IN_INTERNET_APRENDIZAGEM

    @Column(name = "in_internet_comunidade")
    private Boolean inInternetComunidade; // IN_INTERNET_COMUNIDADE

    @Column(name = "in_acesso_internet_computador")
    private Boolean inAcessoInternetComputador; // IN_ACESSO_INTERNET_COMPUTADOR

    @Column(name = "in_aces_internet_disp_pessoais")
    private Boolean inAcesInternetDispPessoais; // IN_ACES_INTERNET_DISP_PESSOAIS

    @Column(name = "tp_rede_local")
    private Integer tpRedeLocal; // TP_REDE_LOCAL

    @Column(name = "in_banda_larga")
    private Boolean inBandaLarga; // IN_BANDA_LARGA

    // Professional Staff
    @Column(name = "in_prof_administrativos")
    private Boolean inProfAdministrativos; // IN_PROF_ADMINISTRATIVOS

    @Column(name = "qt_prof_administrativos")
    private Integer qtProfAdministrativos; // QT_PROF_ADMINISTRATIVOS

    @Column(name = "in_prof_servicos_gerais")
    private Boolean inProfServicosGerais; // IN_PROF_SERVICOS_GERAIS

    @Column(name = "qt_prof_servicos_gerais")
    private Integer qtProfServicosGerais; // QT_PROF_SERVICOS_GERAIS

    @Column(name = "in_prof_bibliotecario")
    private Boolean inProfBibliotecario; // IN_PROF_BIBLIOTECARIO

    @Column(name = "qt_prof_bibliotecario")
    private Integer qtProfBibliotecario; // QT_PROF_BIBLIOTECARIO

    @Column(name = "in_prof_saude")
    private Boolean inProfSaude; // IN_PROF_SAUDE

    @Column(name = "qt_prof_saude")
    private Integer qtProfSaude; // QT_PROF_SAUDE

    @Column(name = "in_prof_coordenador")
    private Boolean inProfCoordenador; // IN_PROF_COORDENADOR

    @Column(name = "qt_prof_coordenador")
    private Integer qtProfCoordenador; // QT_PROF_COORDENADOR

    @Column(name = "in_prof_fonaudiologo")
    private Boolean inProfFonaudiologo; // IN_PROF_FONAUDIOLOGO

    @Column(name = "qt_prof_fonaudiologo")
    private Integer qtProfFonaudiologo; // QT_PROF_FONAUDIOLOGO

    @Column(name = "in_prof_nutricionista")
    private Boolean inProfNutricionista; // IN_PROF_NUTRICIONISTA

    @Column(name = "qt_prof_nutricionista")
    private Integer qtProfNutricionista; // QT_PROF_NUTRICIONISTA

    @Column(name = "in_prof_psicologo")
    private Boolean inProfPsicologo; // IN_PROF_PSICOLOGO

    @Column(name = "qt_prof_psicologo")
    private Integer qtProfPsicologo; // QT_PROF_PSICOLOGO

    @Column(name = "in_prof_alimentacao")
    private Boolean inProfAlimentacao; // IN_PROF_ALIMENTACAO

    @Column(name = "qt_prof_alimentacao")
    private Integer qtProfAlimentacao; // QT_PROF_ALIMENTACAO

    @Column(name = "in_prof_pedagogia")
    private Boolean inProfPedagogia; // IN_PROF_PEDAGOGIA

    @Column(name = "qt_prof_pedagogia")
    private Integer qtProfPedagogia; // QT_PROF_PEDAGOGIA

    @Column(name = "in_prof_secretario")
    private Boolean inProfSecretario; // IN_PROF_SECRETARIO

    @Column(name = "qt_prof_secretario")
    private Integer qtProfSecretario; // QT_PROF_SECRETARIO

    @Column(name = "in_prof_seguranca")
    private Boolean inProfSeguranca; // IN_PROF_SEGURANCA

    @Column(name = "qt_prof_seguranca")
    private Integer qtProfSeguranca; // QT_PROF_SEGURANCA

    @Column(name = "in_prof_monitores")
    private Boolean inProfMonitores; // IN_PROF_MONITORES

    @Column(name = "qt_prof_monitores")
    private Integer qtProfMonitores; // QT_PROF_MONITORES

    @Column(name = "in_prof_gestao")
    private Boolean inProfGestao; // IN_PROF_GESTAO

    @Column(name = "qt_prof_gestao")
    private Integer qtProfGestao; // QT_PROF_GESTAO

    @Column(name = "in_prof_assist_social")
    private Boolean inProfAssistSocial; // IN_PROF_ASSIST_SOCIAL

    @Column(name = "qt_prof_assist_social")
    private Integer qtProfAssistSocial; // QT_PROF_ASSIST_SOCIAL

    @Column(name = "in_prof_trad_libras")
    private Boolean inProfTradLibras; // IN_PROF_TRAD_LIBRAS

    @Column(name = "qt_prof_trad_libras")
    private Integer qtProfTradLibras; // QT_PROF_TRAD_LIBRAS

    @Column(name = "in_prof_agricola")
    private Boolean inProfAgricola; // IN_PROF_AGRICOLA

    @Column(name = "qt_prof_agricola")
    private Integer qtProfAgricola; // QT_PROF_AGRICOLA

    @Column(name = "in_prof_revisor_braille")
    private Boolean inProfRevisorBraille; // IN_PROF_REVISOR_BRAILLE

    @Column(name = "qt_prof_revisor_braille")
    private Integer qtProfRevisorBraille; // QT_PROF_REVISOR_BRAILLE

    // Pedagogical Material and Educational Characteristics
    @Column(name = "in_alimentacao")
    private Boolean inAlimentacao; // IN_ALIMENTACAO

    @Column(name = "in_material_ped_multimidia")
    private Boolean inMaterialPedMultimidia; // IN_MATERIAL_PED_MULTIMIDIA

    @Column(name = "in_material_ped_infantil")
    private Boolean inMaterialPedInfantil; // IN_MATERIAL_PED_INFANTIL

    @Column(name = "in_material_ped_cientifico")
    private Boolean inMaterialPedCientifico; // IN_MATERIAL_PED_CIENTIFICO

    @Column(name = "in_material_ped_difusao")
    private Boolean inMaterialPedDifusao; // IN_MATERIAL_PED_DIFUSAO

    @Column(name = "in_material_ped_musical")
    private Boolean inMaterialPedMusical; // IN_MATERIAL_PED_MUSICAL

    @Column(name = "in_material_ped_jogos")
    private Boolean inMaterialPedJogos; // IN_MATERIAL_PED_JOGOS

    @Column(name = "in_material_ped_artisticas")
    private Boolean inMaterialPedArtisticas; // IN_MATERIAL_PED_ARTISTICAS

    @Column(name = "in_material_ped_profissional")
    private Boolean inMaterialPedProfissional; // IN_MATERIAL_PED_PROFISSIONAL

    @Column(name = "in_material_ped_desportiva")
    private Boolean inMaterialPedDesportiva; // IN_MATERIAL_PED_DESPORTIVA

    @Column(name = "in_material_ped_indigena")
    private Boolean inMaterialPedIndigena; // IN_MATERIAL_PED_INDIGENA

    @Column(name = "in_material_ped_etnico")
    private Boolean inMaterialPedEtnico; // IN_MATERIAL_PED_ETNICO

    @Column(name = "in_material_ped_campo")
    private Boolean inMaterialPedCampo; // IN_MATERIAL_PED_CAMPO

    @Column(name = "in_material_ped_bil_surdos")
    private Boolean inMaterialPedBilSurdos; // IN_MATERIAL_PED_BIL_SURDOS

    @Column(name = "in_material_ped_agricola")
    private Boolean inMaterialPedAgricola; // IN_MATERIAL_PED_AGRICOLA

    @Column(name = "in_material_ped_quilombola")
    private Boolean inMaterialPedQuilombola; // IN_MATERIAL_PED_QUILOMBOLA

    @Column(name = "in_material_ped_edu_esp")
    private Boolean inMaterialPedEduEsp; // IN_MATERIAL_PED_EDU_ESP

    @Column(name = "in_material_ped_nenhum")
    private Boolean inMaterialPedNenhum; // IN_MATERIAL_PED_NENHUM

    @Column(name = "in_educacao_indigena")
    private Boolean inEducacaoIndigena; // IN_EDUCACAO_INDIGENA

    @Column(name = "tp_indigena_lingua")
    private Integer tpIndigenaLingua; // TP_INDIGENA_LINGUA

    @Column(name = "co_lingua_indigena_1")
    private Integer coLinguaIndigena1; // CO_LINGUA_INDIGENA_1

    @Column(name = "co_lingua_indigena_2")
    private Integer coLinguaIndigena2; // CO_LINGUA_INDIGENA_2

    @Column(name = "co_lingua_indigena_3")
    private Integer coLinguaIndigena3; // CO_LINGUA_INDIGENA_3

    // Admission Criteria
    @Column(name = "in_exame_selecao")
    private Boolean inExameSelecao; // IN_EXAME_SELECAO

    @Column(name = "in_reserva_ppi")
    private Boolean inReservaPpi; // IN_RESERVA_PPI (Indigenous, Black, Pardo)

    @Column(name = "in_reserva_renda")
    private Boolean inReservaRenda; // IN_RESERVA_RENDA

    @Column(name = "in_reserva_publica")
    private Boolean inReservaPublica; // IN_RESERVA_PUBLICA

    @Column(name = "in_reserva_pcd")
    private Boolean inReservaPcd; // IN_RESERVA_PCD (Persons with Disabilities)

    @Column(name = "in_reserva_outros")
    private Boolean inReservaOutros; // IN_RESERVA_OUTROS

    @Column(name = "in_reserva_nenhuma")
    private Boolean inReservaNenhuma; // IN_RESERVA_NENHUMA

    // School Engagement
    @Column(name = "in_redes_sociais")
    private Boolean inRedesSociais; // IN_REDES_SOCIAIS

    @Column(name = "in_espaco_atividade")
    private Boolean inEspacoAtividade; // IN_ESPACO_ATIVIDADE

    @Column(name = "in_espaco_equipamento")
    private Boolean inEspacoEquipamento; // IN_ESPACO_EQUIPAMENTO

    // School Councils/Organizations
    @Column(name = "in_orgao_ass_pais")
    private Boolean inOrgaoAssPais; // IN_ORGAO_ASS_PAIS

    @Column(name = "in_orgao_ass_pais_mestres")
    private Boolean inOrgaoAssPaisMestres; // IN_ORGAO_ASS_PAIS_MESTRES

    @Column(name = "in_orgao_conselho_escolar")
    private Boolean inOrgaoConselhoEscolar; // IN_ORGAO_CONSELHO_ESCOLAR

    @Column(name = "in_orgao_gremio_estudantil")
    private Boolean inOrgaoGremioEstudantil; // IN_ORGAO_GREMIO_ESTUDANTIL

    @Column(name = "in_orgao_outros")
    private Boolean inOrgaoOutros; // IN_ORGAO_OUTROS

    @Column(name = "in_orgao_nenhum")
    private Boolean inOrgaoNenhum; // IN_ORGAO_NENHUM

    @Column(name = "tp_proposta_pedagogica")
    private Integer tpPropostaPedagogica; // TP_PROPOSTA_PEDAGOGICA

    // Environmental Education
    @Column(name = "in_educ_ambiental")
    private Boolean inEducAmbiental; // IN_EDUC_AMBIENTAL

    @Column(name = "in_educ_amb_conteudo")
    private Boolean inEducAmbConteudo; // IN_EDUC_AMB_CONTEUDO

    @Column(name = "in_educ_amb_curricular")
    private Boolean inEducAmbCurricular; // IN_EDUC_AMB_CURRICULAR

    @Column(name = "in_educ_amb_eixo")
    private Boolean inEducAmbEixo; // IN_EDUC_AMB_EIXO

    @Column(name = "in_educ_amb_eventos")
    private Boolean inEducAmbEventos; // IN_EDUC_AMB_EVENTOS

    @Column(name = "in_educ_amb_projetos")
    private Boolean inEducAmbProjetos; // IN_EDUC_AMB_PROJETOS

    @Column(name = "in_educ_amb_nenhuma")
    private Boolean inEducAmbNenhuma; // IN_EDUC_AMB_NENHUMA

    @Column(name = "tp_aee")
    private Integer tpAee; // TP_AEE (Specialized Educational Assistance)

    @Column(name = "tp_atividade_complementar")
    private Integer tpAtividadeComplementar; // TP_ATIVIDADE_COMPLEMENTAR

    // Teaching Modalities
    @Column(name = "in_mediacao_presencial")
    private Boolean inMediacaoPresencial; // IN_MEDIACAO_PRESENCIAL

    @Column(name = "in_mediacao_semipresencial")
    private Boolean inMediacaoSemipresencial; // IN_MEDIACAO_SEMIPRESENCIAL

    @Column(name = "in_mediacao_ead")
    private Boolean inMediacaoEad; // IN_MEDIACAO_EAD (Distance Learning)

    // Educational Stages Offered
    @Column(name = "in_regular")
    private Boolean inRegular; // IN_REGULAR

    @Column(name = "in_diurno")
    private Boolean inDiurno; // IN_DIURNO

    @Column(name = "in_noturno")
    private Boolean inNoturno; // IN_NOTURNO

    @Column(name = "in_ead")
    private Boolean inEad; // IN_EAD

    @Column(name = "in_escolarizacao")
    private Boolean inEscolarizacao; // IN_ESCOLARIZACAO

    @Column(name = "in_inf")
    private Boolean inInf; // IN_INF (Early Childhood Education)

    @Column(name = "in_inf_cre")
    private Boolean inInfCre; // IN_INF_CRE (Nursery)

    @Column(name = "in_inf_pre")
    private Boolean inInfPre; // IN_INF_PRE (Preschool)

    @Column(name = "in_fund")
    private Boolean inFund; // IN_FUND (Elementary School)

    @Column(name = "in_fund_ai")
    private Boolean inFundAi; // IN_FUND_AI (Elementary School - Early Years)

    @Column(name = "in_fund_af")
    private Boolean inFundAf; // IN_FUND_AF (Elementary School - Later Years)

    @Column(name = "in_med")
    private Boolean inMed; // IN_MED (High School)

    @Column(name = "in_prof")
    private Boolean inProf; // IN_PROF (Professional Education)

    @Column(name = "in_prof_tec")
    private Boolean inProfTec; // IN_PROF_TEC (Technical Professional Education)

    @Column(name = "in_eja")
    private Boolean inEja; // IN_EJA (Youth and Adult Education)

    @Column(name = "in_eja_fund")
    private Boolean inEjaFund; // IN_EJA_FUND (EJA - Elementary)

    @Column(name = "in_eja_med")
    private Boolean inEjaMed; // IN_EJA_MED (EJA - High School)

    @Column(name = "in_esp")
    private Boolean inEsp; // IN_ESP (Special Education)

    @Column(name = "in_esp_cc")
    private Boolean inEspCc; // IN_ESP_CC (Special Education - Common Class)

    @Column(name = "in_esp_ce")
    private Boolean inEspCe; // IN_ESP_CE (Special Education - Specialized Class)

    // Enrollment Quantities
    @Column(name = "qt_mat_bas")
    private Integer qtMatBas; // QT_MAT_BAS (Basic Education)

    @Column(name = "qt_mat_inf")
    private Integer qtMatInf; // QT_MAT_INF

    @Column(name = "qt_mat_inf_cre")
    private Integer qtMatInfCre; // QT_MAT_INF_CRE

    @Column(name = "qt_mat_inf_pre")
    private Integer qtMatInfPre; // QT_MAT_INF_PRE

    @Column(name = "qt_mat_fund")
    private Integer qtMatFund; // QT_MAT_FUND

    @Column(name = "qt_mat_fund_ai")
    private Integer qtMatFundAi; // QT_MAT_FUND_AI

    @Column(name = "qt_mat_fund_ai_1")
    private Integer qtMatFundAi1; // QT_MAT_FUND_AI_1

    @Column(name = "qt_mat_fund_ai_2")
    private Integer qtMatFundAi2; // QT_MAT_FUND_AI_2

    @Column(name = "qt_mat_fund_ai_3")
    private Integer qtMatFundAi3; // QT_MAT_FUND_AI_3

    @Column(name = "qt_mat_fund_ai_4")
    private Integer qtMatFundAi4; // QT_MAT_FUND_AI_4

    @Column(name = "qt_mat_fund_ai_5")
    private Integer qtMatFundAi5; // QT_MAT_FUND_AI_5

    @Column(name = "qt_mat_fund_af")
    private Integer qtMatFundAf; // QT_MAT_FUND_AF

    @Column(name = "qt_mat_fund_af_6")
    private Integer qtMatFundAf6; // QT_MAT_FUND_AF_6

    @Column(name = "qt_mat_fund_af_7")
    private Integer qtMatFundAf7; // QT_MAT_FUND_AF_7

    @Column(name = "qt_mat_fund_af_8")
    private Integer qtMatFundAf8; // QT_MAT_FUND_AF_8

    @Column(name = "qt_mat_fund_af_9")
    private Integer qtMatFundAf9; // QT_MAT_FUND_AF_9

    @Column(name = "qt_mat_med")
    private Integer qtMatMed; // QT_MAT_MED

    @Column(name = "qt_mat_med_prop")
    private Integer qtMatMedProp; // QT_MAT_MED_PROP

    @Column(name = "qt_mat_med_prop_1")
    private Integer qtMatMedProp1; // QT_MAT_MED_PROP_1

    @Column(name = "qt_mat_med_prop_2")
    private Integer qtMatMedProp2; // QT_MAT_MED_PROP_2

    @Column(name = "qt_mat_med_prop_3")
    private Integer qtMatMedProp3; // QT_MAT_MED_PROP_3

    @Column(name = "qt_mat_med_prop_4")
    private Integer qtMatMedProp4; // QT_MAT_MED_PROP_4

    @Column(name = "qt_mat_med_prop_ns")
    private Integer qtMatMedPropNs; // QT_MAT_MED_PROP_NS (Non-Serie)

    @Column(name = "qt_mat_med_ct")
    private Integer qtMatMedCt; // QT_MAT_MED_CT (Concomitant Technical)

    @Column(name = "qt_mat_med_ct_1")
    private Integer qtMatMedCt1; // QT_MAT_MED_CT_1

    @Column(name = "qt_mat_med_ct_2")
    private Integer qtMatMedCt2; // QT_MAT_MED_CT_2

    @Column(name = "qt_mat_med_ct_3")
    private Integer qtMatMedCt3; // QT_MAT_MED_CT_3

    @Column(name = "qt_mat_med_ct_4")
    private Integer qtMatMedCt4; // QT_MAT_MED_CT_4

    @Column(name = "qt_mat_med_ct_ns")
    private Integer qtMatMedCtNs; // QT_MAT_MED_CT_NS

    @Column(name = "qt_mat_med_nm")
    private Integer qtMatMedNm; // QT_MAT_MED_NM (New High School)

    @Column(name = "qt_mat_med_nm_1")
    private Integer qtMatMedNm1; // QT_MAT_MED_NM_1

    @Column(name = "qt_mat_med_nm_2")
    private Integer qtMatMedNm2; // QT_MAT_MED_NM_2

    @Column(name = "qt_mat_med_nm_3")
    private Integer qtMatMedNm3; // QT_MAT_MED_NM_3

    @Column(name = "qt_mat_med_nm_4")
    private Integer qtMatMedNm4; // QT_MAT_MED_NM_4

    @Column(name = "qt_mat_prof")
    private Integer qtMatProf; // QT_MAT_PROF

    @Column(name = "qt_mat_prof_tec")
    private Integer qtMatProfTec; // QT_MAT_PROF_TEC

    @Column(name = "qt_mat_prof_tec_conc")
    private Integer qtMatProfTecConc; // QT_MAT_PROF_TEC_CONC

    @Column(name = "qt_mat_prof_tec_subs")
    private Integer qtMatProfTecSubs; // QT_MAT_PROF_TEC_SUBS

    @Column(name = "qt_mat_prof_fic_conc")
    private Integer qtMatProfFicConc; // QT_MAT_PROF_FIC_CONC

    @Column(name = "qt_mat_eja")
    private Integer qtMatEja; // QT_MAT_EJA

    @Column(name = "qt_mat_eja_fund")
    private Integer qtMatEjaFund; // QT_MAT_EJA_FUND

    @Column(name = "qt_mat_eja_fund_ai")
    private Integer qtMatEjaFundAi; // QT_MAT_EJA_FUND_AI

    @Column(name = "qt_mat_eja_fund_af")
    private Integer qtMatEjaFundAf; // QT_MAT_EJA_FUND_AF

    @Column(name = "qt_mat_eja_fund_fic")
    private Integer qtMatEjaFundFic; // QT_MAT_EJA_FUND_FIC

    @Column(name = "qt_mat_eja_med")
    private Integer qtMatEjaMed; // QT_MAT_EJA_MED

    @Column(name = "qt_mat_eja_med_nprof")
    private Integer qtMatEjaMedNprof; // QT_MAT_EJA_MED_NPROF

    @Column(name = "qt_mat_eja_med_fic")
    private Integer qtMatEjaMedFic; // QT_MAT_EJA_MED_FIC

    @Column(name = "qt_mat_eja_med_tec")
    private Integer qtMatEjaMedTec; // QT_MAT_EJA_MED_TEC

    @Column(name = "qt_mat_esp")
    private Integer qtMatEsp; // QT_MAT_ESP

    @Column(name = "qt_mat_esp_cc")
    private Integer qtMatEspCc; // QT_MAT_ESP_CC

    @Column(name = "qt_mat_esp_ce")
    private Integer qtMatEspCe; // QT_MAT_ESP_CE

    // Enrollment by Gender, Race, Age
    @Column(name = "qt_mat_bas_fem")
    private Integer qtMatBasFem; // QT_MAT_BAS_FEM

    @Column(name = "qt_mat_bas_masc")
    private Integer qtMatBasMasc; // QT_MAT_BAS_MASC

    @Column(name = "qt_mat_bas_nd")
    private Integer qtMatBasNd; // QT_MAT_BAS_ND (Not Declared)

    @Column(name = "qt_mat_bas_branca")
    private Integer qtMatBasBranca; // QT_MAT_BAS_BRANCA

    @Column(name = "qt_mat_bas_preta")
    private Integer qtMatBasPreta; // QT_MAT_BAS_PRETA

    @Column(name = "qt_mat_bas_parda")
    private Integer qtMatBasParda; // QT_MAT_BAS_PARDA

    @Column(name = "qt_mat_bas_amarela")
    private Integer qtMatBasAmarela; // QT_MAT_BAS_AMARELA

    @Column(name = "qt_mat_bas_indigena")
    private Integer qtMatBasIndigena; // QT_MAT_BAS_INDIGENA

    @Column(name = "qt_mat_bas_0_3")
    private Integer qtMatBas03; // QT_MAT_BAS_0_3

    @Column(name = "qt_mat_bas_4_5")
    private Integer qtMatBas45; // QT_MAT_BAS_4_5

    @Column(name = "qt_mat_bas_6_10")
    private Integer qtMatBas610; // QT_MAT_BAS_6_10

    @Column(name = "qt_mat_bas_11_14")
    private Integer qtMatBas1114; // QT_MAT_BAS_11_14

    @Column(name = "qt_mat_bas_15_17")
    private Integer qtMatBas1517; // QT_MAT_BAS_15_17

    @Column(name = "qt_mat_bas_18_mais")
    private Integer qtMatBas18Mais; // QT_MAT_BAS_18_MAIS

    @Column(name = "qt_mat_bas_d")
    private Integer qtMatBasD; // QT_MAT_BAS_D (Day)

    @Column(name = "qt_mat_bas_n")
    private Integer qtMatBasN; // QT_MAT_BAS_N (Night)

    @Column(name = "qt_mat_bas_ead")
    private Integer qtMatBasEad; // QT_MAT_BAS_EAD

    // Integrated Enrollments (Integrated with Professional Education)
    @Column(name = "qt_mat_inf_int")
    private Integer qtMatInfInt; // QT_MAT_INF_INT

    @Column(name = "qt_mat_inf_cre_int")
    private Integer qtMatInfCreInt; // QT_MAT_INF_CRE_INT

    @Column(name = "qt_mat_inf_pre_int")
    private Integer qtMatInfPreInt; // QT_MAT_INF_PRE_INT

    @Column(name = "qt_mat_fund_int")
    private Integer qtMatFundInt; // QT_MAT_FUND_INT

    @Column(name = "qt_mat_fund_ai_int")
    private Integer qtMatFundAiInt; // QT_MAT_FUND_AI_INT

    @Column(name = "qt_mat_fund_af_int")
    private Integer qtMatFundAfInt; // QT_MAT_FUND_AF_INT

    @Column(name = "qt_mat_med_int")
    private Integer qtMatMedInt; // QT_MAT_MED_INT

    // Rural/Urban Enrollments
    @Column(name = "qt_mat_zr_urb")
    private Integer qtMatZrUrb; // QT_MAT_ZR_URB (Urban Zone)

    @Column(name = "qt_mat_zr_rur")
    private Integer qtMatZrRur; // QT_MAT_ZR_RUR (Rural Zone)

    @Column(name = "qt_mat_zr_na")
    private Integer qtMatZrNa; // QT_MAT_ZR_NA (Not Applicable/Undefined Zone)

    // Transportation
    @Column(name = "qt_transp_publico")
    private Integer qtTranspPublico; // QT_TRANSP_PUBLICO

    @Column(name = "qt_transp_resp_est")
    private Integer qtTranspRespEst; // QT_TRANSP_RESP_EST (State Responsibility)

    @Column(name = "qt_transp_resp_mun")
    private Integer qtTranspRespMun; // QT_TRANSP_RESP_MUN (Municipal Responsibility)

    // Teacher Quantities
    @Column(name = "qt_doc_bas")
    private Integer qtDocBas; // QT_DOC_BAS

    @Column(name = "qt_doc_inf")
    private Integer qtDocInf; // QT_DOC_INF

    @Column(name = "qt_doc_inf_cre")
    private Integer qtDocInfCre; // QT_DOC_INF_CRE

    @Column(name = "qt_doc_inf_pre")
    private Integer qtDocInfPre; // QT_DOC_INF_PRE

    @Column(name = "qt_doc_fund")
    private Integer qtDocFund; // QT_DOC_FUND

    @Column(name = "qt_doc_fund_ai")
    private Integer qtDocFundAi; // QT_DOC_FUND_AI

    @Column(name = "qt_doc_fund_af")
    private Integer qtDocFundAf; // QT_DOC_FUND_AF

    @Column(name = "qt_doc_med")
    private Integer qtDocMed; // QT_DOC_MED

    @Column(name = "qt_doc_prof")
    private Integer qtDocProf; // QT_DOC_PROF

    @Column(name = "qt_doc_prof_tec")
    private Integer qtDocProfTec; // QT_DOC_PROF_TEC

    @Column(name = "qt_doc_eja")
    private Integer qtDocEja; // QT_DOC_EJA

    @Column(name = "qt_doc_eja_fund")
    private Integer qtDocEjaFund; // QT_DOC_EJA_FUND

    @Column(name = "qt_doc_eja_med")
    private Integer qtDocEjaMed; // QT_DOC_EJA_MED

    @Column(name = "qt_doc_esp")
    private Integer qtDocEsp; // QT_DOC_ESP

    @Column(name = "qt_doc_esp_cc")
    private Integer qtDocEspCc; // QT_DOC_ESP_CC

    @Column(name = "qt_doc_esp_ce")
    private Integer qtDocEspCe; // QT_DOC_ESP_CE

    // Class Quantities (Turmas)
    @Column(name = "qt_tur_bas")
    private Integer qtTurBas; // QT_TUR_BAS

    @Column(name = "qt_tur_inf")
    private Integer qtTurInf; // QT_TUR_INF

    @Column(name = "qt_tur_inf_cre")
    private Integer qtTurInfCre; // QT_TUR_INF_CRE

    @Column(name = "qt_tur_inf_pre")
    private Integer qtTurInfPre; // QT_TUR_INF_PRE

    @Column(name = "qt_tur_fund")
    private Integer qtTurFund; // QT_TUR_FUND

    @Column(name = "qt_tur_fund_ai")
    private Integer qtTurFundAi; // QT_TUR_FUND_AI

    @Column(name = "qt_tur_fund_af")
    private Integer qtTurFundAf; // QT_TUR_FUND_AF

    @Column(name = "qt_tur_med")
    private Integer qtTurMed; // QT_TUR_MED

    @Column(name = "qt_tur_prof")
    private Integer qtTurProf; // QT_TUR_PROF

    @Column(name = "qt_tur_prof_tec")
    private Integer qtTurProfTec; // QT_TUR_PROF_TEC

    @Column(name = "qt_tur_eja")
    private Integer qtTurEja; // QT_TUR_EJA

    @Column(name = "qt_tur_eja_fund")
    private Integer qtTurEjaFund; // QT_TUR_EJA_FUND

    @Column(name = "qt_tur_eja_med")
    private Integer qtTurEjaMed; // QT_TUR_EJA_MED

    @Column(name = "qt_tur_esp")
    private Integer qtTurEsp; // QT_TUR_ESP

    @Column(name = "qt_tur_esp_cc")
    private Integer qtTurEspCc; // QT_TUR_ESP_CC

    @Column(name = "qt_tur_esp_ce")
    private Integer qtTurEspCe; // QT_TUR_ESP_CE

    @Column(name = "qt_tur_bas_d")
    private Integer qtTurBasD; // QT_TUR_BAS_D

    @Column(name = "qt_tur_bas_n")
    private Integer qtTurBasN; // QT_TUR_BAS_N

    @Column(name = "qt_tur_bas_ead")
    private Integer qtTurBasEad; // QT_TUR_BAS_EAD

    // Integrated Classes
    @Column(name = "qt_tur_inf_int")
    private Integer qtTurInfInt; // QT_TUR_INF_INT

    @Column(name = "qt_tur_inf_cre_int")
    private Integer qtTurInfCreInt; // QT_TUR_INF_CRE_INT

    @Column(name = "qt_tur_inf_pre_int")
    private Integer qtTurInfPreInt; // QT_TUR_INF_PRE_INT

    @Column(name = "qt_tur_fund_int")
    private Integer qtTurFundInt; // QT_TUR_FUND_INT

    @Column(name = "qt_tur_fund_ai_int")
    private Integer qtTurFundAiInt; // QT_TUR_FUND_AI_INT

    @Column(name = "qt_tur_fund_af_int")
    private Integer qtTurFundAfInt; // QT_TUR_FUND_AF_INT

    @Column(name = "qt_tur_med_int")
    private Integer qtTurMedInt; // QT_TUR_MED_INT
}