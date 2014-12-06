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
import javaSCP.Campus;
import javaSCP.Instituicao;

/**
 *
 * @author Mayara Amanda
 */
public class CampusDAO extends DAO {

    public static Campus obterCampus(int codigoCampus) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Campus campus = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from campus,instituicao where campus.instituicao_codigo = instituicao.codigoInstituicao and codigoCampus = " + codigoCampus);
            rs.first();
            campus = instanciarCampus(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return campus;
    }

    public static List<Campus> obterCampi()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Campus> campi = new ArrayList<Campus>();
        Campus campus = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from campus,instituicao where campus.instituicao_codigo = instituicao.codigoInstituicao");
            while (rs.next()) {
                campus = instanciarCampus(rs);
                campi.add(campus);

            }

        } finally {
            fecharConexao(conexao, comando);
        }

        return campi;

    }

    public static Campus instanciarCampus(ResultSet rs)
            throws SQLException {
        Campus campus = new Campus(rs.getInt("codigoCampus"), rs.getString("nomeCampus"), null);

        campus.setChaveInstituicao(rs.getInt("instituicao_codigo"));

        return campus;
    }

    public static void gravar(Campus campus, Instituicao instituicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into campus(codigoCampus, nomeCampus, instituicao_codigo)"
                    + "values(" + campus.getCodigoCampus() + ", '"
                    + campus.getNomeCampus() + "'";

            if (campus.getInstituicao() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + "," + campus.getInstituicao().getCodigoInstituicao();
            }

            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void editar(Campus campus) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update campus set "
                    + "codigoCampus = " + campus.getCodigoCampus() + ","
                    + "nomeCampus = '" + campus.getNomeCampus() + "'";

            if (campus.getInstituicao() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + ", instituicao_codigo =" + campus.getInstituicao().getCodigoInstituicao();
            }

            stringSQL = stringSQL + " where codigoCampus = " + campus.getCodigoCampus();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Campus campus) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from campus where codigoCampus = "
                    + campus.getCodigoCampus();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}