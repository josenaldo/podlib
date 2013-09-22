<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<h1>Podcasts</h1>

<c:if test="${not empty mensagem}">
	<t:alert messageText="${mensagem}" messageStyle="${tipoDaMensagem}"></t:alert>
</c:if>

<table class="table table-stripped table-hover">
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Descrição</th>
		<th>Site</th>
		<th>Núm. de episódios</th>
		<th></th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach items="${podcasts}" var="podcast">
		<tr class="left">
			<td>${podcast.id}</td>
			<td class="break-column">${podcast.nome}</td>
			<td class="break-column">${podcast.descricao}</td>
			<td class="break-column">
				<a href="${podcast.site}" target="_blank">${podcast.site}</a>
			</td>
			<td>${fn:length(podcast.episodios)}</td>
			<td>
				<a href="${contextPath}/podcasts/${podcast.id}" title="Visualizar"
					class="btn btn-info"> <i class="icon-zoom-in"></i>
				</a>
			</td>
			<td>
				<a href="${contextPath}/podcasts/${podcast.id}/editar" title="Editar"
					class="btn btn-warning"> <i class="icon-edit"></i>
				</a>
			</td>
			<td>
				<form:form method="DELETE" action="${contextPath}/podcasts/${podcast.id}" >				
					<input type="hidden" name="_method" value="DELETE" />
					<button type="submit" class="btn btn-danger" title="Remover">
						<i class="icon-minus"></i>
					</button>
				</form:form>
			</td>
		</tr>
	</c:forEach>
</table>

<a href="${contextPath}/podcasts/adicionar" class="btn btn-primary">
	<i class="icon-plus"></i> Adicionar
</a>
