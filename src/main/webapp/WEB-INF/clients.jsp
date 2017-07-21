<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Maniac - Client</title>
</head>
<body>
	<h1>Liste des clients</h1>
	<table>
		<tr>
			<th>Prénom</th>
			<th>Nom</th>
		</tr>
		<c:forEach items="${ listeClients }" var="client">
			<tr>
				<td><a href="VueClients?client=${ client.id }">${ client.prenom }</a></td>
				<td><a href="VueClients?client=${ client.id }">${ client.nom }</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>