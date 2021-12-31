<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper" class="d-flex flex-column">
		<div id="goldAmount">
			<h2>Your Gold: </h2>
			<h2 class="border"><c:out value="${gold}"/></h2>
		</div>
		<div id="locations" class="d-flex flex-row justify-content-evenly">
			<div class="farm" style="height:300px; width:300px;" class="border d-flex flex-column">
				<form action="/findGold" method="post" style="height:300px; width:300px;" class="form-control d-flex flex-column align-items-center justify-content-center">
					<h3>Farm</h3>
					<p>(earns 10-20 gold)</p>
					<input type="hidden" name="location" value="farm"/>
					<input type="submit" value="Find Gold!" class="btn btn-primary">
				</form>
			</div>
			<div class="cave" style="height:300px; width:300px;" class="border d-flex flex-column">
				<form action="/findGold" method="post" style="height:300px; width:300px;" class="form-control d-flex flex-column align-items-center justify-content-center">
					<h3>Cave</h3>
					<p>(earns 5-10 gold)</p>
					<input type="hidden" name="location" value="cave"/>
					<input type="submit" value="Find Gold!" class="btn btn-primary">
				</form>
			</div>
			<div class="house" style="height:300px; width:300px;" class="border d-flex flex-colum">
				<form action="/findGold" method="post" style="height:300px; width:300px;" class="form-control d-flex flex-column align-items-center justify-content-center">
					<h3>House</h3>
					<p>(earns 2-5 gold)</p>
					<input type="hidden" name="location" value="house"/>
					<input type="submit" value="Find Gold!" class="btn btn-primary">
				</form>
			</div>
			<div class="casino" style="height:300px; width:300px;" class="border d-flex flex-column">
				<form action="/findGold" method="post" style="height:300px; width:300px;" class="form-control d-flex flex-column align-items-center justify-content-center">
					<h3>Casino!</h3>
					<p>(earns/takes 0 - 50 gold)</p>
					<input type="hidden" name="location" value="casino"/>
					<input type="submit" value="Find Gold!" class="btn btn-primary">
					
				</form>
			</div>
		</div>
		<h1>Activities:</h1>
		<footer class="overflow-auto p-3 border border-5" style="width:auto;height:400px">
			
			${message}
		</footer>
	</div>
</body>
</html>