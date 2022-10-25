<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="kr.or.ddit.vo.ProductVO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<!--	scope : 영역
		page(동일 jsp)(기본), request(동일 요청), session(동일 웹브라우저), application(모든 웹브라우저) 

 -->
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>상품 상세 정보</title>
<script type="text/javascript">
	// 핸들러 함수(상품 주문 버튼 클릭 시 실행)
	function addToCart() {
		console.log("왔다.");
		let result = confirm("상품을 장바구니에 추가하시겠습니까?");
		if(result){ // true
			console.log("true");
			// addCart.jsp?id=P1235
			document.addForm.submit();
		}else{ // false
			console.log("false");
			// 초기화
			document.addForm.reset();
		}
	}
</script>
</head>
<body>
<!-- 머리글에 해당하는 menu.jsp파일의 내용을 포함하도록 include 액션태그 작성 -->
	<jsp:include page="menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3"><spring:message code="productDetail"/></h1>
		</div>
	</div>
<!-- ========================= 상품 상세 시작 =================================== -->
	<div class="container"> 
		<div class="text-right">
			<!-- ?id=${product.productId}&language=ko 이 param이다. -->
			<a href="?productId=${productId}&language=ko">Korea</a> | <a href="?productId=${productId}&language=en">English</a>
		</div>
		<div class="row" align="center">
			<div class="col-md-5">
				<img src="/resources/images/${data.filename}" alt="${data.pname}" title="${data.pname}" style="width:100%; height: 400px"/>
			</div>	
			<div class="col-md-6">
				<h3>${data.pname}</h3>
				<p>${data.description}</p>
				<p><b><spring:message code="productId"/> : </b><span class="badge badge-danger">${data.productId}</span></p>
				<p><b><spring:message code="manufacturer"/></b> : ${data.manufacturer}</p>
				<p><b><spring:message code="category"/></b> : ${data.category}</p>
				<p><b><spring:message code="unitInStock"/></b> : ${data.unitInStock}</p>
				<h4>${data.unitPrice}<spring:message code="won"/></h4>
				<form name="addForm" action="/addCart?productId=${data.productId}" method="post">
					<!-- 상품 주문 -> 상품을 장바구니에 넣음 -->
					<a href="#" class="btn btn-info" onclick="addToCart()"><spring:message code="productOrder"/>&raquo;</a>
					<!-- 장바구니에 넣어진 상품 목록을 봄 -->
					<a href="/cart" class="btn btn-warning"><spring:message code="cart"/>&raquo;</a>
					<!-- 등록된 상품 목록을 봄 -->
					<a href="/products" class="btn btn-secondary"><spring:message code="productList"/>&raquo;</a>
				</form>
				<form action="/delete" method="post">
					<!-- 상품 수정 하기 -->
					<a href="/update?productId=${data.productId}" class="btn btn-info"><spring:message code="update"/>&raquo;</a>
					<!-- 상품 삭제 하기 -->
					<input type="hidden" name="productId" value="${data.productId}">
					<input type="submit" class="btn btn-danger" value="<spring:message code="delete"/>&raquo;">
				</form>	
			</div>
		</div>
	</div>
	<!-- ========================= 상품 상세 끝 ================================= -->
	<jsp:include page="footer.jsp"/>
</body>
</html>