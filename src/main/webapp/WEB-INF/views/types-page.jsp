<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container"><br />
		
		<Table class="table" border="1">
			<% int count = 1; %>
			<c:forEach items="${allTypes}" var="a">
				<tr>	
					<td><%= count++ %></td>
					<td>${a.name}</td>
				</tr>
			</c:forEach> 
		
		</Table>
	</div>

</body>
</html>