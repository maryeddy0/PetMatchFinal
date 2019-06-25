<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question test page</title>
<script>

</script>
</head>
<body>
<h1>Test Questions</h1>

<form action="/matchResults">
<p>What type of space would you mostly share with your pet?</p>
<input type="radio" name="space" value="backyard">Backyard<br>
<input type="radio" name="space" value="inhouse">In house<br>

<p>Based off of your last answer, how big is that space?</p>
<input type="radio" name="size" value="small">Small Space<br>
<input type="radio" name="size" value="enough">Enough Space<br>
<input type="radio" name="size" value="large">Large amount of Space<br>

<p>How do you want to interact with your pet?</p>
<input type="radio" name="interact" value="explore">Explore<br>
<input type="radio" name="interact" value="admire">Admire<br>
<input type="radio" name="interact" value="cuddle">Cuddle<br>

<p>What is your ideal budget for a pet per month?</p>
<input type="radio" name="cost" value="50orless">$50 or less<br>
<input type="radio" name="cost" value="50-100">$50-100<br>
<input type="radio" name="cost" value="100-200">$100-200<br/>
<input type="radio" name="cost" value="200+">$200 or more<br>

<p>On average, how many hours will someone be home a day?</p>
<input type="radio" name="hours" value="l5">Less than 5 hrs<br>
<input type="radio" name="hours" value="b5-8">5-8 hrs<br>
<input type="radio" name="hours" value="m8">More than 8 hrs<br>

<p>What size poop can you endure?</p>
<input type="radio" name="mess" value="smallgift">A small gift<br>
<input type="radio" name="mess" value="mediocore">A mediocre gift<br>
<input type="radio" name="mess" value="massive">A massive gift<br>
<input type = "submit" value="Submit" onsubmit="return validateForm()">
</form>

</body>
</html>
