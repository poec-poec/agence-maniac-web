<!DOCTYPE html>

<html>

<head>

<title>Maniac - Aeroport</title>

</head>

<body>
	<h1>D�tails Aeroport <c:out value="${ aeroport.idAero }" /> : ${ aeroport.nom }</h1>
			<h3>Liste de villes d�sservies :</h3>

			<c:forEach items="${aeroport.villes}" var="ville">
				<ul>
					<li><c:out value="${ville.nom}" /> - [<c:out value="${ville.pays}" />]</li>
				</ul>
			</c:forEach>
			
			<p><a href="VueAeroports">Retour liste a�roports</a></p>
</body>

</html>