<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${item.name}</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
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

        	<div class="card mt-4">
          		<img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
          		<div class="card-body">
            		<h3 class="card-title">${item.name}</h3>
            		<h4>$${item.price}</h4>
            		<p class="card-text">${item.description}</p>
            		
            		
            		
            <form:form class="form-horizontal" action="${pageContext.request.contextPath}/startTrade/${userId}" method="post" modelAttribute="item" role="form">
            	<fieldset>
                	<form:input type="hidden" path="id" name="id" id="id" value="${item.id}" class="form-control"/>
                	<form:input type="hidden" path="userId" name="userId" id="userId" value="${item.userId}" class="form-control"/>
                	<form:input type="hidden" path="name" name="name" id="name" value="${item.name}" class="form-control"/>
                	<form:input type="hidden" path="description" name="description" id="description" value="${item.description}" class="form-control"/>
                	<form:input type="hidden" path="price" name="price" id="price" value="${item.price}" class="form-control"/>
                	<form:input type="hidden" path="expiration" name="expiration" id="expiration" value="${item.expiration}" class="form-control"/>
                	
                	<button type="submit" class="btn btn-success">Start Trade</button>
            	</fieldset>
            </form:form>
          		</div>
        	</div>
        <!-- /.card -->

        <div class="card card-outline-secondary my-4">
        	<div class="card-header">
            	Messages
          	</div>
          	<div class="card-body">
            	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
            	<small class="text-muted">Posted by Anonymous on 3/1/17</small>
            	<hr>
            	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
            	<small class="text-muted">Posted by Anonymous on 3/1/17</small>
            	<hr>
            	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
            	<small class="text-muted">Posted by Anonymous on 3/1/17</small>
            	<hr>
            	<a href="#" class="btn btn-success">Reply</a>
          	</div>
        </div>
        <!-- /.card -->

      </div>
		
	</div>
	
	
	
</body>
</html>