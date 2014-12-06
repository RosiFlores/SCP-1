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
import model.Usuario;

/**
 *
 * @author Angelo
 */
public class UsuarioDAO extends DAO{
    
        public static Usuario obterUsuario(int id) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from usuario where id = " + id);
            rs.first();
            usuario = instanciarUsuario(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return usuario;
    }

        public static List<Usuario> obterUsuarios()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from usuario");
            while (rs.next()) {
                usuario = instanciarUsuario(rs);
                usuarios.add(usuario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return usuarios;
    }


            public static Usuario instanciarUsuario(ResultSet rs)
            throws SQLException {
        Usuario usuario= new Usuario(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("rg"), rs.getString("dt_nasc"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"),rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("uf"), rs.getString("telefone"), rs.getString("email"), rs.getString("senha"));
        
        return usuario;
    }

            public static void gravar(Usuario usuario) throws SQLException, ClassNotFoundException, ClassNotFoundException, ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into usuario( id,cpf, nome, rg, dt_nasc, cep, logradouro, numero, complemento, bairro, cidade, uf, telefone, email, senha)"
                    + "values(" + usuario.getId() + ",'"
                    + usuario.getCpf() + "','"
                    + usuario.getNome() + "','"
                    + usuario.getRg() + "','"
                    + usuario.getDt_nasc() + "','"
                    + usuario.getCep() + "','"
                    + usuario.getLogradouro() + "','"
                    + usuario.getNumero() + "','"
                    + usuario.getComplemento() + "','"
                    + usuario.getBairro() + "','"
                    + usuario.getCidade() + "','"
                    + usuario.getUf() + "','"
                    + usuario.getTelefone() + "','"
                    + usuario.getEmail() + "','"
                    + usuario.getSenha() + "')";

            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update usuario set "
                    + "cpf = '" + usuario.getCpf() + "',"
                    + "nome = '" + usuario.getNome() + "',"
                    + "rg = '" + usuario.getRg() + "',"
                    + "dt_nasc = '" + usuario.getDt_nasc() + "',"
                    + "cep = '" + usuario.getCep() + "',"
                    + "logradouro = '" + usuario.getLogradouro() + "',"
                    + "numero = '" + usuario.getNumero() + "',"
                    + "complemento = '" + usuario.getBairro() + "',"
                    + "cidade = '" + usuario.getCidade() + "',"
                    + "uf = '" + usuario.getUf() + "',"
                    + "telefone = '" + usuario.getTelefone() + "',"
                    + "email = '" + usuario.getEmail() + "',"
                    + "senha = '" + usuario.getSenha() + "'";
            
            stringSQL = stringSQL + " where id = " + usuario.getId();
            comando.execute(stringSQL);

            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
