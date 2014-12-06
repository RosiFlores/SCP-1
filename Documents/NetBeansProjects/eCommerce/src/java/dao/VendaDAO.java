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
import model.Venda;

/**
 *
 * @author Angelo
 */
public class VendaDAO extends DAO{
        public static Venda obterVenda (int id) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        Venda venda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from vendas, carrinho, produto, usuario where vendas.USUARIO_id = usuario.id and vendas.PRODUTO_id = produto.id  and vendas.carrinho_id = carrinho.id and id = " + id);
            rs.first();
            venda = instanciarVenda(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return venda;
    }

        public static List<Venda> obterVendas()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Venda> vendas = new ArrayList<Venda>();
        Venda venda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from vendas, carrinho, produto, usuario where vendas.USUARIO_id = usuario.id and vendas.PRODUTO_id = produto.id  and vendas.carrinho_id = carrinho.id ");
            while (rs.next()) {
               venda = instanciarVenda(rs);
                vendas.add(venda);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return vendas;
    }
        
        public static Venda instanciarVenda(ResultSet rs)
            throws SQLException {
        
        Venda venda = new Venda (rs.getInt("id"), rs.getInt("quant_vendida"), rs.getFloat("total"), null, null, null);
        
        venda.setUsuario_id(rs.getInt("USUARIO_id"));
        venda.setProduto_id(rs.getInt("PRODUTO_id"));
        venda.setCarrinho_id(rs.getInt("CARRINHO_id"));
        
        return venda;
    }
            public static void gravar(Venda venda) throws SQLException, ClassNotFoundException, ClassNotFoundException, ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "insert into vendas ( id,quant_vendida, total, USUARIO_id, PRODUTO_id, CARRINHO_id)"
                    + "values(" + venda.getId() + ","
                    + venda.getQuant_vendida() + ","
                    + venda.getTotal() + ",";
            
            if(venda.getUsuario() == null){
                stringSQL = stringSQL + null;
            }else{
                stringSQL = stringSQL + venda.getUsuario().getId();
            }
            
            if(venda.getProduto() == null){
                stringSQL = stringSQL + "," + null;
            }else{
                stringSQL = stringSQL + "," + venda.getProduto().getId();
            }
            if(venda.getCarrinho() == null){
                stringSQL = stringSQL + "," + null;
            }else{
                stringSQL = stringSQL + "," + venda.getCarrinho().getId();
            }
            
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

            public static void editar(Venda venda) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = " update vendas set "
                    + " id = " + venda.getId() + "";
            
            if(venda.getUsuario() == null){
                stringSQL = stringSQL+ "," + null;
            }else{
                stringSQL = stringSQL + ", USUARIO_id = " + venda.getUsuario().getId();
            }
            
            if(venda.getProduto() == null){
                stringSQL = stringSQL+ "," + null;
            }else{
                stringSQL = stringSQL + ", PRODUTO_id = " + venda.getProduto().getId();
            }
                    
            if(venda.getCarrinho() == null){
                stringSQL = stringSQL+ "," + null;
            }else{
                stringSQL = stringSQL + ", CARRINHO_id = " + venda.getCarrinho().getId();
            }
            
                        
            stringSQL = stringSQL + " where id = " + venda.getId();
            comando.execute(stringSQL);

            
        } finally {
            fecharConexao(conexao, comando);
        }
    }
            public static void excluir(Venda venda) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from vendas where id = "
                    + venda.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
