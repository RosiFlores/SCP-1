<%-- 
    Document   : pesquisarTipoCurso
    Created on : 01/10/2014, 16:24:32
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
         <h3>Tipos de Cursos Cadastrados</h3>
        
        <table border="1">
            <tr id="nomeTabela">
                <th><span>CÓDIGO</span>
                </th>
                <th><span>TIPO DO CURSO</span></th>
                <th colspan="2"><span>OPÇÕES</span>
                    <span></span></th>
            </tr>

            
                <c:forEach items="${tipoCursos}" var="tipoCurso">
                    <tr>
                    <td><c:out value="${tipoCurso.codigoTipoCurso}" /></td>
                    <td><c:out value="${tipoCurso.nomeTipoCurso}" /></td>
                    
                    <td><a href="CadastrarTipoCursoController?acao=prepararOperacao&operacao=Editar&codigoTipoCurso=<c:out value='${tipoCurso.codigoTipoCurso}'/>"> Editar</a>&nbsp;&nbsp;
                    <a href="CadastrarTipoCursoController?acao=prepararOperacao&operacao=Excluir&codigoTipoCurso=<c:out value='${tipoCurso.codigoTipoCurso}'/>"> Excluir</a></td>
                             </tr>
                </c:forEach>
           

        </table><br/><br/>

        <button class="botao1" onClick="location.href ='pesquisar.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="location.href = 'CadastrarTipoCursoController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
    </center>
    </body>
</html>