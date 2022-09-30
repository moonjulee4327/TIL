<%@page import="exam04.dao.BookRepository"%>
<%@page import="exam04.vo.BookVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		BookVO vo = new BookVO();
		vo.setBookId(request.getParameter("bookId"));
		vo.setName(request.getParameter("name"));
		vo.setCategory(request.getParameter("category"));
		vo.setDescription(request.getParameter("description"));
		vo.setAuthor(request.getParameter("author"));
		vo.setPublisher(request.getParameter("publisher"));
		vo.setUnitPrice(Integer.parseInt(request.getParameter("unitPrice")));
		
		
		BookRepository brepo = BookRepository.getInstance();
		
		brepo.insertBook(vo);
		
		request.getRequestDispatcher("books.jsp").forward(request, response);
	%>
</body>
</html>