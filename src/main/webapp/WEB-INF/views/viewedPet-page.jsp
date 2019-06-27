<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="column">
			<div class="card">
				<div style="padding: 10px;">
					<img align="middle" src="${viewedPetInfo.photo}" /><br /> 
					Name:	${viewedPetInfo.petName}<br /> 
					Email:	${viewedPetInfo.contactEmail}<br /> 
					Phone Number:${viewedPetInfo.contactPhone}<br /> 
					Organization Name: ${viewedPetInfo.organizationName}
				</div>
			</div>
		</div>
	</div>
</body>
</html>