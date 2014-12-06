<%-- 
    Document   : pesquisarEdital
    Created on : 17/09/2014, 20:17:05
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
            <h3>Pesquisar Edital</h3>
            
            
			
        <table BORDER="1">
                <tr id="nomeTabela">
                        <th><span>CÓDIGO</span></th>
                        <th><span>NÚMERO</span></th>
                        <th><span>ANO</span></th>
                        <th><span>SUBÁREA DE CONHECIMENTO</span></th>
                        <th><span>CAMPUS</span></th>
                       <th><span>TIPO DA BOLSA</span></th>
                        <th colspan="2"><span>OPÇÕES</span>
                        <span></span></th>

                </tr>
                
                        <c:forEach items="${edital}" var="edital">
                            <tr>
                                <td><c:out value="${edital.codigoEdital}" /></td>
                                <td><c:out value="${edital.numeroEdital}" /></td>
                                <td><c:out value="${edital.anoEdital}" /></td>
                                <td><c:out value="${edital.subArea.nomeSubArea}" /></td>
                                <td><c:out value="${edital.campus.nomeCampus}" /></td>
                                <td><c:out value="${edital.tipoBolsa.nomeTipoBolsa}" /></td> 
                        
                        
                      <td><a href="CadastrarEditalController?acao=prepararOperacao&operacao=Editar&codigoEdital=<c:out value='${edital.codigoEdital}'/>"> Editar</a>&nbsp;&nbsp;
                      <a href="CadastrarEditalController?acao=prepararOperacao&operacao=Excluir&codigoEdital=<c:out value='${edital.codigoEdital}'/>"> Excluir</a></td>
                      
                      
                      </tr>
   </c:forEach>
                
        
</table><br/><br/>

        <button class="botao1" onClick="location.href ='index1.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="location.href = 'CadastrarEditalController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
    </center>
</body>
</html>