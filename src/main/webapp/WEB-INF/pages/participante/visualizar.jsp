<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Visualizar detalhes</h1>

<div class="panel panel-default left form-panel">		
	<div class="panel-body">
		<table class="table table-bordered table-hover">
			<tr>
				<th>ID</th>
				<td>${participante.id}</td>
			</tr>
			<tr>
				<th>Nome</th>
				<td>${participante.nome}</td>
			</tr>
			<tr>
				<th>Apelido</th>
				<td>${participante.apelido}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${participante.email}</td>
			</tr>
			<tr>
				<th>Twitter</th>
				<td>${participante.twitter}</td>
			</tr>
		</table>
	</div>				
	
	<div class="panel-footer right">
		<form:form method="DELETE" action="${contextPath}/participantes/${participante.id}">
			
			<a href="${contextPath}/participantes" class="btn btn-default">
				Cancelar
			</a>
			
			<a href="${contextPath}/participantes/${participante.id}/editar"
				class="btn btn-warning"> Editar
			</a>
				
			<a href="${contextPath}/participantes/adicionar-?participanteId=${participante.id}" class="btn btn-primary">
				Adicionar episódio
			</a>
						
			<button type="submit" class="btn btn-danger">
				Remover participante
			</button>
		</form:form>
	</div>
</div>



