<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp - jstl</title>
</head>
<body>
<h2>camino relativo para insertar el fichero menu, que se cuentra en otro directorio</h2>

	<%@include file="/../jsp/menu.jsp" %>
<p> 
	<c:out value="Bonjour !"/>

</p>
<h2>crear una variable</h2>
<br>
<c:set var="pseudo" value="Mateo21" scope="page"/>
<c:out value="${pseudo }"/><br>
<h3>anbito scope= page, session and application</h3>
<br>
<h3>otra manera de definiar la variable</h3>
<br>
<c:set var="pseudo"  scope="page">Mateo22</c:set>
<c:out value="${pseudo }"/><br>
<br>
<h2>modificar las propiedades de un objeto creado, que tiene que ser pasado en el request</h2> 
<br>
<c:set target="${auteur}" property="prenom" value="jamon"/>
<c:out value="${auteur.prenom}"/>
<br>
<h2>Sentencias de bifulcacion</h2>
<br>
<c:if test="${50 > 10 }" var="variable">
	<c:out value="${variable }"/>
</c:if>
<br>
<c:choose>
	<c:when test="${50 > 10 }"> mayor de diez</c:when>
	<c:when test="${50 eq 50}"> igual de diez</c:when>
	<c:when test="${10 < 50 }"> mayor de diez</c:when>
</c:choose>

<h2>Sentencias de iteracion</h2>
de 0 a 6 de 1 en 1
<br>
<c:set var="contador" value="0" scope="page"/>
<c:forEach begin="0" end="6" step="1">
	<c:set var="contador" value="${contador + 1 }" scope="page"/>
	<c:out value= " ${contador}"/>
	<br>
</c:forEach>
<br>
de 1 a 6 de 2 en 2 con variable en el for
<br>

<c:forEach var="i" begin="1" end="6" step="2">
	<c:out value= " ${i}"/>
	<br>
</c:forEach>

<h2>recorrer un array enviado desde el servlet</h2>
<br>
<c:forEach items="${noms}" var="nom">
	<c:out value= " ${nom }"/>
	<br>
</c:forEach>
<br>

<h2>recorrer un array enviado desde el servlet aconntado valores</h2>
<br>
<c:forEach items="${noms}" var="nom" begin="1" end="6" step="2">
	<c:out value= " ${nom }"/>
	<br>
</c:forEach>
<br>
<h2>para reacoger informacion sobre el bucle usanos la variable varStatus</h2>
<br>
<c:forEach items="${noms}" var="nom" varStatus="status" >
	Nº<c:out value= " ${status.count}"/> :	<c:out value= " ${nom }"/>
	<br>
</c:forEach>
<br>
<h2>para reacoger informacion sobre el bucle husanos la propiedad current</h2>
<br>
<c:forEach items="${noms}" var="nom" varStatus="status" >
	Nº<c:out value= " ${status.current}"/>
	<br>
</c:forEach>
<br>

<h2>para reacoger informacion sobre el bucle forTokens</h2>
<br>
<c:forTokens  var="nom" items="uno/dos/tres/cuatro" delims="/" >
	 ${nom}
	<br>
</c:forTokens>
<br>
</body>
</html>