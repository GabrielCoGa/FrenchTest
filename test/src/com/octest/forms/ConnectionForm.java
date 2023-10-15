package com.octest.forms;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ConnectionForm {
	
	private String resultat;
	
	public void verifierIdentifiants(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if (password.equals(login + 123)) {
			resultat = "vous etes bien connecte !";
			//creo un objeto sesion para guardar los datos del usuario para toda la conexion
			// y poder recuperarlos donde haga falta.
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			session.setAttribute("password", password);
			
			/* * para finalizar una sesion se utiliza la instrucion:
			 * session.invalidate(); */

		}
		else {
			resultat = "identifians incorrects !";
		}
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	

}
