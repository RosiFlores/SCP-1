<%-- 
    Document   : index
    Created on : 13/10/2014, 20:50:16
    Author     : Mayara Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="default.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>

        <div id='cssmenu'>
            <ul>
               <li><a href='sobre.jsp' target="iframe"><span>Início</span></a></li>               
               <li><a href='index2.jsp' target="iframe"><span>Cadastrar</span></a></li>
               <li><a href='index1.jsp' target="iframe"><span>Pesquisar</span></a></li>
               <li class='last'><a href='sobre.jsp' target="iframe"><span>Sobre</span></a></li>
            </ul>
        </div>
        <div id='iframe'>
            <iframe name="iframe" id="iframe" width="1329" height="1600" frameborder="3" src="sobre.jsp" ></iframe>
        </div>  
    </body>
</html>
