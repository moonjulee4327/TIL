<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="ch04.vo.ProductVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="ch04.dao.ProductRepository"%>
<!DOCTYPE html>
<% // 스크립틀릿 태그
	// http://localhost/ch05/product.jsp?id=P1234
	String id = request.getParameter("id");

	ProductRepository productRepository = ProductRepository.getInstance();
	// 상세보기 => 1행(ProductVO)을 리턴
	// SELECT * FROM PRODUCT WHERE PRODUCT_ID = 'P1234'
	ProductVO productVO = productRepository.getProductById(id);
%>
<!--	scope : 영역
		page(동일 jsp)(기본), request(동일 요청), session(동일 웹브라우저), application(모든 웹브라우저) 

 -->
<c:set var="productVO" value="<%=productVO %>" scope="page" />
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>상품 상세 정보</title>
</head>
<body>
<!-- 머리글에 해당하는 menu.jsp파일의 내용을 포함하도록 include 액션태그 작성 -->
	<jsp:include page="../ch04/menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 상세 정보</h1>
		</div>
	</div>
<!-- ========================= 상품 상세 시작 =================================== -->
	<div class="container"> 
		<div class="row" align="center">
			<div class="col-md-6">
				<h3>${productVO.pname}</h3>
				<p>${productVO.description}</p>
				<p><b>상품 코드 : </b><span class="badge badge-danger">${productVO.productId}</span></p>
				<p><b>제조사</b> : ${productVO.manufacturer}</p>
				<p><b>분류</b> : ${productVO.category}</p>
				<p><b>재고 수</b> : ${productVO.unitInStock}</p>
				<h4>${productVO.unitPrice}원</h4>
				<p>
					<a href="#" class="btn btn-info">상품주문&raquo;</a>
					<a href="../ch04/products.jsp" class="btn btn-secondary">상품목록&raquo;</a>
				</p>
			</div>
		</div>
	</div>
	<!-- ========================= 상품 상세 끝 ================================= -->
	<jsp:include page="../ch04/footer.jsp"/>
</body>
</html>