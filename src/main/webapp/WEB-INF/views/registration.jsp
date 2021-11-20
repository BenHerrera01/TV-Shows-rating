<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
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
	<div class="col-sm"></div>
	<div class="col-sm">
	<br>
		<h2>Registrar</h2>
		<form action="/registration" method="post">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" class="form-control" required /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"	class="form-control" required /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" class="form-control" required /></td>
				</tr>
				<tr>
					<td>Password Confirmation:</td>
					<td><input type="password" name="passwordConfirmation" class="form-control" required /></td>
				</tr>
				<tr>
					<td colspan=2><span style="color:red">${mensaje}</span></td>

				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Registrar"
						class="btn btn-lg btn-primary btn-block" /></td>
				</tr>
			
			</table>
		</form>
		
	</div>
	<div class="col-sm"></div>
	</div>
</div>
	
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>