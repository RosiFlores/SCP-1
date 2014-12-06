
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
    <div id="usuario"><a href="login.html" class="login"><span class="login2"><i class="fa fa-sign-in"></i></span>Login</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="registrar2"><i class="fa fa-user" ></i></span><a href="registro.html" class="registrar">Cadastre-se</a></div>
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


            </table><br><br>
            <input type="submit" class="botao botao-fixo" name="btn" id="incluir" value="Incluir">
            <input type="button" class="botao botao-fixo centro" value="Fechar" onclick="javascript: location.href = 'index.jsp';">

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
        <br>
        Copyright © 2014,direitos reservados a Douglas Silva.<br>
        <br>
        <br>

    </div>

</div>


</body>
</html>