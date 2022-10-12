<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%out.print("<p>오류발생 : 요청 파라미터 값이 없습니다.</p>"); %>
<jsp:include page="exception.jsp"/>
</body>
</html>