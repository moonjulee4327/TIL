<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Filter</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if(id.equals("") || passwd.equals("")){
			out.print("<p>로그인 실패</p>");
		}else if(id.equals("admin") && passwd.equals("admin1234")){
			session.setAttribute("id", id);
			response.sendRedirect("login_success.jsp");
		}else {
			session.getAttribute(id);
			out.print("<p>로그인 성공</p>");
		}
		
	
	%>
</body>
</html>