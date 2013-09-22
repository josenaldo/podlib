<%@tag language="java" pageEncoding="UTF-8"%>
<%@tag description="Extended input tag to allow for sophisticated errors"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>
<%@attribute name="items" required="true" type="java.lang.Object"%>
<%@attribute name="itemLabel" required="true" type="java.lang.String"%>
<%@attribute name="itemValue" required="true" type="java.lang.String"%>
<%@attribute name="disabled" required="false" type="java.lang.Boolean"%>
 
<c:if test="${empty label}">
	<c:set var="label"
		value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
</c:if>

<c:if test="${empty disabled}">
	<c:set var="disabled" value="false" />
</c:if>

<spring:bind path="${path}">
	<div class="form-group ${status.error ? 'has-error' : '' }">
		<label for="${path}" class="control-label">
			${label}
			<c:if test="${required}">
				<span class="required">*</span>
			</c:if>		
		</label> 
		
		<form:select  path="${path}" cssClass="form-control ${cssClass}" disabled="${disabled}">				
			<form:options items="${items}" itemLabel="${itemLabel}" itemValue="${itemValue}" />			 
		</form:select>	
				
		<c:if test="${status.error}">
			<span class="label label-danger"> <i class="icon-exclamation"></i></span> <span class="help-inline text-danger">${status.errorMessage}</span>
		</c:if>
				
	</div>	
</spring:bind>