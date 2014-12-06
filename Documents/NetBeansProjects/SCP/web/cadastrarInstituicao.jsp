<%-- 
    Document   : cadastrarInstituicao
    Created on : 09/09/2014, 20:02:52
    Author     : Mayara Amanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css2.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
        <form action="CadastrarInstituicaoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="cadastrarInstituicao">
            <center>
            <h3>Cadastrar Instituição - ${operacao} </h3>

                <table>
                    <tr>
                        <td>
                            <label>Codigo da Instituição:</label>
                        </td>
                        <td>
                            <input type="text" name="codigoInstituicao" value="${instituicao.codigoInstituicao}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>><br><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Nome da Instituição:</label>
                        </td>
                        <td>
                            <input type="text" name="nomeInstituicao" value="${instituicao.nomeInstituicao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br>
                        </td>
                    </tr> 
                </table><br/><br/>
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