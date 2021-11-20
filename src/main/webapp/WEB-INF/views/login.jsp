<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="home">IMDB</a>
</nav>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<br>
				<h2>Login</h2>
				<form action="/login" method="post">
					<input type="text" id="email" name="email" placeholder="Email"
						class="form-control" /><br> 
						<input type="password"
						placeholder="Password" id="password" name="password"
						class="form-control" /><br>
					<div align="center">
						<c:if test="${param.error}">
							<p style="color: red;">Check email or password field</p>
						</c:if>
					</div>	
			

					<button class="btn btn-lg btn-primary btn-block" name="Submit"
						value="Login" type="Submit">Login</button>
						<br>
					<a type="button" class="btn btn-lg btn-primary btn-block" href="/registration">Registrar</a>
				</form>
			</div>

		</div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>