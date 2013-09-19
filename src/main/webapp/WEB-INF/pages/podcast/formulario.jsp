<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h1>${acao} podcast</h1>

<form action="${contextPath}/podcast/salvar" method="post">
	<div class="panel panel-default left form-panel">
		<div class="panel-body">
			<div class="form-group">
				<label for="nome">Nome</label> 
				<input type="text" id="nome"
					class="form-control" 
					placeholder="Digite o nome do podcast">
			</div>
			<div class="form-group">
				<label for="descricao">Descrição</label>
				<textarea class="form-control" id="descricao"
					rows="4" placeholder="Digite a descrição do podcast"></textarea>
			</div>
			<div class="form-group">
				<label for="site">Site</label> 
					<input type="text"
					class="form-control" id="site"
					placeholder="Digite o site do podcast">
			</div>
		</div>
		<div class="panel-footer right">			
			<a href="${contextPath}/podcasts" class="btn btn-default">Cancelar</a>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</div>

	</div>
</form>
