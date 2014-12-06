/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSCP;

import dao.TipoCursoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class TipoCurso {

    private int codigoTipoCurso;
    private String nomeTipoCurso;

    public TipoCurso(int codigoTipoCurso, String nomeTipoCurso) {
        this.nomeTipoCurso = nomeTipoCurso;
        this.codigoTipoCurso = codigoTipoCurso;

    }

    public String getNomeTipoCurso() {
        return nomeTipoCurso;
    }

    public void setNomeTipoCurso(String nomeTipoCurso) {
        this.nomeTipoCurso = nomeTipoCurso;
    }

    public int getCodigoTipoCurso() {
        return codigoTipoCurso;
    }

    public void setCodigoTipoCurso(int codigoTipoCurso) {
        this.codigoTipoCurso = codigoTipoCurso;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
         TipoCursoDAO.gravar(this);
     }
      public void editar() throws SQLException, ClassNotFoundException {
         TipoCursoDAO.editar(this);
     }
        public void excluir() throws SQLException, ClassNotFoundException {
         TipoCursoDAO.excluir(this);
     }
        
    public static List<TipoCurso> obterTipoCursos()
            throws ClassNotFoundException, SQLException {
        return TipoCursoDAO.obterTipoCursos();
    }

    public static TipoCurso obterTipoCurso(int codigoTipoCurso) throws ClassNotFoundException,
            SQLException {
        return TipoCursoDAO.obterTipoCurso(codigoTipoCurso);
    }
}