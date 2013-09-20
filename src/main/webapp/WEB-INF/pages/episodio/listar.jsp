<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<h1>Episódios</h1>
<table class="table table-stripped table-hover">
	<tr>
		<th>Título</th>
		<th>Descrição</th>
		<th>URL</th>		
	</tr>
	<c:forEach items="${episodios}" var="episodio">
	<tr class="left">
		<td>${episodio.titulo}</td>
		<td>${episodio.descricao}</td>
		<td>${episodio.url}</td>		
	</tr>
	</c:forEach>
</table>

<a href="${contextPath}/episodios/adicionar" class="btn btn-primary">
	<i class="icon-plus"></i> Adicionar
</a>