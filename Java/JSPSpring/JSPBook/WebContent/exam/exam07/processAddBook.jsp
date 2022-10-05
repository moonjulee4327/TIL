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
	
	<%
		
		/*
		이렇게 VO에 넣을 수 있나?
		Enumeration bookAdd = request.getParameterNames();
		
		while(bookAdd.hasMoreElements()){
			String bookNm = (String)bookAdd.nextElement();
			
			
		}
		*/	
		

		String fileUploadPath = "E:\\A_TeachingMaterial\\6.JspSpring\\workspace\\JSPBook\\WebContent\\resources\\examImages";
		
		DiskFileUpload upload = new DiskFileUpload();
		
		List items = upload.parseRequest(request);
		
		Iterator params = items.iterator();
		
		String bookId = "";
		String name = "";
		String unitPrice = "";
		String author = "";
		String description = "";
		String publisher = "";
		String category = "";
		String unitsInStock = "";
		String totalPages = "";
		String releaseDate = "";
		String condition = "";
		int price = 0;
		long stock = 0;
		long pages = 0;
		String fileName = "";
		
		while(params.hasNext()){
			
			FileItem fileItem = (FileItem)params.next();
			
			if(fileItem.isFormField()){
				
				if(fileItem.getFieldName().equals("bookId")){
					bookId = fileItem.getString("UTF-8");
				}else if(fileItem.getFieldName().equals("name")){
					name = fileItem.getString("UTF-8");
				}else if(fileItem.getFieldName().equals("unitPrice")){
					unitPrice = fileItem.getString("UTF-8");
					if(unitPrice.isEmpty()){
						price = 0;
					}else{
						price = Integer.parseInt(unitPrice);
					}
				}else if(fileItem.getFieldName().equals("author")){
					author = fileItem.getString("UTF-8");
				}else if(fileItem.getFieldName().equals("description")){
					description = fileItem.getString("UTF-8");
				}else if(fileItem.getFieldName().equals("publisher")){
					publisher = fileItem.getString("UTF-8");
				}else if(fileItem.getFieldName().equals("category")){
					category = fileItem.getString("UTF-8");
				}else if(fileItem.getFieldName().equals("unitsInStock")){
					unitsInStock = fileItem.getString("UTF-8");
					if(unitsInStock.isEmpty()){
						stock = 0;
					}else{
						stock = Long.valueOf(unitsInStock);
					}
				}else if(fileItem.getFieldName().equals("totalPages")){
					totalPages = fileItem.getString("UTF-8");
					if(totalPages.isEmpty()){
						pages = 0;
					}else{
						pages = Long.valueOf(totalPages);
					}
				}else if(fileItem.getFieldName().equals("releaseDate")){
					releaseDate = fileItem.getString("UTF-8");
				}else if(fileItem.getFieldName().equals("condition")){
					condition = fileItem.getString("UTF-8");
				}
		
			}else{
				fileName = fileItem.getName();
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				
				File file = new File(fileUploadPath + "/" + fileName);
				
				fileItem.write(file);
			}
			
		}
		
		BookVO vo = new BookVO();
		vo.setBookId(bookId);					
		vo.setName(name);
		vo.setUnitPrice(price);
		vo.setAuthor(author);
		vo.setDescription(description);
		vo.setPublisher(publisher);
		vo.setCategory(category);
		vo.setUnitsInStock(stock);
		vo.setTotalPages(pages);
		vo.setReleaseDate(releaseDate);
		vo.setCondition(condition);
		vo.setFilename(fileName);
		BookRepository brepo = BookRepository.getInstance();
		brepo.insertBook(vo);
		
		response.sendRedirect("books.jsp");
	%>
</body>
</html>