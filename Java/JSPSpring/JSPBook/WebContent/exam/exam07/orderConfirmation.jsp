<%@page import="java.math.BigDecimal"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="exam04.vo.BookVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.net.URLDecoder"%>
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
<!DOCTYPE html>
<html>
<head>
<title>주문정보</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="../exam04/menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문 정보</h1>
		</div>
	</div>
	<!-- ------------------- 주문 정보 시작 -------------------- -->
	<div class="container col-8 alert alert-info">
		<div class="text-center">
			<h1>영수증</h1>
		</div>
		<!-- 고객 정보 시작 : cookie 사용 -->
		<div class="col justify-content-between">
			<strong>배송 주소</strong><em class="em float-right">배송일 : <%=shippingDate %></em><br/>
			성명 : <%=name %><br/> 
			우편번호 : <%=zipCode %><br/> 
			주소 : <%=addressName %><br/> 
			나라 : <%=country %><br/> 
		</div>
<!-- 		<div class="row-1" align="right"> -->
<!-- 			<p> -->
<!-- 				<em>배송일 : </em> -->
<!-- 			</p> -->
<!-- 		</div> -->
		<!-- 고객 정보 끝 -->
		<!-- 상품 정보 시작 : session 사용 -->
		<div>
			<table class="table table-hover">
				<tr>
				 	<th class="text-center">도서</th>
				 	<th class="text-center">#</th>
				 	<th class="text-center">가격</th>
				 	<th class="text-center">소계</th>
				</tr>
				<% 	
					double sum = 0;
				
					ArrayList<BookVO> cartlist = (ArrayList<BookVO>)session.getAttribute("cartlist");	
				
					for(int i=0; i< cartlist.size(); i++){
						BookVO book = cartlist.get(i);
						double total = book.getQuantity() * book.getUnitPrice();
						BigDecimal totalBig = new BigDecimal(total);
						
						sum += total;
				%>
				<tr>
				 	<td class="text-center"><em><%=book.getName() %></em></td>
				 	<td class="text-center"><%=book.getQuantity() %></td>
				 	<td class="text-center">
				 		<fmt:formatNumber value="<%=book.getUnitPrice() %>" pattern="#,###"/>
				 	</td>
				 	<td class="text-center">
				 		<fmt:formatNumber value="<%=totalBig %>" pattern="#,###"/> 원
				 	</td>
				</tr>
				<%
					}
					
					BigDecimal bdm = new BigDecimal(sum);
				%>
				<tr>
				 	<td></td>
				 	<td></td>
				 	<td class="text-center"><strong>총액:</strong></td>
				 	<td class="text-center text-danger"><strong>
				 		<fmt:formatNumber value="<%=bdm %>" pattern="#,###"/>
				 	</strong></td>
				</tr>
			</table>
			<a href="shippingInfo.jsp?cartId=<%=cartId %>" class="btn btn-secondary" role="button">이전</a>
			<a href="thankCustomer.jsp" class="btn btn-success" role="button">주문 완료</a>
			<a href="checkOutCancelled.jsp" class="btn btn-secondary" role="button">취소</a>
		</div>
		<!-- 상품 정보 끝 : session 사용 -->
	</div>
	
	<!-- ------------------- 주문 정보 끝 -------------------- -->
	<jsp:include page="../exam04/footer.jsp"/>
</body>
</html>