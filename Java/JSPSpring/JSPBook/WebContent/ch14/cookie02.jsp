<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Cookie</title>
</head>
<body>
	<%
// 		Cookie cookie_id = new Cookie("userID", user_id);
// 		Cookie cookie_pw = new Cookie("userPW", user_pw);
		// 모든 쿠키 정보를 가져와보자. 요청 시 쿠키도 함께 전달 됨
		Cookie[] cookies = request.getCookies();
		
		out.println("현재 설정된 쿠키의 개수 : " + cookies.length);
		
// 		for(Cookie cookie : cookies){
// 			out.println("<br/>" + cookie.getName() + "<br/>");
// 			out.println(cookie.getValue() + "<br/>");
// 		}
		for(int i=0; i< cookies.length; i++){
			out.println("쿠키[" + i + "] : " + cookies[i] + "<br/>");
			out.println("설정된 쿠키 속성 이름[" + i + "] : " + cookies[i].getName() + "<br/>");
			out.println("설정된 쿠키 속성 값[" + i + "] : " + cookies[i].getValue() + "<br/>");
			out.println("<hr/>");			
		}
		
		out.println("세션 id : " + session.getId() + "<br/>");
	%>
	<a href="cookie03.jsp">쿠키 모두 제거</a>
</body>
</html>