<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL의 Core 태그를 사용하기 위해 taglib 태그 작성 -->
<!DOCTYPE html>
<html>
<head>
<title>Directives Tag</title>
</head>
<body>
	<% 
	
		// String str = "개똥이";	
		// 밑에와 같음
	%>
	<c:set var="str" value="개똥이" />
	<c:out value="${str}" /> <br>
	<%
		// List : 인터페이스(껍데기)
		// ArrayList : 클래스(껍데기를 채움, 구현)
		List list = new ArrayList();
		list.add("개똥이");
		list.add("김철수");
		list.add("메뚜기");
	%>
	<!-- item에는 Collection -->
	<c:forEach var="item" items="<%=list %>">
		<c:out value="${item}"/> <br>
	</c:forEach>
	<hr />
	
	<!-- 변수 k 가 1부터 10까지 1씩 증가하도록 JSTL의 Core 태그 반복문 작성 -->
	<c:forEach var="k" begin="1" end="10" step="1">
		<c:out value="${k}"/>
	</c:forEach>
	<hr />
	
	<!-- 변수 k 가 1부터 10까지 1씩 증가하도록 JSTL의 Core 태그 반복문 작성 단, 짝수일 경우만-->
	<c:forEach var="k" begin="1" end="10" step="1">
		<c:if test="${k%2==0}">
			<p>${k}</p>
		</c:if>
	</c:forEach>
	
	<!-- choose 연습 -->
	<!-- scope(영역)
		page : JSP 페이지 내에서만 공유
		request : 같은 요청 내에서만 공유
		session : 같은 웹브라우저 내에서만 공유
		application : 다른 웹브라우저에서도 서로 공유
	 -->
	 
	<c:set var="money" value="5000" scope="page" />
	<p>내가 가진 돈은 ${money}원 이다.</p>
	<c:choose>
		<c:when test="${money<=0}">무일푼</c:when>
		<c:when test="${money<=5000}">커피 세 잔의 여유 가능</c:when>
		<c:otherwise>여유 가능</c:otherwise>
	</c:choose>
	
</body>
</html>