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
		}catch(Exception e){
			out.print("<p>오류발생 : " + e.getMessage() + "</p>");
		}
	%>
</body>
</html>