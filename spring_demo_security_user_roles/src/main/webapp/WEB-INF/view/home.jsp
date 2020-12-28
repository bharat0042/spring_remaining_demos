<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HomePage</title>
</head>
<body>
	Welcome to home page - Just some changes!!
	
	<hr>
		<p> 
			User : <security:authentication property="principal.username"/><br>
			Role(s) : <security:authentication property="principal.authorities"/>
		</p>
	<hr>
		<security:authorize access = "hasRole('MANAGER')">
			<a href = "${pageContext.request.contextPath}/leaders">Leadership Page(Only for Leaders)</a>
			<hr>
		</security:authorize>	
	
		<security:authorize access = "hasRole('ADMIN')">
			<a href = "${pageContext.request.contextPath}/admins">Admin Page(Only for Admins)</a>
			<hr>
		</security:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>