<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Company</title>
</head>
<body>
	<h2>Bug Untitled Company</h2>
	
	<p>
		Welcome to the bud untitled company
	</p>
	
	<hr>
		User : <security:authentication property="principal.username"/>
		<br><br>
		Role(s) : <security:authentication property="principal.authorities" />
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>
</html>