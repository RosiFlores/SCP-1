<%-- 
    Document   : cadastrarOrientador
    Created on : 08/09/2014, 20:47:05
    Author     : Mayara Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css" href="css.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
         <form action="CadastrarOrientadorController?acao=confirmarOperacao&operacao=${operacao}" 
          method="post" name="CadastrarOrientador" >

       <div id="page1">
            

                <div> 
                    <h2>Cadastro do Orientador</h2>
                </div>
                <div>    
                    
                        
                        <label>Núcleo:

                            <select name="optNucleo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <c:forEach items="${nucleo}" var="nucleo">
                                    <option value="${nucleo.codigoNucleo}"
                                            <c:if test="${nucleo.codigoNucleo == orientador.nucleo.codigoNucleo}"> selected </c:if>>
                                        ${nucleo.nomeNucleo}</option>
                                </c:forEach></select></label>
                        <label>Selecione o campus:

                                <select name="optCampus" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option>Selecione...</option>
                                    <c:forEach items="${campus}" var="campus">
                                        <option value="${campus.codigoCampus}"
                                                <c:if test="${campus.codigoCampus == orientador.chaveCampus}"> selected </c:if>>
                                            ${campus.nomeCampus}</option>
                                    </c:forEach></select></label>

            <!-- DADOS PESSOAIS-->
            <fieldset>
                <legend>Dados Pessoais</legend>
                <table cellspacing="10" id="table1">
                    <tr>
                        <td>
                            <label for="codigo">Codigo: </label>
                        </td>
                        <td align="left">
                            <input type="text" name="txtCodigo" value="${orientador.codigo}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="email">Email: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtEmail" value="${orientador.email}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="homePageLattes">Home Page do Currículo Lattes: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtHomePageLattes" value="${orientador.homepageLattes}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="nome">Nome: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNome" value="${orientador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label for="nome">Matricula: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtMatricula" value="${orientador.matricula}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Data de Nascimento: </label>
                            </td>
                            <td>
                                <input type="text" name="txtDataNascimento" value="${orientador.dataNascimento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                            <td>
                                <label>UF de Nascimento:</label>
                            </td>
                            <td>
                                <input list="ufNascimento" name="txtUfNascimento" value="${orientador.ufNascimento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <datalist id="ufNascimento" >

                                        <option value="AC"> Acre 
                                        <option value="AL">Alagoas
                                        <option value="AM">Amazonas
                                        <option value="AP">Amapá
                                        <option value="BA">Bahia
                                        <option value="CE">Ceará
                                        <option value="DF">Distrito Federal
                                        <option value="ES">Espírito Santo
                                        <option value="GO">Goiás 
                                        <option value="MA">Maranhão
                                        <option value="MG">Minas Gerais
                                        <option value="MT">Mato Grosso
                                        <option value="MS">Mato Grosso do Sul
                                        <option value="PA">Pará
                                        <option value="PB">Paraíba
                                        <option value="PE">Pernambuco
                                        <option value="PI">Piauí
                                        <option value="PR">Paraná
                                        <option value="RJ">Rio de Janeiro
                                        <option value="RN">Rio Grande do Norte
                                        <option value="RO">Rondônia
                                        <option value="RR">Roraima
                                        <option value="RS">Rio Grande do Sul
                                        <option value="SC">Santa Catarina
                                        <option value="SE">Sergipe
                                        <option value="SP">São Paulo
                                        <option value="TO">Tocantins
                                </datalist>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Estado Civil:</label>
                            </td>
                            <td> 
                                <input type="text" name="txtEstadoCivil" value="${orientador.estadoCivil}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>Nacionalidade:</label>
                            </td>
                            <td> 
                                <input type="text" name="txtNacionalidade" value="${orientador.nacionalidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rg">RG: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtRg" value="${orientador.rg}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                            </td>
                            <td>
                                <label for="rg">Orgão Expedidor: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtOrgaoExpedidor" value="${orientador.orgaoExpedidor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Data de Expedição:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtDataExpedicaoRG" value="${orientador.dataExpedicaoRG}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCpf" value="${orientador.cpf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Nome da Mãe:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNomeMae" value="${orientador.nomeMae}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Nome do Pai:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNomePai" value="${orientador.nomePai}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNaturalidade" value="${orientador.naturalidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td align="left">
                                <input list="sexo" name="txtSexo" value="${orientador.sexo}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                                <datalist id="sexo" >
                                    <option value="F"> Feminino
                                    <option value="M">Masculino
                                </datalist>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Grupo Sanguíneo:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtGrupoSanguineo" value="${orientador.grupoSanguineo}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Fator RH:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtFatorRH" value="${orientador.fatorRH}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Necessidade Especial:</label>
                            </td>
                            <td>
                                <input list="necessidadeEspecial" name="txtNecessidadeEspecial" value="${orientador.necessidadeEspecial}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                                <datalist id="necessidadeEspecial" >
                                    <option value="Sim"> Sim 
                                    <option value="Não">Não
                                </datalist>
                            </td>
                            <td>
                                <label>Cor:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCor" value="${orientador.cor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Escolaridade:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtEscolaridade" value="${orientador.escolaridade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label for="tituloEleitor">Título Eleitor: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtTituloEleitor" value="${orientador.tituloEleitor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                    </tr>
                    <tr>
                        <td>
                                <label for="numeroComprovanteMilitar">Número do comprovante de alistamento: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNumeroComprovanteMilitar" value="${orientador.numeroComprovanteMilitar}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>Pis/Pasep:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtPisPasep" value="${orientador.pisPasep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                    </table>
                </fieldset><br/>

                <!-- ENDEREÇO -->
                <fieldset>
                    <legend>Dados de Endereço</legend>
                    <table cellspacing="10" border="0">
                        <tr>
                            <td>
                                <label for="rua">Rua:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtRua" value="${orientador.rua}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="numero">Numero:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNumero" value="${orientador.numero}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rua">Complemento:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtComplemento" value="${orientador.complemento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="bairro">Bairro: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtBairro" value="${orientador.bairro}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cidade">Cidade: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCidade" value="${orientador.cidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="estado">Estado:</label>
                            </td>
                            <td align="left">
                                <input list="Estado" name="txtEstado" value="${orientador.uf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <datalist id="Estado" >

                                        <option value="AC"> Acre 
                                        <option value="AL">Alagoas
                                        <option value="AM">Amazonas
                                        <option value="AP">Amapá
                                        <option value="BA">Bahia
                                        <option value="CE">Ceará
                                        <option value="DF">Distrito Federal
                                        <option value="ES">Espírito Santo
                                        <option value="GO">Goiás 
                                        <option value="MA">Maranhão
                                        <option value="MG">Minas Gerais
                                        <option value="MT">Mato Grosso
                                        <option value="MS">Mato Grosso do Sul
                                        <option value="PA">Pará
                                        <option value="PB">Paraíba
                                        <option value="PE">Pernambuco
                                        <option value="PI">Piauí
                                        <option value="PR">Paraná
                                        <option value="RJ">Rio de Janeiro
                                        <option value="RN">Rio Grande do Norte
                                        <option value="RO">Rondônia
                                        <option value="RR">Roraima
                                        <option value="RS">Rio Grande do Sul
                                        <option value="SC">Santa Catarina
                                        <option value="SE">Sergipe
                                        <option value="SP">São Paulo
                                        <option value="TO">Tocantins
                                </datalist>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cep">CEP: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCep" value="${orientador.cep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                            <td>
                                <label>País:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtPais" value="${orientador.pais}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>

                        </tr>
                    </table>
                </fieldset>
                             
                
                        <br>
                        <center>
        
                <button class="botao1" onClick="parent.location.href = 'index1.jsp'" value="Cancelar">
                    <span>Cancelar</span>
                </button> &nbsp;&nbsp;

                <button class="botao1" type="submit" name="btnConfirmar"  value= "Confirmar">
                    <span>Confirmar</span>
                </button>
                
            </center>
                    
                </div>      
       </div>
        </form>
    </body>
</html>
