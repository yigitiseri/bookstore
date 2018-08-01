<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import ="com.bookstore.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<script type="text/javascript"
	src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<title>Product</title>
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
	<%
	ProductServiceOutput output = (ProductServiceOutput)request.getAttribute("output"); 
	%>

<div class="container">
	<div class="span9">
	<div class="well well-small">
		<div style="display: flex" class="row-fluid wrapper">
			<div style="flex: 0 0 65%;" class="span5 left">
			<img src="<%=output.getLargeImage()%>" alt="">
			</div>
			<div style="flex: 1;" class="span7 right">
				<h3><%=output.getName()%></h3>
				<hr class="soft">

				<form class="form-horizontal qtyFrm">
					<div class="control-group">
						<label class="control-label"><h4 style="font-weight: bold;">$<%=output.getSalePrice()%></h4></label>
					</div>	
					<div class="control-group">
						<label class="control-label"><span>Quantity</span></label>
						<div class="controls">
							<select class="span11">
							<%for(int i =1 ; i <= 12 ; i++) {%>
								<option><%=i%></option>
							<%}%>
							</select>
						</div>
					</div>
					<h4>Free 2-day shipping on orders over $35</h4>
					<p><%=output.getLongDescription()%></p>
					<p>
						<button style="float: right;" type="submit" class="btn btn-success">
							<span class=" icon-shopping-cart"></span> Add to cart
						</button>
					</p>
				</form>
			</div>
		</div>

	</div>
	</div>
</div>
</body>
</html>