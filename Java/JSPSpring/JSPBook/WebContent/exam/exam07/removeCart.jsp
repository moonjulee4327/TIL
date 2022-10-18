<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="exam04.vo.BookVO"%>
<%@ page import="exam04.dao.BookRepository"%>
<%
	String id = request.getParameter("id");

	if(id == null || id.trim().equals("")){
		response.sendRedirect("products.jsp");
		return;
	}
	
	BookRepository dao = BookRepository.getInstance();
	BookVO product = dao.getBookById(id);
	
	if(product == null){
		response.sendRedirect("/exam11/exceptionNoBookId.jsp");
		return;
	}
	
	ArrayList<BookVO> cartlist= (ArrayList<BookVO>)session.getAttribute("cartlist");
	
	for(int i=0; i< cartlist.size(); i++){
		if(cartlist.get(i).getBookId().equals(id)){
			cartlist.remove(cartlist.get(i));
		}
	}
	if(cartlist.size() == 0){
		session.invalidate();
	}
	response.sendRedirect("cart.jsp");
%>