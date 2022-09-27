<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>BookMarket</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="jumbotron">
		<div class="container">		
			<h1 class="display-3">도서 웹 쇼핑몰</h1>	
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
	<%@ include file="footer.jsp" %>
	

</body>
</html>