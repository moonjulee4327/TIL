<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@page import="exam04.dao.BookRepository"%>
<%@page import="exam04.vo.BookVO"%>
<%@ page errorPage="/exam/exam11/exceptionNoBookId.jsp"%>

<!DOCTYPE html>
<%
	String bookId = request.getParameter("id");
	BookRepository brp = BookRepository.getInstance();
	BookVO bookVO = brp.getBookById(bookId);
	
	if(bookId.equals("")){
		throw new Exception();
	}else if(!bookVO.getBookId().equals(bookId)){
		throw new Exception();
	}
	
%>

<c:set var="bookVO" value="<%=bookVO %>" scope="page" />
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>상품 상세 정보</title>
<script type="text/javascript">
	function addToCart() {
		let result = confirm("해당 도서를 장바구니에 추가하시겠습니까?");
		
		if(result){
			document.addForm.submit();
		}else{
			document.addForm.reset();
		}
	}
</script>
</head>
<body>
<!-- 머리글에 해당하는 menu.jsp파일의 내용을 포함하도록 include 액션태그 작성 -->
	<jsp:include page="../exam04/menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 상세 정보</h1>
		</div>
	</div>
	
	<div class="container"> 
		<div class="row" >
			<div class="col">
				<h1>[${bookVO.category}] ${bookVO.name}</h1>
				<p>${bookVO.description}</p>
				<p><b>도서 코드 : </b><span class="badge badge-danger">${bookVO.bookId}</span></p>
				<p><b>출판사</b> : ${bookVO.publisher}</p>
				<p><b>저자</b> : ${bookVO.author}</p>
				<p><b>재고 수</b> : ${bookVO.unitsInStock}</p>
				<p><b>총 페이지 수</b> : ${bookVO.totalPages}</p>
				<p><b>출판일</b> : ${bookVO.releaseDate}</p>
				<p><b>저자</b> : ${bookVO.author}</p>
				<h4>${bookVO.unitPrice}원</h4>
				<p>
				<form name="addForm" action="addCart.jsp?id=${bookVO.bookId}" method="post">
					<a href="#" class="btn btn-info" onclick="addToCart()">상품주문&raquo;</a>
					<a href="cart.jsp" class="btn btn-warning">장바구니&raquo;</a>
					<a href="books.jsp" class="btn btn-secondary">도서목록&raquo;</a>
				</form>
				</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="../exam04/footer.jsp"/>
</body>
</html>