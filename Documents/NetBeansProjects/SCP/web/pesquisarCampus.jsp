<%-- 
    Document   : pesquisarCampus
    Created on : 17/09/2014, 20:16:00
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
        <h3>Campus Cadastrados</h3>

        <table BORDER="1">
            <tr id="nomeTabela">
                <th><span>ID</span>
                </th>
                <th><span>NOME DO CAMPUS</span></th>
                <th><span>NOME DA INSTITUIÇÃO</span></th>
                
                <th colspan="2"><span>OPÇÕES</span>
                    <span></span></th>

            </tr>

            <c:forEach items="${campus}" var="campus">
                <tr>
                    <td><c:out value="${campus.codigoCampus}" /></td>
                    <td><c:out value="${campus.nomeCampus}" /></td>
                    <td><c:out value="${campus.instituicao.nomeInstituicao}" /></td>

                        <td><a href="CadastrarCampusController?acao=prepararOperacao&operacao=Editar&codigoCampus=<c:out value='${campus.codigoCampus}'/>"> Editar</a>&nbsp;&nbsp;
                        <a href="CadastrarCampusController?acao=prepararOperacao&operacao=Excluir&codigoCampus=<c:out value='${campus.codigoCampus}'/>"> Excluir</a></td>

                </tr> 
            </c:forEach>


         </table><br/><br/>

        <button class="botao1" onClick="parent.location.href ='index1.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="parent.location.href = 'CadastrarCampusController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
      </center>
    </body>
</html>