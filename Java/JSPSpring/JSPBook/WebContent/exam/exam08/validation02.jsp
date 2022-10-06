<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script type="text/javascript">
	function checkLogin() {
		let form = document.loginForm;
		let s = form.passwd.value;
 		console.log(s);
 		if(/(\w)\1\1/.test(s)){
			alert("영문, 숫자는 3자이상 연속 입력할 수 없습니다."); 
 			return false;
 		}
 		
		for(var i in s) {
	        if (+s[+i+1] == +s[i]+1 && 
	            +s[+i+2] == +s[i]+2){
	        	alert("영문, 숫자는 3자이상 연속 입력할 수 없습니다."); 
	        	return false;	        	
	        }
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