<%-- 
    Document   : pesquisarSubArea
    Created on : 17/09/2014, 20:19:05
    Author     : Mayara Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="default.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
    <center>
        <h3>Subáreas de Conhecimento Cadastradas</h3>


        <table BORDER="1">
            <tr id="nomeTabela">
                <th><span>CÓDIGO</span>
                </th>
                <th><span>SUBAREA DE CONHECIMENTO</span></th>
                <th colspan="2"><span>OPÇÕES</span>
                    <span></span></th>

            </tr>

            <c:forEach items="${subAreas}" var="subArea">
                <tr>
                    <td><c:out value="${subArea.codigoSubArea}" /></td>
                <td><c:out value="${subArea.nomeSubArea}" /></td>
                <td><a href="CadastrarSubAreaController?acao=prepararOperacao&operacao=Editar&codigoSubArea=<c:out value='${subArea.codigoSubArea}'/>"> Editar</a>&nbsp;&nbsp;
                <a href="CadastrarSubAreaController?acao=prepararOperacao&operacao=Excluir&codigoSubArea=<c:out value='${subArea.codigoSubArea}'/>"> Excluir</a></td>
                </tr>
            </c:forEach>
        </table><br/><br/>

        <button class="botao1" onClick="location.href ='pesquisar.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="location.href = 'CadastrarSubAreaController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
    </center>

    </body>
</html>