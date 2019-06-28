<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body style="mask-size: 3em;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>

			</ul>
		</div>
	</nav>
	<div class="row">
		<!-- Display basic pet Info one by one with a link to descriptionAndContact-page -->
		<c:forEach items="${basicInfo}" var="i">
			<div class="column">
				<div class="card">

					<div style="height: 450px;">
						<div style="padding: 10px;">
							<div style="max-height: 300px; max-width: 95%; overflow: hidden;">
								<img id="img" src="${i.photos}">
							</div>
							Name: ${i.name} <br /> Gender: ${i.gender} <br /> Age: ${i.age}
							<br />
							<!-- URL link: moreDetail -->
							<a
								href="moreDetail?description=${i.description}&photo=${i.photos}&name=${i.name}&orgID=${i.organizationID}&petID=${i.petID}"><button
									class="button">More Information</button></a><br />
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>