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
					
				<h1>Title: ${show.showTitle}</h1>
				<h2>Network: ${show.showNetwork}</h2>
				<h3>Users who rated this show</h3>
		
				<table class="table table-dark">
					<thead class="thead-dark">
						<tr>
							<th>Name</th>
							<th>Rating</th>
						</tr>
					</thead>
					<c:forEach items="${showRate}" var="element">
						<tr>
							<td>${element.user.email}</td>
							<td>${element.rating}</td>
						</tr>
					</c:forEach>
				</table>
				<c:set var="mail" scope="session" value="${principalName}" />
				<c:if test="${mail.equals(show.user.email)}">
					<a class="btn btn-info" href="../edit/${show.id}">Edit Show</a>
				</c:if>
			
				<form action="../showRate" method="post">
					<table>
						<tr>
							<td>
								<input type="number" name="rating" class="form-control"/>
							</td>
							<td>
								<input type="hidden" name="valor" value="${show.id}"/>
								<input type="submit" class="btn btn-dark" value="Rate!"/>
							</td>						
						</tr>
						<tr>
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