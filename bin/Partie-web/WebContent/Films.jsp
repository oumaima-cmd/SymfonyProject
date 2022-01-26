<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="StyleSheet" href="JEE2.css" type="text/css">
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
		<table border="1">
			<tr>
				<th>Nom_film</th>
				<th>Prix_film</th>
				<th>Acheter_film</th>
			</tr>
			<c:forEach items="${films}" var="f">
				<tr>
					<td>${f.name}</td>
					<td>${f.price}</td>
					<td ><a href="cinema.do?u_id=1&f_price=${f.id}">Achat_du_film</a></td>
				</tr>
			</c:forEach>
		</table>
		<img src="film.jpg" alt="" width="500px">
	</div>
	<div class="ajouterUtilisateur">
	
		<form action=cinema.do method="POST" class="formAjouter" style="display: flex; flex-direction: column;">
		<h1><b><u>Ajouter_film</u></b></h1>
			<input placeholder="Name" name="name" />
			<input placeholder="price" name="price" />
			<input type="submit" name="action" value="Ajouter"/>
		</form>
	</div>
</body>

</html>