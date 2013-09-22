<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:choose>
	<c:when test="${episodio.novo}">
		<c:set var="metodo" value="POST"/>
        <c:set var="acao" value="Adicionar"/>
	</c:when>
	<c:otherwise>        	
		<c:set var="metodo" value="PUT"/>
        <c:set var="acao" value="Editar"/>
	</c:otherwise>
</c:choose>

<h1>Adicionar participantes </h1>

<c:if test="${not empty mensagem}">
	<t:alert messageText="${mensagem}" messageStyle="${tipoDaMensagem}"></t:alert>
</c:if>

<form:form method="POST" id="episodio-participante-form" 
	commandName="episodioParticipante"
	action="${contextPath}/episodios/adicionar-participantes">
 
	<div class="panel panel-default left form-panel">
		<div class="panel-body">
					
			<t:selectFromObjecs path="episodio" label="Episódio" required="true" items="${episodios}" itemValue="id" itemLabel="nome" disabled="true"/>
			
			<table class="table table-stripped table-hover">
				<tr>
					<th>ID</th>
					<th>Nome</th>					
					<th></th>
				</tr>
				<c:forEach items="${participantes}" var="participante">
				<tr class="left">
					<td>${participante.id}</td>
					<td class="break-column">${participante.nome}</td>
					<td></td>
				</tr>
				</c:forEach>
			</table>
		
		
		</div>
		<div class="panel-footer right">			
			<a href="${contextPath}/episodios" class="btn btn-default">Cancelar</a>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</div>

	</div>
</form:form>

