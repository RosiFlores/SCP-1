/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.Produto;
import model.Usuario;
import model.Venda;

/**
 *
 * @author Angelo
 */
public class CadastrarVendaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("usuarios", Usuario.obterUsuarios());
            request.setAttribute("produtos", Produto.obterProdutos());
            request.setAttribute("carrinhos", Carrinho.obterCarrinhos());

            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Venda venda = Venda.obterVenda(id);
                request.setAttribute("venda", venda);
            }
            RequestDispatcher view = request.getRequestDispatcher("/PesquisarVendaController.jsp");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ServletException, IOException, SQLException, ClassNotFoundException {

        String operacao = request.getParameter("operacao");
        int id = Integer.parseInt(request.getParameter("id"));
        int quant_vendida = Integer.parseInt(request.getParameter("quant_vendida"));
        float total = Float.parseFloat(request.getParameter("total"));
        int usuario_id = Integer.parseInt(request.getParameter("usuario_id"));
        int produto_id = Integer.parseInt(request.getParameter("produto_id"));
        int carrinho_id = Integer.parseInt(request.getParameter("carrinho_id"));
        try {
            Usuario usuario = null;
            if (usuario_id != 0) {
                usuario = Usuario.obterUsuario(usuario_id);
            }
            Produto produto = null;
            if (produto_id != 0) {
                produto = Produto.obterProduto(produto_id);
            }
            Carrinho carrinho = null;
            if (carrinho_id != 0) {
                carrinho = Carrinho.obterCarrinho(id);
            }

            Venda venda = new Venda(id, quant_vendida, total, usuario, produto, carrinho);

            if (operacao.equals("Incluir")) {
                venda.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    venda.editar();
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarVendaController");
            view.forward(request, response);

        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw new ServletException(e);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuarioController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarUsuarioController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuarioController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarUsuarioController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
