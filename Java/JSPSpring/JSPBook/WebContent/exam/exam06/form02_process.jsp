<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		StringBuffer sb = new StringBuffer();
		request.setCharacterEncoding("UTF-8");
		
		Enumeration enu = request.getParameterNames();
		
		while(enu.hasMoreElements()){
			String valEnu = (String)enu.nextElement();
			
			String val = request.getParameter(valEnu);
			
			out.print("<p>" + valEnu + " : " + val + "</p>");
		}
	
		//sb.append("아이디 : " + request.getParameter("name") + "<br/>"); 
		//sb.append("주소 : " + request.getParameter("addr") + "<br/>"); 
		//sb.append("이메일 : " + request.getParameter("mail") + "<br/>"); 
		
	%>
	<%=sb.toString() %>
</body>
</html>