<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.bookstore.pojo.*"%>
<html lang="en">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/home">Book Store</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/bookstore">Categories</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">	
		<ul class="thumbnails">
			<%
				TaxonomyCategories bookCategory = (TaxonomyCategories) request.getAttribute("bookCategory");
				for (int i = 0; i < bookCategory.getChildren().size(); i++) {
			%>
			<li class="span3 book-name">
			  <div class="thumbnail">
				<a href="<%= "/category/" +bookCategory.getChildren().get(i).getId()%>" class="overlay"></a>
				<a href="<%= "/category/" +bookCategory.getChildren().get(i).getId()%>" ><img src="<%=bookCategory.getChildren().get(i).getThumbnailImage()%>" alt=""></a>
				<div class="caption cntr">
				<a href="<%= "/category/" +bookCategory.getChildren().get(i).getId()%>">
					<span class="caption cntr"><%= bookCategory.getChildren().get(i).getName() %></span>
				</a>
				</div>
			  </div>
			</li>
			<%}%>
		  </ul>
		  
	</div>
</body>

</html>
