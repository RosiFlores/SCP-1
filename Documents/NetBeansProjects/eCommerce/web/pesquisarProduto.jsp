<%-- 
    Document   : pesquisarProduto
    Created on : 04/12/2014, 23:40:20
    Author     : Mayara Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CallStore</title>
    </head>
    <body>
        <form action="CadastrarProdutoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th><span>CÓDIGO</span></th>
                    <th><span>NOME</span></th>
                    <th><span>PREÇO</span></th>
                    <th colspan="2"><span>OPÇÕES</span>
                        <span></span></th>
                </tr>

                <c:forEach items="${produtos}" var="produto">
                    <tr>
                        <td><c:out value="${produto.id}" /></td>
                        <td><c:out value="${produto.nome}" /></td>
                        <td><c:out value="${produto.preco}" /></td>
                        <td>
                            <a href="CadastrarProdutoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${carrinho.id}" />">Editar</a>
                            <a href="CadastrarProdutoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${carrinho.id}" />">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>

            </table><br/><br/>
            <input type="submit" class="botao botao-fixo" name="btn" id="incluir" value="Incluir">
            <input type="button" class="botao botao-fixo centro" value="Fechar" onclick="javascript: location.href = 'index.jsp';">
        </form>

    </body>
</html>
