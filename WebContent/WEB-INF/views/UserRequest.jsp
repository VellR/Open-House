<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>${request.name}</title>
</head>
<body>
	
	<div class="row">
	<div class="col-2">
		<ul class="nav flex-column">
  			<li class="nav-item">
    			<a class="nav-link" id="feed-link" href="${pageContext.request.contextPath}/homeWithId/${userId}">Feed</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" id="items-link" href="${pageContext.request.contextPath}/userItems/${userId}">My Items</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" id="trade-link" href="${pageContext.request.contextPath}/userTrades/${userId}">Active Trades</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" id="request-link" href="${pageContext.request.contextPath}/request/${userId}">Item Request</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" id="all-items-link" href="${pageContext.request.contextPath}/browesableItems/${userId}">All Listed Items</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" id="profile-link" href="${pageContext.request.contextPath}/profile/${userId}">Profile</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" id="logout-link" href="${pageContext.request.contextPath}/">Logout</a>
  			</li>
		</ul>
	</div>
	
	<div class="col-6">
		<!-- Page Content -->
<div class="container">

  <!-- Portfolio Item Heading -->
  <h1 class="my-4">${request.name}</h1>
  <small>$${request.price}</small>

  <!-- Portfolio Item Row -->
  <div class="row">

    <div class="col-md-8">
      <img class="img-fluid" src="http://placehold.it/750x500" alt="">
    </div>

    <div class="col-md-4">
      <h3 class="my-3">Request Description</h3>
      <p>${request.description}</p>
      <h3 class="my-3">Barter Item</h3>
      <p>${request.barterItem}</p>
      
      <form action="${pageContext.request.contextPath}/fulfillRequest/${userId}/${request.id}" method="get">
      	<button id="fulfill-request-button" type="submit" class="btn btn-warning">Fulfill Request</button>
      </form>
      
    </div>

  </div>

</div>
<!-- /.container -->
	</div>
</div>
	
</body>
</html>