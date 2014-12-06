<%-- 
    Document   : cadastrarBolsista
    Created on : 26/11/2014, 16:45:02
    Author     : Angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="page1">
            <form action="CadastrarBolsistaController?acao=confirmarOperacao&operacao=${operacao}"
                  method="post" name="CadastrarBolsista">
                <center><h3>Cadastro de Bolsistas - ${operacao}</h3></center>

                <table>
                    <tr>
                        <td>
                            <label>Selecione o curso:

                                <select name="optCurso" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        <option>Selecione...</option>
                                    <c:forEach items="${cursos}" var="curso">
                                        <option value="${curso.codigoCurso}"
                                                <c:if test="${curso.codigoCurso == bolsista.codigoCurso}"> selected </c:if>>
                                            ${curso.nomeCurso}</option>
                                    </c:forEach></select></label>
                        </td>

                        <td>
                            <label>Selecione o projeto:

                                <select name="optProjeto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        <option>Selecione...</option>
                                    <c:forEach items="${projetos}" var="projeto">
                                        <option value="${projeto.codigoProjeto}"
                                                <c:if test="${projeto.codigoProjeto == bolsista.codigoProjeto}"> selected </c:if>>
                                            ${projeto.nomeProjeto}</option>
                                    </c:forEach></select>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Selecione o campus:

                                <select name="optCampus" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        <option>Selecione...</option>
                                    <c:forEach items="${campi}" var="campus">
                                        <option value="${campus.codigoCampus}" <c:if test="${campus.codigoCampus == bolsista.chaveCampus}"> selected</c:if>>${campus.nomeCampus}</option>
                                    </c:forEach></select>
                            </label>
                        </td>
                    </tr>
                    <tr>
                    <h4>Dados pessoais </h4>

                    <td>
                        <label for="codigo">Codigo: </label>
                    </td>
                    <td align="left">
                        <input type="text" name="txtCodigo" value="${bolsista.codigo}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </td>
                        <td>
                            <label for="email">Email: </label>
                        </td>
                        <td align="left">
                            <input type="text" name="txtEmail" value="${bolsista.email}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>

                        </tr>
                        <tr>
                            <td>
                                <label for="nome">Nome: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNome" value="${bolsista.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label for="nome">Matricula: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtMatricula" value="${bolsista.matricula}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Data de Nascimento: </label>
                            </td>
                            <td>
                                <input type="text" name="txtDataNascimento" value="${bolsista.dataNascimento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                            <td>
                                <label>UF de Nascimento:</label>
                            </td>
                            <td>
                                <input list="ufNascimento" name="txtUfNascimento" value="${bolsista.ufNascimento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                                <input type="text" name="txtEstadoCivil" value="${bolsista.estadoCivil}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>Nacionalidade:</label>
                            </td>
                            <td> 
                                <input type="text" name="txtNacionalidade" value="${bolsista.nacionalidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rg">RG: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtRg" value="${bolsista.rg}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                            </td>
                            <td>
                                <label for="rg">Orgão Expedidor: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtOrgaoExpedidor" value="${bolsista.orgaoExpedidor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Data de Expedição:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtDataExpedicaoRG" value="${bolsista.dataExpedicaoRG}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>CPF:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCpf" value="${bolsista.cpf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Nome da Mãe:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNomeMae" value="${bolsista.nomeMae}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Nome do Pai:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNomePai" value="${bolsista.nomePai}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Naturalidade:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNaturalidade" value="${bolsista.naturalidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Sexo:</label>
                            </td>
                            <td align="left">
                                <input list="sexo" name="txtSexo" value="${bolsista.sexo}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
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
                                <input type="text" name="txtGrupoSanguineo" value="${bolsista.grupoSanguineo}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label>Fator RH:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtFatorRH" value="${bolsista.fatorRH}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Necessidade Especial:</label>
                            </td>
                            <td>
                                <input list="necessidadeEspecial" name="txtNecessidadeEspecial" value="${bolsista.necessidadeEspecial}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                                <datalist id="necessidadeEspecial" >
                                    <option value="Sim"> Sim 
                                    <option value="Não">Não
                                </datalist>
                            </td>
                            <td>
                                <label>Cor:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCor" value="${bolsista.cor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Escolaridade:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtEscolaridade" value="${bolsista.escolaridade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                <label for="tituloEleitor">Título Eleitor: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtTituloEleitor" value="${bolsista.tituloEleitor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="numeroComprovanteMilitar">Número do comprovante de alistamento: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNumeroComprovanteMilitar" value="${bolsista.numeroComprovanteMilitar}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label>Pis/Pasep:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtPisPasep" value="${bolsista.pisPasep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <h4>Dados de endereço</h4>
                        <tr>
                            <td>
                                <label for="rua">Rua:</label>
                            </td>
                            <td>
                                <input type="text" name="txtRua" value="${bolsista.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            </td>
                            <td>
                                Numero:
                            </td>
                            <td>
                                <input type="text" name="txtNumero" value="${bolsista.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rua">Complemento:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtComplemento" value="${bolsista.complemento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="bairro">Bairro: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtBairro" value="${bolsista.bairro}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cidade">Cidade: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtCidade" value="${bolsista.cidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="estado">Estado:</label>
                            </td>
                            <td align="left">
                                <input list="Estado" name="txtEstado" value="${bolsista.uf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                                <input type="text" name="txtCep" value="${bolsista.cep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> > 
                            </td>
                            <td>
                                <label>País:</label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtPais" value="${bolsista.pais}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>

                        </tr> 
                        <h4>Dados Bancários</h4>
                        <tr>
                            <td>
                                <label for="banco">Banco: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtNomeBanco" value="${bolsista.nomeBanco}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="agencia">Agência: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtAgencia" value="${bolsista.agencia}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="contaCorrente">Conta Corrente: </label>
                            </td>
                            <td align="left">
                                <input type="text" name="txtContaCorrente" value="${bolsista.contaCorrente}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                    </tr>
                </table>
                <center>
                    <button class="botao1" onClick="parent.location.href = 'index1.jsp'" value="Cancelar">
                                          
                        <span>Cancelar</span>
                    </button> &nbsp;&nbsp;

                    <button class="botao1" type="submit" name="btnConfirmar"  value= "Confirmar">
                        <span>Confirmar</span>
                    </button>


                </center>


            </form>
        </div>
    </body>
</html>
