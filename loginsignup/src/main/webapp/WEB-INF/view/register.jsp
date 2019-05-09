<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h3 align="center">${headerMessage}</h3>
	<form:form action="/loginsignup/registerSuccess"
		method="post" modelAttribute="customer">
		<table align="center">
		<caption align="top">Customer registration form</caption>
		
			<tr>
				<td>Firstname:</td>
				<td><form:input path="firstname"/></td>
				<td><form:errors path="firstname" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>Surname:</td>
				<td><form:input path="surname"/></td>
				<td><form:errors path="surname" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>Enter Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>

			<tr>
				<td><input type="submit" value="SIGN UP"></td>
			</tr>
		</table>

	</form:form>

</body>
</html>