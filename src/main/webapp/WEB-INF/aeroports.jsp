<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<title>Maniac - Aeroport</title>

</head>

<body>
	<h1>Liste des aéroports</h1>
	
		<ul>
			<c:forEach items="${ listeAeroports }" var="aeroport">
				<li><a href="VueAeroports?aeroport=${ aeroport.idAero }">${ aeroport.nom }</a></li>
			</c:forEach>
		</ul>
	
</body>

</html>