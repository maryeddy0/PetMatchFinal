<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="/">Click</a>


<h1>Default Pets</h1>
	<div class="container"><br />
		<Table class="table" border="1">
			<c:forEach items="${mary}" var="a">
				<tr>
						<td><img src="${a.id}">Pet Info</a>
					<td><a href="send-animalId?id=${a.id}">Pet Info</a>
				</tr>
			</c:forEach> 
		
		</Table>
	</div>



</body>
</html>