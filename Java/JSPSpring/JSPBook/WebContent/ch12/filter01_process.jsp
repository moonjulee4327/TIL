<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Filter</title>
</head>
<body>
	<%	
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		response.setCharacterEncoding("UTF-8");
	%>
	<p>입력된 name 값 : <%=name %></p>
</body>
</html>