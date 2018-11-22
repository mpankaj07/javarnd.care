<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="login.css" rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="login.js"></script>
<title>Registration</title>
</head>
<body>

	<div class="container">

		<div class="row" style="margin-top: 20px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form" action="${pageContext.request.contextPath}/register" method="post">
				
					<fieldset>
						<h2>Please Enter the Details : </h2>
						
						<hr class="colorgraph">

						<div class="form-group">
							<input type="text" name="name" id="name"
								class="form-control input-lg" placeholder="Name">
						</div>

						<div class="form-group">
							<input type="text" name="mobileNumber" id="phone"
								class="form-control input-lg" placeholder="Phone">
						</div>

						<div class="form-group">
							<input type="email" name="email" id="email"
								class="form-control input-lg" placeholder="Email Address">
						</div>

						<div class="form-group">
							<input type="text" name="address" id="address"
								class="form-control input-lg" placeholder="Address">
						</div>

						<div class="form-group">
							<input type="text" name="userName" id="userName"
								class="form-control input-lg" placeholder="User Name">
						</div>

						<div class="form-group">
							<input type="password" name="password" id="password"
								class="form-control input-lg" placeholder="Password">
						</div>

						<div class="form-group">
							<select name="status" id="status" class="form-control input-lg">
								<option value="A">Active</option>
								<option value="B">Blocked</option>
							</select>
						</div>

						<hr class="colorgraph">
						
						<div class="row">
							<div class="col-xs-3 col-sm-3 col-md-3"></div>
							<div class="col-xs-6 col-sm-6 col-md-6">
							
							<input type="submit" class="btn btn-lg btn-primary btn-block" value="Register">
							
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
