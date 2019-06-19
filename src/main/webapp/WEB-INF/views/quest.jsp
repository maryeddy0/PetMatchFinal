<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question test page</title>
<script>
function validateForm() {
    var x = document.forms["myForm"]["fname"].value;
    if (x == null || x == "") {
        alert("Please make sure all questions are filled out");
        return false;
    }
}
</script>
</head>
<body>
<h1>Test Questions</h1>

<form action="/spaces">
<p>Where do you have space to share with your pet?</p>
<input type="radio" name="space" value="indoor">Indoor<br>
<input type="radio" name="space" value="outdoor">Outdoor<br>

<p>How do you want to interact with your pet?</p>
<input type="radio" name="interact" value="explore">Explore<br>
<input type="radio" name="interact" value="admire">Admire<br>
<input type="radio" name="interact" value="cuddle">Cuddle<br>

<p>How much can you spend each month?</p>
<input type="radio" name="cost" value="50">$50<br>
<input type="radio" name="cost" value="50-100">$50-100<br>
<input type="radio" name="cost" value="100-200">$100-200<br/>
<input type="radio" name="cost" value="200+">$200+<br>

<p>How many hours will someone be home a day?</p>
<input type="radio" name="hours" value="l5">Less than 5<br>
<input type="radio" name="hours" value="l8">Less than 8<br>
<input type="radio" name="hours" value="m8">More than 8<br>

<p>How much can you spend each month?</p>
<input type="radio" name="cost" value="50">$50<br>
<input type="radio" name="cost" value="50 - 100">$50-100<br>
<input type="radio" name="cost" value="200+">$200<br>

<p>How many hours will someone be home a day?</p>
<input type="radio" name="hours" value="less than 5">Less than 5<br>
<input type="radio" name="hours" value="less than 8">Less than 8<br>
<input type="radio" name="hours" value="more than 8">More than 8<br>

<p>What is a noise level you are comfortable with?</p>
<input type="radio" name="noise" value="loud">Loud<br>
<input type="radio" name="noise" value="minimal">Minimal<br>
<input type = "submit" value="Submit" onsubmit="return validateForm()">
</form>

</body>
</html>