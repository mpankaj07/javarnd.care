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
<title>Block User</title>
</head>
<body>

	<!------ Include the above in your HEAD tag ---------->

	<div class="container">

		<div class="row" style="margin-top: 20px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form" action="${pageContext.request.contextPath}/blockUser" method="post">
					
					<fieldset>
						<h2>Please Enter the Details :</h2>
						<hr class="colorgraph">

						<div class="form-group">
							<input type="text" name="mobileNumber" id="phone"
								class="form-control input-lg" placeholder="Phone">
						</div>

						<hr class="colorgraph">
						
						<div class="row">
							<div class="col-xs-3 col-sm-3 col-md-3"></div>
							<div class="col-xs-6 col-sm-6 col-md-6">
							
							<input type="submit" class="btn btn-lg btn-primary btn-block" value="Block User">
							
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
