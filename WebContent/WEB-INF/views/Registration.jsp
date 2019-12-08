<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="/styles/register_style.css" rel="stylesheet" type="text/css">

<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>

<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

<div class="container">
            <form:form class="form-horizontal" action="${pageContext.request.contextPath}/registerUser" method="post" modelAttribute="user" role="form">
            <fieldset>
                <h2>Registration</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">First Name</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="firstName" name="firstName" id="firstName" placeholder="First Name" class="form-control"/>
                         <p style="color: red;" id="firstName-error" ><form:errors path="firstName" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                    <div class="col-sm-9">
                        <form:input path="lastName" type="text" name="lastName" id="lastName" placeholder="Last Name" class="form-control"/>
                         <p style="color: red;" id="lastName-error" ><form:errors path="lastName" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email* </label>
                    <div class="col-sm-9">
                        <form:input path="email" type="email" name="email" id="email" placeholder="Email" class="form-control"/>
                         <p style="color: red;" id="email-error" ><form:errors path="email" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">Username* </label>
                    <div class="col-sm-9">
                        <form:input path="username" type="text" name="username" id="username" placeholder="Username" class="form-control"/>
                         <p style="color: red;" id="username-error" ><form:errors path="username" class="error"/></p>
                         <p id="usernameTakenError" style="color: red;">${usernameTakenError}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password*</label>
                    <div class="col-sm-9">
                        <form:input path="password" type="password" name="password" id="password" placeholder="Password" class="form-control"/>
                         <p style="color: red;" id="password-error" ><form:errors path="password" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmPassword" class="col-sm-3 control-label">Confirm Password*</label>
                    <div class="col-sm-9">
                        <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Password" class="form-control">
                        <p id="confirmPasswordErrorMessage" style="color: red;">${confirmPasswordErrorMessage}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="location" class="col-sm-3 control-label">Location </label>
                    <div class="col-sm-9">
                        <form:input path="location" type="text" name="location" id="location" placeholder="Location" class="form-control"/>
                         <p style="color: red;" id="location-error" ><form:errors path="location" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Date of Birth*</label>
                    <div class="col-sm-9">
                        <form:input path="birthday" type="date" name="birthday" id="birthday" class="form-control"/>
                         <p style="color: red;" id="birthday-error" ><form:errors path="birthday" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phoneNumber" class="col-sm-3 control-label">Phone number </label>
                    <div class="col-sm-9">
                        <form:input path="phoneNumber" type="tel" name="phoneNumber" id="phoneNumber" placeholder="Phone number" class="form-control"/>
                         <p style="color: red;" id="phoneNumber-error" ><form:errors path="phoneNumber" class="error"/></p>
                    </div>
                </div>
                <button id="register-button" type="submit" class="btn btn-primary btn-block">Register</button>
                </fieldset>
            </form:form>
            <p id="errorMessage" style="color: red;">${errorMessage}</p>
        </div>

</body>
</html>