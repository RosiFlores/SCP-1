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
import model.Produto;



/**
 *
 * @author Angelo
 */
public class ProdutoDAO extends DAO{
    
        public static Produto obterProduto(int id) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Produto produto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from produto where id = " + id);
            rs.first();
            produto = instanciarProduto(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return produto;
    }
        
            public static List<Produto> obterProdutos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Produto> produtos = new ArrayList<Produto>();
        Produto produto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from produto");
            while (rs.next()) {
                produto = instanciarProduto(rs);
                produtos.add(produto);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return produtos;
    }
        
        public static Produto instanciarProduto(ResultSet rs)
            throws SQLException {
        Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getFloat("preco"));
        
        return produto;
    }

            public static void gravar(Produto produto) throws SQLException, ClassNotFoundException, ClassNotFoundException, ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into usuario( id, nome, preco)"
                    + "values(" + produto.getId() + ",'"
                    + produto.getNome() + "',"
                    + produto.getPreco() + ")";

            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

            
    public static void editar(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update usuario set "
                    + "id = " + produto.getId() + ","
                    + "nome = '" + produto.getNome() + "',"
                    + "preco = " + produto.getPreco() + "";
            
            stringSQL = stringSQL + " where id = " + produto.getId();
            comando.execute(stringSQL);

            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

            
            
}
