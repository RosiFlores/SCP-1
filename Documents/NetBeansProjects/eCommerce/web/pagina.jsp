<%-- 
    Document   : pagina
    Created on : 05/12/2014, 12:32:27
    Author     : Mayara Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="utf-8">
        <title>CallStore</title>
        <link rel="StyleSheet" type="text/css" href="_css/estilo.css">
        <link rel="StyleSheet" type="text/css" href="_css/fotos.css">
        <link rel="StyleSheet" type="text/css" href="font-awesome-4.2.0/css/font-awesome.css">
        <link rel="StyleSheet" type="text/css" href="font-awesome-4.2.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="./_css/vendor/normalize.css">
        <link rel="stylesheet" href="_css/gallery.prefixed.css">
        <link rel="stylesheet" href="_css/gallery.css">
        <link rel="stylesheet" href="_css/gallery.theme.css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <Link  rel = "stylesheet"  href ="path/to/font-awesome/css/font-awesome.min.css">

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script type="text/javascript" src="/fancybox/source/jquery.fancybox.pack.js?v=2.1.4"></script>


        <script>
            $(document).ready(function () {
                $('#facebook').hover(function () {
                    $(this).addClass('transition');

                }, function () {
                    $(this).removeClass('transition');
                });
            });
        </script>

        <script>
            $(document).ready(function () {
                $('#twitter').hover(function () {
                    $(this).addClass('transition');

                }, function () {
                    $(this).removeClass('transition');
                });
            });
        </script>



    </head>

    <body>
        <div id="facebook" ><a href="https://www.facebook.com/douglas.sillva.3" target="_blank"><img src="_imagens/facebook.png" ></a></div>
        <div id="twitter"><a href="#" target="_blank"><img src="_imagens/twitter.png"></a></div>
        <header>
            <div id="cabecalho">

                <a href="pagina.jsp"><div id="logo-site"></div></a>
                <div id="buscar">

                    <input type="search" placeholder="buscar...">
                    <div id="lupa"><a href="#"><i class="fa fa-search"></i></a></div>
                </div>
                <div id="usuario"><a href="login.jsp" class="login"><span class="login2"><i class="fa fa-sign-in"></i></span>Login</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="registrar2"><i class="fa fa-user" ></i></span>
                    
                    <a href = 'CadastrarUsuarioController?acao=prepararOperacao&operacao=Incluir' class="registrar"><span>Cadastre-se</span></a>
        </button>
        </form>
                    
                
                </div>
                <div id="menu">
                    <ul>
                        <li><a href="pagina.jsp"><i class="fa fa-home fa-lg"></i></a></li>
                        <li><a href="produtos.jsp" class="padding-right">Produtos</a></li>

                    </ul>
                    <div id="menu-direito"><a href="#"><i class="fa fa-shopping-cart"></i> &nbsp; carrinho</a></div>
                </div>
            </div>
        </header>
        <div id="banner">
            <div class="gallery autoplay items-3">
                <div id="item-1" class="control-operator"></div>
                <div id="item-2" class="control-operator"></div>
                <div id="item-3" class="control-operator"></div>

                <figure class="item">
                    <img src="_imagens/outra.jpg">
                </figure>

                <figure class="item">
                    <img src="_imagens/banner2.jpg">
                </figure>

                <figure class="item">
                    <img src="_imagens/banner3.jpg">
                </figure>

                <div class="controls">
                    <a href="#item-1" class="control-button">•</a>
                    <a href="#item-2" class="control-button">•</a>
                    <a href="#item-3" class="control-button">•</a>
                </div>
            </div>

            <div id="populares">
                <div id="check">
                    <span id="check2"><i class="fa fa-check fa-3x"></i><br>Todos os produtos sao importados</span>
                    <span id="truck2"><i class="fa fa-truck fa-3x"></i><br>Entregas para todo o país</span>		
                    <span id="texto">
                        <i class="fa fa-mobile fa-3x"></i>
                        <i class="fa fa-desktop fa-3x"></i>
                        <i class="fa fa-tablet fa-3x"></i></i><br>	
                        <span id="mobile2">Voce porderá adquirir nossos produtos em qualquer dipostivo móvel</span>	
                    </span>
                </div>
                <span class="titulo"><h3>Mais Populares</h3></span>
                <div id="posicionaa">
                    <ul id="album-fotos">
                        <li id="foto01"><span>Populares</span></li>
                        <li id="foto02"><span>Populares</span></li>
                        <li id="foto03"><span>Populares</span></li>
                        <li id="foto04"><span>Populares</span></li>
                        <li id="foto05"><span>Populares</span></li>
                    </ul>
                </div>
            </div>
            </br>

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
                </br>
                </br>
            </div>

        </div>


    </body>
</html>