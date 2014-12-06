/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaSCP.Edital;

/**
 *
 * @author Mayara Amanda
 */
public class EditalDAO extends DAO {

    public static Edital obterEdital(int codigoEdital) 
            throws ClassNotFoundException, SQLException{

        Connection conexao = null;
        Statement comando = null;
        Edital edital = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from edital, subareaconhecimento, campus, tipobolsa where edital.subareaconhecimento_codigo = subareaconhecimento.codigoSubArea and edital.campus_codigo = campus.codigoCampus and edital.tipobolsa_codigo = tipobolsa.codigoTipoBolsa and codigoEdital = " + codigoEdital);
            rs.first();
            edital = instanciarEdital(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return edital;
    }         
    

    
    
    public static List<Edital> obterEditais()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Edital> editais = new ArrayList<Edital>();
        Edital edital = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from edital, subareaconhecimento, campus, tipobolsa where edital.subareaconhecimento_codigo = subareaconhecimento.codigoSubArea and edital.campus_codigo = campus.codigoCampus and edital.tipobolsa_codigo = tipobolsa.codigoTipoBolsa");

            while (rs.next()) {
                edital = instanciarEdital(rs);
                editais.add(edital);

            }

        } finally {
            fecharConexao(conexao, comando);
        }
        return editais;

    }

    public static Edital instanciarEdital(ResultSet rs)
            throws SQLException {
        Edital edital = new Edital(rs.getInt("codigoEdital"),rs.getInt("numeroEdital"), rs.getInt("anoEdital"), rs.getInt("quantidadeBolsa"), rs.getInt("validadeBolsa"), rs.getFloat("valorBolsa"), rs.getInt("validadeEdital"),null,null,null);
        
        edital.setCodigoCampus(rs.getInt("campus_codigo"));
        edital.setCodigoSubArea(rs.getInt("subareaconhecimento_codigo"));
        edital.setCodigoTipoBolsa(rs.getInt("tipoBolsa_codigo"));
        
        return edital;

    }
    
       
     public static void gravar(Edital edital) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            
            stringSQL = "insert into edital(codigoEdital, numeroEdital, anoEdital, validadeEdital, valorBolsa, quantidadeBolsa, validadeBolsa, subareaconhecimento_codigo, campus_codigo, tipobolsa_codigo)"
                    + "values(" + edital.getCodigoEdital() + ", "
                    + edital.getNumeroEdital() + ","
                    + edital.getAnoEdital() + ","
                    + edital.getValidadeEdital() + ","
                    + edital.getValorBolsa() + ","
                    + edital.getQuantidadeBolsas() + ","
                    + edital.getValidadeBolsa()+ ",";
            
            if (edital.getSubArea() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + edital.getSubArea().getCodigoSubArea();

            }
            
            if (edital.getCampus() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + "," + edital.getCampus().getCodigoCampus();

            }
            
            if (edital.getTipoBolsa() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + "," + edital.getTipoBolsa().getCodigoTipoBolsa();

            }
                        
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
            
            
        } finally {
            fecharConexao(conexao, comando);
        }

    }
     public static void editar(Edital edital) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            stringSQL = "update edital set "

                    + "codigoEdital = " + edital.getCodigoEdital() + ","
                    + "numeroEdital = " + edital.getNumeroEdital() + ","
                    + "anoEdital = " + edital.getAnoEdital() + ","
                    + "validadeEdital = " +edital.getValidadeEdital() + ","
                    + "valorBolsa = " + edital.getValorBolsa() +","
                    + "quantidadeBolsa = " + edital.getQuantidadeBolsas() + ","
                    + "validadeBolsa = " +edital.getValidadeBolsa() + "";

                      // subareaconhecimento_codigo, campus_codigo, tipobolsa_codigo
            
            
            if (edital.getSubArea() == null) {
                stringSQL = stringSQL+ "," + null;
            } else {
                stringSQL = stringSQL + ", subareaconhecimento_codigo = " + edital.getSubArea().getCodigoSubArea();
            }
            
            if (edital.getCampus() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + ", campus_codigo = " + edital.getCampus().getCodigoCampus();
            }
            
            if (edital.getTipoBolsa() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + ", tipoBolsa_codigo = " + edital.getTipoBolsa().getCodigoTipoBolsa();
            }
            
            stringSQL = stringSQL + " where codigoEdital = " + edital.getCodigoEdital();
            
            comando.execute(stringSQL);
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
public static void excluir(Edital edital)
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from edital where codigoEdital = " + edital.getCodigoEdital();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

     
}