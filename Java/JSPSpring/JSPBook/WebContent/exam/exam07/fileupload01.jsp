<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>File Upload</title>
</head>
<body>
	<form action="fileupload01_process.jsp" method="post" enctype="multipart/form-data">
		<p>파일 : <input type="file" name="filename"></p>
		<input type="submit" value="파일 올리기">
	</form>
</body>
</html>