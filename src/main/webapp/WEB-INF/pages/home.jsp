<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="row-container">
	<div class="container column-center dashboard">
		<div class="col-lg-4 dashboard-item">
			<div class="panel panel-default">
				<a href="podcasts" class="dashboard-link">
					<i class="icon-rss-sign"></i>
					<br /> 
					<span>Podcasts</span>
				</a>
			</div>
		</div>
		<div class="col-lg-4 dashboard-item">
			<div class="panel panel-default">
				<a href="episodios"  class="dashboard-link">
					<i class="icon-volume-up"></i> 
					<br /> 
					<span>Episódios</span>
				</a>
			</div>
		</div>
		<div class="col-lg-4 dashboard-item">
			<div class="panel panel-default">
				<a href="participantes"  class="dashboard-link">
					<i class="icon-group"></i>
					<br />
					<span>Participantes</span>
				</a>
			</div>
		</div>
	</div>
</div>