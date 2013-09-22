<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <c:choose>
        <c:when test="${podcast.novo}">
        	<c:set var="metodo" value="POST"/>
        	<c:set var="acao" value="Adicionar"/>
        </c:when>
        <c:otherwise>        	
        	<c:set var="metodo" value="PUT"/>
        	<c:set var="acao" value="Editar"/>
        </c:otherwise>
</c:choose>
<h1>${acao} podcast</h1>

<c:if test="${not empty mensagem}">
	<t:alert messageText="${mensagem}" messageStyle="${tipoDaMensagem}"></t:alert>
</c:if>

<form:form method="${metodo}" id="podcast-form" 
	commandName="podcast"
	action="${contextPath}/podcasts/${podcast.id}">
 
	<div class="panel panel-default left form-panel">
		<div class="panel-body">
			<t:input path="id" label="ID" disabled="true"/>
			
			<t:input path="nome" label="Nome" placeholder="Digite o nome do podcast" required="true" />
			
			<t:textarea path="descricao" label="Descrição" placeholder="Digite a descrição do podcast" required="true" rows="4"/>
			
			<t:input path="site" label="Site" placeholder="Digite o site do podcast. Exemplo: 'http://jnaldo.com'" required="true" />
		
		</div>
		<div class="panel-footer right">			
			<a href="${contextPath}/podcasts" class="btn btn-default">Cancelar</a>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</div>

	</div>
</form:form>
