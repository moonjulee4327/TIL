<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<title>주문완료</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<%
	String cartId = "";
	String name = "";
	String shippingDate = "";
	String country = "";
	String zipCode = "";
	String addressName = "";

	Cookie[] cookies = request.getCookies();

	for(int i=0; i<cookies.length; i++){
		if(cookies[i].getName().equals("Shipping_cartId")){
			cartId = URLDecoder.decode(cookies[i].getValue());
		}
		if(cookies[i].getName().equals("Shipping_name")){
			name = URLDecoder.decode(cookies[i].getValue());
		}
		if(cookies[i].getName().equals("Shipping_shippingDate")){
			shippingDate = URLDecoder.decode(cookies[i].getValue());
		}
		if(cookies[i].getName().equals("Shipping_country")){
			country = URLDecoder.decode(cookies[i].getValue());
		}
		if(cookies[i].getName().equals("Shipping_zipCode")){
			zipCode = URLDecoder.decode(cookies[i].getValue());
		}
		if(cookies[i].getName().equals("Shipping_addressName")){
			addressName = URLDecoder.decode(cookies[i].getValue());
		}
	}
%>
	<jsp:include page="../exam04/menu.jsp"/>
	<div class="jumbotron">
		<!-- container : 이 안에 내용이 있다. -->
		<div class="container">
			<h1 class="display-3">주문완료</h1>
		</div>
	</div>
	<!-- ------------------- 주문 완료 시작 -------------------- -->
	<div class="container">
		<h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
		<p>주문은 <%=shippingDate %></p>
		<p>주문번호 : <%=cartId %></p>
	</div>
	<div class="container">
		<p><a href="books.jsp" class="btn btn-secondary">&laquo;상품목록</a></p>
	</div>
	<!-- ------------------- 주문 완료 끝 -------------------- -->
	<jsp:include page="../exam04/footer.jsp"/>
</body>
</html>