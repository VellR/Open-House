<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/userItems/${userId}">User Items</a>
	<a href="${pageContext.request.contextPath}/userTrades/${userId}">User Trades</a>
	<a href="${pageContext.request.contextPath}/browesableItems/${userId}">Browse Items</a>
	
</body>
</html>