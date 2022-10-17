<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Session</title>
</head>
<body>
	<%
		String userID = request.getParameter("id");
		String userPW = request.getParameter("passwd");
		
		if(userID.equals("a") && userPW.equals("123")){
			session.setAttribute("userID", userID);
			response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("session.jsp");
		}
	%>
</body>
</html>