<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Form</title>

<style type="text/css">
	.error{
		color:red
	}
</style>

</head>
<body>
	<h2>Customer (Form)Validation - Example</h2>
	
	<form:form modelAttribute="customer" action="processForm">
		First Name: <form:input type="text" path="firstName"/>
		
		<br><br>
		
		Last Name(<span style="color:red">*</span>): <form:input type="text" path="lastName"/>
		<form:errors path="lastName" cssClass="error" />
		
		<br><br>
			Free Passes(<span style="color:red">*</span>): <form:input type="text" path="freePasses"/>
		<form:errors path="freePasses" cssClass="error" />
		<br><br>
		 
			Postal Code(<span style="color:red">*</span>): <form:input type="text" path="postalCode"/>
		<form:errors path="postalCode" cssClass="error" />
		<br><br>
		
		
		
		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>