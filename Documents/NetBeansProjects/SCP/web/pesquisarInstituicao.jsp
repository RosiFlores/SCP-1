<%-- 
    Document   : pesquisarInstituicao
    Created on : 01/10/2014, 16:24:53
    Author     : Angelo
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
        <h3>Instituições Cadastradas</h3>
        
        <table border="1">
            <tr id="nomeTabela">
                <th><span>CÓDIGO</span>
                </th>
                <th><span>NOME</span></th>
                <th colspan="2"><span>OPÇÕES</span>
                    <span></span></th>
            </tr>

            
                <c:forEach items="${instituicoes}" var="instituicao">
                    <tr>
                    <td><c:out value="${instituicao.codigoInstituicao}" /></td>
                    <td><c:out value="${instituicao.nomeInstituicao}" /></td>
                    <td><a href="CadastrarInstituicaoController?acao=prepararOperacao&operacao=Editar&codigoInstituicao=<c:out value='${instituicao.codigoInstituicao}'/>"> Editar</a>&nbsp;&nbsp;
                    <a href="CadastrarInstituicaoController?acao=prepararOperacao&operacao=Excluir&codigoInstituicao=<c:out value='${instituicao.codigoInstituicao}'/>"> Excluir</a></td>
                             </tr>
                </c:forEach>
           

        </table><br/><br/>

        <button class="botao1" onClick="location.href ='pesquisar.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="location.href = 'CadastrarInstituicaoController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
    </center>
    
    </body>
</html>