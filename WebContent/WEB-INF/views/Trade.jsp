<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/css/login_style.css" rel="stylesheet" type="text/css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>My Trades</title>
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
		<h4>My Active Buys</h4>
		<c:forEach items = "${sellerTradeList}" var = "trade">
	    	<tr>
				<td><a href="#">${trade.key}</a></td><br>
				<c:forEach items="${trade.value}" var="item">
        			<td>${item.name}</td><br>
					<td>${item.price}</td><br>
					<td>${item.description}</td><br>
					<td>${item.expiration}</td><br>
				</c:forEach>
	    	</tr><br>
		</c:forEach>
		
		<h4>My Active Sells</h4>
		<c:forEach items = "${ownerTradeList}" var = "trade">
	    	<tr>
				<c:forEach items="${trade.value}" var="item">
        			<td>${item.name}</td><br>
					<td>${item.price}</td><br>
					<td>${item.description}</td><br>
					<td>${item.expiration}</td><br>
				</c:forEach>
	    	</tr><br>
		</c:forEach>
		
	</div>
</div>

	

</body>
</html>