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
import model.Carrinho;

/**
 *
 * @author Angelo
 */
public class CarrinhoDAO extends DAO{
    
    public static Carrinho obterCarrinho (int id) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Carrinho carrinho = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from carrinho, produto, usuario where carrinho.USUARIO_id = usuario.id and carrinho.PRODUTO_id = produto.id  and id = " + id);
            rs.first();
            carrinho = instanciarCarrinho(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return carrinho;
    }
    public static List<Carrinho> obterCarrinhos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Carrinho> carrinhos = new ArrayList<Carrinho>();
        Carrinho carrinho = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from carrinho, produto, usuario where carrinho.USUARIO_id = usuario.id and carrinho.PRODUTO_id = produto.id ");
            while (rs.next()) {
               carrinho = instanciarCarrinho(rs);
                carrinhos.add(carrinho);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return carrinhos;
    }
        public static Carrinho instanciarCarrinho(ResultSet rs)
            throws SQLException {
        Carrinho carrinho= new Carrinho(rs.getInt("id"), null, null);
        
        carrinho.setUsuario_id(rs.getInt("USUARIO_id"));
        carrinho.setProduto_id(rs.getInt("PRODUTO_id"));
        
        
        return carrinho;
    }
        
            public static void gravar(Carrinho carrinho) throws SQLException, ClassNotFoundException, ClassNotFoundException, ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into carrinho( id, USUARIO_id, PRODUTO_id)"
                    + "values(" + carrinho.getId() + ", ";
            
            if(carrinho.getUsuario() == null){
                stringSQL = stringSQL + null;
            }else{
                stringSQL = stringSQL + carrinho.getUsuario().getId();
            }
            
            if(carrinho.getProduto() == null){
                stringSQL = stringSQL + ", " + null;
            }else{
                stringSQL = stringSQL + ", " + carrinho.getProduto().getId()+")";
            }
        
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

                public static void editar(Carrinho carrinho) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = " update carrinho set "
                    + " id = " + carrinho.getId() + "";
            
            
            if(carrinho.getUsuario() == null){
                stringSQL = stringSQL+ "," + null;
            }else{
                stringSQL = stringSQL + ", USUARIO_id = " + carrinho.getUsuario().getId();
            }
            
            if(carrinho.getProduto() == null){
                stringSQL = stringSQL+ "," + null;
            }else{
                stringSQL = stringSQL + ", PRODUTO_id = " + carrinho.getProduto().getId();
            }
            
                        
            stringSQL = stringSQL + " where id = " + carrinho.getId();
            comando.execute(stringSQL);

            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

         public static void excluir(Carrinho carrinho) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from carrinho where id = "
                    + carrinho.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }
        
}
