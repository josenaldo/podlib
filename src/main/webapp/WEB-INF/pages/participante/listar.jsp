<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<h1>Participante</h1>
<table class="table table-stripped table-hover">
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Apelido</th>
		<th>Email</th>
		<th>twitter</th>
		<th></th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach items="${participantes}" var="participante">
	<tr class="left">
		<td>${participante.id}</td>
		<td>${participante.nome}</td>
		<td>${participante.apelido}</td>
		<td>${participante.email}</td>
		<td>${participante.twitter}</td>
		<td>
			<a href="${contextPath}/participantes/${participante.id}" title="Visualizar"
				class="btn btn-info"> <i class="icon-zoom-in"></i>
			</a>
		</td>
		<td>
			<a href="${contextPath}/participantes/${participante.id}/editar" title="Editar"
				class="btn btn-warning"> <i class="icon-edit"></i>
			</a>
		</td>
		<td>
			<form:form method="DELETE" action="${contextPath}/participantes/${participante.id}" >				
				<input type="hidden" name="_method" value="DELETE" />
				<button type="submit" class="btn btn-danger" title="Remover">
					<i class="icon-minus"></i>
				</button>
			</form:form>
		</td>	
	</tr>
	</c:forEach>
</table>

<a href="${contextPath}/participantes/adicionar" class="btn btn-primary">
	<i class="icon-plus"></i> Adicionar
</a>