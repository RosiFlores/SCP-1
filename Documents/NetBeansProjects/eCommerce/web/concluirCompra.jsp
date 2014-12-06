
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
                    <p><center><br>Sua compra foi concluída, agradecemos pela preferência.</center> <br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O boleto foi enviado para o e-mail cadastrado. Pagamentos via boleto podem demorar até dois dias utéis para serem confirmados<br>&nbsp;&nbsp; porém após a confirmação enviaremos o pedido para o endereço cadastrado.
                    
                    </p>
	
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
        Copyright © 2014,direitos reservados a Douglas Silva.<br>
        <br>
        <br>

    </div>

</div>


</body>
</html>