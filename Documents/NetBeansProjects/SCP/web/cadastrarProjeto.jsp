<%-- 
    Document   : cadastrarProjeto
    Created on : 08/09/2014, 16:16:35
    Author     : Mayara Amanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css2.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
       <div id="Content">
           <form action="CadastrarProjetoController?acao=confirmarOperacao&operacao=${operacao}" 
                  method="post" name="cadastrarProjeto">
           <center>
             <h3>Cadastrar Projeto - ${operacao} </h3>
                <table>
                    <tr>
                        <td><label>Selecione o tipo da bolsa:
                            
                            <select name="optTipoBolsa" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <c:forEach items="${tipobolsas}" var="tipobolsa">
                                <option value="${tipobolsa.codigoTipoBolsa}"
                                    <c:if test="${tipobolsa.codigoTipoBolsa == projeto.tipoBolsa.codigoTipoBolsa}"> selected </c:if>>
                                        ${tipobolsa.nomeTipoBolsa}</option>
                            </c:forEach></select></label>
                        </td>
                    </tr> 
                    <tr>
                        <td><label>Selecione o edital:
                            
                            <select name="optEdital" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                            <c:forEach items="${editais}" var="edital">
                                <option value="${edital.codigoEdital}"
                                    <c:if test="${edital.codigoEdital == projeto.edital.codigoEdital}"> selected </c:if>>
                                        ${edital.numeroEdital}</option>
                            </c:forEach></select></label>
                        </td>
                        
                    </tr> 
                    <tr>
                        <td><label>Selecione a SubArea:
                            
                            <select name="optSubArea" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                            <c:forEach items="${subareas}" var="subarea">
                                <option value="${subarea.codigoSubArea}"
                                    <c:if test="${subarea.codigoSubArea == projeto.subArea.codigoSubArea}"> selected </c:if>>
                                        ${subarea.nomeSubArea}</option>
                            </c:forEach></select></label>
                        </td>
                        
                    </tr> 
                     <tr>
                        <td><label>Selecione o Orientador:
                            
                            <select name="optOrientador" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                            <c:forEach items="${orientadores}" var="orientador">
                                <option value="${orientador.matricula}"
                                    <c:if test="${orientador.matricula == projeto.coordenador.matricula}"> selected </c:if>>
                                        ${orientador.nome}</option>
                            </c:forEach></select></label>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            <label>Codigo Projeto:</label>
                        </td>
                        <td>
                            <input type="text" name="codigoProjeto" value="${projeto.codigoProjeto}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Nome do Projeto:</label>
                        </td>
                        <td>
                            <input type="text" name="nomeProjeto" value="${projeto.nomeProjeto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Carga Horária:</label>
                        </td>
                        <td>
                            <input type="text" name="cargaHoraria" value="${projeto.cargaHoraria}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Palavras Chaves:</label>
                        </td>
                        <td>
                            <input type="text" name="palavraChave" value="${projeto.palavraChave}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Duração Projeto:</label>
                        </td>
                        <td>
                            <input type="text" name="duracao" value="${projeto.duracao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Data Início:</label>
                        </td>
                        <td>
                            <input type="text" name="dataInicio" value="${projeto.dataInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Data Término:</label>
                        </td>
                        <td>
                            <input type="text" name="dataTermino" value="${projeto.dataTermino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Valor Financiamento:</label>
                        </td>
                        <td>
                            <input type="text" name="valorFinanciamento" value="${projeto.valorfinanciamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Data Financiamento:</label>
                        </td>
                        <td>
                            <input type="text" name="dataFinanciamento" value="${projeto.dataFinanciamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Programa:</label>
                        </td>
                        <td>
                            <input type="text" name="programa" value="${projeto.programa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Agência Fomento:</label>
                        </td>
                        <td>
                            <input type="text" name="agenciaFomento" value="${projeto.agenciaFomento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Quantidade Bolsa:</label>
                        </td>
                        <td>
                            <input type="text" name="quantidadeBolsista" value="${projeto.quantidadeBolsista}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <label>Instituição Parceira:</label>
                        </td>
                        <td>
                            <input type="text" name="instituicaoParceira" value="${projeto.instituicaoParceira}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <label>Coorientador:</label>
                        </td>
                        <td>
                            <input type="text" name="coorientador" value="${projeto.professorParticipante}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Grupo Pesquisa CNPq:</label>
                        </td>
                        <td>
                            <input type="text" name="grupoPesquisaCNPq" value="${projeto.grupoPesquisaCNPq}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>                 
                        </td>
                    </tr>
                </table>

                                <button class="botao1" onClick="parent.location.href='index1.jsp'">
                                        <label>Cancelar</label>
                                </button> &nbsp;&nbsp;

                                <button class="botao1" type="submit" name="btnConfirmar" value="Confirmar">
                                        Confirmar
                                </button>
                      </center>

                   </form>
       </div>
    
    </body>
</html>