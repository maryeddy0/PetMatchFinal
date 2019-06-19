<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box
}

.container {
	width: 100%;
	background-color: #ddd;
}

.skills {
	text-align: right;
	padding-right: 20px;
	line-height: 40px;
	color: white;
}

<!--
.html {
	width: 80%;
	background-color: #4CAF50;
}
-->
</style>
</head>
<body>
	<form action="selected">
		<div class="container">

			<h1>Matching Rate</h1>

			<c:forEach items="${space}" var="sp">
				<p>
					See Match(click): <a href="seeMatch?type=${sp.key}"><strong>${sp.key}</strong></a>
					<!-- go to petController, type is sending over... -->
				</p>
				<div class="container">
					<div class="skills html">${sp.value}</div>
				</div>
			</c:forEach>
		</div>
	</form>
</body>
</html>