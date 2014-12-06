<%-- 
    Document   : cadastrarEdital
    Created on : 06/09/2014, 16:58:38
    Author     : Mayara Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css" media="all" />
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
        <div id="TelaLogin">
            <center>
                <h2>Cadastro de Edital</h2>
            </center>
                
            <form action="CadastrarEditalController?acao=confirmarOperacao&operacao=${operacao}"
                  method="post" name="CadastrarEdital" onsubmit="validarFormulario(this)">
                    <fieldset>
                        <legend>Dados do edital</legend>
                        <label>Código do Edital:<input type="text" name="codigoEdital" value="${edital.codigoEdital}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></label>
                        <label>Número do Edital:<input type="text" name="numeroEdital" value="${edital.numeroEdital}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label>
                        <br/><br/>
                        <label>Ano do Edital:<input type="text" name="anoEdital" value="${edital.anoEdital}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label> <br/><br/>
                                <label>Selecione o Tipo de Bolsa:

                                    <select name="optTipoBolsa" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                            <option>Selecione...</option>
                                        <c:forEach items="${tipoBolsas}" var="tipoBolsa">
                                            <option value="${tipoBolsa.codigoTipoBolsa}"
                                                    <c:if test="${tipoBolsa.codigoTipoBolsa == edital.tipoBolsa.codigoTipoBolsa}"> selected </c:if>> ${tipoBolsa.nomeTipoBolsa}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                                               
                        <br><br>
                            <label>Selecione Subarea de Conhecimento:

                                    <select name="optSubarea" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                            <option>Selecione...</option>
                                        <c:forEach items="${subareas}" var="subarea">
                                            <option value="${subarea.codigoSubArea}"
                                                    <c:if test="${subarea.codigoSubArea == edital.subArea.codigoSubArea}"> selected </c:if>>${subarea.nomeSubArea}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            
                        
                        <br><br>
                        <label>Selecione o campus:

                                    <select name="optCampus" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                            <option>Selecione...</option>
                                        <c:forEach items="${campi}" var="campus">
                                            <option value="${campus.codigoCampus}" <c:if test="${campus.codigoCampus == edital.campus.codigoCampus}"> selected</c:if>>${campus.nomeCampus}</option>
                                        </c:forEach></select></label>

                        <label>Quantidade de Bolsas:<input type="text" name="quantidadeBolsas" value="${edital.quantidadeBolsas}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label> <br/><br/>
                        <label>Validade da Bolsa:<input type="text" name="validadeBolsa"value="${edital.validadeBolsa}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label> <br/><br/>
                        <label>Valor da Bolsa:<input type="text" name="valorBolsa" value="${edital.valorBolsa}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label> <br/><br/>
                        <label>Validade do Edital:<input type="text" name="validadeEdital" value="${edital.validadeEdital}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label> <br/><br/>


                            <center>

                                <button class="botao3" onClick="parent.location.href='index1.jsp'">
                                        <label>Cancelar</label>
                                </button> &nbsp;&nbsp;

                    <button class="botao1" type="submit" name="btnConfirmar"  value= "Confirmar">
                        <span>Cadastrar</span>
                    </button>
                             </center>
                        
                    </fieldset>
                        </form>
            </div>
                        
    </body>
</html>