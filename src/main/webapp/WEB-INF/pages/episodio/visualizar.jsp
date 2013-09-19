<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h1>${acao} episódio</h1>

<form action="${contextPath}/episodio/salvar" method="post">
	<fieldset disabled="disabled">
		<div class="panel panel-default left form-panel">
			<div class="panel-body">
				<div class="form-group">
					<label for="title">Título</label> 
					<input type="text" id="title"
						class="form-control" 
						placeholder="Digite o título do episódio">
				</div>
				<div class="form-group">
					<label for="descricao">Descrição</label>
					<textarea class="form-control" id="descricao"
						rows="4" placeholder="Digite a descrição do episódio"></textarea>
				</div>
				<div class="form-group">
					<label for="url">URL</label> 
					<input type="text" class="form-control" id="url"
						placeholder="Digite a url do episódio">
				</div>
			</div>
			<div class="panel-footer right">			
				<a href="${contextPath}/episodio" class="btn btn-default">Cancelar</a>
				<input type="submit" class="btn btn-primary" value="Salvar">
			</div>
		
		</div>
	</fieldset>
</form>
