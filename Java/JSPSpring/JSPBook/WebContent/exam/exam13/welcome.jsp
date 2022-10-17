<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		String userID = (String)session.getAttribute("userID");
		if(userID == null){
			response.sendRedirect("session_out.jsp");
		}
	%>
	<p><%=userID %>님 반갑습니다.</p>
	<a href="session_out.jsp">로그아웃</a>
</body>
</html>