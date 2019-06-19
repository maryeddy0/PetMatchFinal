<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">

</head>
<body>
  <div class="container">
  <h1>Details of the pet selected</h1>
	 <section class="one">
		
		<c:choose>
			<c:when test="${ empty picture }">
			<h4>Actual Image Not Available</h4>
				<img alt="no picture available" src="https://upload.wikimedia.org/wikipedia/commons/e/ec/Happy_smiley_face.png" height="100px" width="100px"><br>
			</c:when>
			<c:otherwise>
				
				<img src="${picture}"><br>
			</c:otherwise>
		
		</c:choose>	
	</section>
	
    <section class="two">
  
	<h3>Name: ${detailedinfo.name}</h3>
	<h3>Age: ${detailedinfo.age}</h3>
	<h3>Gender: ${detailedinfo.gender}</h3>
	<h3>Size: ${detailedinfo.size }</h3>
	<h5>Organization: ${organization}</h5>
	<h5>Telephone: ${telephone}</h5>
	<h5>City: ${city}</h5>
	<h5>State: ${state}</h5>
	<h5>Postal Code: ${postcode}</h5>
	
   
   </section> 
   
 </div>
</body>
</html>