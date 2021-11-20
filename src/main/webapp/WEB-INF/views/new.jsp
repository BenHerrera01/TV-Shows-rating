<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tv Shows</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="../home">Tv Shows</a>

		<div class="">
			<ul class="nav navbar-nav list-group list-group-horizontal">
				<li class="list-inline-item"><a class="nav-link" href="../showForm">Add Show</a></li>
				<li class="list-inline-item"><a class="nav-link" href="../logout">logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
	<br>
	<div class="col"></div>
	<div class="col-lg-12">
		<h1>Create a new show</h1>
		<form action="new" method="post">
				<table class="table">
					<tr>
						<td>Show title:</td>
						<td><input type="text" name="showTitle" class="form-control"
							required />
							<small id="showHelp" class="form-text text-muted">Min length: 3 - Max length: 50</small>
						</td>
					</tr>
					<tr>
						<td>Network:</td>
						<td><input type="text" name="showNetwork"
							class="form-control" required />
							<small id="showHelp" class="form-text text-muted">Min length: 1 - Max length: 30</small>	
						</td>
					</tr>
					<tr>
						<td><input type="button" value="Go back" class="btn btn-dark"
							onclick="history.go(-1) " /></td>
						<td><input type="submit" value="Create" class="btn btn-dark" /></td>
					</tr>
					
				</table>
				<span style="color:red">${mensaje}</span>

			</form>
	</div>
	<div class="col"></div>
	
	</div>
	

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>