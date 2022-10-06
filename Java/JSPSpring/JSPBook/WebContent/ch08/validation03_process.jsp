<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="id" value=""/>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
	%>
	<h3>입력에 성공했습니다.</h3>
	
	<p>아이디 : <%=id %></p>
	<p>비밀번호 : <%=passwd %></p>
</body>
</html>