<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
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
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown">Podcasts<b class="caret"></b></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="${contextPath}/podcasts">Lista</a></li>	
						<li><a href="${contextPath}/podcasts/adicionar">Adicionar</a></li>							
					</ul>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown">Episódios<b class="caret"></b></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="${contextPath}/episodios">Lista</a></li>	
						<li><a href="${contextPath}/episodios/adicionar">Adicionar</a></li>							
					</ul>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown">Participantes<b class="caret"></b></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="${contextPath}/participantes">Lista</a></li>	
						<li><a href="${contextPath}/participantes/adicionar">Adicionar</a></li>							
					</ul>
				</li>				
			</ul>
		</div>
	</nav>
</header>

<div class="row-container">
	<div class="container column-center">