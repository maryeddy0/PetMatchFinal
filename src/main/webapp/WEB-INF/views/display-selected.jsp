<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">
</head>
<body>
  <div class="container">
  
  <h1>Pets selected for you</h1>

		<h2>${type}</h2>
		<ol>
			<c:forEach items="${display}" var="b">
				<li> <a href="detail?id=${b.id}">Pet id</a></li>
			</c:forEach>

		</ol>
	
	
  </div>
</body>
</html>