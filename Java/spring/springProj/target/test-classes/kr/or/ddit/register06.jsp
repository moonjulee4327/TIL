<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>파일 업로드</title>
</head>
<body>
	<form action="/registerFile01" method="post" enctype="multipart/form-data">
		<p><input type="file" name="picture"></p>
		<p><input type="submit" value="업로드"></p>
	</form>
</body>
</html>