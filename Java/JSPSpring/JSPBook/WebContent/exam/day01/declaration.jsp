<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%!
		String str = "Hello,Java Server Pages";
	
		String getString(String str){
			return str;
		}
	%>
	
	<%
		out.println(getString(str));
	%>
	
	
</body>
</html>