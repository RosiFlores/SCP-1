<%-- 
    Document   : cadastrarCurso
    Created on : 08/09/2014, 22:19:13
    Author     : Mayara Amanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="default.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
        <div id="Content">
            <form action="CadastrarCursoController?acao=confirmarOperacao&operacao=${operacao}" 
                  method="post" name="cadastrarCurso">
                <center>
                    <h3>Cadastrar Curso - ${operacao} </h3>
                    <table>
                        <tr>
                            <td><label>Selecione o Tipo Curso:</label>
                                <select name="optTipoCurso">
                                    <option>Selecione...</option>
                                    <c:forEach items="${tipoCurso}" var="tipoCurso">
                                        <option value="${tipoCurso.codigoTipoCurso}"
                                                <c:if test="${tipoCurso.codigoTipoCurso == curso.tipoCurso.codigoTipoCurso}"> selected</c:if>>
                                            ${tipoCurso.nomeTipoCurso}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Selecione o Campus:</label>
                                <select name="optCampus">
                                    <option>
                                        Selecione...
                                    </option>
                                    <c:forEach items="${campus}" var="campus">
                                        <option value="${campus.codigoCampus}"
                                                <c:if test="${campus.codigoCampus == curso.campus.codigoCampus}"> selected </c:if>>
                                            ${campus.nomeCampus}</option>
                                    </c:forEach></select></label>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Selecione a Instituição:</label>

                                <select name="optInstituicao">
                                    <option>Selecione...</option>
                                    <c:forEach items="${instituicao}" var="instituicao">
                                        <option value="${instituicao.codigoInstituicao}"
                                                <c:if test="${instituicao.codigoInstituicao == curso.instituicao.codigoInstituicao}"> selected</c:if>>
                                            ${instituicao.nomeInstituicao}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Selecione o Coordenador</label>
                                <select name="optCoordenador">
                                    <option>Selecione...</option>
                                    <c:forEach items="${orientador}" var="orientador">
                                        <option value="${orientador.matricula}"
                                                <c:if test="${orientador.matricula == curso.coordenador.matricula}"> selected</c:if>>
                                            ${orientador.nome}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Codigo do Curso:</label>
                            </td>
                            <td>
                                <input type="text" name="codigoCurso" value="${curso.codigoCurso}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>                 
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Nome do Curso:</label>
                                </td>
                                <td>
                                    <input type="text" name="nomeCurso" value="${curso.nomeCurso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>              
                            </td>
                        </tr>
                    </table>



                    <button class="botao1" onClick="parent.location.href = 'index1.jsp'">
                        <span>Cancelar</span>
                    </button> &nbsp;&nbsp;

                    <button class="botao1" type="submit" name="btnConfirmar" value="Confirmar" >
                        <span>Confirmar</span>
                    </button>

                </center>  
            </form>
        </div>
    </body>
</html>