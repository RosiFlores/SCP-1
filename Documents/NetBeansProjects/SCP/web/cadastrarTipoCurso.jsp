<%-- 
    Document   : cadastrarTipoCurso
    Created on : 09/09/2014, 20:02:52
    Author     : Mayara Amanda
--%>

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="default.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
        <form action="CadastrarTipoCursoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="cadastrarTipoCurso">
            <center>
            <h3>Cadastrar Tipo Curso</h3>
            <div>
                <table>
                    <tr>
                        <td>
                            <label>Codigo do Tipo do Curso:</label>
                        </td>
                        <td>
                            <input type="text" name="codigoTipoCurso" value="${tipoCurso.codigoTipoCurso}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Tipo Curso:</label>
                        </td>
                        <td>
                            <input type="text" name="nomeTipoCurso" value="${tipoCurso.nomeTipoCurso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                    </tr> 
                </table>
                        <button class="botao1" onClick="parent.location.href = 'index1.jsp'">
                                <span>Cancelar</span>
                        </button> &nbsp;&nbsp;

                        <button class="botao1" type="submit" name="btnConfirmar" value="Confirmar">
                                <span>Confirmar</span>
                        </button> 
            </center>
        </form>
                        
                        
        
    </body>
</html>