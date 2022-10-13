<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
</head>
<body>
	<jsp:include page="../exam04/menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h2 class="alert alert-danger">요청하신 페이지를 찾을 수 없습니다.</h2>
		</div>
	</div>
	<div class="container">
		<!-- http://localhost/ch06/product.jsp?id=P1234 -->
		<p><%=request.getRequestURL()%>?<%=request.getQueryString()%></p>
		<p><a href="../exam07/products.jsp" class="btn btn-secondary">도서목록&raquo;</a></p>
	</div>
	<jsp:include page="../exam04/footer.jsp"/>
</body>
</html>