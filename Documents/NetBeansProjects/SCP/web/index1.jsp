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
              <h1>Escolha uma opção de pesquisa</h1>
              <button class="botao" onclick="location.href='PesquisarBolsistaController'">
                        <span>Bolsista</span>
                </button>
                
                <button class="botao" onclick="location.href='PesquisarCampusController'">
                        <span>Campus</span>
                </button>
                
                <button class="botao" onclick="location.href='PesquisarCursoController'">
                        <span>Curso</span>
                </button><br/><br/>
                
                <button class="botao" onclick="location.href='PesquisarEditalController'">
                        <span>Edital</span>
                </button>
                
                <button class="botao" onclick="location.href='PesquisarFuncionarioController'">
                        <span>Funcionario</span>
                </button>   
                
                <button class="botao" onclick="location.href='PesquisarInstituicaoController'">
                        <span>Instituição</span>
                </button><br/><br/>

                <button class="botao" onclick="location.href='PesquisarNucleoController'">
                        <span> Núcleo</span>
                </button>
                
                <button class="botao" onclick="location.href='PesquisarOrientadorController'">
                        <span>Orientador</span>
                </button>

                <button class="botao" onclick="location.href='PesquisarProjetoController'">
                        <span>Projeto</span>
                </button><br/><br/>

                <button class="botao" onclick="location.href='PesquisarSubAreaController'">
                        <span>SubArea</span>
                </button>

                <button class="botao" onclick="location.href='PesquisarTipoBolsaController'">
                        <span>Tipo de Bolsa</span>
                </button>
                <button class="botao" onclick="location.href='PesquisarTipoCursoController'">
                        <span>Tipo de Curso</span>
                </button><br/><br/>
                

            </center>

        </div>
        
    </body>
</html>