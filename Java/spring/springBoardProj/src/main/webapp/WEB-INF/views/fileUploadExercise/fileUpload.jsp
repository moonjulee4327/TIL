<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>FileUploadExercise</title>
</head>
<body>
<form action="/fileUploadExercise/fileUploadPost" method="post" enctype="multipart/form-data">
	<input type="file" id="uploadFile" name="uploadFile" multiple="multiple">
	<p><input type="submit" value="파일 등록"></p>
</form>
</body>
</html>