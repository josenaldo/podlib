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
		<form action="${contextPath}/episodios/${episodio.id}" method="post">
			<input type="hidden" name="_method" value="DELETE" />
			<a href="${contextPath}/episodios" class="btn btn-default">Cancelar</a>
			<button type="submit" class="btn btn-danger">Remover</button>
		</form>
	</div>
</div>



