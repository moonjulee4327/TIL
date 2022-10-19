<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="exam04.dao.BookRepository"%>
<%@ page import="exam04.vo.BookVO"%>
<%@ page import="java.util.ArrayList"%>
<%
	String id = request.getParameter("id"); // QueryString으로 표현 된것이 온다.
	
	if(id == null || id.trim().equals("")){
		response.sendRedirect("books.jsp");
		return;
	}
	
	BookRepository dao = BookRepository.getInstance();
	
	BookVO book = dao.getBookById(id);
	if(book == null){
		response.sendRedirect("/exam11/exceptionNoBookId.jsp");
	}
	
	ArrayList<BookVO> list = (ArrayList<BookVO>)session.getAttribute("cartlist");
	
	if(list == null){
		list = new ArrayList<BookVO>();
		session.setAttribute("cartlist", list);
	}
	
	int cnt = 0;
	
	for(int i=0; i<list.size(); i++){
		if(list.get(i).getBookId().equals(id)){
			cnt++;
			list.get(i).setQuantity(list.get(i).getQuantity() + 1);
		}
	}
	
	if(cnt == 0){
		book.setQuantity(1);
		list.add(book);
	}
	
	response.sendRedirect("product.jsp?id=" + id);
	
%>