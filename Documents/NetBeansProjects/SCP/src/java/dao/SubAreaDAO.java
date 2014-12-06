package dao;

/**
 *
 * @author Angelo
 */
import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaSCP.SubArea;

public class SubAreaDAO extends DAO {

    public static SubArea obterSubArea(int codigoSubArea) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        SubArea subArea = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from subareaconhecimento where codigoSubArea=" + codigoSubArea);
            rs.first();
            subArea = instanciarSubArea(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return subArea;
    }

    public static List<SubArea> obterSubAreas()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<SubArea> subAreas = new ArrayList<SubArea>();
        SubArea subArea = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from subareaconhecimento");
            while (rs.next()) {
                subArea = instanciarSubArea(rs);
                subAreas.add(subArea);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return subAreas;
    }

    public static SubArea instanciarSubArea(ResultSet rs)
            throws SQLException {
        SubArea subArea = new SubArea(rs.getInt("codigoSubArea"), rs.getString("nomeSubArea"));
        return subArea;
    }

    public static void gravar(SubArea subarea) throws SQLException, ClassNotFoundException, ClassNotFoundException, ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into subareaconhecimento(codigoSubArea, nomeSubArea)"
                    + "values(" + subarea.getCodigoSubArea() + ",'"
                    + subarea.getNomeSubArea() + "')";

            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(SubArea subarea) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update subareaconhecimento set "
                    + "codigoSubArea = " + subarea.getCodigoSubArea() + ","
                    + "nomeSubArea = '" + subarea.getNomeSubArea() + "'";

            stringSQL = stringSQL + " where codigoSubArea = " + subarea.getCodigoSubArea();
            comando.execute(stringSQL);

            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(SubArea subarea) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from subareaconhecimento where codigoSubArea = "
                    + subarea.getCodigoSubArea();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}