<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script type="text/javascript">
	function checkLogin() {
		let form = document.loginForm;
		let passwd = form.passwd.value;
		let regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
		
		if(!regExp.test(passwd)){
			alert("영문+숫자+특수기호 8자리 이상으로 구성하여야 합니다.");
			return false;
		}
 		
	}
</script>
</head>
<body>
	<form name="loginForm" method="post">
		<p>아이디 : <input type="text" name="id"></p>
		<p>비밀번호 : <input type="text" name="passwd"></p>
		<p>비밀번호 확인 : <input type="text" name="passwdC"></p>
		<p><input type="button" value="전송" onclick="checkLogin()"></p>
	</form>
</body>
</html>