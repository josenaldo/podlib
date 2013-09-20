<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 <c:choose>
        <c:when test="${podcast.novo}">
        	<c:set var="metodo" value="POST"/>
        	<c:set var="acao" value="Adicionar"/>
        </c:when>
        <c:otherwise>        	
        	<c:set var="metodo" value="PUT"/>
        	<c:set var="acao" value="Editar"/>
        </c:otherwise>
</c:choose>
<h1>${acao} podcast</h1>

<form action="${contextPath}/podcasts/${podcast.id}" method="post" id="podcast">
	<input type="hidden" name="_method" value="${metodo}"/> 
	<div class="panel panel-default left form-panel">
		<div class="panel-body">
			<div class="form-group">
				<label for="nome">Nome</label> 
				<input type="text" id="nome" name="nome"
					class="form-control" 
					placeholder="Digite o nome do podcast"
					value="${podcast.nome}">
			</div>
			<div class="form-group">
				<label for="descricao">Descrição</label>
				<textarea class="form-control" id="descricao" name="descricao"
					rows="4" placeholder="Digite a descrição do podcast">${podcast.descricao}</textarea>
			</div>
			<div class="form-group">
				<label for="site">Site</label> 
					<input type="text" name="site"
					class="form-control" id="site"
					placeholder="Digite o site do podcast"
					value="${podcast.site}">
			</div>
		</div>
		<div class="panel-footer right">			
			<a href="${contextPath}/podcasts" class="btn btn-default">Cancelar</a>
			<input type="submit" class="btn btn-primary" value="Salvar">
		</div>

	</div>
</form>
