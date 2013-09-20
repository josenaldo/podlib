<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<h1>Podcasts</h1>
<table class="table table-stripped table-hover">
	<tr>
		<th>Nome</th>
		<th>Descrição</th>
		<th>Site</th>
		<th>Núm. de episódios</th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach items="${podcasts}" var="podcast">
		<tr class="left">
			<td>${podcast.nome}</td>
			<td>${podcast.descricao}</td>
			<td>${podcast.site}</td>
			<td>${fn:length(podcast.episodios)}</td>
			<td>
				<a href="${contextPath}/podcasts/${podcast.id}"
					class="btn btn-info"> <i class="icon-zoom-in"></i>
				</a>
			</td>
			<td>
				<a href="${contextPath}/podcasts/${podcast.id}/editar"
					class="btn btn-warning"> <i class="icon-edit"></i>
				</a>
			</td>
			<td>
				<form action="${contextPath}/podcasts/${podcast.id}" method="post">
					<input type="hidden" name="_method" value="DELETE" />
					<button type="submit" class="btn btn-danger">
						<i class="icon-remove"></i>
					</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

<a href="${contextPath}/podcasts/adicionar" class="btn btn-primary">
	<i class="icon-plus"></i> Adicionar
</a>
