<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Objects</title>
</head>
<body>
	<% // 스크립틀릿
		// 1) 폼 페이지에서 입력한 한글을 처리해보자
		request.setCharacterEncoding("UTF-8");
		// 2) 입력된 아이디와 비밀번호를 폼 문으로부터 전송받음(request객체)
		String userId = request.getParameter("id");
		String pw = request.getParameter("passwd"); 
		// 3) 폼 문으로부토 전송받은 아이디와 비밀번호가 일치
		if(userId.equals("개똥이")&&pw.equals("1234")){
			response.sendRedirect("response01_success.jsp");
		}else{
		// 4) 일치하지 않음 -> response01_failed.jsp로 이동
			response.sendRedirect("response01_failed.jsp");			
		}
		
	%>

</body>
</html>