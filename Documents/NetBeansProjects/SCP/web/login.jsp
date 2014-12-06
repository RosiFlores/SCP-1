<%-- 
    Document   : index
    Created on : 06/09/2014, 12:58:49
    Author     : Angelo, Mayara, Rosi
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
      <div id="loginTela">
            <fieldset>
                <div>
                    <h2>Sistema de Controle de Projetos</h2>
                </div>
                    <form name="TelaLogin">
                        <label>Login:<input type="text" name="login" id="login" placeholder="Digite seu login..."></label> <br/><br/>
                        <label>Senha:<input type="password" name="password" id="password" placeholder="Digite sua senha..."></label>

                        <br/><br/><button class="botao2">
                            <label>Corrigir</label>
                                   </button> &nbsp;&nbsp;

                            <button class="botao2" onClick="location.href='home.jsp'">
                                <label>Entrar</label>
                            </button>
                    </form>
                        
           
                </br> <span><a href="alterarSenha.jsp" >Esqueceu a senha?</a>  &nbsp; &nbsp; &nbsp;
                    <a href="cadastrarFuncionario.jsp"> Novo? Cadastre-se!</a></span>

           
            </fieldset>
          
          <a href="PesquisarCursoController"> Cadastrar Curso</a>
        </div>
      
    </body>
</html>