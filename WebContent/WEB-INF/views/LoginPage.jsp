<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Open House</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div id="login-wrapper" class="card mx-auto align-items-center">
		<div class="row" class="login-row">
		<p>Username: </p>
		<input type="text" name="username">
		</div>
		<div class="row" class="login-row">
		<p>Password: </p>
		<input type="password" name="password">
		</div>
		<div class="row">
			<div class="col-sm-6">
				<button type="button" id="login-submit" class="btn">Login</button>
			</div>
			<div class="col-sm-6">
				<button type="button" id="register" class="btn">Register</button>
			</div>
		</div>
	</div>
	
</body>
</html>
