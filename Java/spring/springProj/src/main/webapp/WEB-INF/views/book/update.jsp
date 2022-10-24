<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<title>책 생성하기</title>
<script type="text/javascript">
// jQuery 시작
$(function() {
	// 취소 버트 클릭 이벤트
	$("#btnCancel").on("click", function() {
 		// location.href = "/detail?bookId=${data.bookId}";
		// http://localhost/update?bookId=2
		// param => bookId=2
		location.href = "/detail?bookId=${param.bookId}";
		// let bookId = ${param.bookId};
		// location.href = "/detail?bookId=" + bookId;
	});
	
	// 목록 버튼 클릭 이벤트
	$("#btnList").on("click", function() {
		location.href = "/list";
	});
});
</script>
</head>
<body>
	<h1>책 수정</h1>
	<!-- BookController에서 넘어온 데이터
		BookVO data = this.bookService.selectDetail(bookVO);
		mav.addObject("data", data);
	 -->
	<!-- http://localhost/create?title=개똥이&category=분류&price=100 -->
	<form action="/update" method="post">
		<input type="hidden" name="bookId" value="${data.bookId}">
		<p>제목 : <input type="text" name="title" value="${data.title}" required="required"/></p>
		<p>카테고리 : <input type="text" name="category" value="${data.category}" required="required"/></p>
		<p>가격 : <input type="text" name="price" value="${data.price}" required="required"/></p>
		<p>
			<input type="submit" value="저장"/>
			<input type="button" id="btnCancel" value="취소">
			<button type="button" id="btnList">목록</button>
		</p>
	</form>
</body>
</html>