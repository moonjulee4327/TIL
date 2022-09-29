<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Object</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pw = request.getParameter("passwd");
		
	%>
	
	<p>아이디 : <%=userId %></p>
	<p>비밀번호 : <%=pw %></p>
	
</body>
</html>