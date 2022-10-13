<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<h1>오류발생</h1>
<!-- 	
	web.xml 의 <error-code>, <exception-type> 엘리먼트에 설정된 오류의 <location> 
	지정 서블릿/JSP 가 수행될 때 발생된 오류에 대한 정보가 HttpServletRequest 객체 통해 전달됨.
	
  - javax.servlet.error.status_code : 오류 코드
  - javax.servlet.error.exception_type : 예외 타입 정보 (Class 형 객체)
  - javax.servlet.error.message : 예외 메시지
  - javax.servlet.error.exception : 발생된 예외 객체
  - javax.servlet.error.request_uri : 오류 발생 파일의 URI 
  -->
	<table border="1px">
		<tr>
			<td><b>Error:</b></td>
			<td><%=exception.toString() %>: 오류발생</td>
		</tr>
		<tr>
			<td><b>URI:</b></td>
			<td><%=request.getRequestURI() %></td>
		</tr>
		<tr>
			<td><b>Status code:</b></td>
			<td><%=response.getStatus()%></td>
		</tr>
	</table>
		<table border="1px">
		<tr>
			<td><b>Error:</b></td>
			<td>${pageContext.exception}</td>
		</tr>
		<tr>
			<td><b>URI:</b></td>
			<td>${pageContext.errorData.requestURI}</td>
		</tr>
		<tr>
			<td><b>Status code:</b></td>
			<td>${pageContext.errorData.statusCode}</td>
		</tr>
	</table>
</body>
</html>