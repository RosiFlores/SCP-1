/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package javaSCP;

import dao.CampusDAO;
import dao.InstituicaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rosi
 */
public class Campus {

    private int codigoCampus;
    private String nomeCampus;
    private Instituicao instituicao;
    private int chaveInstituicao;

    public Campus(int codigoCampus, String nomeCampus,Instituicao instituicao) {
        this.codigoCampus = codigoCampus;
        this.nomeCampus = nomeCampus;
        this.instituicao = instituicao;
    }

    public int getCodigoCampus() {
        return codigoCampus;
    }

    public void setCodigoCampus(int codigoCampus) {
        this.codigoCampus = codigoCampus;
    }

    public String getNomeCampus() {
        return nomeCampus;
    }

    public void setNomeCampus(String nomeCampus) {
        this.nomeCampus = nomeCampus;
    }
    
    public Instituicao getInstituicao() throws ClassNotFoundException, SQLException {
        if (instituicao == null && chaveInstituicao!= 0) {
            instituicao = InstituicaoDAO.obterInstituicao(chaveInstituicao);
        }
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
    
    public int getChaveInstituicao() {
        return chaveInstituicao;
    }

    public void setChaveInstituicao(int codigoInstituicao) {
        this.chaveInstituicao = codigoInstituicao;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        CampusDAO.gravar(this, instituicao);
        
     }
      public void alterar() throws SQLException, ClassNotFoundException {
         CampusDAO.editar(this);
     }
        public void excluir() throws SQLException, ClassNotFoundException {
         CampusDAO.excluir(this);
     }
    
    
    
    public static List<Campus> obterCampi()
            throws ClassNotFoundException, SQLException {
        return CampusDAO.obterCampi();
    }

    public static Campus obterCampus(int codigoCampus)
            throws ClassNotFoundException, SQLException {
        return CampusDAO.obterCampus(codigoCampus);
        
    }

    
    

    
}