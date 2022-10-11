<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<!-- 머리글에 해당하는 menu.jsp파일의 내용을 포함하도록 include 액션태그 작성 -->
	<jsp:include page="../exam04/menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
	<div class="container" >
		<form name="loginForm" action="j_security_check" method="post" >
			<h3 style="text-align: center;">Please sign in</h3>
			<div class="form-group row" style="margin:auto;">
				<div class="col-sm-3" style="margin:auto;">
					<input type="text" name="j_username" class="form-control" placeholder="ID">
					<input type="password" name="j_password" class="form-control" placeholder="Password">
					<input type="submit" class="btn btn btn-1g btn-success btn-block" value="전송">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="../exam04/footer.jsp"/>
</body>
</html>