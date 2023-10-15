<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>work with file</title>
</head>
<body>
<%@include file="/../jsp/menu.jsp" %>

<!-- recupero el parametro que viene del servlet -->
<c:if test="${!empty fichier}">
	<p>
		<c:out value="le ficher ${fichier } (${description }) a ete upload"></c:out>
	</p>
</c:if>

	<form method="post" action="fichier" enctype="multipart/form-data">
	<p>
		<label for="description"> Description du fichier: </label>
		<input type="text" id="description" name="description" />
	</p>
	
	<p>
		<label for="fichier"> Ficher a envoyer: </label>
		<input type="file" id="fichier" name="fichier" />
	</p>
		
		<input type="submit"/>
	
	</form>

</body>
</html>