<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="StyleSheet" href="JEE.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	.ajouterUtilisateur{
		flex-grow: 1;
	}
	.listeUtilisateur{
		flex-grow: 1;
	}
	.formAjouter{
		padding:3rem;
	}
	.formAjouter input{
		margin-top: 1rem;
	}
</style>
<body style="display: flex;">
	<div class="listeUtilisateur">
		<table border="2">
			<tr>
				<th>id</th>
				<th>Nom</th>
				<th>Solde</th>
			</tr>
			<c:forEach items="${utilisateurs}" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.name}</td>
					<td>${u.solde}</td>
				</tr>
			</c:forEach>
		</table>
		<img src="cin.jpg" alt="" width="500px">
	</div>
	
	<div class="ajouterUtilisateur">
	<h1><b><u>Ajouter utilisateur</u></b></h1>
		<form action="user.do" method="POST" class="formAjouter" style="display: flex; flex-direction: column;">
			<input placeholder="Name" name="name" />
			<input placeholder="solde" name="solde" />
			<input placeholder="password" name="password" />
			<input type="submit" name="action" value="Ajouter"/>
			<input type="submit" name="action" value="Connecter" />
		</form>
	</div>
</body>
</html>