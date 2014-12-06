/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CarrinhoDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Venda {

    private int id;
    private int quant_vendida;
    private float total;
    private int usuario_id;
    private int produto_id;
    private int carrinho_id;
    private Usuario usuario;
    private Produto produto;
    private Carrinho carrinho;

    public Venda(int id, int quant_vendida, float total, Usuario usuario, Produto produto, Carrinho carrinho) {

        this.id = id;
        this.quant_vendida = quant_vendida;
        this.total = total;
        this.usuario = usuario;
        this.produto = produto;
        this.carrinho = carrinho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuant_vendida() {
        return quant_vendida;
    }

    public void setQuant_vendida(int quant_vendida) {
        this.quant_vendida = quant_vendida;
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

    public int getCarrinho_id() {
        return carrinho_id;
    }

    public void setCarrinho_id(int carrinho_id) {
        this.carrinho_id = carrinho_id;
    }

    public Carrinho getCarrinho() throws ClassNotFoundException, SQLException {
        if (carrinho == null && carrinho_id != 0) {
            carrinho = CarrinhoDAO.obterCarrinho(carrinho_id);
        }
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        VendaDAO.gravar(this);
    }

    public void editar() throws SQLException, ClassNotFoundException {
        VendaDAO.editar(this);
    }

    public static List<Venda> obterVendas()
            throws ClassNotFoundException, SQLException {
        return VendaDAO.obterVendas();

    }

    public static Venda obterVenda(int id) throws ClassNotFoundException,
            SQLException {
        return VendaDAO.obterVenda(id);
    }
}
