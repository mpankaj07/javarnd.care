<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
<body>

	<div class="container-fluid header">
		<header>
			<c:import url="/header.jsp" />
		</header>
	</div>

	<h1>Welcome ${sessionScope.user.name}</h1>

	<h3 align="center">Order Submitted Successfully </h3>

	<hr class="colorgraph">

	<h3> Order Id : ${orderId} </h3>

	<h3>Ordered Pizza : ${ pizzaName }</h3>

	<h3>Cost of Pizza : ${ totalCost }</h3>

	<div class="row" align="right">
		<div class="col-sm-2 col-md-2 col-lg-2">
			<a href="user_home.jsp" class="btn btn-lg btn-primary btn-block">Back
				to Home</a>
		</div>
	</div>

	<footer>
		<c:import url="/footer.jsp" />
	</footer>

</body>
</html>