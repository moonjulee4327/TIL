<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		response.setIntHeader("Refresh", 5);
		Calendar cal = Calendar.getInstance();
		
		int ampm = cal.get(Calendar.AM_PM);
		String strAmpm = (ampm == Calendar.AM) ? "AM" : "PM";
	%>
	<p>현재 시간은 <%=Calendar.HOUR_OF_DAY %>:<%=Calendar.MINUTE %>:<%=Calendar.SECOND %> <%=strAmpm %></p>
	<a href="response_data.jsp">Google 홈페이지로 이동하기</a>
</body>
</html>