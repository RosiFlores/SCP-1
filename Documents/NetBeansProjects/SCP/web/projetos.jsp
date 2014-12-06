<%-- 
    Document   : projeto
    Created on : 06/09/2014, 19:21:53
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
        
        <div id="page">
            <center>
                <h2>Bem vindo FULANO DE TAL, escolha uma opção abaixo:</h2><br/><br/>
            
                <div id="menu">
                
                <button  class="botao" onclick="location.href='cadastrarBolsista.jsp'">
                    <span>Cadastrar Bolsista</span>
                </button>

                <button class="botao1" onclick="location.href='cadastrarBolsistaVoluntario.jsp'">
                    <span>Cadastrar Bolsistas Voluntários</span>
                </button>

                <button class="botao1" onclick="location.href='desempenhoAluno.jsp'">
                    <span>Desempenho Mensal do Bolsista</span>
                </button><br/><br/>

                <button class="botao1" onclick="location.href='avaliacaoFinal.jsp'">
                    <span>Avaliação Final do Bolsista</span>
                </button>
                
                <button class="botao" onclick="location.href='renovarProjeto.jsp'">
                    <span>Renovar Projeto</span>
                </button>

                <button class="botao" onclick="location.href='renovarBolsista.jsp'">
                    <span>Renovar Bolsista</span>
                </button>
                </div>   
            </center>
        </div>
        
    </body>
</html>
