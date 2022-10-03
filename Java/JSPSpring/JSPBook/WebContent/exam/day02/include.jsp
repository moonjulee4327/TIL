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

<!-- 
<%@ include page="./header.jsp" %> 정적인 방식

<jsp:include page="./header.jsp"> 동적인 방식 : 잘 쓰이지 않는다.
	<jsp:param value="a001" name="id"/>
</jsp:include>
-->
</body>
</html>