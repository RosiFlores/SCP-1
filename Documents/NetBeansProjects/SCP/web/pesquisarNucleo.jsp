<%-- 
    Document   : pesquisarNucleo
    Created on : 17/09/2014, 20:17:40
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
        <h3>Núcleos Cadastrados</h3>

        <table border="1">
            <tr id="nomeTabela">
                <th><span>CÓDIGO</span>
                </th>
                <th><span>NOME DO NÚCLEO</span></th>
                <th colspan="2"><span>OPÇÕES</span>
                    <span></span></th>
            </tr>


            <c:forEach items="${nucleos}" var="nucleo">
                <tr>
                    <td><c:out value="${nucleo.codigoNucleo}" /></td>
                    <td><c:out value="${nucleo.nomeNucleo}" /></td>
                    <td><a href="CadastrarNucleoController?acao=prepararOperacao&operacao=Editar&codigoNucleo=<c:out value='${nucleo.codigoNucleo}'/>"> Editar</a>&nbsp;&nbsp;
                    <a href="CadastrarNucleoController?acao=prepararOperacao&operacao=Excluir&codigoNucleo=<c:out value='${nucleo.codigoNucleo}'/>"> Excluir</a></td>

                </tr>
            </c:forEach>

        </table><br/><br/>

        <button class="botao1" onClick="location.href ='index1.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="location.href = 'CadastrarNucleoController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
    </center>
    </body>
</html>