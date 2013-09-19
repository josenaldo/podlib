<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<h1>Podcasts</h1>
<table class="table table-stripped table-hover">
	<tr>
		<th>Nome</th>
		<th>Descrição</th>
		<th>Site</th>
		<th>Núm. de episódios</th>
	</tr>
	<c:forEach items="${podcasts}" var="podcast">
	<tr class="left">
		<td>${podcast.nome}</td>
		<td>${podcast.descricao}</td>
		<td>${podcast.site}</td>
		<td>${fn:length(podcast.episodios)}</td>
	</tr>
	</c:forEach>
</table>

<a href="${contextPath}/podcast/adicionar" class="btn btn-primary">
	<i class="icon-plus"></i> Adicionar
</a>
	