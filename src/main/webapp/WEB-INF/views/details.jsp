<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

</head>
<body>

	<div class="container">
		<!-- Display basic pet Info one by one with a link to descriptionAndContact-page -->
		<c:forEach items="${basicInfo}" var="i">
			<div style="padding: 10px;">
				<img height="300px" width="300px" src="${i.photos}" /><br />
				Name: ${i.name} <br /> 
				Gender: ${i.gender} <br />
				Age: ${i.age} <br /> 
				<!-- URL link: moreDetail -->
				<a href="moreDetail?description=${i.description}&photo=${i.photos}&name=${i.name}&orgID=${i.organizationID}"><strong>More Description</strong></a><br />
			</div>
		</c:forEach>
	</div>

</body>
</html>