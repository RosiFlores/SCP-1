package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaSCP.TipoBolsa;

/**
 *
 * @author Angelo
 */
public class TipoBolsaDAO extends DAO {

    public static TipoBolsa obterTipoBolsa(int codigoTipoBolsa) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        TipoBolsa tipoBolsa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tipobolsa where codigoTipoBolsa = " + codigoTipoBolsa);
            rs.first();
            tipoBolsa = instanciarTipoBolsa(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipoBolsa;
    }

    public static List<TipoBolsa> obterTipoBolsas()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoBolsa> tipoBolsas = new ArrayList<TipoBolsa>();
        TipoBolsa tipoBolsa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tipobolsa");
            while (rs.next()) {
                tipoBolsa = instanciarTipoBolsa(rs);
                tipoBolsas.add(tipoBolsa);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipoBolsas;
    }

    public static TipoBolsa instanciarTipoBolsa(ResultSet rs)
            throws SQLException {
        TipoBolsa tipoBolsa = new TipoBolsa(rs.getInt("codigoTipoBolsa"), rs.getString("nomeTipoBolsa"));
        return tipoBolsa;
    }

public static void gravar(TipoBolsa tipobolsa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into tipobolsa(codigoTipoBolsa, nomeTipoBolsa)"
                    + "values(" + tipobolsa.getCodigoTipoBolsa() + ", '"
                    + tipobolsa.getNomeTipoBolsa() + "')";
            
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void editar(TipoBolsa tipobolsa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tipobolsa set "
                    + "codigoTipoBolsa = " + tipobolsa.getCodigoTipoBolsa() + ","
                    + "nomeTipoBolsa = '" + tipobolsa.getNomeTipoBolsa() + "'";

            stringSQL = stringSQL + " where codigoTipoBolsa = " + tipobolsa.getCodigoTipoBolsa();
            comando.execute(stringSQL);

            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
     public static void excluir(TipoBolsa tipobolsa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tipobolsa where codigoTipoBolsa = "
                    + tipobolsa.getCodigoTipoBolsa();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}