/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Produto {
   
   private int id;
   private String nome;
   private float preco;

    public Produto(int id, String nome, float preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

      
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
   
   public void gravar() throws SQLException, ClassNotFoundException {
        ProdutoDAO.gravar(this);
    }
    public void editar() throws SQLException, ClassNotFoundException{
      ProdutoDAO.editar(this);
    }
    
    //public void excluir() throws SQLException, ClassNotFoundException{
     //ProdutoDAO.excluir(this);
    //}
       public static List<Produto> obterProdutos()
            throws ClassNotFoundException, SQLException {
        return ProdutoDAO.obterProdutos();

    }

    public static Produto obterProduto(int id ) throws ClassNotFoundException,
            SQLException {
        return ProdutoDAO.obterProduto(id);
    }
}
