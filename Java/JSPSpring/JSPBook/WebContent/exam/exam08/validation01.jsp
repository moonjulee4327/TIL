<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script type="text/javascript">
	function checkLogin() {
		let form = document.loginForm;

		let id = form.id.value;
		let passwd = form.passwd.value;

		if(id == ""){
			alert("아이디를 입력해주세요");
            return false;
		}

		if(passwd == ""){
			alert("비밀번호를 입력해주세요");
            return false;
		}else if(passwd.search(id) > -1){
			alert("비밀번호에 아이디가 포함되어 있습니다.");
            return false;
		}
		
		form.submit();
	}
</script>
</head>
<body>
	<form name="loginForm" action="validation_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"></p>
		<p>비밀번호 : <input type="text" name="passwd"></p>
		<p><input type="button" value="전송" onclick="checkLogin()"></p>
	</form>
</body>
</html>