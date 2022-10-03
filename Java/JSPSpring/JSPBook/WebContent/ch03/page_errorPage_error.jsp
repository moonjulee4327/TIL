<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page isErrorPage="true" %>
<!-- 위에 페이지 디렉티브 태그가 true로 되어 있어야 exception 객체를 사용가능 -->
<!DOCTYPE html>
<html>
<head>
<title>Directives Tag</title>
</head>
<body>
	<h4>errorPage 디렉티브 태그</h4>
	에러가 발생했습니다.
	<%=exception%>
</body>
</html>