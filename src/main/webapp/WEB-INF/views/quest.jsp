<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question test page</title>
</head>
<body>

<h1>Test Questions</h1>

<form action="/spaces">
<p>Where do you have space to share?</p>
<input type="radio" name="indoor" value="indoor">Indoor<br>
<input type="radio" name="outdoor" value="outdoor">Outdoor<br>
<input type = "submit" value="Submit">
</form>

<form action="/interact">
<p>What do you want to interact with your pet?</p>
<input type="radio" name="interact" value="explore">Explore<br>
<input type="radio" name="interact" value="admire">Admire<br>
<input type="radio" name="interact" value="cuddle">Cuddle<br>
<input type = "submit" value="Submit">

</form>

<form action="/cost">
<p>How much can you spend each month?</p>
<input type="radio" name="cost" value="50">$50<br>
<input type="radio" name="cost" value="50 - 100">$50-100<br>
<input type="radio" name="cost" value="200+">$200<br>
<input type = "submit" value="Submit">
</form>

<form action="/hours">
<p>How many hours will someone be home?</p>
<input type="radio" name="hours" value="less than 5">less than 5<br>
<input type="radio" name="hours" value="less than 8">less than 8<br>
<input type="radio" name="hours" value="more than 8">more than 8<br>
<input type = "submit" value="Submit">
</form>

<form action="/noise">
<p>What is a noise level you are comfortable with?</p>
<input type="radio" name="noise" value="loud">Loud<br>
<input type="radio" name="noise" value="minimal">minimal<br>
<input type = "submit" value="Submit">
</form>

</body>
</html>