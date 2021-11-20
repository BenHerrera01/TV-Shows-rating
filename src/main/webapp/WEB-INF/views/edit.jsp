<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tv Shows</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
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
		<div class="row">
			<div class="col-lg-12">
			<h1>Edit show</h1>

		<form action="../edit" method="post">
			<table class="table">
				<tr>
					<td>Show title:</td>
					<td><input type="text" name="showTitle"
						value="${show.showTitle}" class="form-control" required />
						<small id="showHelp" class="form-text text-muted">Min length: 3 - Max length: 50</small>	
					</td>
				</tr>
				<tr>
					<td>Network:</td>
					<td><input type="text" name="showNetwork"
						value="${show.showNetwork}" class="form-control" required />
						<small id="showHelp" class="form-text text-muted">Min length: 1 - Max length: 30</small>		
					</td>
				</tr>
				<tr>
					<td colspan="1">
						<input type="button" value="Go back" class="btn btn-dark" onclick="history.go(-1) " />
						 <a class="btn btn-danger" href="../delete?id=${show.id}">Delete</a>
					</td>
					<td colspan="2">
						<input type="hidden" name="id" value="${show.id}" />
						<input type="submit" value="Update"	class="btn btn-dark" />
					</td>
				</tr>
			</table>
			<span style="color:red">${mensaje}</span>

		</form>
			</div>
		</div>
		
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>