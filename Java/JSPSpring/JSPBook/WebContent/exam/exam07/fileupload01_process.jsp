<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%
	String fileUploadPath = "C:\\upload";

	DiskFileUpload upload = new DiskFileUpload();
	
	List items = upload.parseRequest(request);
	
	Iterator params = items.iterator();
	
	while(params.hasNext()){
		FileItem fileItem = (FileItem)params.next();
		
		if(!fileItem.isFormField()){
			String name = fileItem.getFieldName();
			String fileName = fileItem.getName();
			String fileCon = fileItem.getContentType();
			Long fileSize = fileItem.getSize();
			
			out.println("요청 파라미터 이름 : " + name + "<br />");
			out.println("저장 파일 이름 : " + fileName + "<br />");
			out.println("파일 콘텐츠 타입 : " + fileCon + "<br />");
			out.println("파일 크기 : " + fileSize);
		}
	}
%>