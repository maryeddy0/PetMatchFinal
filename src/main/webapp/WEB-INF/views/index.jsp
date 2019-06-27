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
<style>
.modal-header, h4, .close {
	background-color: #5cb85c;
	color: white !important;
	text-align: center;
	font-size: 30px;
}

.modal-footer {
	background-color: #f9f9f9;
}
</style>
</head>
<body style="background: url(index.gif); background-size: cover;">


	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Friends for Life</a>
			</div>
			<ul class="nav navbar-nav">
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1
			style="color: #ff7007; font-style: heavy; font-size: 70px; font-weight: bold; padding-top: 30px;">
			Welcome to <br>Friends for Life
		</h1>
	</div>
	<div class="container">
		<h3 style="color: #ff7007; font-weight: bold;">Find your ideal
			pet based on personality and lifestyle.</h3>
	</div>
	<br>
	<br>
	<br>
	<div class="container">
		<form action="/quiz">
			<h3>
				Start your test here:
				<button style="background-color: #ff7007; color: white;"
					type="button" class="btn btn-default btn-lg" id="myBtn">Test!</button>
			</h3>
			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="padding: 35px 50px;">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4>
								<span class="glyphicon glyphicon-lock"></span> Login
							</h4>
						</div>
						<div class="modal-body" style="padding: 40px 50px;">
							<div class="form-group">
								<label for="usrname"><span
									class="glyphicon glyphicon-user"></span> Enter your email: </label> <input
									type="text" class="form-control" id="usrname"
									placeholder="Enter email">
							</div>
							<br />
							<button type="submit" name="email"
								class="btn btn-success btn-block">
								<span class="glyphicon glyphicon-off"></span> Login
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="container">
		<h3>Browse pet types below:</h3>
		<form action="/selected" class="navbar-form navbar-left">
			<select class="btn btn-default" name="type" class="form-control">
				<option value="dog">Dog</option>
				<option value="bird">Bird</option>
				<option value="cat">Cat</option>
				<option value="small-furry">Small & Furry</option>
				<option value="scales-fins-other">Reptile</option>
				<option value="horse">Horse</option>
			</select>
			<!-- Trigger the modal with a button -->
			<button style="background-color: #ff7007; color: white;"
				type="button" class="btn btn-default btn-lg" id="myBtn1">Search</button>
			<!-- Modal -->
			<div class="modal fade" id="myModal1" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="padding: 35px 50px;">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4>
								<span class="glyphicon glyphicon-lock"></span> Login
							</h4>
						</div>
						<div class="modal-body" style="padding: 40px 50px;">
							<div class="form-group">
								<label for="usrname"><span
									class="glyphicon glyphicon-user"></span> Enter your email: </label><br>
								<input type="text" class="form-control" id="username"
									placeholder="Enter email">
							</div>
							<br /> <br />
							<button type="submit" name="email"
								class="btn btn-success btn-block">
								<span class="glyphicon glyphicon-off"></span> Login
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


	<script>
		$(document).ready(function() {
			$("#myBtn").click(function() {
				$("#myModal").modal();
			});
		});
		$(document).ready(function() {
			$("#myBtn1").click(function() {
				$("#myModal1").modal();
			});
		});
	</script>
</body>
</html>