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
		<div class="container">
            <form:form class="form-horizontal" action="${pageContext.request.contextPath}/addRequest/${userId}" method="post" modelAttribute="request" role="form">
            <fieldset>
                <h2>New Request</h2>
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Item Name</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="name" name="name" id="name" placeholder="Item name" class="form-control"/>
                         <p style="color: red;"><form:errors path="name" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label">Item Description</label>
                    <div class="col-sm-9">
                        <form:input path="description" type="textarea" name="description" id="description" placeholder="Item description..." class="form-control"/>
                         <p style="color: red;"><form:errors path="description" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="price" class="col-sm-3 control-label">Item Price</label>
                    <div class="col-sm-9">
                        <form:input path="price" type="text" name="price" id="price" placeholder="0.00" class="form-control"/>
                         <p style="color: red;"><form:errors path="price" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="barter" class="col-sm-3 control-label">Would you like to barter?</label>
                    <div class="col-sm-9">
                       Yes <form:radiobutton path="barter" id="yes" value="true" class="form-control"/>
                       No  <form:radiobutton path="barter" id="no" value="false" class="form-control"/>
                        <p style="color: red;"><form:errors path="barter" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="barterItem" class="col-sm-3 control-label">Preferred Barter Item:</label>
                    <div class="col-sm-9">
                        <form:input path="barterItem" type="text" name="barterItem" id="barterItem" placeholder="Item Name" class="form-control"/>
                         <p style="color: red;"><form:errors path="barterItem" class="error"/></p>
                    </div>
                </div>
                <button id="make-request-button" type="submit" class="btn btn-primary btn-block">Make Request</button>
                </fieldset>
            </form:form>
            <p style="color: red;">${errorMessage}</p>
        </div>
        
        
        <c:forEach items = "${requestList}" var = "request">
	    <tr>
			<td id="request-link-${request.name}"><a href="${pageContext.request.contextPath}/userRequest/${userId}/${request.id}">
                    ${request.name}</a></td>
			<td>${request.description}</td>
			<td>$${request.price}</td>
			<td>${request.barter}</td>
			<td>${request.barterItem}</td>
			<td id="request-remove-link-${request.name}"><a href="${pageContext.request.contextPath}/removeRequest/${request.id}/${userId}">remove</a></td><br>
	    </tr>
	</c:forEach>
	</div>
</div>
	
</body>
</html>