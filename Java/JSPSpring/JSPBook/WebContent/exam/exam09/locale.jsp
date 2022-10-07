<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>현재 로케일</h1>
	<%
		Locale locale = request.getLocale();
	%>
	<p>언어 : <%=locale.getLanguage() %></p>
	<p>국가 : <%=locale.getCountry() %></p>
</body>
</html>