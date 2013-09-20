<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
		<form action="${contextPath}/participantes/${participante.id}" method="post">
			<input type="hidden" name="_method" value="DELETE" />
			<a href="${contextPath}/participantes" class="btn btn-default">Cancelar</a>
			<button type="submit" class="btn btn-danger">Remover</button>
		</form>
	</div>
</div>



