<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script type="text/javascript">
	function checkLogin() {
		// form => object
		let form = document.loginForm;

		// 아이디 체크. 4~12자 이내로 입력 가능
		if(form.id.value.length < 4 || form.id.value.length > 12){
			alert("아이디는 4~12자 이내로 입력 가능합니다.");
			form.id.select(); // = focus()
			return false;
		}
		// 비밀번호 체크. 4자 이상으로 입력
		if(form.passwd.value.length < 4){
			alert("비밀번호는 4자 이상으로 입력해주세요");
			form.id.focus();
			return;
		}
		form.submit();
	}
</script>
</head>
<body>
	<form name="loginForm" action="validation03_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"></p>
		<p>비밀번호 : <input type="password" name="passwd"></p>
		<p><input type="button" value="전송" onclick="checkLogin()"></p>
	</form>
</body>
</html>