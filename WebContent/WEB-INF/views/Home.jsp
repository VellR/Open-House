<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/css/login_style.css" rel="stylesheet" type="text/css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Home</title>
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
		<c:forEach items = "${feedItems}" var = "item">
	    	<div class="list-group">
	    		<c:if test="${item.type == 1}">
	    			<a href="${pageContext.request.contextPath}/item/${userId}/${item.id}" class="list-group-item list-group-item-action flex-column align-items-start">
    					<div class="d-flex w-100 justify-content-between">
      					<h5 class="mb-1">Item: ${item.name}</h5>
      					<small class="text-muted">Expires on: ${item.expiration}</small>
    					</div>
    					<small class="text-muted">$${item.price}</small>
    					<p class="mb-1">${item.description}</p><br>
  					</a>
	    		</c:if>
	    		<c:if test="${item.type == 2}">
	    			<a href="${pageContext.request.contextPath}/userRequest/${userId}/${item.id}" class="list-group-item list-group-item-action flex-column align-items-start">
    					<div class="d-flex w-100 justify-content-between">
      					<h5 class="mb-1">Request: ${item.name}</h5>
    					</div>
    					<small class="text-muted">$${item.price}</small>
    					<p class="mb-1">${item.description}</p><br>
  					</a>
	    		</c:if>
			</div>
	    
	    
	</c:forEach>
		
	</div>
	
</div>

	
	
</body>
</html>