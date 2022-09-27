<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>BookMarket</title>
</head>
<body>
	<%!
		String title = "Book Market Mall";
		String content = "Welcome to Book Market";
	%>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<!-- 내용이 들어간다. -->
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./welcome.jsp">Home</a>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">		
			<h1 class="display-3"><%=title%></h1>	
		</div>
	</div>
	<main role="main">
		<div class="container">
			<div class="text-center">
				<h3><%=content %></h3>		
			</div>
			<hr />
		</div>
	</main>
	
	<footer class="container">
		<p>&copy;WebMarket</p>
	</footer>

</body>
</html>