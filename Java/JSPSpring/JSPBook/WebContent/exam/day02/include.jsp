<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%!
	Calendar cal = Calendar.getInstance();
%>
현재시간 : <%= cal.getTime() %>
</body>
</html>