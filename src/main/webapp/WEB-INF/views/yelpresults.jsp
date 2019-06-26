<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
		<h1> Results of Zip Code ${zipcode}</h1>

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