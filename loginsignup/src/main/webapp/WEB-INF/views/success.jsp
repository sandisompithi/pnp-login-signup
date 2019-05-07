<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pick n Pay Online Shopping | Welcome! Start Filling Your Trolley</title>
</head>
<body>
	<h1>${msg}</h1>
	<div>
		<div align="right">
			<a href="${pageContext.request.contextPath}/customer/logout">LOGOUT</a>	
		</div>
		<div align="left">
			<b>${customer.firstname}</b>
		</div>
		<div align="center">
			<table>
				<tr>
					<td>Firstname:</td>
					<td>${customer.firstname}</td>
				</tr>
				<tr>
					<td>Surname:</td>
					<td>${customer.surname}</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>${customer.email}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>