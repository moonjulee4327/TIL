<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Filter</title>
</head>
<body>
	<!-- <url-pattern>/ch12/filter02_process.jsp</url-pattern> -->
	<!-- filter02_process.jsp 를 요청하면 InitParamFilter가 작동 -->
	<!-- filter02_process.jsp?id=admin&passwd=1234 -->
	<form action="filter02_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id" /></p>
		<p>비밀번호 : <input type="password" name="passwd" /></p>
		<p><input type="submit" value="전송" /></p>
	</form>
</body>
</html>