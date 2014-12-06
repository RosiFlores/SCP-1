/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaSCP.Campus;
import javaSCP.Nucleo;
import javaSCP.Orientador;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angelo
 */
public class CadastrarOrientadorController extends HttpServlet {

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
            request.setAttribute("nucleo", Nucleo.obterNucleos());
            request.setAttribute("campus", Campus.obterCampi());

            if (!operacao.equals("Incluir")) {
                int matricula = Integer.parseInt(request.getParameter("matricula"));
                Orientador orientador = Orientador.obterOrientador(matricula);
                request.setAttribute("orientador", orientador);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarOrientador.jsp");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        String operacao = request.getParameter("operacao");
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String homePageLattes = request.getParameter("txtHomePageLattes");
        int chavePessoa = Integer.parseInt(request.getParameter("txtCodigo"));
        String nome = request.getParameter("txtNome");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String estadoCivil = request.getParameter("txtEstadoCivil");
        String nacionalidade = request.getParameter("txtNacionalidade");
        String ufNascimento = request.getParameter("txtUfNascimento");
        String nomeMae = request.getParameter("txtNomeMae");
        String nomePai = request.getParameter("txtNomePai");
        String naturalidade = request.getParameter("txtNaturalidade");
        String grupoSanguineo = request.getParameter("txtGrupoSanguineo");
        String fatorRH = request.getParameter("txtFatorRH");
        String sexo = request.getParameter("txtSexo");
        String necessidadeEspecial = request.getParameter("txtNecessidadeEspecial");
        String cor = request.getParameter("txtCor");
        String escolaridade = request.getParameter("txtEscolaridade");
        String rua = request.getParameter("txtRua");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        int cep = Integer.parseInt(request.getParameter("txtCep"));
        String uf = request.getParameter("txtEstado");
        String pais = request.getParameter("txtPais");
        String email = request.getParameter("txtEmail");
        int rg = Integer.parseInt(request.getParameter("txtRg"));
        String orgaoExpedidor = request.getParameter("txtOrgaoExpedidor");
        int tituloEleitor = Integer.parseInt(request.getParameter("txtTituloEleitor"));
        int numeroComprovanteMilitar = Integer.parseInt(request.getParameter("txtNumeroComprovanteMilitar"));
        int cpf = Integer.parseInt(request.getParameter("txtCpf"));
        int pisPasep = Integer.parseInt(request.getParameter("txtPisPasep"));
        String dataExpedicaoRG = request.getParameter("txtDataExpedicaoRG");
        int chaveCampus = Integer.parseInt(request.getParameter("optCampus"));
        int codigoNucleo = Integer.parseInt(request.getParameter("optNucleo"));

        try {
            Nucleo nucleo = null;
            if (codigoNucleo != 0) {
                nucleo = Nucleo.obterNucleo(codigoNucleo);
            }
            Orientador orientador = new Orientador(matricula, homePageLattes, chavePessoa, nome, dataNascimento, estadoCivil, nacionalidade, ufNascimento, nomeMae, nomePai, naturalidade, grupoSanguineo, fatorRH, sexo, necessidadeEspecial, cor, escolaridade, rua, numero, complemento, bairro, cidade, cep, uf, pais, email, rg, orgaoExpedidor, tituloEleitor, numeroComprovanteMilitar, cpf, pisPasep, dataExpedicaoRG, chaveCampus, nucleo, null);
            if (operacao.equals("Incluir")) {
                orientador.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    orientador.editar();
                } else {
                    if (operacao.equals("Excluir")) {
                        orientador.excluir();

                    }
                }
            }

                        RequestDispatcher view = request.getRequestDispatcher("PesquisarOrientadorController");
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
            Logger.getLogger(CadastrarOrientadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarOrientadorController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarOrientadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarOrientadorController.class.getName()).log(Level.SEVERE, null, ex);
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
