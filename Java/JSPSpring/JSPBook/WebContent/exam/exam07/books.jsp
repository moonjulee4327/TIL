<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@page import="exam04.dao.BookRepository"%>
<%@page import="exam04.vo.BookVO"%>
<!DOCTYPE html>
<%
	BookRepository bookRepo = BookRepository.getInstance();
	List<BookVO> listOfBooks = bookRepo.getAllBooks();

%>
<c:set var="listOfBooks" value="<%=listOfBooks %>" scope="page"/>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>상품 목록</title>
</head>
<body>
<!-- 머리글에 해당하는 menu.jsp파일의 내용을 포함하도록 include 액션태그 작성 -->
	<jsp:include page="../exam04/menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>
	<div class="container"> 
		<div class="row" style="justify-content: legt;margin:0 0 30px 0;"> 
			<a href="addBook.jsp" class="btn btn-primary">상품추가</a>
		</div>
		<div class="row" align="left">
			<c:forEach var="bookVO" items="${listOfBooks}">
				<div class="col-11">
					<img alt="${bookVO.name}" title="${bookVO.name}" src="/resources/examImages/${bookVO.filename}" style="width: 10%; width: 10%">
					<h3>[${bookVO.category}] ${bookVO.name}</h3>
					<br>
					<p>${bookVO.description}</p>
					<p>${bookVO.author} | ${bookVO.publisher} | ${bookVO.unitPrice}원</p>
					<hr>
				</div>
				<div class="col-1">
					<p><a href="product.jsp?id=${bookVO.bookId}" class="btn btn-secondary" role="button">상세 정보&raquo;</a></p>
				</div>
				<br>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="../exam04/footer.jsp"/>
</body>
</html>