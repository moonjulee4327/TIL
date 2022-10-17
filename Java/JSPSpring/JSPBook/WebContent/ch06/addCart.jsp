<%@page import="ch04.vo.ProductVO"%>
<%@page import="ch04.dao.ProductRepository"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// addCart.jsp?id=P1235
	String id = request.getParameter("id"); // P1235
	
	// id에 값이 없다면.. => 장바구니에 담을 상품이 없다면...
	if(id == null || id.trim().equals("")){
		// 상품 목록으로 이동
		response.sendRedirect("products.jsp");
		// 현재 jsp를 더 이상 실행 안함
		return;
	}
	
	// 상품 저장소 객체
	ProductRepository dao = ProductRepository.getInstance();
	
	// 1) P1235에 해당되는 productVO를 가져옴
	// select * from product where product_id = 'P1235'
	// id : P1235
	ProductVO product = dao.getProductById(id);
	if(product == null){ // 해당 상품이 없으면 예외 처리 페이지로 이동
		response.sendRedirect("exceptionNoProductId.jsp");
	}
	
	// 2) session 객체에 cartlist라는 속성이 있는지 체크 => 장바구니
	// 	  session.getAttribute("cartlist");
	// 2-2) cartlist라는 장바구니가 없으면 장바구니를 생성
	// 		session.setAttribute("cartlist");
	
	// 3-1) cartlist라는 장바구니에 P1235라는 상품이 이미 있는 경우
	// 		P1235라는 상품 객체(productVO)의 quantity 멤버변수의 값을 1 증가
	
	// 3-2) cartlist라는 장바구니에 P1235라는 상품이 없는 경우
	// 		cartlist라는 장바구니에 P1235라는 상품을 넣자. quantity 값을 1로 처리
	
	// 4) product.jsp?id=P1235 경로로 되돌아가자
%>