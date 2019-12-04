<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<title>Browse Items</title>
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
	
	<form>
  		<div class="form-group">
    		<input type="email" class="form-control" placeholder="search..." id="exampleInputEmail1" aria-describedby="emailHelp">
  		</div>
	</form>
  
        <c:forEach items = "${avaiableItems}" var = "item">
	    	<div class="list-group">
 				<a href="${pageContext.request.contextPath}/item/${userId}/${item.itemId}" class="list-group-item list-group-item-action flex-column align-items-start">
    				<div class="d-flex w-100 justify-content-between">
      					<h5 class="mb-1">${item.name}</h5>
      					<small class="text-muted">Expires on: ${item.expiration}</small>
    				</div>
    					<small class="text-muted">$${item.price}</small>
    				<p class="mb-1">${item.description}</p><br>
  				</a>
			</div>
		</c:forEach>
	</div>
</div>

</body>
</html>