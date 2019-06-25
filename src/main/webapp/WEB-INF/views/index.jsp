<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetMatchApp</title>
<!--  <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">
-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Pet Match</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li><a href="/login">Login</a></li>
			</ul>
				<!-- No login page yet -->

				<!-- 	<form class="navbar-form navbar-left" action="/action_page.php">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search"
						name="search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form> -->
		</div>
	</nav>
	
	
	<div class="container">
		<h1>Welcome to Friends for Life</h1>


		<h3>
			Click below to find your match:<br>
		</h3>
		<h4>
			<a href="/quiz">Start the Test!</a>
		</h4>
		<br />
		<h3>If you want to choose an specific type of pet click below</h3>
		<form action="/selected" class="navbar-form navbar-left">
			<select class="btn btn-default" name="type" class="form-control">
				<option value="dog">Dog</option>
				<option value="bird">Bird</option>
				<option value="cat">Cat</option>
				<option value="small-furry">Small & Furry</option>
				<option value="scales-fins-other">Reptile</option>
				<option value="horse">Horse</option>
			</select> <input type="submit" class="btn btn-primary" value="Search">

		</form>
	</div>
</body>
</html>