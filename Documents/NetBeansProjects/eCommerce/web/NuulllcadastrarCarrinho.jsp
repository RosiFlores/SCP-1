<%-- 
    Document   : venda
    Created on : 03/12/2014, 12:01:00
    Author     : Angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CallStore</title>
    </head>
    <body>
        <div>
            <form action="CadastrarCarrinhoController?acao=confirmarOperacao&operacao=${operacao}"
                  method="post" name="CadastrarCarrinho" >
                <table border="1">

                    <th>Carrinho</th>

                    <tr>   
                        <td>
                            <label for="id">Código do carrinho: </label>

                            <input type="text" name="id" value="${carrinho.id}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </td>
                        </tr><br>

                        <tr>
                            <td><label>Cliente:

                                    <select name="usuario_id" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        <!--> <option>
                                             Selecione...
                                         </option></!-->
                                    <c:forEach items="${usuarios}" var="usuario">
                                        <option value="${usuario.id}"
                                                <c:if test="${usuario.id == carrinho.usuario.id}"> selected </c:if>>
                                            ${usuario.nome}</option>
                                    </c:forEach></select></label>
                        </td>
                    </tr>

                    <br>    
                    <tr>
                        <td><label>Produto:

                                <select name="produto_id" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                         <option>
                                             Selecione...
                                         </option>
                                    <c:forEach items="${produtos}" var="produto">
                                        <option value="${produto.id}"
                                                <c:if test="${produto.id == carrinho.produto.id}"> selected </c:if>>
                                            ${produto.nome}</option>
                                    </c:forEach></select></label>
                        </td>
                    </tr>
                    <br> 

                   
                </table>
                <center>
                    <button class="botao1" onClick="location.href = 'index.jsp'" value="Cancelar">
                        <span>Cancelar</span>
                    </button> &nbsp;&nbsp;

                    <button class="botao1" type="submit" name="btnConfirmar"  value= "Confirmar">
                        <span>Confirmar</span>
                    </button>

                </center>

            </form>
        </div>

    </body>
</html>
