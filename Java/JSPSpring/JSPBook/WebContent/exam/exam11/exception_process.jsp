<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="exception_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getParameter("id").equals("")){
// 			request.getParameter("id").toUpperCase();
			throw new ServletException();
		}else {
			out.print("<p>" + request.getParameter("id") + "</p>");
		}
	%>
</body>
</html>