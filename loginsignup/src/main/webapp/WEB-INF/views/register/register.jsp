<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pick n Pay</title>
</head>
<body>
	<div align="center">
		<h1>Register for Pick n Pay Online</h1>
		
		<table>
			<s:form commandName="customerData"
				action="${pageContext.request.contextPath}/customer/register" method="post">
				
				<tr>
					<td>Firstname</td>
					<td><s:input path="firstname"/></td>
					<td><s:errors path="firstname" cssStyle="color:red;"/></td>
				</tr>
				
				<tr>
					<td>Surname</td>
					<td><s:input path="surname"/></td>
					<td><s:errors path="surname" cssStyle="color:red;"/></td>
				</tr>
				
				<tr>
					<td>Email</td>
					<td><s:input path="email"/></td>
					<td><s:errors path="email" cssStyle="color:red;"/></td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><s:input path="password"/></td>
					<td><s:errors path="password" cssStyle="color:red;"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="ACCEPT AND REGISTER" /></td>
				</tr>
				
			</s:form>
		</table>
	</div>
</body>
</html>