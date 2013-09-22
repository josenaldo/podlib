<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${not empty mensagemDeErro}">
<div class="row-container" >
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-lg-offset-3 vspace10 alert-top">
				<div class="alert alert-${tipoDaMensagemDeErro}">					
					${mensagemDeErro}
				</div>
			</div>
		</div>
	</div>
</div>
</c:if>