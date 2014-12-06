/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CarrinhoDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Carrinho {

    private int id;
    private int usuario_id;
    private int produto_id;
    ;
    private Usuario usuario;
    private Produto produto;

    public Carrinho(int id, Usuario usuario, Produto produto) {
        this.id = id;
        this.usuario = usuario;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public Usuario getUsuario() throws ClassNotFoundException, SQLException {
        if (usuario == null && usuario_id != 0) {
            usuario = UsuarioDAO.obterUsuario(usuario_id);
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() throws ClassNotFoundException, SQLException {
        if (produto == null && produto_id != 0) {
            produto = ProdutoDAO.obterProduto(produto_id);
        }

        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        CarrinhoDAO.gravar(this);
    }

    public void editar() throws SQLException, ClassNotFoundException {
        CarrinhoDAO.editar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CarrinhoDAO.excluir(this);
    }

    public static List<Carrinho> obterCarrinhos()
            throws ClassNotFoundException, SQLException {
        return CarrinhoDAO.obterCarrinhos();

    }

    public static Carrinho obterCarrinho(int id) throws ClassNotFoundException,
            SQLException {
        return CarrinhoDAO.obterCarrinho(id);
    }

}
