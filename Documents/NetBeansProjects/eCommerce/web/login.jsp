<%-- 
    Document   : login
    Created on : 05/12/2014, 12:53:02
    Author     : Mayara Amanda
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title>CallStore</title>
    <link rel="StyleSheet" type="text/css" href="_css/registro.css">
    <link rel="StyleSheet" type="text/css" href="_css/form.css">
    <link rel="StyleSheet" type="text/css" href="_css/login.css">
	<link rel="StyleSheet" type="text/css" href="font-awesome-4.2.0/css/font-awesome.css">
    <link rel="StyleSheet" type="text/css" href="font-awesome-4.2.0/css/font-awesome.min.css">


    <link rel="stylesheet" href="./_css/vendor/normalize.css">
    <link rel="stylesheet" href="_css/gallery.prefixed.css">
    <link rel="stylesheet" href="_css/gallery.css">
    <link rel="stylesheet" href="_css/gallery.theme.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <Link  rel = "stylesheet"  href ="path/to/font-awesome/css/font-awesome.min.css">

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script type="text/javascript" src="/fancybox/source/jquery.fancybox.pack.js?v=2.1.4">    </script>


</head>

<body>


<div id="cabecalho">

    <a href="pagina.jsp"><div id="logo-site"></div></a>

    <div id="buscar">
        <input type="search" placeholder="buscar...">
        <div id="lupa"><a href="#"><i class="fa fa-search"></i></a></div>
    </div>

    <div id="usuario"><a href="login.jsp" class="login"><span class="login2"><i class="fa fa-sign-in"></i></span>Login</a>

        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="registrar2"><i class="fa fa-user" ></i></span><a href="registro.jsp" class="registrar">Cadastre-se</a></div>

    <div id="menu">
        <ul>
            <li><a href="#" class="padding-right">Produtos</a>
            </li>
        </ul>
        <div id="menu-direito"><a href="#"><i class="fa fa-shopping-cart"></i>carrinho</a></div>
    </div>
</div>

<div id="conteudo">
    <div class="titulo">Login</div>

    <div id="caixaesquerda">
            <br/>

        <div class="cposiciona">
            <h4><br/>Registrar Conta</h4>
            <br/>
            Ao criar uma conta, você será capaz de comprar mais rápido, estar atualizado sobre o status de um pedido e acompanhar os pedidos que você já fez.
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="enviar">

                <a class="but but-primary but-shadow but-rc" href="registro.jsp" >Continuar</a>
            </div>
            </div>
            </div>

            <div id="caixadireita">
                <br>

                <div class="cposiciona">
                    <h4><br/>Já sou cliente</h4>
                    <br>
                    <form>
                       <p>E-Mail:&nbsp;&nbsp;<input type="email" name="tMail" id="cMail" size="40" maxlength="40"/></p>
                    <br>
                        <p>Senha:&nbsp;&nbsp;<br/><input type="password" name="tSenha" id="cSenha" size="8" maxlength="8" /></p>
                    </form>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>

                    <div class="enviar">
                        <a class="but but-primary but-shadow but-rc" href="paginaLogado.jsp">Conecte-se</a>
                    </div>
                <br/>
                </div>
        </div>

    </div>
</div>
    <div id="rodape">

        <div class="menuesquerda">				
         <nav>
				<h3>Informações</h3>
				<br>
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
        Copyright © 2014,direitos reservados a Douglas Silva.</br>
        <br>
        <br>

    </div>

</div>


</body>
</html>