<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">

<style type="text/css">

.container {
    width: 1000px;
    margin: 0px auto;
    /*display:table;*/
    position:relative;
   max-height:500px;
}

    #left {
        width: 600px;
        display:inline-block;
        /*float:left;*/
        position:absolute;
        left:0;
    }

    #right {
   
        width: 500px;
        border-radius: 3px;
        display:inline-block;
        /*float:right;*/
        position:absolute;
        right:0;
        }
        
   #last-viewed{
	padding-top: 400px;
    display: inline-block;
    
   }



</style>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>

			</ul>
		</div>
	</nav>
	<!-- Pet basic infor and contacts -->
	<!-- Pet basic infor and contacts -->
	<div class="container">
		
		<img id="left" style="max-height:400px; width:auto;" src="${basic.photos}"><br><br>
		
		<div id="right">
			<h4>Name: ${basic.name}</h4><h4>Description:</h4> ${basic.description}

			<h3>Contact Information</h3>
			Organization Name: ${contacts.name}<br /> Contact
			Email:${contacts.email}<br /> Contact Phone#: ${contacts.phone}<br />
			Location: ${contacts.address.city}, ${contacts.address.state}
			${contacts.address.postcode}
	
	<!-- Yelp Part! -->
	<div id="bottom">
	<h3>To find more adoption resources in your area, enter your zip code below</h3>
	
	<form action ="/resultsyelp" method = "POST">
        <input type="number" name="zipcode"  minlength="8" required><br>
        <input type= "submit" value="Submit">
    </form>
	</div>
		</div>
	
	<!-- view history part -->
	<div id="last-viewed">
		<h3>Your most recent 5 views:</h3>
		<c:forEach items="${views}" var="v">
		
			<a href="viewedPet?petPhoto=${v.photo}&petName=${v.petName}&contactEmail=${v.contactEmail}&contactPhone=${v.contactPhone}&orgName=${organizationName}"><img height="100px" width="auto" src="${v.photo}"></a>
			${v.petName}
			
		</c:forEach>
	</div>

	

</body>
</html>