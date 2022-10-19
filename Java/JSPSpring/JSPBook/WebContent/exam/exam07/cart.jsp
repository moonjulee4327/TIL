<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="exam04.vo.BookVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
	<%
		String cartId = session.getId();	
	%>
	<jsp:include page="../exam04/menu.jsp"/>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">장바구니</h1>
		</div>
	</div>
	
	<!-- 장바구니 상세내용 시작 -->
	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left">
						<a href="deleteCart.jsp?cartId=<%=cartId%>" class="btn btn-danger">삭제하기</a>
					</td>
					<td align="right">
						<a href="shippingInfo.jsp?cartId=<%=cartId%>" class="btn btn-success">주문하기</a>
					</td>
				</tr>
			</table>
		</div>
	
	<!-- 장바구니 출력 시작 -->
		<div style="padding-top: 50px;">
			<table class="table table-hover">
				<tr>
					<th>상품</th><th>가격</th><th>수량</th>
					<th>금액</th><th>비고</th>
				</tr>
				<%
					ArrayList<BookVO> cartlist = (ArrayList<BookVO>)session.getAttribute("cartlist");
				
					double sum = 0;	
				
					if(cartlist == null){
				%>
				<tr>
					<td colspan="5" style="text-align: center;">장바구니에 상품이 없습니다.</td>
				</tr>
				<%
					}else{
						
						for(BookVO vo : cartlist){
							double total = vo.getUnitPrice() * vo.getQuantity();
							BigDecimal totalBig = new BigDecimal(total);
							sum = sum + total;
				%>
							<tr>
								<td><%=vo.getBookId() %> - <%=vo.getName() %></td>
								<td><fmt:formatNumber value="<%=vo.getUnitPrice() %>" pattern="#,###"/></td>
								<td><fmt:formatNumber value="<%=vo.getQuantity() %>" pattern="#,###"/></td>
								<td><fmt:formatNumber value="<%=totalBig %>" pattern="#,###"/></td>
								<td>
									<a href="removeCart.jsp?id=<%=vo.getBookId()%>" class="badge badge-danger">삭제</a>
								</td>
							</tr>
				<%
						} // end for
						BigDecimal big = new BigDecimal(sum);
				%>
					<tr>
						<th></th>
						<th></th>
						<th>총액</th>
						<th><fmt:formatNumber value="<%=big %>" pattern="#,###"/></th>
						<th></th>
					</tr>
						
				<%		
					} // end if
				%>
				
			</table>
			<a href="books.jsp" class="btn btn-secondary">&laquo;쇼핑 계속하기</a>
		</div>
	</div>
	<!-- 장바구니 출력 끝 -->
	<!-- 장바구니 상세내용 끝 -->
	<jsp:include page="../exam04/footer.jsp"/>
</body>
</html>