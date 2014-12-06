/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaSCP.Bolsista;

/**
 *
 * @author Mayara Amanda
 */
public class BolsistaDAO extends DAO {

    public static Bolsista obterBolsista(int matricula) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Bolsista bolsista = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from bolsista, pessoas, curso, projeto where bolsista.pessoas_codigo = pessoas.codigo and bolsista.curso_codigo = curso.codigoCurso and bolsista.projeto_codigo = projeto.codigoProjeto and matricula = " + matricula);
            rs.first();
            bolsista = instanciarBolsista(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return bolsista;
    }

    public static List<Bolsista> obterBolsistas()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Bolsista> bolsistas = new ArrayList<Bolsista>();
        Bolsista bolsista = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from bolsista, pessoas, curso, projeto where bolsista.pessoas_codigo = pessoas.codigo and bolsista.curso_codigo = curso.codigoCurso and bolsista.projeto_codigo = projeto.codigoProjeto");
            while (rs.next()) {
                bolsista = instanciarBolsista(rs);
                bolsistas.add(bolsista);

            }

        } finally {
            fecharConexao(conexao, comando);
        }
        return bolsistas;

    }

    public static Bolsista instanciarBolsista(ResultSet rs)
            throws SQLException {
        Bolsista bolsista = new Bolsista(rs.getInt("matricula"), rs.getInt("contaCorrente"), rs.getString("nomeBanco"), rs.getInt("agencia"), rs.getInt("codigo"), rs.getString("nome"), rs.getString("dataNascimento"),
                rs.getString("estadoCivil"), rs.getString("nacionalidade"), rs.getString("ufNascimento"), rs.getString("nomeMae"),
                rs.getString("nomePai"), rs.getString("naturalidade"), rs.getString("grupoSanguineo"), rs.getString("fatorRH"),
                rs.getString("sexo"), rs.getString("necessidadeEspecial"), rs.getString("cor"), rs.getString("escolaridade"),
                rs.getString("rua"), rs.getInt("numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"),
                rs.getInt("cep"), rs.getString("uf"), rs.getString("pais"), rs.getString("email"),
                rs.getInt("rg"), rs.getString("orgaoExpedidor"), rs.getInt("tituloEleitor"), rs.getInt("numeroComprovanteMilitar"),
                rs.getInt("cpf"), rs.getInt("pisPasep"), rs.getString("dataExpedicaoRG"), rs.getInt("campus_codigo"), null, null, null);

        bolsista.setCodigoCurso(rs.getInt("curso_codigo"));
        bolsista.setCodigoPessoa(rs.getInt("pessoas_codigo"));
        bolsista.setCodigoProjeto(rs.getInt("projeto_codigo"));
        return bolsista;

    }

    public static void gravar(Bolsista bolsista) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            stringSQL = "insert into pessoas(codigo, nome, dataNascimento, estadoCivil, nacionalidade,  ufNascimento, nomeMae, "
                    + "nomePai, naturalidade, grupoSanguineo, fatorRH, sexo, necessidadeEspecial, cor, escolaridade, rua, numero, "
                    + "complemento, bairro, cidade, cep, uf, pais, email, rg, orgaoExpedidor, tituloEleitor, numeroComprovanteMilitar, "
                    + "cpf, pisPasep, dataExpedicaoRG, campus_codigo)"
                    + " values(" + bolsista.getCodigo() + ", '"
                    + bolsista.getNome() + "', '"
                    + bolsista.getDataNascimento() + "','"
                    + bolsista.getEstadoCivil() + "', '"
                    + bolsista.getNacionalidade() + "', '"
                    + bolsista.getUfNascimento() + "', '"
                    + bolsista.getNomeMae() + "','"
                    + bolsista.getNomePai() + "', '"
                    + bolsista.getNaturalidade() + "', '"
                    + bolsista.getGrupoSanguineo() + "', '"
                    + bolsista.getFatorRH() + "', '"
                    + bolsista.getSexo() + "', '"
                    + bolsista.getNecessidadeEspecial() + "', '"
                    + bolsista.getCor() + "', '"
                    + bolsista.getEscolaridade() + "', '"
                    + bolsista.getRua() + "', "
                    + bolsista.getNumero() + ", '"
                    + bolsista.getComplemento() + "', '"
                    + bolsista.getBairro() + "', '"
                    + bolsista.getCidade() + "',"
                    + bolsista.getCep() + ", '"
                    + bolsista.getUf() + "', '"
                    + bolsista.getPais() + "', '"
                    + bolsista.getEmail() + "', "
                    + bolsista.getRg() + ", '"
                    + bolsista.getOrgaoExpedidor() + "', "
                    + bolsista.getTituloEleitor() + ", "
                    + bolsista.getNumeroComprovanteMilitar() + ", "
                    + bolsista.getCpf() + ", "
                    + bolsista.getPisPasep() + ", '"
                    + bolsista.getDataExpedicaoRG() + "'";
            

            if (bolsista.getCampus() == null) {
                stringSQL = stringSQL + ", " + null;
            } else {
                stringSQL = stringSQL + ", " + bolsista.getCampus().getCodigoCampus();
            }

            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
            
            stringSQL = "insert into bolsista(matricula, contaCorrente, nomeBanco, agencia, pessoas_codigo, curso_codigo, projeto_codigo)"
                    + " values(" + bolsista.getMatricula() + ", "
                    + bolsista.getContaCorrente() + ", '"
                    + bolsista.getNomeBanco() + "', "
                    + bolsista.getAgencia() + ","
                    + bolsista.getCodigo() + "";
                    
            
              if (bolsista.getCurso() == null) {
                stringSQL = stringSQL  + "," +  null;
            } else {
                stringSQL = stringSQL + "," + bolsista.getCurso().getCodigoCurso();
            }
              
              if (bolsista.getProjeto() == null) {
                stringSQL = stringSQL + "," + null;
            } else {
                stringSQL = stringSQL + "," + bolsista.getProjeto().getCodigoProjeto();
            }


            stringSQL = stringSQL + ")";
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void editar(Bolsista bolsista) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            stringSQL = "update pessoas set "
                    + "cpf = " + bolsista.getCpf() + ", "
                    + "nome = '" + bolsista.getNome() + "', "
                    + "dataNascimento ='" + bolsista.getDataNascimento() + "',"
                    + "estadoCivil = '" + bolsista.getEstadoCivil() + "', "
                    + "nacionalidade = '" + bolsista.getNacionalidade() + "', "
                    + "ufNascimento='" + bolsista.getUfNascimento() + "', "
                    + "nomeMae = '" + bolsista.getNomeMae() + "',"
                    + "nomePai = '" + bolsista.getNomePai() + "', "
                    + "naturalidade ='" + bolsista.getNaturalidade() + "', "
                    + "grupoSanguineo = '" + bolsista.getGrupoSanguineo() + "', "
                    + "fatorRH = '" + bolsista.getFatorRH() + "', "
                    + "sexo ='" + bolsista.getSexo() + "', "
                    + "necessidadeEspecial = '" + bolsista.getNecessidadeEspecial() + "', "
                    + "cor = '" + bolsista.getCor() + "', "
                    + "escolaridade ='" + bolsista.getEscolaridade() + "', "
                    + "rua ='" + bolsista.getRua() + "', "
                    + "numero = " + bolsista.getNumero() + ", "
                    + "complemento ='" + bolsista.getComplemento() + "', "
                    + "bairro ='" + bolsista.getBairro() + "', "
                    + "cidade ='" + bolsista.getCidade() + "',"
                    + "cep=" + bolsista.getCep() + ", "
                    + "uf='" + bolsista.getUf() + "', "
                    + "pais='" + bolsista.getPais() + "', "
                    + "email='" + bolsista.getEmail() + "', "
                    + "rg =" + bolsista.getRg() + ", "
                    + "orgaoExpedidor ='" + bolsista.getOrgaoExpedidor() + "', "
                    + "tituloEleitor =" + bolsista.getTituloEleitor() + ", "
                    + "numeroComprovanteMilitar =" + bolsista.getNumeroComprovanteMilitar() + ", "
                    + "pisPasep =" + bolsista.getPisPasep() + ", "
                    + "dataExpedicaoRG ='" + bolsista.getDataExpedicaoRG() + "'";

                      
            if (bolsista.getCampus() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ", campus_codigo = " + bolsista.getCampus().getCodigoCampus();
            }

            stringSQL = stringSQL + " where codigo = " + bolsista.getCodigo();
            
            comando.execute(stringSQL);
            
            stringSQL = " update bolsista set "
                    
                    + "contaCorrente = " + bolsista.getContaCorrente() + ","
                    + "nomeBanco = '" + bolsista.getNomeBanco() + "',"
                    + "agencia = " + bolsista.getAgencia() + "";

            if (bolsista.getCodigo() == 0) {
              stringSQL = stringSQL + null;
            } else {
               stringSQL = stringSQL + " , pessoas_codigo = " + bolsista.getCodigo() + "";
           }

            if (bolsista.getCurso()== null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + " , curso_codigo = " + bolsista.getCurso().getCodigoCurso() + "";
            }

            if (bolsista.getProjeto() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + " , projeto_codigo = " + bolsista.getProjeto().getCodigoProjeto();
            }

            stringSQL = stringSQL + " where matricula = " + bolsista.getMatricula();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Bolsista bolsista)
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from bolsista where matricula = " + bolsista.getMatricula();
            comando.execute(stringSQL);
            stringSQL = "delete from pessoas where codigo = " + bolsista.getCodigo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}
