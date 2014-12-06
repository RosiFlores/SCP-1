/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSCP;

import dao.SubAreaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class SubArea {

    private int codigoSubArea;
    private String nomeSubArea;

    public SubArea(int codigoSubArea, String nomeSubArea) {
        this.codigoSubArea = codigoSubArea;
        this.nomeSubArea = nomeSubArea;
    }

    public int getCodigoSubArea() throws ClassNotFoundException, SQLException {
        return codigoSubArea;
    }

    public void setCodigoSubArea(int codigoSubArea) {
        this.codigoSubArea = codigoSubArea;
    }

    public String getNomeSubArea() {
        return nomeSubArea;
    }

    public void setNomeSubArea(String nomeSubArea) {
        this.nomeSubArea = nomeSubArea;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
         SubAreaDAO.gravar(this);
     }
      public void editar() throws SQLException, ClassNotFoundException {
         SubAreaDAO.editar(this);
     }
        public void excluir() throws SQLException, ClassNotFoundException {
         SubAreaDAO.excluir(this);
     }
    public static List<SubArea> obterSubAreas()
            throws ClassNotFoundException, SQLException {
        return SubAreaDAO.obterSubAreas();

    }
 public static SubArea obterSubArea(int codigoSubArea) throws ClassNotFoundException, 
            SQLException {
    return SubAreaDAO.obterSubArea(codigoSubArea);
}
}