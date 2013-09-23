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
			
			<spring:bind path="participantes">
			
				<table class="table table-stripped table-hover table-bordered">
					<c:if test="${status.error}">
						
						<caption>
							<span class="label label-danger"> 
								<i class="icon-exclamation"></i>
							</span> 
							<span class="help-inline text-danger">
								${status.errorMessage}
							</span>
						</caption>
					</c:if>
					<tr>
						<th>${episodioParticipantesForm.titulo}</th>
					</tr>
					
					<c:forEach items="${listaDeParticipantes}" var="participante">
						<tr class="left ${status.error ? 'danger' : '' }">
							<td>
								<form:checkbox path="participantes" value="${participante.id}" label=" ${participante.nome}"/>
							</td>						
						</tr>
					</c:forEach>
				</table>
			</spring:bind>
		
		
		</div>
		<div class="panel-footer right">			
			<a href="${contextPath}/episodios" class="btn btn-default">Cancelar</a>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</div>

	</div>
</form:form>

