<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Access Denied Page</title>
</head>
<body>
	<h1>Access Denied</h1>
	<h2>${SPRING_SECURITY_403_EXCEPTION.getMessage()}</h2>
	<h3>${msg}</h3>
</body>
</html>