<%-- 
    Document   : registro
    Created on : 05/12/2014, 12:53:02
    Author     : Mayara Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="utf-8">
        <title>CallStore</title>
        <link rel="StyleSheet" type="text/css" href="_css/registro.css">
        <link rel="StyleSheet" type="text/css" href="_css/form.css">
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
            function consultacep(cep) {
                cep = cep.replace(/\D/g, "")
                url = "http://cep.correiocontrol.com.br/" + cep + ".js"
                s = document.createElement('script')
                s.setAttribute('charset', 'utf-8')
                s.src = url
                document.querySelector('head').appendChild(s)
            }

            function correiocontrolcep(valor) {
                if (valor.erro) {
                    alert('Cep não encontrado');
                    return;
                }
                ;
                document.getElementById('logradouro').value = valor.logradouro
                document.getElementById('bairro').value = valor.bairro
                document.getElementById('localidade').value = valor.localidade
                document.getElementById('uf').value = valor.uf
            }
        </script>


        <script>
            function formatar(mascara, documento) {
                var i = documento.value.length;
                var saida = mascara.substring(0, 1);
                var texto = mascara.substring(i)

                if (texto.substring(0, 1) != saida) {
                    documento.value += texto.substring(0, 1);
                }

            }
        </script>


    </head>

    <body>
        <form action="CadastrarUsuarioController?acao=confirmarOperacao&operacao=${operacao}"
              method="post" name="CadastrarUsuario" >


            <div id="cabecalho">

                <a href="pagina.jsp"><div id="logo-site"></div></a>
                <div id="buscar">
                    <input type="search" placeholder="buscar...">
                    <div id="lupa"><a href="#"><i class="fa fa-search"></i></a></div>
                </div>
                <div id="usuario"><a href="login.jsp" class="login"><span class="login2"><i class="fa fa-sign-in"></i></span>Login</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="registrar2"><i class="fa fa-user" ></i></span><a href="#" class="registrar">Cadastre-se</a></div>
                <div id="menu">
                    <ul>
                        <li><a href="pagina.jsp"><i class="fa fa-home fa-lg"></i></a></li>
                        <li><a href="produtos.jsp" class="padding-right">Produtos</a>
                        </li>
                    </ul>
                    <div id="menu-direito"><a href="#"><i class="fa fa-shopping-cart"></i>carrinho</a></div>
                </div>
            </div>

            <div id="conteudo"> </div>

            <div id="conta">
                <span class="titulo">&nbsp;&nbsp;&nbsp;Registrar Conta</span>
                <br/>
                <br/>
                <br/>

                <fieldset id="identificacao">
                    <span class="titulo"><small>Seus detalhes Pessoais</small></span>
                    <br/>
                    <br/>
                    <br/>
                    
                    <p><label>Código:&nbsp;&nbsp;<input type="text" name="id" id="codigo" size="40" maxlength="30" placeholder="Código do Usuário" value="${usuario.id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label></p><br/>

                        <p><label>Nome:&nbsp;&nbsp;<input type="text" id="nome" name="nome" size="40" maxlength="30" placeholder="Nome Completo" value="${usuario.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label></p>
                        <br/>
                        <p>Data de Nascimento:&nbsp;&nbsp;<input type="date" name="dt_nasc" value="${usuario.dt_nasc}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                        <p>CPF:&nbsp;&nbsp;<input type="text" size="20" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" name="cpf" value="${usuario.cpf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                        <p>RG:&nbsp;&nbsp;<input type="text" size="20" maxlength="14" name="rg" value="${usuario.rg}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                        <p>Senha:&nbsp;&nbsp;<input type="password" id="senha" size="8" maxlength="8" placeholder="8 dígitos" name="senha" value="${usuario.senha}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                        <p>E-Mail:&nbsp;&nbsp;<input type="email" id="cMail" size="40" maxlength="40" name="email" value="${usuario.email}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                        <p>Telefone:&nbsp;&nbsp;<input type="tel" size="20" OnKeyPress="formatar('##-####-####', this)" placeholder="(xx)número" name="telefone" value="${usuario.telefone}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                    </fieldset>
                    <br/>
                    <br/>

                    <fieldset id="endereco">
                        <span class="titulo"><small>Endereço do Usuário</small></span>
                        <br/>
                        <br/>
                        <br/>
                        <p>Logradouro:&nbsp;&nbsp;<input type="text" id="cRua" size="30" maxlength="80" placeholder="Rua, Av, Trav..." name="logradouro" value="${usuario.logradouro}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                        <p>Número:&nbsp;&nbsp;<input type="number" id="cNum" min="0" max="9999" name="numero" value="${usuario.numero}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                        <p>CEP:&nbsp;&nbsp;<input id="cep" onblur="consultacep(this.value)" size="10" OnKeyPress="formatar('#####-###', this)"/></p>
                        <br/>
                        <p>Bairro:&nbsp;&nbsp;<input id="bairro" name="bairro" value="${usuario.bairro}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                        <br/>
                        <p>Estado:&nbsp;&nbsp;<select name="tEst" id="cEst" name="uf" value="${usuario.uf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <optgroup label="Regiao Sudeste">
                                    <option value="SP">São Paulo</option>
                                    <option value="MG"selected>Minas Gerais</option>
                                    <option value="RJ">Rio de Janeiro</option>
                                </optgroup>
                                <optgroup label="Regiao Sul">
                                    <option value="PR">Paraná</option>
                                    <option value="SC">Santa Catarina</option>
                                    <option value="RS">Rio Grande do Sul</option>
                                </optgroup>
                            </select></p>
                        <br/>

                        <p>Cidade:&nbsp;&nbsp;<input type="text" id="tCid" maxlength="40" size="20" placeholder="Sua Cidade" list="cidades" name="cidade" value="${usuario.cidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></p>
                    <datalist id="cidades">
                        <option value="Minas Gerais"></option>
                        <option value="Belo Horizonte"></option>
                        <option value="Juiz de Fora"></option>
                        <option value="Além Paraíba"></option>
                        <option value="Niterói"></option>
                        <option value="Rio de Janeiro"></option>
                        <option value="Nova Iguaçu"></option>
                        <option value="Belford Roxo"></option>
                        <option value="Sao Paulo"></option>
                        <option value="Mogi-Mirim"></option>
                        <option value="Rio Claro"></option>
                        <option value="Santo Antonio de Posse"></option>
                    </datalist>

                    <br/>

                </fieldset>
                <br/>
            </div>
                    
        <div id="privacidade">
            <p><input type="checkbox" name="tPriv" id="cPriv"/>Eu li e concordo com a <a href="politica.jsp" target="blank">Política de Privacidade</a></p>
        </div>
        <br/>
        <div id="enviar">
           
            <button class="but but-primary but-shadow but-rc" type="submit" name="btnConfirmar"  value= "Confirmar" >
                        <span>Confirmar</span>
                    </button>

        </div>
        </form>

    </div>

    <br>

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
        </br>
        Copyright © 2014,direitos reservados a Douglas Silva.</br>
        </br>
        </br>

    </div>


</body>
</html>