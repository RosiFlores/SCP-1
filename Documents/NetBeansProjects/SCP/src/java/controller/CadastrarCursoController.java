package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaSCP.Campus;
import javaSCP.Curso;
import javaSCP.Instituicao;
import javaSCP.Orientador;
import javaSCP.TipoCurso;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angelo
 */
public class CadastrarCursoController extends HttpServlet {

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
            request.setAttribute("instituicao", Instituicao.obterInstituicoes());
            request.setAttribute("campus", Campus.obterCampi());
            request.setAttribute("tipoCurso", TipoCurso.obterTipoCursos());
            request.setAttribute("orientador", Orientador.obterOrientadores());
            

            if (!operacao.equals("Incluir")) {
                int codigoCurso = Integer.parseInt(request.getParameter("codigoCurso"));
                Curso curso = Curso.obterCurso(codigoCurso);
                request.setAttribute("curso", curso);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCurso.jsp");
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
        int codigoCurso = Integer.parseInt(request.getParameter("codigoCurso"));
        String nomeCurso = request.getParameter("nomeCurso");
        int codigoCampus = Integer.parseInt(request.getParameter("optCampus"));
        int codigoCoordenador = Integer.parseInt(request.getParameter("optCoordenador"));
        int codigoInstituicao = Integer.parseInt(request.getParameter("optInstituicao"));
        int codigoTipoCurso = Integer.parseInt(request.getParameter("optTipoCurso"));

        try {
            Campus campus = null;
            if (codigoCampus != 0) {
                campus = Campus.obterCampus(codigoCampus);
            }
            
            Instituicao instituicao = null;
            if (codigoInstituicao != 0) {
                instituicao = Instituicao.obterInstituicao(codigoInstituicao);
            }
            
            Orientador coordenador = null;
            if (codigoCoordenador != 0) {
                coordenador = Orientador.obterOrientador(codigoCoordenador);
            }
           
             TipoCurso tipoCurso = null;
            if (codigoTipoCurso != 0) {
                tipoCurso = TipoCurso.obterTipoCurso(codigoTipoCurso);
            }
           

            Curso curso = new Curso(nomeCurso, codigoCurso, instituicao, coordenador, tipoCurso, campus);

            if (operacao.equals("Incluir")) {
                curso.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    curso.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        curso.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarCursoController");
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
            Logger.getLogger(CadastrarCursoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCursoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarCursoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCursoController.class.getName()).log(Level.SEVERE, null, ex);
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