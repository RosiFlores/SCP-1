<%-- 
    Document   : index 
    Created on : 28/09/2014, 20:37:49
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
                <h1>Escolha uma opção de cadastro</h1>
                <button class="botao" onclick="location.href='CadastrarBolsistaController'">
                        <span>Bolsista</span>
                </button>
                
                <button class="botao" onclick="location.href='CadastrarCampusController'">
                        <span>Campus</span>
                </button>
                
                <button class="botao" onclick="location.href='CadastrarCursoController'">
                        <span>Curso</span>
                </button><br/><br/>
                
                <button class="botao" onclick="location.href='CadastrarEditalController'">
                        <span>Edital</span>
                </button>
                
                <button class="botao" onclick="location.href='CadastrarFuncionarioController'">
                        <span>Funcionario</span>
                </button>   
                
                <button class="botao" onclick="location.href='CadastrarInstituicaoController'">
                        <span>Instituição</span>
                </button><br/><br/>

                <button class="botao" onclick="location.href='CadastrarNucleoController'">
                        <span> Núcleo</span>
                </button>
                
                <button class="botao" onclick="location.href='CadastrarOrientadorController'">
                        <span>Orientador</span>
                </button>

                <button class="botao" onclick="location.href='CadastrarProjetoController'">
                        <span>Projeto</span>
                </button><br/><br/>

                <button class="botao" onclick="location.href='CadastrarSubAreaController'">
                        <span>SubArea</span>
                </button>

                <button class="botao" onclick="location.href='CadastrarTipoBolsaController'">
                        <span>Tipo de Bolsa</span>
                </button>
                <button class="botao" onclick="location.href='CadastrarTipoCursoController'">
                        <span>Tipo de Curso</span>
                </button><br/><br/>
                

            </center>

        </div>
        
    </body>
</html>