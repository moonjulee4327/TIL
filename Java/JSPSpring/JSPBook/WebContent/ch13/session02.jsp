<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Session</title>
</head>
<body>
	<%
		// session기본 객체에 저장된 userID라는 속성 이름에 대응한 값을 가져옴
		// Object 타입으로 리턴됨
		String id = (String)session.getAttribute("userID"); //admin
		String pw = (String)session.getAttribute("userPW"); //1234
		out.println("userID : " + id + "<br/>");
		out.println("userPW : " + pw);
	%>
<%-- <c:set var="id" value="<%= id %>" scope="application" /> --%>
<%-- <p>id : ${id}</p> --%>
<p>id : <%=application.getAttribute("id") %></p>
</body>
</html>