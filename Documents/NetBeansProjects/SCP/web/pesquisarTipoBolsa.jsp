<%-- 
    Document   : pesquisarTipoBolsa
    Created on : 17/09/2014, 20:18:50
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
            <h3>Tipos de Bolsas Cadastradas</h3>
            
        
			
        <table BORDER="1">
                <tr id="nomeTabela">
                        <th><span>CÓDIGO</span>
                        </th>
                        <th><span>TIPO DA BOLSA</span></th>
                        <th colspan="2"><span>OPÇÕES</span>
                        <span></span></th>

                </tr>
               <c:forEach items="${tipoBolsas}" var="tipoBolsa">
                    <tr>
                    <td><c:out value="${tipoBolsa.codigoTipoBolsa}" /></td>
                    <td><c:out value="${tipoBolsa.nomeTipoBolsa}" /></td>
                    <td><a href="CadastrarTipoBolsaController?acao=prepararOperacao&operacao=Editar&codigoTipoBolsa=<c:out value='${tipoBolsa.codigoTipoBolsa}'/>"> Editar</a>&nbsp;&nbsp;
                    <a href="CadastrarTipoBolsaController?acao=prepararOperacao&operacao=Excluir&codigoTipoBolsa=<c:out value='${tipoBolsa.codigoTipoBolsa}'/>"> Excluir</a></td>
                    </tr>
                </c:forEach>
        </table><br/><br/>

        <button class="botao1" onClick="location.href ='index1.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="location.href = 'CadastrarTipoBolsaController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
    </center>
    </body>
</html>