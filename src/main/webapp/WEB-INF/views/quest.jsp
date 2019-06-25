<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question test page</title>
<script>
<!--thr form validate is not working-->
</script>
</head>
<body style="margin:70px;">
<h1>Friends for Life Quiz</h1>
<p>Select an answer for each question below to find your best match</p>

<form action="/matchResults">

<p>What type of space would you mostly share with your pet?</p>
<input type="radio" name="space" value="backyard">Backyard<br>
<input type="radio" name="space" value="inhouse" checked>In house<br>
<br>

<p>Based off of your last answer, how big is that space?</p>
<input type="radio" name="size" value="small" checked>Small Space<br>
<input type="radio" name="size" value="enough">Enough Space<br>
<input type="radio" name="size" value="large">Large amount of Space<br>
<br>

<p>How do you want to interact with your pet?</p>
<input type="radio" name="interact" value="explore" checked>Explore<br>
<input type="radio" name="interact" value="admire">Admire<br>
<input type="radio" name="interact" value="cuddle">Cuddle<br>
<br>

<p>What is your ideal budget for a pet per month?</p>
<input type="radio" name="cost" value="50orless" checked>$50 or less<br>
<input type="radio" name="cost" value="50-100">$50-100<br>
<input type="radio" name="cost" value="100-200">$100-200<br/>
<input type="radio" name="cost" value="200+">$200 or more<br>
<br>

<p>On average, how many hours will someone be home a day?</p>
<input type="radio" name="hours" value="l5" checked>Less than 5 hrs<br>
<input type="radio" name="hours" value="b5-8">5-8 hrs<br>
<input type="radio" name="hours" value="m8">More than 8 hrs<br>
<br>

<p>What size poop can you endure?</p>
<input type="radio" name="mess" value="smallgift" checked>A small gift<br>
<input type="radio" name="mess" value="mediocore">A mediocre gift<br>
<input type="radio" name="mess" value="massive">A massive gift<br><br>
<input type = "submit" value="Submit" onsubmit="return validateForm()"> <!-- The form is gone, accidently deleted it -->
</form>

</body>
</html>
