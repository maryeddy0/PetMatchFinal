<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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


<body style="background-image:url(cat-fav.jpg); background-size:cover;">


	<div class="container">
		<h1>Your Match Mates</h1>
		<c:forEach items="${space}" var="sp">
			<!-- change "smallfurry" type to "Small & Furry" -->
			<c:choose>

				<c:when test="${sp.key =='smallfurry'}">

					<h4>
						
						<a data-toggle="tooltip" title="click me to see your matches!" href="selected1?type=${sp.key}">Small & Furry</a>
					</h4>
				</c:when>
				
				<c:otherwise>
					<h4>
						<a data-toggle="tooltip" title="click me to see your matches!" href="selected1?type=${sp.key}"> ${sp.key}</a>
					</h4>
				</c:otherwise>
			</c:choose>
			<div class="progress">
				<div class="progress-bar progress-bar-success" aria-valuenow="${sp.value}" aria-valuemin="0" aria-valuemax="100" style="width:${sp.value}%">
				<fmt:parseNumber var="i" integerOnly="true" type="number" value="${sp.value}"/> <c:out value="${i}" />%</div>
			</div>
			<!-- go to petController, type is sending over... -->
		</c:forEach>
	</div>
<script>
$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip();   
});
</script>
</body>
</html>