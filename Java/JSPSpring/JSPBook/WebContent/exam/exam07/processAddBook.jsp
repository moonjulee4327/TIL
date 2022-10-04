<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
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
		
		
		
		BookRepository brepo = BookRepository.getInstance();
		
		vo.setBookId(request.getParameter("bookId"));
		vo.setName(request.getParameter("name"));
		vo.setUnitPrice(Integer.parseInt(request.getParameter("unitPrice")));
		vo.setAuthor(request.getParameter("author"));
		vo.setCategory(request.getParameter("category"));
		vo.setDescription(request.getParameter("description"));
		vo.setPublisher(request.getParameter("publisher"));
		vo.setCondition(request.getParameter("condition"));
		
		brepo.insertBook(vo);

// 		String fileUploadPath = "C:\\upload";
		
// 		DiskFileUpload upload = new DiskFileUpload();
		
// 		List items = upload.parseRequest(request);
		
// 		Iterator params = items.iterator();
		
// 		while(params.hasNext()){
			
// 			FileItem fileItem = (FileItem)params.next();
			
// 			if(fileItem.isFormField()){
				
// 				String value = fileItem.getString("UTF-8");
				
				
		
				
				
// 				out.print(value);
				
// 			}else{
// 				String fileName = fileItem.getName();
// // 				vo.setFilename(fileName);
// 				fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				
// 				File file = new File(fileUploadPath + "/" + fileName);
				
// 				fileItem.write(file);
// 			}
			
// 		}
		
		
		response.sendRedirect("books.jsp");
	%>
</body>
</html>