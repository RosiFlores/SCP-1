/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProjetoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaSCP.Bolsista;
import javaSCP.Campus;
import javaSCP.Curso;
import javaSCP.Projeto;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angelo
 */
public class CadastrarBolsistaController extends HttpServlet {

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
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("projetos", Projeto.obterProjetos());
            request.setAttribute("campi", Campus.obterCampi());

            if (!operacao.equals("Incluir")) {
                int matricula = Integer.parseInt(request.getParameter("matricula"));
                Bolsista bolsista = Bolsista.obterBolsista(matricula);
                request.setAttribute("bolsista", bolsista);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarBolsista.jsp");
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
        int contaCorrente = Integer.parseInt(request.getParameter("txtContaCorrente"));
        String nomeBanco = request.getParameter("txtNomeBanco");
        int agencia = Integer.parseInt(request.getParameter("txtAgencia"));
        int codigoPessoa = Integer.parseInt(request.getParameter("txtCodigo"));
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
        int codigoCurso = Integer.parseInt(request.getParameter("optCurso"));
        int codigoProjeto = Integer.parseInt(request.getParameter("optProjeto"));

        try {
            Curso curso = null;
            if (codigoCurso != 0) {
                curso = Curso.obterCurso(codigoCurso);
            }
            Projeto projeto = null;
            if (codigoProjeto != 0) {
                projeto = ProjetoDAO.obterProjeto(codigoProjeto);
            }

            Bolsista bolsista = new Bolsista(matricula, contaCorrente, nomeBanco, agencia, codigoPessoa, nome, dataNascimento,
                    estadoCivil, nacionalidade, ufNascimento, nomeMae, nomePai, naturalidade, grupoSanguineo, fatorRH, sexo,
                    necessidadeEspecial, cor, escolaridade, rua, numero, complemento, bairro, cidade, cep, uf, pais, email, rg,
                    orgaoExpedidor, tituloEleitor, numeroComprovanteMilitar, cpf, pisPasep, dataExpedicaoRG, chaveCampus, null, curso, projeto);
            if (operacao.equals("Incluir")) {
                bolsista.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    bolsista.editar();
                } else {
                    if (operacao.equals("Excluir")) {
                        bolsista.excluir();

                    }
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("PesquisarBolsistaController");
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
            Logger.getLogger(CadastrarCampusController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCampusController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarCampusController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCampusController.class.getName()).log(Level.SEVERE, null, ex);
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
