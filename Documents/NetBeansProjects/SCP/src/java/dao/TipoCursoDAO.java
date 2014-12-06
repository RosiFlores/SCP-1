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
import javaSCP.TipoCurso;
/**
 *
 * @author Angelo
 */
public class TipoCursoDAO {
    
    
   
    public static TipoCurso obterTipoCurso(int codigoTipoCurso) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        TipoCurso tipoCurso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from tipocurso where codigoTipoCurso = " + codigoTipoCurso);
            rs.first();
            tipoCurso = instanciarTipoCurso(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipoCurso;
    } 
    
     public static List<TipoCurso> obterTipoCursos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoCurso> tipoCursos = new ArrayList<TipoCurso>();
        TipoCurso tipoCurso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tipocurso");
            while (rs.next()) {
                tipoCurso = instanciarTipoCurso(rs);
                tipoCursos.add(tipoCurso);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipoCursos;
    }
    public static TipoCurso instanciarTipoCurso(ResultSet rs)
            throws SQLException {
        TipoCurso tipoCurso = new TipoCurso(rs.getInt("codigoTipoCurso"), rs.getString("nomeTipoCurso"));
        
        
        
        return tipoCurso;
}

public static void gravar(TipoCurso tipocurso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

           stringSQL = "insert into tipocurso(codigoTipoCurso, nomeTipoCurso)"
                    + "values(" + tipocurso.getCodigoTipoCurso() + ",'"
                    + tipocurso.getNomeTipoCurso() + "')";

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(TipoCurso tipocurso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tipocurso set "
                    + "codigoTipoCurso = " + tipocurso.getCodigoTipoCurso() + ","
                    + "nomeTipoCurso = '" + tipocurso.getNomeTipoCurso() + "'";

            stringSQL = stringSQL + " where codigoTipoCurso = " + tipocurso.getCodigoTipoCurso();
            comando.execute(stringSQL);

            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(TipoCurso tipocurso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tipocurso where codigoTipoCurso = "
                    + tipocurso.getCodigoTipoCurso();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}