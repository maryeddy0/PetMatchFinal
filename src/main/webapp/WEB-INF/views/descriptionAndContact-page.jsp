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
		<img src="${basic.photos}" /><br />
		Name: ${basic.name} <br /> Description: ${basic.description}<br />
	</div>
	<div class="container">
		<h3>Contact Information</h3>
		Organization Name: ${contacts.name}<br/>
		Contact Email: ${contacts.email}<br />
		Contact Phone#: ${contacts.phone}<br />
		Address: ${contacts.address.city}, ${contacts.address.state} ${contacts.address.postcode} <br/>
	</div>
</body>
</html>