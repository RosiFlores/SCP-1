

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<!doctype html>

<html>

    <head>
        <meta charset="utf-8">
        <title>CallStore</title>

    </head>

    <body>
        <form action="CadastrarCarrinhoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table border="1">
                <tr>
                    <th><span>CÓDIGO</span></th>
                    <th><span>USUÁRIO</span></th>
                    <th><span>PRODUTO</span></th>
                    <th colspan="2"><span>OPÇÕES</span>
                        <span></span></th>
                </tr>

                <c:forEach items="${carrinhos}" var="carrinho">
                    <tr>
                        <td><c:out value="${carrinho.id}" /></td>
                        <td><c:out value="${carrinho.usuario.nome}" /></td>
                        <td><c:out value="${carrinho.produto.nome}" /></td>
                        <td>
                            <a href="CadastrarCarrinhoController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${carrinho.id}" />">Editar</a>
                            <a href="CadastrarCarrinhoController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${carrinho.id}" />">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>

            </table><br/><br/>
            <input type="submit" class="botao botao-fixo" name="btn" id="incluir" value="Incluir">
            <input type="button" class="botao botao-fixo centro" value="Fechar" onclick="javascript: location.href = 'index.jsp';">
        </form>

    </body>

</html>