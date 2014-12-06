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
import javaSCP.Curso;

/**
 *
 * @author Mayara Amanda
 */
public class CursoDAO extends DAO {

    public static Curso obterCurso(int codigoCurso) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Curso curso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from curso, instituicao, orientador, pessoas, tipocurso where "
                    + "curso.instituicao_codigo = instituicao.codigoInstituicao and curso.coordenador = orientador.matricula and "
                    + "orientador.pessoas_codigo=pessoas.codigo and curso.tipoCurso_codigo=tipocurso.codigoTipoCurso and codigoCurso=" + codigoCurso);
            rs.first();
            curso = instanciarCurso(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return curso;
    }

    public static List<Curso> obterCursos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Curso> cursos = new ArrayList<Curso>();
        Curso curso = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from curso, instituicao, orientador, pessoas, tipocurso where "
                    + "curso.instituicao_codigo = instituicao.codigoInstituicao and curso.coordenador = orientador.matricula and "
                    + "orientador.pessoas_codigo=pessoas.codigo and curso.tipoCurso_codigo=tipocurso.codigoTipoCurso");

            while (rs.next()) {
                curso = instanciarCurso(rs);
                cursos.add(curso);

            }

        } finally {
            fecharConexao(conexao, comando);
        }
        return cursos;

    }

    public static Curso instanciarCurso(ResultSet rs)
            throws SQLException, ClassNotFoundException {
        Curso curso = new Curso(rs.getString("nomeCurso"), rs.getInt("codigoCurso"), null, null, null, null);

        curso.setChaveCoordenador(rs.getInt("coordenador"));
        curso.setChaveInstituicao(rs.getInt("instituicao_codigo"));
        curso.setChaveTipoCurso(rs.getInt("tipoCurso_codigo"));
        curso.setChaveCampus(rs.getInt("campus_codigo"));
        return curso;

    }

    public static void gravar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into curso(codigoCurso, nomeCurso, coordenador, instituicao_codigo, campus_codigo, tipocurso_codigo)"
                    + "values (" + curso.getCodigoCurso() + ", '"
                    + curso.getNomeCurso() + "'";

            if (curso.getCoordenador() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "," + curso.getCoordenador().getMatricula();

            }
            
              if (curso.getInstituicao() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "," + curso.getInstituicao().getCodigoInstituicao();
                
            }
               if (curso.getCampus()== null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "," + curso.getCampus().getCodigoCampus();

            }
               if (curso.getTipoCurso() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + "," + curso.getTipoCurso().getCodigoTipoCurso();

            }
               
            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update curso set "
                    + "codigoCurso = " + curso.getCodigoCurso() + ","
                    + "nomeCurso = '" + curso.getNomeCurso() + "'";

            if (curso.getCoordenador() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", coordenador =" + curso.getCoordenador().getMatricula();

            }
            
              if (curso.getInstituicao() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", instituicao_codigo =" + curso.getInstituicao().getCodigoInstituicao();
                
            }
               if (curso.getCampus()== null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", campus_codigo =" + curso.getCampus().getCodigoCampus();

            }
               if (curso.getTipoCurso() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", tipocurso_codigo =" + curso.getTipoCurso().getCodigoTipoCurso();

            }
            
            stringSQL = stringSQL + " where codigoCurso = " + curso.getCodigoCurso();
            comando.execute(stringSQL);

            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from curso where codigoCurso = "
                    + curso.getCodigoCurso();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}