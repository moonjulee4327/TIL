<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		session.invalidate();
	%>
<script type="text/javascript">
	location.href="/exam/exam06/addBook.jsp"
</script>
</body>
</html>