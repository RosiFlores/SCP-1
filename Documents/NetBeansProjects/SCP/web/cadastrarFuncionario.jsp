<%-- 
    Document   : cadastrarFuncionario
    Created on : 06/09/2014, 15:08:10
    Author     : Angelo
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
         <form action="CadastrarFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" 
               method="post" name="CadastrarFuncionario" >
              

            <div id="page1">
               <h2>Cadastro de Funcionário</h2>
              
                 <label>Instituição:

                            <select name="optInstituicao" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <c:forEach items="${instituicao}" var="instituicao">
                                    <option value="${instituicao.codigoInstituicao}"
                                            <c:if test="${instituicao.codigoInstituicao == funcionario.instituicao.codigoInstituicao}"> selected </c:if>>
                                        ${instituicao.nomeInstituicao}</option>
                                </c:forEach></select></label>
                                
                        <label>Selecione o campus:

                                <select name="optCampus" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option>Selecione...</option>
                                    <c:forEach items="${campus}" var="campus">
                                        <option value="${campus.codigoCampus}"
                                                <c:if test="${campus.codigoCampus == funcionario.chaveCampus}"> selected </c:if>>
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
                            <input type="text" name="txtCodigo" value="${funcionario.codigo}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="email">Email: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtEmail" value="${funcionario.email}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="nome">Nome: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNome" value="${funcionario.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label for="nome">Matricula: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtMatricula" value="${funcionario.matricula}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Data de Nascimento: </label>
                            </td>
                            <td>
                                <input type="text" name="txtDataNascimento" value="${funcionario.dataNascimento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                            <td>
                                <label>UF de Nascimento:</label>
                            </td>
                            <td>
                                <input list="ufNascimento" name="txtUfNascimento" value="${funcionario.ufNascimento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                                <input type="text" name="txtEstadoCivil" value="${funcionario.estadoCivil}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>Nacionalidade:</label>
                            </td>
                            <td> 
                                <input type="text" name="txtNacionalidade" value="${funcionario.nacionalidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rg">RG: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtRg" value="${funcionario.rg}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                            </td>
                            <td>
                                <label for="rg">Orgão Expedidor: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtOrgaoExpedidor" value="${funcionario.orgaoExpedidor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Data de Expedição:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtDataExpedicaoRG" value="${funcionario.dataExpedicaoRG}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCpf" value="${funcionario.cpf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Nome da Mãe:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNomeMae" value="${funcionario.nomeMae}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Nome do Pai:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNomePai" value="${funcionario.nomePai}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNaturalidade" value="${funcionario.naturalidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td align="left">
                                <input list="sexo" name="txtSexo" value="${funcionario.sexo}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
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
                                <input type="text" name="txtGrupoSanguineo" value="${funcionario.grupoSanguineo}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Fator RH:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtFatorRH" value="${funcionario.fatorRH}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Necessidade Especial:</label>
                            </td>
                            <td>
                                <input list="necessidadeEspecial" name="txtNecessidadeEspecial" value="${funcionario.necessidadeEspecial}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                                <datalist id="necessidadeEspecial" >
                                    <option value="Sim"> Sim 
                                    <option value="Não">Não
                                </datalist>
                            </td>
                            <td>
                                <label>Cor:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCor" value="${funcionario.cor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Escolaridade:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtEscolaridade" value="${funcionario.escolaridade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label for="tituloEleitor">Título Eleitor: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtTituloEleitor" value="${funcionario.tituloEleitor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                    </tr>
                    <tr>
                        <td>
                                <label for="numeroComprovanteMilitar">Número do comprovante de alistamento: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNumeroComprovanteMilitar" value="${funcionario.numeroComprovanteMilitar}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>Pis/Pasep:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtPisPasep" value="${funcionario.pisPasep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                                <input type="text" name="txtRua" value="${funcionario.rua}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="numero">Numero:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNumero" value="${funcionario.numero}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rua">Complemento:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtComplemento" value="${funcionario.complemento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="bairro">Bairro: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtBairro" value="${funcionario.bairro}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cidade">Cidade: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCidade" value="${funcionario.cidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="estado">Estado:</label>
                            </td>
                            <td align="left">
                                <input list="Estado" name="txtEstado" value="${funcionario.uf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                                <input type="text" name="txtCep" value="${funcionario.cep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                            <td>
                                <label>País:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtPais" value="${funcionario.pais}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>

                        </tr>
                    </table>
                </fieldset>
                                
                                
                <br/>
                
               <center>
                <button class="botao1" onClick="parent.location.href = 'index1.jsp'" value="Cancelar">
                    <span>Cancelar</span>
                </button> &nbsp;&nbsp;

                <button class="botao1" type="submit" name="btnConfirmar"  value= "Confirmar">
                    <span>Confirmar</span>
                </button>
                </center>
                
            </div>
                            </form>
    </body>
</html>
