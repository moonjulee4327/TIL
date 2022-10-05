<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="ch04.vo.ProductVO"%>
<%@page import="ch04.dao.ProductRepository"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	// 폼 페이지에서 입력된 데이터를 서버(톰캣)로 전송 시 한글이 깨지지 않도록 하자
	request.setCharacterEncoding("UTF-8");

	// 1) 어디에 저장할 것인지?(윈도우 상의 경로는 \\)
	String path = "E:\\A_TeachingMaterial\\6.JspSpring\\workspace\\JSPBook\\WebContent\\resources\\images";
	// 2) 파일 업로드 객체 생성
	DiskFileUpload upload = new DiskFileUpload();
	// 3) 환경설정. bit -> bytes -> kbytes -> mbtes -> gbytes
	upload.setSizeMax(1000000); // bytes
	upload.setSizeThreshold(4096); // 메모리 최대 크기(4MB)
	upload.setRepositoryPath(path); // 임시 저장 경로
	// 4) 폼 페이지의 item 받아오기. items -> {"productId":"P1237","pname":"게이밍 마우스"...}
	List items = upload.parseRequest(request);
	// 5) 열거형 타입으로 변환
	Iterator params = items.iterator();
	
	
	String productId = "";
	String pname = "";
	String unitPrice = "";
	String description = "";
	String manufacturer = "";
	String category = "";
	String unitInStock = "";
	String condition = "";
	int price = 0;
	int stock = 0;
	String fileName = "";
	
	// 6) 요청 파라미터가 없을 때까지 반복
	while(params.hasNext()){
		
		FileItem item = (FileItem)params.next();
		
		// Spring 프레임워크에서는 MutipartFile로 처리
		if(item.isFormField()){	// 6-1) 일반 데이터
			
			// 6-1-1) 파라미터의 이름 가져오기
			if(item.getFieldName().equals("productId")){
				productId = item.getString("UTF-8");
			}else if(item.getFieldName().equals("pname")){
				pname = item.getString("UTF-8");
			}else if(item.getFieldName().equals("unitPrice")){
				unitPrice = item.getString("UTF-8");
				// 폼 페이지에서 상품 가격이 입력되지 않으면 0으로 처리
				if(unitPrice.isEmpty()){
					price = 0;
				}else{
					price = Integer.parseInt(unitPrice);
				}
			}else if(item.getFieldName().equals("description")){
				description = item.getString("UTF-8");
			}else if(item.getFieldName().equals("manufacturer")){
				manufacturer = item.getString("UTF-8");
			}else if(item.getFieldName().equals("category")){
				category = item.getString("UTF-8");
			}else if(item.getFieldName().equals("unitInStock")){
				unitInStock = item.getString("UTF-8");
				// 상품 재고수도 숫자
				if(unitInStock.isEmpty()){
					stock = 0;
				}else{
					stock = Integer.parseInt(unitInStock);
				}
			}else if(item.getFieldName().equals("condition")){
				condition = item.getString("UTF-8");
			}
		
		}else{	// 6-2) 파일 데이터
			String fileFieldName = item.getFieldName(); // 요청 파라미터 명(productImages)
			fileName = item.getName(); // 저장파일명(... .png)
			String contentType = item.getContentType(); // images/jpeg
			// 순수한 파일명만 추출
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
			long fileSize = item.getSize();
			// 파일 객체 생성(copy 설계)
			File file = new File(path + "/" + fileName);
			// copy 실행
			item.write(file);
			
			out.println("--------------------------<br/>");
			out.println("오청 파라미터 명 : " + fileFieldName + "<br/>");
			out.println("저장 파일 명 : " + fileName + "<br/>");
			out.println("파일 콘텐츠 타입 : " + contentType +"<br/>");
			out.println("파일 크기 : " + fileSize +"<br/>");
			
		}
	} // end while
	
	// 빈(Bean) 객체에 데이터를 태워서 add하자
	ProductVO productVO = new ProductVO();
	productVO.setProductId(productId);
	productVO.setPname(pname);
	productVO.setUnitPrice(price);
	productVO.setDescription(description);
	productVO.setManufacturer(manufacturer);
	productVO.setCategory(category);
	productVO.setUnitInStock(stock);
	productVO.setCondition(condition);
	productVO.setFilename(fileName);
	
	ProductRepository dao = ProductRepository.getInstance();
	
	// insert into product(.....) values(.....)
	// 폼 페이지에서 입력된 데이터를 저장하도록 
	// ProductRepository 클래스의 addProduct 메소드를 호출
	dao.addProduct(productVO);
	
	out.print("productVO : " + productVO.toString());
	
// 	response.sendRedirect("products.jsp");
%>