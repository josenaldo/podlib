<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h1>${acao} participante</h1>

<form action="${contextPath}/participantes" method="post">
	<div class="panel panel-default left form-panel">
		<div class="panel-body">
			<div class="form-group">
				<label for="nome">Nome</label> 
				<input type="text" id="nome"
					class="form-control" 
					placeholder="Digite o nome do participante">
			</div>
			<div class="form-group">
				<label for="apelido">Apelido</label> 
				<input type="text" id="apelido"
					class="form-control" 
					placeholder="Digite o apelido do participante">
			</div>
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="text" id="email"
					class="form-control" 
					placeholder="Digite o email do participante">
			</div>
			<div class="form-group">
				<label for="twitter">Twitter</label> 
				<input type="text"
					class="form-control" id="twitter"
					placeholder="Digite o twitter do participante">
			</div>
		</div>
		<div class="panel-footer right">			
			<a href="${contextPath}/participantes" class="btn btn-default">Cancelar</a>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</div>

	</div>
</form>
