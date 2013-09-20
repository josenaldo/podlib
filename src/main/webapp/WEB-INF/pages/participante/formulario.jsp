<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <c:choose>
        <c:when test="${participante.novo}">
        	<c:set var="metodo" value="POST"/>
        	<c:set var="acao" value="Adicionar"/>
        </c:when>
        <c:otherwise>        	
        	<c:set var="metodo" value="PUT"/>
        	<c:set var="acao" value="Editar"/>
        </c:otherwise>
</c:choose>
<h1>${acao} participante</h1>

<form:form method="${metodo}" id="participante-form" 
	commandName="participante"
	action="${contextPath}/participantes/${participante.id}">
 
	<div class="panel panel-default left form-panel">
		<div class="panel-body">
		
			<t:input path="nome" label="Nome" placeholder="Digite o nome do participante" required="true" />
			
			<t:input path="apelido" label="Apelido" placeholder="Digite o apelido do participante" required="false" />
									
			<t:input path="email" label="Email" placeholder="Digite o email do participante. Exemplo: 'josenaldo@jnaldo.com'" required="true" />
			
			<t:input path="twitter" label="Twitter" placeholder="Digite o Twitter do participante." required="true" />
		
		</div>
		<div class="panel-footer right">			
			<a href="${contextPath}/participantes" class="btn btn-default">Cancelar</a>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</div>

	</div>
</form:form>