<%-- 
    Document   : editais
    Created on : 06/09/2014, 19:22:20
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
            <button class="botao" onclick="location.href='cadastrarEdital.jsp'">
                <span>Cadastrar Edital</span>
            </button>
           
            <button class="botao" onclick="location.href='cadastrarProjeto.jsp'">
                <span>Cadastrar Projetos</span>
            </button>

            <button class="botao" onclick="location.href='cadastrarOrientador.jsp'">
                <span>Cadastrar Orientador</span>
            </button><br/><br/>

            <button class="botao1" onclick="location.href='cadastrarSubArea.jsp'">
                <span>Cadastrar Subárea de Conhecimento</span>
            </button>

            <button class="botao" onclick="location.href='cadastrarCampus.jsp'">
                <span>Cadastrar Campus</span>
            </button>

            <button class="botao1" onclick="location.href='cadastrarTipoBolsa.jsp'">
                <span>Cadastrar Tipo de Bolsa</span>
            </button><br/><br/>

            <button class="botao1" onclick="location.href='cadastrarNucleo.jsp'">
                <span>Cadastrar Núcleo do Professor Orientador</span>
            </button>
            
            <button class="botao" onclick="location.href='cadastrarCurso.jsp'">
                <span>Cadastrar Curso</span>
            </button>
            
            <button class="botao" onclick="location.href='listarProjeto.jsp'">
                <span>Listar Projetos</span>
            </button>
            
            <br/><br/><button class="botao" onclick="location.href='exibirEdital.jsp'">
                <span>Exibir Editais</span>
            </button>
            
            </center>

            
            
        </div>
        
        
    </body>
</html>
