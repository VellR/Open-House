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

<title>Profile</title>
</head>
<body>

<div class="row">
	<div class="col-lg-3">
		
		<ul class="nav flex-column">
  			<li class="nav-item">
    			<a class="nav-link" href="${pageContext.request.contextPath}/homeWithId/${userId}">Feed</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="${pageContext.request.contextPath}/userItems/${userId}">My Items</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="${pageContext.request.contextPath}/userTrades/${userId}">Active Trades</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="${pageContext.request.contextPath}/request/${userId}">Item Request</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="${pageContext.request.contextPath}/browesableItems/${userId}">All Listed Items</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="${pageContext.request.contextPath}/profile/${userId}">Profile</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="${pageContext.request.contextPath}/">Logout</a>
  			</li>
		</ul>
	</div>

	<div class="col-lg-9">
		<form:form class="form-horizontal" action="${pageContext.request.contextPath}/updateUser/${userId}" method="post" modelAttribute="user" role="form">
			<fieldset>
                <h2>Profile</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">First Name: ${currentUser.firstName}</label>
                    <div class="col-sm-9">
                        <form:input type="hidden" path="firstName" name="firstName" id="firstName" value="${currentUser.firstName}" class="form-control"/>
                         <p><form:errors path="firstName" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastName" class="col-sm-3 control-label">Last Name: ${currentUser.lastName}</label>
                    <div class="col-sm-9">
                        <form:input path="lastName" type="hidden" name="lastName" id="lastName" value="${currentUser.lastName}" class="form-control"/>
                         <p><form:errors path="lastName" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email: ${currentUser.email} </label>
                    <div class="col-sm-9">
                        <form:input path="email" type="email" name="email" id="email" placeholder="Email" class="form-control"/>
                         <p><form:errors path="email" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">Username: ${currentUser.username}</label>
                    <div class="col-sm-9">
                        <form:input path="username" type="hidden" name="username" id="username" value="${currentUser.username}" class="form-control"/>
                         <p><form:errors path="username" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="currentPassword" class="col-sm-3 control-label">Current Password*</label>
                    <div class="col-sm-9">
                        <input type="password" name="currentPassword" id="currentPassword" placeholder="Current Password" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">New Password*</label>
                    <div class="col-sm-9">
                        <form:input path="password" type="password" name="password" id="password" placeholder="Password" class="form-control"/>
                         <p><form:errors path="password" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Confirm New Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="Password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="location" class="col-sm-3 control-label">Location: ${currentUser.location}</label>
                    <div class="col-sm-9">
                        <form:input path="location" type="text" name="location" id="location" placeholder="Location" class="form-control"/>
                         <p><form:errors path="location" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Date of Birth: ${currentUser.birthday}</label>
                    <div class="col-sm-9">
                        <form:input path="birthday" type="hidden" name="birthday" value="${currentUser.birthday}" id="birthday" class="form-control"/>
                        <p><form:errors path="birthday" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phoneNumber" class="col-sm-3 control-label">Phone number: ${currentUser.phoneNumber}</label>
                    <div class="col-sm-9">
                        <form:input path="phoneNumber" type="tel" name="phoneNumber" id="phoneNumber" placeholder="Phone number" class="form-control"/>
                         <p><form:errors path="phoneNumber" class="error"/></p>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Update Profile</button>
                </fieldset>
            </form:form>
            <p style="color: red;">${errorMessage}</p>
        </div>
</div>
</body>
</html>