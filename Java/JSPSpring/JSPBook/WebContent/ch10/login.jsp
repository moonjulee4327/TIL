<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Security</title>
</head>
<body>
	<!-- j_security_check 목적지가 이미 있음. 폼 기반 인증(인증) 처리 action 속성 값 
		로그인 인증
		권한 인가
		----------------------
		j_username 과 j_password 는 정해져 있는대로 사용하는 것임
		
	-->
	<form name="loginForm" action="j_security_check" method="post">
		<p>ID : <input type="text" name="j_username"></p>
		<p>비밀번호 : <input type="password" name="j_password"></p>
		<p><input type="submit" value="로그인"></p>
	</form>
</body>
</html>