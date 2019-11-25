<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>My Items</title>
</head>
<body>

	<div class="container">
            <form:form class="form-horizontal" action="${pageContext.request.contextPath}/addUserItem" method="post" modelAttribute="item" role="form">
            <fieldset>
                <h2>New Item Listing</h2>
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Item Name</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="name" name="name" id="name" placeholder="Item name" class="form-control"/>
                         <p><form:errors path="name" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="price" class="col-sm-3 control-label">Item Price</label>
                    <div class="col-sm-9">
                        <form:input path="price" type="number" name="price" id="price" placeholder="0.00" class="form-control"/>
                         <p><form:errors path="price" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label">Item Description</label>
                    <div class="col-sm-9">
                        <form:input path="description" type="textarea" name="description" id="description" placeholder="item description" class="form-control"/>
                         <p><form:errors path="description" class="error"/></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="expiration" class="col-sm-3 control-label">Item Expiration</label>
                    <div class="col-sm-9">
                        <form:input path="expiration" type="date" name="expiration" id="expiration" class="form-control"/>
                         <p><form:errors path="expiration" class="error"/></p>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Add Item</button>
                </fieldset>
            </form:form>
            <p style="color: red;">${errorMessage}</p>
        </div>

</body>
</html>