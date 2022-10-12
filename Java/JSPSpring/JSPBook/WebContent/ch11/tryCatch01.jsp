<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<%
		try{
			int num = 10 / 0;	
			request.getParameter("name").toString();
		}catch(NumberFormatException e){
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/error/errorNullPointer.jsp");
			
			// tryCatch.jsp 실행을 멈추고, errorNullPointer.jsp를 요청
			dispatcher.forward(request, response);
		}
		out.print("실행");
	%>
</body>
</html>