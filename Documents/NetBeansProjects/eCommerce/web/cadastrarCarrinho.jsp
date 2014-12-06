
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title>CallStore</title>
    <link rel="StyleSheet" type="text/css" href="_css/registro.css">
    <link rel="StyleSheet" type="text/css" href="_css/carrinho.css">
	<link rel="StyleSheet" type="text/css" href="font-awesome-4.2.0/css/font-awesome.css">
    <link rel="StyleSheet" type="text/css" href="font-awesome-4.2.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="./_css/vendor/normalize.css">
    <link rel="stylesheet" href="_css/gallery.prefixed.css">
    <link rel="stylesheet" href="_css/gallery.css">
    <link rel="stylesheet" href="_css/gallery.theme.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <Link  rel = "stylesheet"  href ="path/to/font-awesome/css/font-awesome.min.css">
	
</head>

<body>


<div id="cabecalho">

    <a href="pagina.html"><div id="logo-site"></div></a>
    <div id="buscar">
        <input type="search" placeholder="buscar...">
        
    </div>
    <div id="usuario"><a href="pagina.jsp" class="login"><span class="login2"><i class="fa fa-sign-in"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>Logout</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
    <div id="menu">
        <ul>
            <li><a href="pagina.jsp"><i class="fa fa-home fa-lg"></i></a></li>
            <li><a href="produtos.jsp" class="padding-right">Marcas</a></li>
        </ul>
        <div id="menu-direito"><a href="carrinho.jsp"><i class="fa fa-shopping-cart"></i>&nbsp;&nbsp; carrinho</a></div>
    </div>
</div>

	<div id="conteudo"> 
		<div id="carrinho">
		
		
		<div>
	 <form action="CadastrarCarrinhoController?acao=confirmarOperacao&operacao=${operacao}"
                  method="post" name="CadastrarCarrinho" >
                <table border="1">

                    <th>Carrinho</th>
                        
                    <tr>
                        <td>
                            <label> Código carrinho: 
                                <input type="text" name="id" value="${carrinho.id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </label>
                        </td>
                    </tr>

                    
                    
                        <tr>
                            <td><label>Cliente:

                                    <select name="usuario_id" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        <option>
                                            Selecione...
                                        </option>
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
                    <button class="botao1" onClick="parent.location.href = 'index.jsp'" value="Cancelar">
                        <span>Cancelar</span>
                    </button> &nbsp;&nbsp;

                    <button class="botao1" type="submit" name="btnConfirmar"  value= "Confirmar">
                        <span>Confirmar</span>
                    </button>

                </center>

            </form>
	
	
	</div>
		
                </div>	
	

    <div id="rodape">

        <div class="menuesquerda">				
         <nav>
				<h3>Informações</h3>
				<br>
				<hr>
				<br>
            <ul>
				<li><a href="#">Sobre nós</a></li>
                <li><a href="#">Termos e Condições</a></li>
                <li><a href="#">Mapa do site</a></li>
            </ul>
         </nav>
        </div>				
        <div class="menucentro">
            <nav>
					<h3>Suporte ao Cliente</h3>
					<br>
					<hr>
					<br>
                <ul>
                    <li><a href="#">Blog Site</a></li>
                    <li><a href="#">Restuarant Site</a></li>
                    <li><a href="#">Design Site</a></li>
                </ul>
            </nav>
        </div>
    </div>

    <div id="copyright">
        </br>
        Copyright © 2014,direitos reservados a Douglas Silva.</br>
        </br>
        </br>

    </div>

</div>


</body>
</html>