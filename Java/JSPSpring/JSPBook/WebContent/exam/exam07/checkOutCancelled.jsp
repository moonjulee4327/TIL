<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>주문 취소</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="../exam04/menu.jsp"/>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문 취소</h1>
		</div>
	</div>
	<%
		session.invalidate();
	%>
	
	<div class="container">
		<h2 class="alert alert-danger">주문이 취소되었습니다.</h2>
	</div>
	<div class="container">
		<p><a href="books.jsp" class="btn btn-secondary">&laquo;상품목록</a></p>
	</div>
	<jsp:include page="../exam04/footer.jsp"/>
</body>
</html>