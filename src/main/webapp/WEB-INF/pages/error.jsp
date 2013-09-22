<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${not empty mensagem}">
<div class="row-container" >
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-lg-offset-3 vspace10 alert-top">			
				<t:alert messageText="${mensagem}" messageStyle="${tipoDaMensagem}" messageHeader="Canelada!"></t:alert>
			</div>
		</div>
	</div>
</div>

<a href="${contextPath}/" class="btn btn-default btn-back">
	<i class="icon-home"></i>
</a>
</c:if>
