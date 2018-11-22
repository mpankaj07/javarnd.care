<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<link href="login.css" rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>

	<div class="container">
		<div class="row" style="margin-top: 20px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form" action="login" method="post">
					<fieldset>
						<h2>Sign In</h2>

						<hr class="colorgraph">
						<c:if test="${error!=null}">
							<div>${error}</div>
						</c:if>

						<div class="form-group">
							<input type="text" name="loginName" id="loginName"
								class="form-control input-lg" placeholder="Login">
						</div>
						<div class="form-group">
							<input type="password" name="password" id="password"
								class="form-control input-lg" placeholder="Password">
						</div>

						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="submit" class="btn btn-lg btn-success btn-block"
									value="Login">
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<a href="login/register.jsp"
									class="btn btn-lg btn-primary btn-block">Register</a>
							</div>
						</div>
						<hr class="colorgraph">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
