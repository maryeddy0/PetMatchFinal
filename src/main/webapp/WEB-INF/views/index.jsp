<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetMatchApp</title>
</head>
<body>
<h1>WELCOME TO PET MATCH APP</h1>

<h1>Login to find your perfect pet match</h1>
<form action="">
<input type="text" name="name">
<input type="submit" value="submit">

</form>
<form action="/animals">
</form>
	<c:forEach items="${display}" var="a">
		${a.type}
		${a.species}
	</c:forEach>

</body>
</html>