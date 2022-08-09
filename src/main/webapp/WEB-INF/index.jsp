<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container-fluid p-3">
		<div class="container">
			<label for="gold">Your Gold:</label>
			<p>${ninja.getGold()}</p>
		</div>
		<div class="container">
			<div class="container">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<form action="/location" method="post">
					<input type="hidden" name="loc" value="farm">
					<input type="submit" class="btn btn-warning" value="Find Gold!">
				</form>
			</div>
			<div class="container">
				<h2>Cave</h2>
				<p>(earns 10-20 gold)</p>
				<form action="/location" method="post">
					<input type="hidden" name="loc" value="cave">
					<input type="submit" class="btn btn-warning" value="Find Gold!">
				</form>
			</div>
			<div class="container">
				<h2>House</h2>
				<p>(earns 10-20 gold)</p>
				<form action="/location" method="post">
					<input type="hidden" name="loc" value="house">
					<input type="submit" class="btn btn-warning" value="Find Gold!">
				</form>
			</div>
			<div class="container">
				<h2>Quest</h2>
				<p>(earns/takes 0-50 gold)</p>
				<form action="/location" method="post">
					<input type="hidden" name="loc" value="quest">
					<input type="submit" class="btn btn-warning" value="Find Gold!">
				</form>
			</div>
		</div>
		<div class="container">
			<h2>Activities</h2>
			<div class="container">
				<c:forEach var="event" items="${ninja.getEventLog() }">
					<c:choose>
						<c:when test="${event.contains(\"failed\")}">
							<p class="text-danger">${event}</p>
						</c:when>
						<c:otherwise>
							<p class="text-success">${event}</p>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>