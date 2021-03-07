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
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders" >LeaderShip Meeting</a>
			(only for Manager Peeps)
		</p>
	</security:authorize>
	<!-- add a link to point to systems  this is for the admins -->
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems" >IT Meeting</a>
			(only for Admin Peeps)
		</p>
	</security:authorize>
	
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>
</html>