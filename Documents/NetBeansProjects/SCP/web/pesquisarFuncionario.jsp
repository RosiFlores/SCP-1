<%-- 
    Document   : pesquisarFuncionario
    Created on : 17/09/2014, 20:17:29
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
        <h3>Funcionários Cadastrados</h3>

        <table border="1">
            <tr id="nomeTabela">
                <th><span>MATRÍCULA</span>
                    <th><span>NOME</span>
                        <th><span>INSTITUIÇÃO</span>
                </th>
                
                <th colspan="2"><span>OPÇÕES</span>
                    <span></span></th>
            </tr>

            
                <c:forEach items="${funcionarios}" var="funcionario">
                    <tr>
                    <td><c:out value="${funcionario.matricula}" /></td>
                    <td><c:out value="${funcionario.nome}" /></td>
                    <td><c:out value="${funcionario.instituicao.nomeInstituicao}" /></td>
                      <td><a href="CadastrarFuncionarioController?acao=prepararOperacao&operacao=Editar&matricula=<c:out value='${funcionario.matricula}'/>"> Editar</a>&nbsp;&nbsp;
                      <a href="CadastrarFuncionarioController?acao=prepararOperacao&operacao=Excluir&matricula=<c:out value='${funcionario.matricula}'/>"> Excluir</a></td>

                      </tr>
                </c:forEach>
            
        </table><br/><br/>

        <button class="botao1" onClick="location.href ='index1.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <button class="botao1"onClick="location.href = 'CadastrarFuncionarioController?acao=prepararOperacao&operacao=Incluir'">
            <span>Inserir</span>
        </button>
    </center>
</body>
</html>
