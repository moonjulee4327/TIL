<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Filter</title>
</head>
<body>
	<%
		Object id = session.getAttribute("id");
		String idStr = (String) id;
		out.print(idStr + "님 로그인을 성공했습니다.");
	%>

</body>
</html>