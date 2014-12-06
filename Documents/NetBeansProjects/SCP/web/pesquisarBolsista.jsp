<%-- 
    Document   : PesquisarBolsista
    Created on : 17/09/2014, 15:28:41
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
                <h3>Bolsistas Cadastrados</h3>

                <table BORDER="1">
                    <tr id="nomeTabela">
                        <th><span>MATRÍCULA</span></th>
                        <th><span>NOME</span></th>
                        <th><span>CURSO</span></th>
                        <th><span>PROJETO</span></th>
                        <th colspan="2"><span>OPÇÕES</span>
                            <span></span></th>

                    </tr>

                        <c:forEach items="${bolsistas}" var="bolsista">
                            <tr>
                                <td><c:out value="${bolsista.matricula}" /></td>
                                <td><c:out value="${bolsista.nome}" /></td>
                                 <td><c:out value="${bolsista.curso.nomeCurso}" /></td>
                                 <td><c:out value="${bolsista.projeto.nomeProjeto}" /></td> 
                                 <td><a href="CadastrarBolsistaController?acao=prepararOperacao&operacao=Editar&matricula=<c:out value='${bolsista.matricula}'/>"> Editar</a>&nbsp;&nbsp;
                                 <a href="CadastrarBolsistaController?acao=prepararOperacao&operacao=Excluir&matricula=<c:out value='${bolsista.matricula}'/>"> Excluir</a></td>

                              </tr>

                        </c:forEach>


                  </table><br/><br/>

        <button class="botao1" onClick="location.href ='index1.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1" onClick="location.href = 'CadastrarBolsistaController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
        </center>
    </body>
</html>