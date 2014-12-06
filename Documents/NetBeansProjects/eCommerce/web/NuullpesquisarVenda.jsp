<%-- 
    Document   : pesquisarVenda
    Created on : 04/12/2014, 22:03:58
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
        <form action="CadastrarVendaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th><span>CÓDIGO</span></th>
                    <th><span>QUANTIDADE VENDIDA</span></th>
                    <th><span>TOTAL</span></th>
                    <th><span>CLIENTE</span></th>
                    <th><span>PRODUTO</span></th>
                    <th><span>CARRINHO</span></th>
                </tr>


                <c:forEach items="${vendas}" var="venda">
                    <tr>
                        <td><c:out value="${venda.id}" /></td>
                        <td><c:out value="${venda.quant_vendida}" /></td>
                        <td><c:out value="${venda.total}" /></td>
                        <td><c:out value="${venda.usuario.nome}" /></td>
                        <td><c:out value="${venda.produto.nome}" /></td>
                        <td><c:out value="${venda.carrinho_id}" /></td>

                    </tr>
                </c:forEach>


            </table><br/><br/>
            <input type="submit" class="botao botao-fixo" name="btn" id="incluir" value="Incluir">
            <input type="button" class="botao botao-fixo centro" value="Fechar" onclick="javascript: location.href = 'index.jsp';">

        </form>
    </body>
</html>
