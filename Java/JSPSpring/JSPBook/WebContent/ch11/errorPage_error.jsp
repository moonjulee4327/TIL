<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!-- 
	page 디렉티브위 isErrorPage 속성의 값은 기본적으로 false 
	true로 바꾸면 에러 전용 페이지라고 하는 것이다.
-->
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<p>오류가 발생했습니다.</p>
	<p>예외 유형 : <%=exception.toString() %> </p>
	<p>예외 유형 : <%=exception.getClass().getName() %> </p>
	<!-- getMessage() : 오류 이벤트와 함께 들어오는 메시지를 출력 -->
	<p>오류 메시지 : <%=exception.getMessage() %></p>
	<!-- 오류 메시지의 발생 근원지를 찾아 단계별로 오류 출력 => 오류가 발생함 -->
<%-- 	<p><%=exception.printStackTrace() %></p> --%>
	<p><%=exception %></p>
</body>
</html>