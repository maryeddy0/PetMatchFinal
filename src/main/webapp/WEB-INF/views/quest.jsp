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

<body style="background-image:url(puppy.jpg); background-size: cover; font-size: 16;  background-attachment: fixed;
    height:700px;">

<div id="parent" style="height:1200px; padding:40px; float:left; width:550px; position:absolute; z-index: 2;
    position: inherit;">

<h1 style="color:orange; font-style:heavy; font-size: 80px; font-weight: bold;">Friends for Life Quiz</h1>
<h3>Select an answer for each question below to find your best match</h3>


<form name="quest" action="/matchResults" onsubmit="return dontEatPets()">
 <p>1. What type of space would you mostly share with your pet?</p>
<input type="radio" name="space" value="backyard">Backyard<br>
<input type="radio" name="space" value="inhouse" checked>In house<br>
<input type="radio" name="space" value="bi">Backyard and in house<br>
<br>

<p>2. Based off of your last answer, how big is that space?</p>
<input type="radio" name="size" value="small" checked>Small Space<br>
<input type="radio" name="size" value="enough">Enough Space<br>
<input type="radio" name="size" value="large">Large amount of Space<br>
<br>

<p>3. How do you want to interact with your pet?</p>
<input type="radio" name="interact" value="explore" checked>Explore<br>
<input type="radio" name="interact" value="play">Play and exercise<br>
<input type="radio" name="interact" value="admire">Admire<br>
<input type="radio" name="interact" value="cuddle">Cuddle<br>
<br>

<p>4. What is your ideal budget for a pet per month?</p>
<input type="radio" name="cost" value="l50" checked>$50 or less<br>
<input type="radio" name="cost" value="50100">$50-100<br>
<input type="radio" name="cost" value="100200">$100-200<br/>
<input type="radio" name="cost" value="200+">$200 or more<br>
<br>

<p>5. On average, how many hours will someone be home a day?</p>
<input type="radio" name="hours" value="l5" checked>Less than 5 hrs<br>
<input type="radio" name="hours" value="b58">5-8 hrs<br>
<input type="radio" name="hours" value="m8">More than 8 hrs<br>
<br>

<p>6. What size poop can you endure?</p>
<input type="radio" name="mess" value="smallgift" checked>A small gift<br>
<input type="radio" name="mess" value="mediocre">A mediocre gift<br>
<input type="radio" name="mess" value="massive">A massive gift<br><br>


<p>7. How often are you willing to give your pet a bubble bath?</p>
<input type="radio" name="bath" value="never" checked>Never<br>
<input type="radio" name="bath" value="week">Once a week<br>
<input type="radio" name="bath" value="month">Once a month<br>
<br>

<p>8. How would you describe your best human friend?</p>
<input type="radio" name="friend" value="social" checked>Social<br>
<input type="radio" name="friend" value="antisocial">Antisocial<br>
<input type="radio" name="friend" value="chill">Chill<br>
<br>

<p>9. How likely are you to eat your pet?</p>
<input type="radio" name="eat" value="nlikely" checked>Not likely<br>
<input type="radio" name="eat" value="only">Only under extreme conditions<br>
<input type="radio" name="eat" value="possibly">Very possibly<br>
<br>

<p>10. Are you likely to dress up your pet?</p>
<input type="radio" name="dress" value="yes" checked>yes<br>
<input type="radio" name="dress" value="maybe">Maybe<br>
<input type="radio" name="dress" value="no">No<br>
<br>

<input type = "submit" value="Submit" onsubmit="return validateForm()"> <!-- The form is gone, accidently deleted it -->
</form>
</div>

<script>
function dontEatPets() {
	  var x = document.forms["quest"]["eat"].value;
	  if (x == "yes") {
	    window.alert("Because you answered likely to eat your pet, we ask you not to pursue pet adoption. Thank you");
	    return false;
	  }
	}
</script>

</body>

</html>