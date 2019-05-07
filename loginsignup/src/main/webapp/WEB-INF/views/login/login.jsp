<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>Welcome to Pick n Pay Online</h1>
		
		<table>
			<s:form commandName="customerData"
				action="${pageContext.request.contextPath}/customer/login" method="post">
				
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
					<td>
						<a href="${pageContext.request.contextPath}/customer/register">SIGN UP</a>
					</td>
					<td><input type="submit" value="LOG IN" /></td>
				</tr>
				
			</s:form>
			<tr>
				<td><a href="${pageContext.request.contextPath}/">Home</a></td>
			</tr>
		</table>
	</div>
	<div></div>
	<div>
		<p style="color:red;">${failed}</p>
	</div>
</body>
</html>