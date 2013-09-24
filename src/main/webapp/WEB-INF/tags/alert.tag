<%@tag language="java" pageEncoding="UTF-8"%>
<%@tag
	description="Extended input tag to allow for sophisticated errors"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@attribute name="messageStyle" required="true" type="java.lang.String"%>
<%@attribute name="messageText" required="true" type="java.lang.String"%>

<%@attribute name="messageHeader" required="false" type="java.lang.String"%>
<%@attribute name="messageHelp" required="false" type="java.lang.String"%>
<%@attribute name="closeButton" required="false" type="java.lang.Boolean"%>

<c:if test="${empty closeButton}">
	<c:set var="closeButton" value="false"/>
</c:if>

<div class="alert alert-${messageStyle}">
	<c:if test="${closeButton}">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
	</c:if> 
	<c:if test="${not empty messageHeader}">
		<h2>${messageHeader}</h2>
	</c:if>
	<p>${messageText}</p>
	<c:if test="${not empty messageHelp}">
		<small>${messageHelp}</small>
	</c:if>

</div>