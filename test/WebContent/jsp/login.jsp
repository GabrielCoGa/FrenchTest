<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/../jsp/menu.jsp" %>

llamo a la pagina(vista) login.jsp, que al enviar el formulario llama al servlet(controlador) login.java, el cual
crea un objeto ConnectionForm.java, que verifica la contraseña y devuelve a servlet login.java el 
resultado y este lo manda de vuelta a la pagina jsp login.jsp.
<br>


<!-- recupero el parametro que viene del servlet -->
<c:if test="${!empty connectForm.resultat}">
	<p>
		<c:out value="${connectForm.resultat }"></c:out>
	</p>
</c:if>

Tambien se ha añadido al objeto  ConnectionForm.java la creacion y captura de la sesion de la conecsion al sitio
web, utiliza el objeto implicito sessionScope
<br>
<c:if test="${!empty sessionScope.login && !empty sessionScope.password}">
		<p> Vous estes ${sessionScope.login} poir toute la session</p>
</c:if>
<br>
Hora vamos a ver el funcionamiento de las cookis  poara eso hemos modificado el servlet login.java
ahora la recuperamos en la pagina
<c:out value="${login }"></c:out>

	<form method="post" action="login">
	<p>
		<label for="login"> Login: </label>
		<input type="text" id="login" name="login" />
	</p>
	<p>
		<label for="password"> Password: </label>
		<input type="text" id="password" name="password" />
	</p>	
		<input type="submit"/>
	
	</form>

</body>
</html>