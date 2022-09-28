<%@page import="exam04.dao.BookRepository"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="exam04.vo.BookVO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<%
	BookRepository bookRepo = new BookRepository();
	List<BookVO> listOfBooks = bookRepo.getAllBooks();
	
%>
<c:set var="listOfBooks" value="<%=listOfBooks %>" scope="page"/>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>상품 목룍</title>
</head>
<body>
<!-- 머리글에 해당하는 menu.jsp파일의 내용을 포함하도록 include 액션태그 작성 -->
	<jsp:include page="menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>
	<div class="container"> 
		<div class="col" align="left">
			<c:forEach var="bookVO" items="${listOfBooks}">
				<div class="row-md-4">
					<h3>[${bookVO.category}] ${bookVO.name}</h3>
					<br>
					<p>${bookVO.description}</p>
					<p>${bookVO.author} | ${bookVO.publisher} | ${bookVO.unitPrice}원</p>
					<br>
				</div>
				<br>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>