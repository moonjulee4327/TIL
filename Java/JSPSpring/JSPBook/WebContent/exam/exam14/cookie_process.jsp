<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	
	if(id.equals("개똥이") && pw.equals("admin1234")){
		Cookie cookie = new Cookie("userID", URLEncoder.encode(id, "UTF-8"));
		response.addCookie(cookie);
	}
	response.sendRedirect("welcome.jsp");
		
%>