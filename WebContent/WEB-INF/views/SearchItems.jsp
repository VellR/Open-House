<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Browse Items</title>
</head>
<body>
	
	<c:forEach items = "${avaiableItems}" var = "item">
	    <tr>
		<td><a href="#">${item.itemId}</a></td>
        <td>${item.name}</td>
		<td>${item.price}</td>
		<td>${item.expiration}</td>
		<td>${item.description}</td><br>
	    </tr>
	</c:forEach>

</body>
</html>