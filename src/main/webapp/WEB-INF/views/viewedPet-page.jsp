<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		<div class="column">
			<div class="card">
				<div style="padding: 10px;">
					<img align="middle" src="${viewedPetInfo.photo}" /><br /> 
					Name:	${viewedPetInfo.petName}<br /> 
					Email:	${viewedPetInfo.contactEmail}<br /> 
					Phone Number:${viewedPetInfo.contactPhone}<br /> 
					Organization Name: ${viewedPetInfo.organizationName}
				</div>
			</div>
		</div>
	</div>
</body>
</html>