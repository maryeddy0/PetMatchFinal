<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<div class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>

			</ul>
		</div>
	</nav>
		<h1> Results of Zip Code</h1>
		<h3>${zipcode}</h3> 
	<br>
		<ol>
			<c:forEach items="${yelpinfo}" var="b">
				<li> ${b.name}  </li>
					<ul>
						<li>  Telephone: ${b.display_phone }  </li>
					<li>  ${b.location.displayaddress[0] }  </li>
					<li>  ${b.location.displayaddress[1] }  </li>
					</ul>
					<%-- <c:forEach items="${b.location.displayaddress[0]}" var="loc">
					<ul>
					<li>  ${loc }</li>
					</ul>
					</c:forEach> --%>
			</c:forEach>
		
		</ol>
		
		
			
	</div>


</body>
</html>