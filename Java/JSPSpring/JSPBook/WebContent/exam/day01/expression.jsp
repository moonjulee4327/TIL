<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%!
		Calendar cal = Calendar.getInstance();
	%>
	
	Current Time : <%= cal.getTime()%>
</body>
</html>