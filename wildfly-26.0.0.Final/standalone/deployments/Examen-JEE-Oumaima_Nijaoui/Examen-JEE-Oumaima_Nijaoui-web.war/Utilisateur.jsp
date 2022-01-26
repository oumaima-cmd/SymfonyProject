<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
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
		<table>
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
	</div>
	<div class="ajouterUtilisateur">
		<form action="landing.do" method="POST" class="formAjouter" style="display: flex; flex-direction: column;">
			<input placeholder="nom" name="name" />
			<input placeholder="solde" name="solde" />
			<input placeholder="password" name="password" />
			<input type="submit" name="action" value="Ajouter"/>
			<input type="submit" name="action" value="Connecter" />
		</form>
	</div>
</body>
</html>