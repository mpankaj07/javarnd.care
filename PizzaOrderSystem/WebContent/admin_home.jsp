<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
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

	<h1>Welcome ${sessionScope.user.name}</h1>

	<h2 align="center">User Operations :</h2>

	<hr class="colorgraph">

	<div class="row" align="center">
		<div class="col-xs-4 col-sm-4 col-md-4">
			<a href="login/register.jsp" class="btn btn-primary">Register New
				User</a>
		</div>

		<div class="col-xs-4 col-sm-4 col-md-4">
			<a href="login/blockUser.jsp" class="btn btn-primary">Deactivate User</a>
		</div>

		<div class="col-xs-4 col-sm-4 col-md-4">
			<a href="login/deleteUser.jsp" class="btn btn-primary">Delete
				User</a>
		</div>
	</div>

	<footer>
		<c:import url="/footer.jsp" />
	</footer>



</body>
</html>