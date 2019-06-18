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
<!-- 	<!-- <form action="q">
		<input type="text" name="range"> 
		<input type="submit" value="next">
	</form>
	 -->
	<form action="to-yelp">
	response: ${yelp}
	</form>
	
	<h1>WELCOME TO PET MATCH APP</h1>
	
	<h1>Login to find your perfect pet match</h1>
	<form action="">
		<input type="text" name="name">
		<input type="submit" value="submit">
	</form>
	
	<h1>Default Pets</h1>
	<div class="container"><br />
		<Table class="table" border="1">
			<c:forEach items="${allType}" var="a">
				<tr>
					<td><a href="send-animalId?id=${a.id}">Pet Info</a>
				</tr>
			</c:forEach> 
		
		</Table>
	</div>
	 
	 <form action="/t">
	 <c:forEach items="${singleType}" var="st">
	 	name: ${st.name}
	 </c:forEach>
	 
	 </form>
	<form action="/testing">${quest}</form>

</body>
</html>