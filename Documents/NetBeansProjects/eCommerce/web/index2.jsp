<%-- 
    Document   : index
    Created on : 14/11/2014, 21:44:34
    Author     : Angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                <button onclick="location.href='PesquisarVendaController'">
                        <span>Venda</span>
                </button>
                <button onclick="location.href='PesquisarCarrinhoController'">
                        <span>Carrinho</span>
                </button>
    
                <button onclick="location.href='PesquisarUsuarioController'">
                                <span>Usuario</span>
                </button>
        <button onclick="location.href='PesquisarProdutoController'">
                                <span>Produto</span>
                </button>

        <form action="CadastrarUsuarioController?acao=prepararOperacao&operacao=Incluir" method="post">
                  <button class="botao1" onClick="location.href = 'CadastrarUsuarioController?acao=prepararOperacao&operacao=Incluir'">
            <span>Incluir Usuario</span>
        </button>
        </form>
    
    </body>
</html>
