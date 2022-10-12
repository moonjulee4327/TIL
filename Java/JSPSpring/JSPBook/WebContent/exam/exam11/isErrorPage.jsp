<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<h1>오류발생</h1>
	<table border="1px">
		<tr>
			<td><b>Error:</b></td>
			<td><%=exception.toString() %>: 오류발생</td>
		</tr>
		<tr>
			<td><b>URI:</b></td>
			<td><%=request.getRequestURI() %></td>
		</tr>
		<tr>
			<td><b>Status code:</b></td>
			<td><%=response.getStatus()%></td>
		</tr>
	</table>
</body>
</html>