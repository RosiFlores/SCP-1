<%-- 
    Document   : pesquisarProjeto
    Created on : 17/09/2014, 20:18:29
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
        <h3>Projetos Cadastrados</h3>

        <table BORDER="1">
            <tr id="nomeTabela">
                <th><span>CÓDIGO</span> </th>
                <th><span>TÍTULO</span></th>
                <th><span>TIPO DA BOLSA</span></th>
                <th><span>EDITAL</span></th>
                <th><span>SUBAREA DE CONHECIMENTO</span></th>
                


                <td colspan="2"><span>OPÇÕES</span>
                    <span></span></td>

            </tr>
            <c:forEach items="${projetos}" var="projeto">
                <tr>
                    <td><c:out value="${projeto.codigoProjeto}" /></td>
                    <td><c:out value="${projeto.nomeProjeto}" /></td>
                    <td><c:out value="${projeto.tipoBolsa.nomeTipoBolsa}" /></td>
                    <td><c:out value="${projeto.edital.numeroEdital}" /></td>
                    <td><c:out value="${projeto.subArea.nomeSubArea}" /></td>

                    <td><a href="CadastrarProjetoController?acao=prepararOperacao&operacao=Editar&codigoProjeto=<c:out value='${projeto.codigoProjeto}'/>"> Editar</a>&nbsp;&nbsp;
                    <a href="CadastrarProjetoController?acao=prepararOperacao&operacao=Excluir&codigoProjeto=<c:out value='${projeto.codigoProjeto}'/>"> Excluir</a></td>
                </tr>
            </c:forEach>
        </table><br/><br/>

        <button class="botao1" onClick="location.href ='pesquisar.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1" value="Confirmar" onClick="location.href = 'CadastrarProjetoController?acao=prepararOperacao&operacao=Incluir'" >
            <span>Inserir</span>
        </button>
    </center>
    </body>
</html>