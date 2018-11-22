<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<head>
<title>Pizza Order System</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="../layout.css">
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
</head>

<body>


	<div class="container-fluid header">
		<header>
			<c:import url="../header.jsp" />
		</header>
	</div>

	<hr class="colorgraph">

	<h2 align="center">User Deleted Successfully</h2>

	<hr class="colorgraph">

	<div class="row">
		<div class="col-xs-3 col-sm-3 col-md-3"></div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<a href="../admin_home.jsp" class="btn btn-lg btn-primary btn-block">Return to Home Page</a>
		</div>
	</div>

	<footer>
		<c:import url="../footer.jsp" />
	</footer>

</body>
</html>