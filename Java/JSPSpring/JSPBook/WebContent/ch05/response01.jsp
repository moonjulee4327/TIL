<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Objects</title>
</head>
<body>
	<!-- 
		아이디와 비밀번호가 일치하면 성공페이지 아니면 로그인 페이지
	 -->
	
	<form action="response01_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"/></p>
		<p>비밀번호 : <input type="text" name="passwd"/></p>
		<!-- button type => button(클릭 이벤트) / submit(전송) -->
		<p><button type="submit">전송</button></p>
	</form>
</body>
</html>