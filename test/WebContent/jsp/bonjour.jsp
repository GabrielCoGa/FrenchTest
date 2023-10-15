<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonjour JSP</title>
</head>
<body>
		<%@include file="menu.jsp" %>
	
	<p>
	<%String variable = (String) request.getAttribute("variable");
		out.print(variable);
	%>
	</p>
	
	<p>
		<%for(int i = 0; i< 6; i++ ){ %>
				<h<%=i%>>hola</h>
		<%}	%>
	</p>
	
	<p>
		<%String valorDia = (String)request.getAttribute("heure");
		if (valorDia.equals("jour"))
		{
			out.println("goodMorning");
		}
		else
		{
			out.println("goodNight");
		}
		%>
	</p>
	

	
	<p>
		Hello my frend <%String name = (String)request.getAttribute("name");
		if(name.isEmpty()) {
			name="";
		}
		out.println(name);
		out.println("<br>");
		out.println((String)request.getAttribute("name"));
		%>
	</p>
	
	<p>
	
	<h2>EXPRESSION LANGUAGE IN THE JSP</h2>
	${name} have a lot the things ${4 * 5}
	hola ${empty name ? 'nothing' : name}
	
	<p>
	${noms[1] }
	</p>
	
	<p>
		<h2>JAVA BEANS</h2>	
		directamente del objeto obtenemos una propiedad:
		${auteur.prenom }<br>
		obtenermos la propiedad a traves de los get:
		${auteur.getPrenom() }
		<br>
		${auteur.actif ? "Eres muy activo" : "no estas activo"}
		<br>
		${!auteur.actif ? "Eres muy activo" : "no estas activo"}
	</p>
	

</body>
</html>