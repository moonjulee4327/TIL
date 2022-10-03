<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		Date day = new Date();
		out.println("Today : " + day);
	%>
</body>
</html>