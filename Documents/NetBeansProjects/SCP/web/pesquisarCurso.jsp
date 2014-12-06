<%-- 
    Document   : pesquisarCurso
    Created on : 17/09/2014, 20:16:34
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
        <h3>Pesquisar Curso</h3>
        
        <table border="1">
            <tr id="nomeTabela">
                <th><span>CÓDIGO</span></th>
                <th><span>NOME</span></th>
                <th><span>CLASSIFICAÇÃO</span></th>
                <th><span>INSTITUIÇÃO</span></th>
                <%--<th><span>COORDENADOR</span></th>--%>
                <th colspan="2"><span>OPÇÕES</span>
                    <span></span></th>
            </tr>

            
                <c:forEach items="${cursos}" var="curso">
                    <tr>
                    <td><c:out value="${curso.codigoCurso}" /></td>
                    <td><c:out value="${curso.nomeCurso}" /></td>
                    <td><c:out value="${curso.tipoCurso.nomeTipoCurso}" /></td>
                    <td><c:out value="${curso.instituicao.nomeInstituicao}" /></td>
                   <%-- <td><c:out value="${curso.coordenador.nome}" /></td>--%>
                    
                    <td><a href="CadastrarCursoController?acao=prepararOperacao&operacao=Editar&codigoCurso=<c:out value='${curso.codigoCurso}'/>"> Editar</a>&nbsp;&nbsp;
                    <a href="CadastrarCursoController?acao=prepararOperacao&operacao=Excluir&codigoCurso=<c:out value='${curso.codigoCurso}'/>"> Excluir</a></td>
                             </tr>
                </c:forEach>
           

        </table><br/><br/>

        <button class="botao1" onClick="location.href ='pesquisar.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="location.href = 'CadastrarCursoController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
    </center>
    </body>
    
</html>