<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Maniac - Client</title>
</head>
<body>
	<h1>Détails Client <c:out value="${ client.id }" /> : ${ client.prenom } ${ client.nom }</h1>
	<p>Adresse e-mail : ${ client.email }</p>
	<p>Numéro téléphone : ${ client.numeroTel }</p>
	<p>Numéro Fax : ${ client.numeroFax }</p>
	<p>Adresse :</p>
	<ul>
		<li>${ client.adresse.adresse }</li>
		<li>${ client.adresse.codePostal } - ${ client.adresse.ville }</li>
		<li>${ client.adresse.pays }</li>
	</ul>
	<p><a href="VueClients">Retour liste clients</a></p>
</body>
</html>