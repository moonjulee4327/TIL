<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<title>주문 완료</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<%
	String Shipping_cartId = "";
	String Shipping_name = "";
	String Shipping_shippingDate = "";
	String Shipping_country = "";
	String Shipping_zipCode = "";
	String Shipping_addressName = "";
	
	// request 객체에 있는 모든 쿠키 객체를 받자
	Cookie[] cookies = request.getCookies();
	// 쿠키 개수 만큼 반복
	for(int i=0; i<cookies.length; i++){
		Cookie thisCookie = cookies[i];
		// 쿠키 이름 가져옴
	//		out.println(thisCookie.getName() + "<br/>");
		// 쿠키 값 가져옴
		// URLEncoder.encode(request.getParameter("cartId")
	//		out.println(URLDecoder.decode(thisCookie.getValue()) + "<br/>");
		if(thisCookie.getName().equals("Shipping_cartId")){
			Shipping_cartId = URLDecoder.decode(thisCookie.getValue());
		}
		if(thisCookie.getName().equals("Shipping_name")){
			Shipping_name = URLDecoder.decode(thisCookie.getValue());
		}
		if(thisCookie.getName().equals("Shipping_shippingDate")){
			Shipping_shippingDate = URLDecoder.decode(thisCookie.getValue());
		}
		if(thisCookie.getName().equals("Shipping_country")){
			Shipping_country = URLDecoder.decode(thisCookie.getValue());
		}
		if(thisCookie.getName().equals("Shipping_zipCode")){
			Shipping_zipCode = URLDecoder.decode(thisCookie.getValue());
		}
		if(thisCookie.getName().equals("Shipping_addressName")){
			Shipping_addressName = URLDecoder.decode(thisCookie.getValue());
		}
	}
%>
	<jsp:include page="menu.jsp"/>
	
	<div class="jumbotron">
		<!-- container : 이 안에 내용이 있다. -->
		<div class="container">
			<h1 class="display-3">주문완료</h1>
		</div>
	</div>
	<!-- ------------------- 주문 완료 시작 -------------------- -->
	<div class="container">
		<h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
		<p>주문은  <%=Shipping_shippingDate %></p>
		<p>주문번호 : <%=Shipping_cartId %></p>
	</div>
	<div class="container">
		<p><a href="/products" class="btn btn-secondary">&laquo;상품목록</a></p>
	</div>
	<!-- ------------------- 주문 완료 끝 -------------------- -->
	
	<!-- 끝맺음 -->
	<jsp:include page="footer.jsp"/>
</body>
</html>

<%//스크립틀릿
	session.invalidate();

for(int i=0;i<cookies.length;i++){
	Cookie thisCookie = cookies[i];
	//쿠키 이름 가져옴
// 		out.print(thisCookie.getName() + "<br />");
	//쿠키 값 가져옴
// 		out.print(URLDecoder.decode(thisCookie.getValue(),"UTF-8")+"<br />");
	//유효기간을 0으로 설정 => 쿠키 정보 삭제
	if(thisCookie.getName().equals("Shipping_name")){
		thisCookie.setMaxAge(0);
	}
	if(thisCookie.getName().equals("Shipping_zipCode")){
		thisCookie.setMaxAge(0);
	}
	if(thisCookie.getName().equals("Shipping_country")){
		thisCookie.setMaxAge(0);
	}
	if(thisCookie.getName().equals("Shipping_addressName")){
		thisCookie.setMaxAge(0);
	}
	if(thisCookie.getName().equals("Shipping_addressDetail")){
		thisCookie.setMaxAge(0);
	}
	if(thisCookie.getName().equals("Shipping_shippingDate")){
		thisCookie.setMaxAge(0);
	}
	if(thisCookie.getName().equals("Shipping_cartId")){
		thisCookie.setMaxAge(0);
	}
	
	response.addCookie(thisCookie);
}
%>