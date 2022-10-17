<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Session</title>
</head>
<body>
	<% // 스크립틀릿
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("passwd");
		
		if(user_id.equals("admin") && user_pw.equals("1234")){
			// session 기본 객체의 userID라는 name속성의 값으로 user_id변수에
			// 들어있는 admin이 setting이 됨
			// 세션을 두개 넣어줘도 세션 객체는 하나이다.
			session.setAttribute("userID", user_id); //{"userID":"admin"}
			session.setAttribute("userPW", user_pw); //{"userPW":"1234"}
			out.println("세션 설정 성공");
			out.println(user_id + "님 환영합니다.");
			out.println("<a href='session02.jsp'>세션확인</a>");			
		}else{
			out.println("세션 설정 실패");
		}
	%>
<c:set var="id" value="<%= user_id %>" scope="application" />
</body>
</html>