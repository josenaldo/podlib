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
	commandName="episodioParticipantesForm"
	action="${contextPath}/episodios/adicionar-remover-participantes/${episodioParticipantesForm.id} ">
 
	<div class="panel panel-default left form-panel">
		<div class="panel-body">
			
		
			<form:hidden path="id" />
			<form:hidden path="titulo" />
			
			<spring:bind path="participantes">
				<h3>${episodioParticipantesForm.titulo}</h3>
						
				<c:if test="${status.error}">
					<p class="text-danger">
						<span class="label label-danger">
							<i class="icon-exclamation"></i>
						</span>
						&nbsp; 
						<span class="help-inline text-danger">
							${status.errorMessage}
						</span>
					</p>
				</c:if>
				
				<ul class="list-group left ${status.error ? 'danger' : '' }">
					<form:checkboxes path="participantes"
					items="${listaDeParticipantes}" 
					itemLabel="nome" 
					itemValue="id"					
					element="li class='list-group-item'" 
					/>													
				</ul>					
			</spring:bind>
		
		</div>
		<div class="panel-footer right">			
			<a href="${contextPath}/episodios" class="btn btn-default">Cancelar</a>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</div>

	</div>
</form:form>

