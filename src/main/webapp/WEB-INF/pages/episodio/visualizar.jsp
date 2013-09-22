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
				<td>${episodio.id}</td>
			</tr>
			<tr>
				<th>Nome</th>
				<td>${episodio.titulo}</td>
			</tr>
			<tr>
				<th>Descrição</th>
				<td>${episodio.descricao}</td>
			</tr>
			<tr>
				<th>Site</th>
				<td>
					<a href="${episodio.url}" target="_blank">
						${episodio.url}
					</a>
				</td>
			</tr>
			<tr>
				<th>Podcast</th>
				<td>
					<a href="${contextPath}/podcasts/${episodio.podcast.id}">
						${episodio.podcast.nome}
					</a>
				</td>
			</tr>
		</table>
	</div>				
	
	<div class="panel-footer right">
		<form:form method="DELETE" action="${contextPath}/episodios/${episodio.id}">
			
			<a href="${contextPath}/episodios" class="btn btn-default">
				Cancelar
			</a>
			
			<a href="${contextPath}/episodios/${episodio.id}/editar"
				class="btn btn-warning"> Editar
			</a>
				
			<a href="${contextPath}/episodios/adicionar-remover-participantes/${episodio.id}" class="btn btn-primary">
				Adicionar participante
			</a>
						
			<button type="submit" class="btn btn-danger">
				Remover episódio
			</button>
		</form:form>	
	</div>
</div>

<h2>Participante</h2>
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
	<c:forEach items="${episodio.participantes}" var="participante">
	<tr class="left">
		<td>${participante.id}</td>
		<td class="break-column">${participante.nome}</td>
		<td class="break-column">${participante.apelido}</td>
		<td class="break-column">
			<a href="mailto:${participante.email}" target="_blank">
				${participante.email}
			</a>
		</td>
		<td class="break-column">
			<a href="http://twitter.com/${participante.twitter}" target="_blank">${participante.twitter}</a>
		</td>
		<td class="buttom-column">
			<a href="${contextPath}/participantes/${participante.id}" title="Visualizar"
				class="btn btn-info"> <i class="icon-zoom-in"></i>
			</a>
		</td>
		<td class="buttom-column">
			<a href="${contextPath}/participantes/${participante.id}/editar" title="Editar"
				class="btn btn-warning"> <i class="icon-edit"></i>
			</a>
		</td>
		<td class="buttom-column">
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




