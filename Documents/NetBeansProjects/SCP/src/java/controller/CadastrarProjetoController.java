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
import javaSCP.Edital;
import javaSCP.Orientador;
import javaSCP.Projeto;
import javaSCP.SubArea;
import javaSCP.TipoBolsa;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angelo
 */
public class CadastrarProjetoController extends HttpServlet {
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
            request.setAttribute("editais", Edital.obterEditais());
            request.setAttribute("tipobolsas", TipoBolsa.obterTipoBolsas());
            request.setAttribute("subareas", SubArea.obterSubAreas());
            request.setAttribute("orientadores", Orientador.obterOrientadores());

            if (!operacao.equals("Incluir")) {
                int codigoProjeto = Integer.parseInt(request.getParameter("codigoProjeto"));
                Projeto projeto = Projeto.obterProjeto(codigoProjeto);
                request.setAttribute("projeto", projeto);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarProjeto.jsp");
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
        int codigoProjeto = Integer.parseInt(request.getParameter("codigoProjeto"));
        String nomeProjeto = request.getParameter("nomeProjeto");
        int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
        String palavraChave = request.getParameter("palavraChave");
        int duracao = Integer.parseInt(request.getParameter("duracao"));
        String dataInicio = request.getParameter("dataInicio");
        String dataTermino = request.getParameter("dataTermino");
        float valorfinanciamento = Float.parseFloat(request.getParameter("valorFinanciamento"));
        String dataFinanciamento = request.getParameter("dataFinanciamento");
        String programa = request.getParameter("programa");
        String agenciaFomento = request.getParameter("agenciaFomento");
        int quantidadeBolsista = Integer.parseInt(request.getParameter("quantidadeBolsista"));
        String instituicaoParceira = request.getParameter("instituicaoParceira");
        String professorParticipante = request.getParameter("coorientador");
        String grupoPesquisaCNPq = request.getParameter("grupoPesquisaCNPq");
        int codigoTipoBolsa = Integer.parseInt(request.getParameter("optTipoBolsa"));
        int codigoEdital = Integer.parseInt(request.getParameter("optEdital"));
        int codigoCoordenador = Integer.parseInt(request.getParameter("optOrientador"));
        int codigoSubArea = Integer.parseInt(request.getParameter("optSubArea"));
        

        try {
            TipoBolsa tipoBolsa = null;
            if (codigoTipoBolsa != 0) {
                tipoBolsa = TipoBolsa.obterTipoBolsa(codigoTipoBolsa);
            }
            
            Edital edital = null;
            if (codigoEdital != 0) {
                edital = Edital.obterEdital(codigoEdital);
            }
            
            Orientador coordenador = null;
            if (codigoCoordenador != 0) {
                coordenador = Orientador.obterOrientador(codigoCoordenador);
            }
           
             SubArea subArea = null;
            if (codigoSubArea != 0) {
                subArea = SubArea.obterSubArea(codigoSubArea);
            }
           
           Projeto projeto = new Projeto(codigoProjeto, nomeProjeto, cargaHoraria, palavraChave, duracao, dataInicio, dataTermino, valorfinanciamento, dataFinanciamento, programa, agenciaFomento, quantidadeBolsista, instituicaoParceira,  grupoPesquisaCNPq, professorParticipante, tipoBolsa, edital,  subArea, coordenador);

            if (operacao.equals("Incluir")) {
                projeto.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    projeto.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        projeto.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarProjetoController");
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
        Logger.getLogger(CadastrarProjetoController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CadastrarProjetoController.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(CadastrarProjetoController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CadastrarProjetoController.class.getName()).log(Level.SEVERE, null, ex);
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