<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<img height="500px" width="auto" src="${basic.photos}" />
		<br>
		<br>
		<div class="container">
			Name: ${basic.name} <br /> Description: ${basic.description}<br />
		</div>
	</div>
	<div class="container">
		<div class="container">
			<br>
			<h3>Contact Information</h3>
		</div>
		<div class="container">
			Organization Name: ${contacts.name}<br /> Contact Email:
			${contacts.email}<br /> Contact Phone#: ${contacts.phone}<br />
			Address: ${contacts.address.city}, ${contacts.address.state}
			${contacts.address.postcode}
		</div>
		<br />
	</div>
	<!-- Testing view history, hasn't finish yet -->
<%-- 	<div class="container">
		<img height="100px" width="auto" src="${viewedPetBasic.photos}"/><br>
		Name: ${viewedPetBasic.name}
		More Info: <!-- redirect back to description and contact-page when user clicks-->
	</div --%>>
</body>
</html>