/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaSCP;


import dao.EditalDAO;
import dao.OrientadorDAO;
import dao.ProjetoDAO;
import dao.SubAreaDAO;
import dao.TipoBolsaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Projeto { 
    private int codigoProjeto;
    private String nomeProjeto;
    private int cargaHoraria;
    private String palavraChave;
    private int duracao;
    private String dataInicio;
    private String dataTermino;
    private float valorfinanciamento;
    private String dataFinanciamento;
    private String programa;
    private String agenciaFomento;
    private int quantidadeBolsista;
    private String instituicaoParceira;
    private String grupoPesquisaCNPq;
    private String professorParticipante;
    private TipoBolsa tipoBolsa;
    private Edital edital;
    private int codigoTipoBolsa;
    private int codigoEdital;
    private SubArea subArea;
    private int codigoSubArea;
    private Orientador coordenador;
    private int codigoCoordenador;
    
    public Projeto(int codigoProjeto, String nomeProjeto, int cargaHoraria, String palavraChave, int duracao, String dataInicio, String dataTermino, float valorfinanciamento, String dataFinanciamento, String programa, String agenciaFomento, int quantidadeBolsista, String instituicaoParceira, String grupoPesquisaCNPq, String professorParticipante, TipoBolsa tipoBolsa, Edital edital, SubArea subArea, Orientador coordenador) {
        this.codigoProjeto = codigoProjeto;
        this.nomeProjeto = nomeProjeto;
        this.cargaHoraria = cargaHoraria;
        this.palavraChave = palavraChave;
        this.duracao = duracao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorfinanciamento = valorfinanciamento;
        this.dataFinanciamento = dataFinanciamento;
        this.programa = programa;
        this.agenciaFomento = agenciaFomento;
        this.quantidadeBolsista = quantidadeBolsista;
        this.instituicaoParceira = instituicaoParceira;
        this.grupoPesquisaCNPq = grupoPesquisaCNPq;
        this.professorParticipante = professorParticipante;
        this.edital = edital;
        this.tipoBolsa = tipoBolsa;
        this.subArea = subArea;
        this.coordenador = coordenador;
        
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavrasChave) {
        this.palavraChave = palavrasChave;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getDataFinanciamento() {
        return dataFinanciamento;
    }

    public void setDataFinanciamento(String dataFinanciamento) {
        this.dataFinanciamento = dataFinanciamento;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getAgenciaFomento() {
        return agenciaFomento;
    }

    public void setAgenciaFomento(String agenciaFomento) {
        this.agenciaFomento = agenciaFomento;
    }

    public int getQuantidadeBolsista() {
        return quantidadeBolsista;
    }

    public void setQuantidadeBolsista(int quantidadeBolsista) {
        this.quantidadeBolsista = quantidadeBolsista;
    }

    public String getProfessorParticipante() {
        return professorParticipante;
    }

    public void setProfessorParticipante(String professorParticipante) {
        this.professorParticipante = professorParticipante;
    }

    public int getCodigoProjeto() {
        return codigoProjeto;
    }

    public void setCodigoProjeto(int codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int CargaHoraria) {
        this.cargaHoraria = CargaHoraria;
    }

    public float getValorfinanciamento() {
        return valorfinanciamento;
    }

    public void setValorfinanciamento(float valorfinanciamento) {
        this.valorfinanciamento = valorfinanciamento;
    }

    public String getInstituicaoParceira() {
        return instituicaoParceira;
    }

    public void setInstituicaoParceira(String instituicaoParceira) {
        this.instituicaoParceira = instituicaoParceira;
    }

    public String getGrupoPesquisaCNPq() {
        return grupoPesquisaCNPq;
    }

    public void setGrupoPesquisaCNPq(String grupoPesquisaCNPq) {
        this.grupoPesquisaCNPq = grupoPesquisaCNPq;
    }

    public TipoBolsa getTipoBolsa()throws ClassNotFoundException, SQLException {
         if ((tipoBolsa == null) && (codigoTipoBolsa != 0)) {
            tipoBolsa = TipoBolsaDAO.obterTipoBolsa(codigoTipoBolsa);
        } 
        return tipoBolsa;
    }

    public void setTipoBolsa(TipoBolsa tipoBolsa) {
        this.tipoBolsa = tipoBolsa;
    }

    public Edital getEdital() throws ClassNotFoundException, SQLException {
         if ((edital == null) && (codigoEdital != 0)) {
            edital = EditalDAO.obterEdital(codigoEdital);
        }
        return edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    public int getCodigoTipoBolsa() {
        return codigoTipoBolsa;
    }

    public void setCodigoTipoBolsa(int codigoTipoBolsa) {
        this.codigoTipoBolsa = codigoTipoBolsa;
    }

    public int getCodigoEdital() {
        return codigoEdital;
    }

    public void setCodigoEdital(int codigoEdital) {
        this.codigoEdital = codigoEdital;
    }

    public SubArea getSubArea() throws ClassNotFoundException, SQLException {
         if ((subArea == null) && (codigoSubArea != 0)) {
            subArea = SubAreaDAO.obterSubArea(codigoSubArea);
        }
        return subArea;
    }

    public void setSubArea(SubArea subArea) {
        this.subArea = subArea;
    }

    public int getCodigoSubArea() {
        return codigoSubArea;
    }

    public void setCodigoSubArea(int codigoSubArea) {
        this.codigoSubArea = codigoSubArea;
    }
       
    public Orientador getCoordenador() throws ClassNotFoundException, SQLException {
         if ((coordenador == null) && (codigoCoordenador != 0)) {
            coordenador = OrientadorDAO.obterOrientador(codigoCoordenador);
        } 
        return coordenador;
    }

    public void setCoordenador(Orientador coordenador) {
        this.coordenador = coordenador;
    }

    public int getCodigoCoordenador() {
        return codigoCoordenador;
    }

    public void setCodigoCoordenador(int codigoCoordenador) {
        this.codigoCoordenador = codigoCoordenador;
    }

    
    public static List<Projeto> obterProjetos()
            throws ClassNotFoundException, SQLException {
    return ProjetoDAO.obterProjetos();
      
    
 }
    public static Projeto obterProjeto(int codigoProjeto)
            throws ClassNotFoundException, SQLException {
    return ProjetoDAO.obterProjeto(codigoProjeto);
      
 }
    
    
    public void gravar() throws SQLException, ClassNotFoundException {
       ProjetoDAO.gravar(this);

    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ProjetoDAO.editar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ProjetoDAO.excluir(this);
    }

    
}