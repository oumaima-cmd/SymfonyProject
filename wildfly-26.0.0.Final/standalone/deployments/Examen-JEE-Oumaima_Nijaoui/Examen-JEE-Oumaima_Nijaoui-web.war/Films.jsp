<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>List film</title>
<style>
	
	td, th {
		text-align: center;
	}
	
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
</head>
<body style="display: flex;">
	<div class="listeUtilisateur">
		<table>
			<tr>
				<th>Nom film</th>
				<th>Prix film</th>
				<th>Acheter film</th>
			</tr>
			<c:forEach items="${films}" var="f">
				<tr>
					<td>${f.name}</td>
					<td>${f.price}</td>
					<td><a href="listFIlm.do?u_id=1&f_price=${f.id}">Acheter film</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="ajouterUtilisateur">
	
		<form action=listFIlm.do method="POST" class="formAjouter" style="display: flex; flex-direction: column;">
		<h1>Ajouter film</h1>
			<input placeholder="nom" name="name" />
			<input placeholder="prix" name="price" />
			<input type="submit" name="action" value="Ajouter"/>
		</form>
	</div>
</body>

</html>