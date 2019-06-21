<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetMatchApp</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">

</head>
<body>
	
	<h1>Welcome to Friends for Life</h1>
	
	<h2>Click button to find your perfect pet match!</h2>
<!-- <form action="">
		<input type="text" name="name">
		<input type="submit" value="submit"> 
	</form> -->
	

	 <a href= "/quiz">Start the Test!</a>

	 <h3><a href= "/firstPage">Start the Test!</a></h3>
	 
	 
  <h2>If you want to choose an specific type of pet click below</h2>
  <form action="/selected">
	 <select name="type">
  	  <option value="horse">Horse</option>
  	  <option value="scales-fins-other">Scales</option>
      <option value="dog">Dog</option>
  	  <option value="bird">Bird</option>
  	  <option value="cat">Cat</option>
  	  <option value="small-furry">Small & Furry</option>
  	  <option value="fish">Fish</option>
  	  <input type="submit" value="Submit">
   </select>
   </form>
  

</body>
</html>