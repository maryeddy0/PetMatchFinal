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

</head>
<body>
	<!-- Pet basic infor and contacts -->
	<div class="container">
		<img height="500px" width="auto" src="${basic.photos}" /> <br> <br>
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
			Organization Name: ${contacts.name}<br /> Contact
			Email:${contacts.email}<br /> Contact Phone#: ${contacts.phone}<br />
			Location: ${contacts.address.city}, ${contacts.address.state}
			${contacts.address.postcode}
		</div>
		<br />
	</div>
	<!-- Yelp Part! -->
	<div class="container">
	<h1>If you want to look up for an specific zip code enter it below!</h1>
	
	<form action ="/resultsyelp" method = "POST">
        <input type="number" name="zipcode"  minlength="8" required><br>
        <input type= "submit" value="Submit">
   
    </form>
    
	</div>
	<!-- view history part -->
	<div class="container">
		<h3>Your most recent 5 views:</h3>
		<c:forEach items="${views}" var="v">
			<a href="viewedPet?petPhoto=${v.photo}&petName=${v.petName}&contactEmail=${v.contactEmail}&contactPhone=${v.contactPhone}&orgName=${organizationName}"><img height="100px" width="auto" src="${v.photo}"></a>
			${v.petName}
		</c:forEach>
	</div>

	

</body>
</html>