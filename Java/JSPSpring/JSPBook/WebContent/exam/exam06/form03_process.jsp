<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h3><b>선택한 과일</b></h3>
	<br>
	<%
		String[] fruit= request.getParameterValues("fruit");
		String sum = "";
		
		for(int i=0; i < fruit.length; i++){
			sum += fruit[i] + "&nbsp;";
		}
		out.print(sum);
	%>
	 
</body>
</html>