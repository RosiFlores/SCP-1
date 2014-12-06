/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSCP;

import dao.CampusDAO;
import dao.CursoDAO;
import dao.InstituicaoDAO;
import dao.OrientadorDAO;
import dao.TipoCursoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Curso {

    private String nomeCurso;
    private int codigoCurso;
    private Instituicao instituicao;
    private int chaveInstituicao;
    private Orientador coordenador;
    private int chaveCoordenador;
    private TipoCurso tipoCurso;
    private int chaveTipoCurso;
    private Campus campus;
    private int chaveCampus;

    public Curso(String nomeCurso, int codigoCurso, Instituicao instituicao, Orientador coordenador, TipoCurso tipoCurso, Campus campus) {
        this.nomeCurso = nomeCurso;
        this.codigoCurso = codigoCurso;
        this.instituicao = instituicao;
        this.coordenador = coordenador;
        this.tipoCurso = tipoCurso;
        this.campus = campus;

    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getChaveInstituicao() {
        return chaveInstituicao;
    }

    public void setChaveInstituicao(int chaveInstituicao) {
        this.chaveInstituicao = chaveInstituicao;
    }

    public Instituicao getInstituicao() throws ClassNotFoundException, SQLException {
        if (instituicao == null && chaveInstituicao != 0) {
            instituicao = InstituicaoDAO.obterInstituicao(chaveInstituicao);
        }
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Orientador getCoordenador() throws ClassNotFoundException, SQLException {

        if (coordenador == null && chaveCoordenador != 0) {
            coordenador = OrientadorDAO.obterOrientador(chaveCoordenador);
        }
        return coordenador;
    }

    public void setCoordenador(Orientador coordenador) {
        this.coordenador = coordenador;
    }

    public int getChaveCoordenador() {
        return chaveCoordenador;
    }

    public void setChaveCoordenador(int chaveCoordenador) {
        this.chaveCoordenador = chaveCoordenador;
    }

    public TipoCurso getTipoCurso() throws ClassNotFoundException, SQLException {

        if (tipoCurso == null && chaveTipoCurso != 0) {
            tipoCurso = TipoCursoDAO.obterTipoCurso(chaveTipoCurso);
        }
        return tipoCurso;
    }

    public void setTipoCurso(TipoCurso tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public int getChaveTipoCurso() {
        return chaveTipoCurso;
    }

    public void setChaveTipoCurso(int chaveTipoCurso) {
        this.chaveTipoCurso = chaveTipoCurso;
    }

    public static Orientador obterOrientador(int chaveCoordenador) throws ClassNotFoundException,
            SQLException {
        return OrientadorDAO.obterOrientador(chaveCoordenador);
    }

    public Campus getCampus() throws ClassNotFoundException, SQLException {
        if (campus == null && chaveCampus != 0) {
            campus = CampusDAO.obterCampus(chaveCampus);
        }

        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getChaveCampus() {
        return chaveCampus;
    }

    public void setChaveCampus(int chaveCampus) {
        this.chaveCampus = chaveCampus;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        CursoDAO.gravar(this);

    }

    public void alterar() throws SQLException, ClassNotFoundException {
        CursoDAO.editar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CursoDAO.excluir(this);
    }

    public static List<Curso> obterCursos()
            throws ClassNotFoundException, SQLException {
        return CursoDAO.obterCursos();
    }

    public static Curso obterCurso(int codigoCurso) throws ClassNotFoundException,
            SQLException {
        return CursoDAO.obterCurso(codigoCurso);
    }

}