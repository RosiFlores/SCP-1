<%-- 
    Document   : cadastrarNucleo
    Created on : 09/09/2014, 20:02:52
    Author     : Mayara Amanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css2.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
        <form action="CadastrarNucleoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="cadastrarNucleo">
        
            <center>
            <h3>Cadastrar Núcleo - ${operacao} </h3>
            <div>
                <table>
                    <tr>
                        <td><label>Selecione o campus:
                            <select name="optCampus">
                                <option>
                                    Selecione...
                                </option>
                            <c:forEach items="${campi}" var="campus">
                                <option value="${campus.codigoCampus}"
                                    <c:if test="${campus.codigoCampus == nucleo.campus.codigoCampus}"> selected </c:if>>
                                        ${campus.nomeCampus}</option>
                            </c:forEach></select></label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Codigo do Núcleo:</label>
                            <input type="text" name="codigoNucleo" value="${nucleo.codigoNucleo}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Núcleo:
                            <input type="text" name="nomeNucleo" value="${nucleo.nomeNucleo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br></label>
                        </td>
                    </tr>
                </table> 
                
                <button class="botao1" onClick="parent.location.href = 'index1.jsp'">
                                <span>Cancelar</span>
                </button> &nbsp;&nbsp;

                <button class="botao1" type="submit" name="btnConfirmar">
                                <span>Confirmar</span>
                </button> 
            </center>
        </form>
        
        
        
        </div>
    </body>
</html>