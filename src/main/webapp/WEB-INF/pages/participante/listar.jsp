<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<h1>Participante</h1>
<table class="table table-stripped table-hover">
	<tr>
		<th>Nome</th>
		<th>Apelido</th>
		<th>Email</th>
		<th>twitter</th>
	</tr>
	<c:forEach items="${participantes}" var="participante">
	<tr class="left">
		<td>${participante.nome}</td>
		<td>${participante.apelido}</td>
		<td>${participante.email}</td>
		<td>${participante.twitter}</td>
	</tr>
	</c:forEach>
</table>

<a href="${contextPath}/participante/adicionar" class="btn btn-primary">
	<i class="icon-plus"></i> Adicionar
</a>