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

	<h3 align="center">Choose Pizza :</h3>

	<hr class="colorgraph">

	<form action="${pageContext.request.contextPath}/reviewOrder"
		method="post">

		<hr class="colorgraph">


		<div class="row" align="center">
			<div class="col-sm-3 col-md-3 col-lg-3">
				
				<select name="selectedPizza" id="selectedPizza"
					class="form-control input-lg" required="required">
					<option value="null">--Select Pizza--</option>
					<c:forEach items="${sessionScope.menu}" var="pizza">
						<option value="${pizza.pizzaid}">${pizza.pizzaName}</option>
					</c:forEach>
				</select>

			</div>


			<div class="col-sm-3 col-md-3 col-lg-3">				
				
				<select name="selectedPizza" id="selectedPizza"
					class="form-control input-lg" required="required">
					<option value="null">--Select Pizza--</option>
					<c:forEach items="${sessionScope.toppingList}" var="topping">
						<option value="${topping.toppingId}">${topping.toppingName}</option>
					</c:forEach>
				</select>
				
			</div>

			<div class="col-sm-3 col-md-3 col-lg-3">
				<select name="quantity" id="quantity" class="form-control input-lg">
					<option value=null>--Select Quantity--</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
			</div>

			<div class="col-sm-3 col-md-3 col-lg-3">
				<select name="size" id="size" class="form-control input-lg">
					<option value=null>--Select Size--</option>
					<option value="small">Small</option>
					<option value="medium">Medium</option>
					<option value="large">Large</option>
				</select>
			</div>

		</div>

		<hr class="colorgraph">

		<div class="row" align="right">
			<div class="col-sm-2 col-md-2 col-lg-2">
				<input type="submit" class="btn btn-lg btn-primary btn-block"
					value="Review">
			</div>
		</div>

	</form>


	<footer>
		<c:import url="/footer.jsp" />
	</footer>

</body>
</html>