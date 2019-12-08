<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/css/login_style.css" rel="stylesheet" type="text/css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<div class="sidenav">
         <div class="login-main-text">
            <h2>Open House<br></h2>
            <h2>Login Page</h2>
            <p>Login or register from here to access.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form action="${pageContext.request.contextPath}/loginUser" method="POST">
                  <div class="form-group">
                     <label>User Name</label>
                     <input name="username" id="username-input" type="text" class="form-control" placeholder="User Name">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input name="password" id="password-input" type="password" class="form-control" placeholder="Password">
                  </div>
                  <button type="submit" id="login-button" class="btn btn-black">Login</button>
                  <button id="register-button" formmethod="get" formaction="${pageContext.request.contextPath}/register" class="btn btn-secondary">Register</button>
               </form>
            </div>
         </div>
      </div>
</body>
</html>