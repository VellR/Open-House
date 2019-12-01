<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<meta charset="ISO-8859-1">
<title>Requested Items</title>
</head>
<body>
	
	<div class="row">
	<div class="col-2">
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
	
	<div class="col-6">
		<div class="container">
            <form:form class="form-horizontal" action="${pageContext.request.contextPath}/addRequest/${userId}" method="post" modelAttribute="request" role="form">
            <fieldset>
                <h2>New Request</h2>
                <div class="form-group">
                    <label for="itemName" class="col-sm-3 control-label">Item Name</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="itemName" name="itemName" id="itemName" placeholder="Item name" class="form-control"/>
                         <p><form:errors path="name" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="itemDescription" class="col-sm-3 control-label">Item Description</label>
                    <div class="col-sm-9">
                        <form:input path="itemDescription" type="textarea" name="itemDescription" id="itemDescription" placeholder="Item description..." class="form-control"/>
                         <p><form:errors path="description" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="itemPrice" class="col-sm-3 control-label">Item Price</label>
                    <div class="col-sm-9">
                        <form:input path="itemPrice" type="number" name="itemPrice" id="itemPrice" placeholder="0.00" class="form-control"/>
                         <p><form:errors path="price" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="isBarter" class="col-sm-3 control-label">Would you like to barter?</label>
                    <div class="col-sm-9">
                        <form:input path="isBarter" type="radio" name="true" id="true" value="true" class="form-control"/>
                        <form:input path="isBarter" type="radio" name="false" id="false" value="false" class="form-control"/>
                        <p><form:errors path="isBarter" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="barterItem" class="col-sm-3 control-label">Preferred Barter Item:</label>
                    <div class="col-sm-9">
                        <form:input path="barterItem" type="text" name="barterItem" id="barterItem" placeholder="Item Name" class="form-control"/>
                         <p><form:errors path="price" class="error"/></p>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Make Request</button>
                </fieldset>
            </form:form>
            <p style="color: red;">${errorMessage}</p>
        </div>
        
        
        <c:forEach items = "${requestList}" var = "request">
	    <tr>
		<td><a href="#">
                    ${request.name}</a></td>
		<td>${request.description}</td>
		<td>${request.price}</td>
		<td>${request.isBarter}</td>
		<td>${request.barterItem}</td>
		<td><a href="${pageContext.request.contextPath}/removeRequest/${request.requestId}/${userId}">remove</a></td><br>
	    </tr>
	</c:forEach>
	</div>
</div>
	
</body>
</html>