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



	<form action="Typeselected">
		<c:forEach items="${allTypes}" var="at">
			<c:out value="${at.name}"></c:out><br/>
		</c:forEach>

	</form>

	${type} ${display}
</body>
</html>