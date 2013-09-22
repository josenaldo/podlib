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
				<td>${podcast.id}</td>
			</tr>
			<tr>
				<th>Nome</th>
				<td>${podcast.nome}</td>
			</tr>
			<tr>
				<th>Descrição</th>
				<td>${podcast.descricao}</td>
			</tr>
			<tr>
				<th>Site</th>
				<td>
					<a href="${podcast.site}" target="_blank">${podcast.site}</a>
				</td>
			</tr>
		</table>
	</div>				
	
	<div class="panel-footer right">
		<form:form method="DELETE" action="${contextPath}/podcasts/${podcast.id}">
			
			<a href="${contextPath}/podcasts" class="btn btn-default">
				Cancelar
			</a>
			
			<a href="${contextPath}/podcasts/${podcast.id}/editar" title="Editar"
				class="btn btn-warning"> Editar
			</a>
				
			<a href="${contextPath}/episodios/adicionar?podcastId=${podcast.id}" class="btn btn-primary">
				Adicionar episódio
			</a>
						
			<button type="submit" class="btn btn-danger">
				Remover podcast
			</button>
		</form:form>
	
		
	</div>
</div>

<h2>Episódios</h2>
<table class="table table-stripped table-hover">
	<tr>
		<th>Título</th>
		<th>Descrição</th>
		<th>URL</th>
		<th></th>
		<th></th>
		<th></th>	
	</tr>
	<c:forEach items="${podcast.episodios}" var="episodio">
		<tr class="left">
			<td>${episodio.titulo}</td>
			<td>${episodio.descricao}</td>
			<td>${episodio.url}</td>
			<td>
				<a href="${contextPath}/episodios/${episodio.id}" title="Visualizar"
					class="btn btn-info"> <i class="icon-zoom-in"></i>
				</a>
			</td>
			<td>
				<a href="${contextPath}/episodios/${episodio.id}/editar" title="Editar"
					class="btn btn-warning"> <i class="icon-edit"></i>
				</a>
			</td>
			<td>
				<form:form method="DELETE" action="${contextPath}/episodios/${episodio.id}" >				
					<input type="hidden" name="_method" value="DELETE" />
					<button type="submit" class="btn btn-danger" title="Remover">
						<i class="icon-minus"></i>
					</button>
				</form:form>
			</td>	
		</tr>
	</c:forEach>
</table>


