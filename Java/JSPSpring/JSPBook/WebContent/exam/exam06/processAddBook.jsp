<%@page import="java.util.Enumeration"%>
<%@page import="exam04.dao.BookRepository"%>
<%@page import="exam04.vo.BookVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%! 
		public String arrToStr(String[] arr){
			String str = "";
			for(String strs : arr){
				str += strs;
			}
			return str;
		}
	
	%>
	
	<%
		request.setCharacterEncoding("UTF-8");
		BookVO vo = new BookVO();
		
		/*
		이렇게 VO에 넣을 수 있나?
		Enumeration bookAdd = request.getParameterNames();
		
		while(bookAdd.hasMoreElements()){
			String bookNm = (String)bookAdd.nextElement();
			
			
		}
		*/	
		
		vo.setBookId(request.getParameter("bookId"));
		vo.setName(request.getParameter("name"));
		vo.setCategory(request.getParameter("category"));
		vo.setDescription(request.getParameter("description"));
		vo.setAuthor(request.getParameter("author"));
		vo.setPublisher(request.getParameter("publisher"));
		vo.setUnitPrice(Integer.parseInt(request.getParameter("unitPrice")));
		vo.setCondition(request.getParameter("condition"));
		
		
		BookRepository brepo = BookRepository.getInstance();
		
		brepo.insertBook(vo);
		
		// request.getRequestDispatcher("books.jsp").forward(request, response);
		response.sendRedirect("books.jsp");
	%>
</body>
</html>