package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaSCP.Campus;
import javaSCP.Nucleo;

/**
 *
 * @author Mayara Amanda
 */
public class NucleoDAO extends DAO {

    public static Nucleo obterNucleo(int codigoNucleo) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Nucleo nucleo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from nucleo where codigoNucleo = " + codigoNucleo);
            rs.first();
            nucleo = instanciarNucleo(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return nucleo;
    }

    public static List<Nucleo> obterNucleos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Nucleo> nucleos = new ArrayList<Nucleo>();
        Nucleo nucleo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement(); 
            ResultSet rs = comando.executeQuery("select * from nucleo, campus where nucleo.campus_codigo = campus.codigoCampus");
            while (rs.next()) {
                nucleo = instanciarNucleo(rs);
                nucleos.add(nucleo);
            }
        } finally {
            fecharConexao(conexao, comando);

        }
        return nucleos;
    }

    public static Nucleo instanciarNucleo(ResultSet rs)
            throws SQLException {
        Nucleo nucleo = new Nucleo(rs.getInt("codigoNucleo"), rs.getString("nomeNucleo"), null);
        
        nucleo.setChaveCampus(rs.getInt("campus_codigo"));
       

        return nucleo;
    }

    public static void gravar(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into nucleo(codigoNucleo, nomeNucleo, campus_codigo)"
                    + "values(" + nucleo.getCodigoNucleo() + ", '"
                    + nucleo.getNomeNucleo() + "',";

            if (nucleo.getCampus() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + nucleo.getCampus().getCodigoCampus();

            }
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    public static void editar(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update nucleo set "
                    + "codigoNucleo = " + nucleo.getCodigoNucleo() + ","
                    + "nomeNucleo = '" + nucleo.getNomeNucleo() + "'";

            if (nucleo.getCampus() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", campus_codigo = " + nucleo.getCampus().getCodigoCampus();

            }
            
            stringSQL = stringSQL + " where codigoNucleo = " + nucleo.getCodigoNucleo();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from nucleo where codigoNucleo = "
                    + nucleo.getCodigoNucleo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}