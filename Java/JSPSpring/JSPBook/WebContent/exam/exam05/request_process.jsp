<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("utf-8");
		String qs = request.getQueryString();
	%>
	전송된 요청 파라미터 : <%=qs %>
</body>
</html>