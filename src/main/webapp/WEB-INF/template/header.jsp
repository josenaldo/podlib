<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
		
	<title>Podoteca</title>
	
	<meta charset="utf-8">

	<!-- Set the viewport width to device width for mobile -->
  	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

  	<!-- IE compatibility mode -->
  	<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1" />

	<!-- Included Bootstrap CSS File -->
	<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css" />	
	
	<!-- Includes FontAwesome -->
	<link rel="stylesheet" href="${contextPath}/resources/css/font-awesome.min.css" />
	
	<!-- Included Bootstrap Extensions CSS File -->
	<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-extensions.css" />	
	
	<!-- Includes Application Base Style -->
	<link rel="stylesheet" href="${contextPath}/resources/css/base.css" />

</head>
<body>
  
<header>	
	
	<!-- Navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextPath}">Podoteca</a>
		</div>

		<div class="collapse navbar-collapse navbar-ex1-collapse">					
			<ul class="nav navbar-nav">
				<li>
					<a href="${contextPath}/podcast">Podcast</a>
				</li>
				<li>
					<a href="${contextPath}/episodio">Episódios</a>
				</li>
				<li>
					<a href="${contextPath}/participante">Participantes</a>
				</li>
			</ul>
		</div>
	</div>
</header>