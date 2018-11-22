<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style.css">
<link rel="stylesheet" href="/resources/layout.css">
<!-- meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>


	<div class="container-fluid header">
		<header>
			<c:import url="/header.jsp" />
			<c:import url="/logout.jsp" />
		</header>
	</div>

	<h2>Welcome ${sessionScope.user.name}</h2>

	<h2 align="center">Order Operations :</h2>

	<hr class="colorgraph">

	<div class="row" align="center">

		<form action="pizzamenu" method="post"
			class="col-xs-4 col-sm-4 col-md-4">
			<div class="col-xs-4 col-sm-4 col-md-4">
				<input type="submit" class="btn btn-primary" value="Order Pizza" />
			</div>
		</form>

		<form action="orderPlace" method="post"
			class="col-xs-4 col-sm-4 col-md-4">
			<div class="col-xs-4 col-sm-4 col-md-4">
				<input type="submit" class="btn btn-primary" value="Track Order" />
			</div>
		</form>

		<form action="orderPlace" method="post"
			class="col-xs-4 col-sm-4 col-md-4">
			<div class="col-xs-4 col-sm-4 col-md-4">
				<input type="submit" class="btn btn-primary" value="Cancel Order" />
			</div>
		</form>

	</div>

	<footer>
		<c:import url="/footer.jsp" />
	</footer>



</body>
</html>