<%-- 
    Document   : cadastrarTipoBolsa
    Created on : 09/09/2014, 20:02:52
    Author     : Mayara Amanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css2.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
        <form action="CadastrarTipoBolsaController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="cadastrarSubArea">
            <center>
            <h3>Cadastrar Tipo de Bolsa - ${operacao} </h3>
            <div>
                <table>
                    <tr>
                        <td>
                            <label>Codigo do Tipo de Bolsa:</label>
                        </td>
                        <td>
                            <input type="text" name="codigoTipoBolsa" value="${TipoBolsa.codigoTipoBolsa}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>><br><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Nome do Tipo de Bolsa:</label>
                        </td>
                        <td>
                            <input type="text" name="nomeTipoBolsa" value="${TipoBolsa.nomeTipoBolsa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br>
                        </td>
                    </tr> 
                </table><br/><br/>
                        <button class="botao1" type="submit" onClick="parent.location.href = 'index1.jsp'">
                                <span>Cancelar</span>
                        </button> &nbsp;&nbsp;

                        <button class="botao1" type="submit" name="btnConfirmar" value="Confirmar">
                                <span>Confirmar</span>
                        </button> 
            </center>
        </form>
                        
                        
        
    </body>
</html>