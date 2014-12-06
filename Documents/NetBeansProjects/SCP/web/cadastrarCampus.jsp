<%-- 
    Document   : cadastrarCampus
    Created on : 08/09/2014, 21:45:20
    Author     : Mayara Amanda
--%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css2.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body> 
        <div id="Content">
        <form action="CadastrarCampusController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="cadastrarCampus">

            
                <h3>Cadastrar Campus - ${operacao} </h3>
             
                <table border="2">
                    <tr>
                        <td><label>Selecione a instituicao:
                            
                            <select name="optInstituicao">
                                <option>
                                    Selecione...
                                </option>
                            <c:forEach items="${instituicoes}" var="instituicao">
                                <option value="${instituicao.codigoInstituicao}"
                                    <c:if test="${instituicao.codigoInstituicao == campus.instituicao.codigoInstituicao}"> selected </c:if>>
                                        ${instituicao.nomeInstituicao}</option>
                            </c:forEach></select></label>
                        </td>
                    </tr>
                <tr>
                    <td>
                        <label>Codigo do Campus:
                            <input type="text" name="codigoCampus" value="${campus.codigoCampus}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Nome do Campus:
                            <input type="text" name="nomeCampus" value="${campus.nomeCampus}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></label>
                    </td>
                </tr>
            </table> 

                    <button class="botao1" onClick="parent.location.href = 'index1.jsp'" value="Cancelar">
                                          
                        <span>Cancelar</span>
                    </button> &nbsp;&nbsp;


            <button class="botao1" type="submit" name="btnConfirmar" value="Confirmar">
                <span>Confirmar</span>
            </button> 
        
    
</form>
</div>

</body>
</html>