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
		<div class="row">
			<div class="col-lg-12">
				<h2><b>Welcome ${email}</b></h2>
				<h3>Tv Shows</h3>
				<table class="table table-dark">
					<thead class="thead-dark">
						<tr>
							<th>Show title</th>
							<th>Network</th>
						</tr>
					</thead>
					<c:forEach items="${shows}" var="element">
						<tr>
							<td><a href="show/${element.id}">${element.showTitle}</a></td>
							<td>${element.showNetwork}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>