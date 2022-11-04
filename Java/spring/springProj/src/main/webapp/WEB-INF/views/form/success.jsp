<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>요청처리</title>
</head>
<body>
	<h2>성공!</h2>
	<c:forEach var="hobby" items="${hobbyList}">
		${hobby}
	</c:forEach>
</body>
</html>