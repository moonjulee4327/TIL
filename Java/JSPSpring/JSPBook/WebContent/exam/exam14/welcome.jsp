<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("userID")){
				out.println(URLDecoder.decode(cookies[i].getValue(),"UTF-8") + "님 반갑습니다.");
			}else if(cookies[i].getName().equals("")){
				response.sendRedirect("cookie_out.jsp");
			}			
		}
	%>
	<a href="cookie_out.jsp">로그아웃</a>
</body>
</html>