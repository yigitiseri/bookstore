<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="com.bookstore.pojo.*"%>
<html>		
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<script type="text/javascript" src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<title>Category</title>
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
			PaginatedServiceOutput output = (PaginatedServiceOutput)request.getAttribute("output"); 
				for(int i = 0 ; i<output.getItems().size() ; i ++){%>
			<li class="span3 book-name">
			  <div class="thumbnail">
				<a href="<%= "/product/" +output.getItems().get(i).getItemId()%>" class="overlay"></a>
				<a href="<%= "/product/" +output.getItems().get(i).getItemId()%>" ><img src="<%=output.getItems().get(i).getThumbnailImage() %>" alt=""></a>
				<div class="caption cntr">
					<p><%= output.getItems().get(i).getName()%></p>
					<p><strong>$<%= output.getItems().get(i).getSalePrice()%></strong></p>
				</div>
			  </div>
			</li>
			<%}%>
		  </ul>
		  <%  
		  String[] params = output.getNextPage().split("&");  
 		  String[] nextParams= params[1].split("=");
 		  String nextPage = nextParams[1];
 			%>
		<p style="text-align: right;"><strong>Total Pages :<%=output.getTotalPages()%></strong>
		   <% if(!"1".equals(output.getTotalPages())){ %>
		  <a href="<%= "/home/" +nextPage + "/"+ output.getCategory()%>">
					<span class="pager">Next Page</span>
				</a> <%}%>
		  </p>
	</div>
</body>
</html>