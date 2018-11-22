<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="layout.css">
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


	<div class="container-fluid header" style="padding: 1%;">
		<header>
			<c:import url="/header.jsp" />
		</header>
	</div>

	<h3>Welcome ${sessionScope.user.name}</h3>

	<hr class="colorgraph">

	
	<div class="row">
		<div class="col-sm-6 col-md-6 col-lg-6">
		<h4 align="center">Available Pizza's </h4>
			<div align="center">
				<table border="2" cellpadding="4">
					<tr>
						<th>Pizza Id</th>
						<th>Name</th>
						<th>Small</th>
						<th>Medium</th>
						<th>Large</th>
					</tr>
					<c:forEach var="pizza" items="${sessionScope.menu}">
						<tr>
							<td><c:out value="${pizza.pizzaid}" /></td>
							<td><c:out value="${pizza.pizzaName}" /></td>
							<td><c:out value="${pizza.smallPrize}" /></td>
							<td><c:out value="${pizza.mediumPrize}" /></td>
							<td><c:out value="${pizza.largePrize}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-6 col-lg-6">
		<h4 align="center">Available Topping's </h4>
			<div align="center">
				<table border="2" cellpadding="4">
					<tr>
						<th>Topping Id</th>
						<th>Topping Name</th>
						<th>Topping Prize</th>
						
					</tr>
					<c:forEach var="topping" items="${sessionScope.toppingList}">
						<tr>
							<td><c:out value="${topping.toppingId}" /></td>
							<td><c:out value="${topping.toppingName}" /></td>
							<td><c:out value="${topping.toppingPrize}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

	<hr class="colorgraph">
	<div class="row" align="right">
		<div class="col-sm-11 col-md-11 col-lg-11">
			<a href="${pageContext.request.contextPath}/order/order_info.jsp" class="btn btn-primary">Place Order</a>
		</div>
	</div>
	
	<footer>
		<c:import url="/footer.jsp" />
	</footer>



</body>
</html>