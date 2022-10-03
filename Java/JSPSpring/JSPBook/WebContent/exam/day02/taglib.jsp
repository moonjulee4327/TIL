<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="k" begin="0" end="10" step="1">
		<c:if test="${k%2 == 0}"><span>${k}</span></c:if>
	</c:forEach>
	
	<c:forEach var="i" begin="0" end="10" step="2">
		<c:out value="${i}"/>
	</c:forEach>
	
</body>
</html>