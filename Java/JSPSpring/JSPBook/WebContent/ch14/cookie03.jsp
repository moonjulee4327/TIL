<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Cookie</title>
</head>
<body>
	<%
		// 요청 시 마다 쿠키를 함께 보냄. 쿠키는 request 개체에 담겨있음
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies){
			// 모든 쿠키를 삭제
			// 쿠키는 invalidate() 메소드가 없음 => 유효시간을 0으로 설정
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		response.sendRedirect("cookie02.jsp");
	%>
</body>
</html>