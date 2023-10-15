package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//esta cabecera hace que no funcionene las cookie
//import org.apache.tomcat.util.http.parser.Cookie;

import com.octest.forms.ConnectionForm;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//recuperar la informacion de la cookie
		Cookie[]cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cook: cookies) {
				if(cook.getName().equals("login")) {
					request.setAttribute("login", cook.getValue());
					//ahora vamos a la jsp para recuperar el valor y nostrarlo
				}
			}
		}

		this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnectionForm connectForm = new ConnectionForm();
		connectForm.verifierIdentifiants(request);
		request.setAttribute("connectForm", connectForm);
		
		// vamos a trabajar las cookis como necesitamos HttpServletResponse lo hacemos desde el servlet
		//no desde la clase ConnectionForm como hicimos con la sesion
		String login = request.getParameter("login");
		//creacion de la Cookie:
			//response.addCookie(new Cookie("login", login));
		//Otra forma de crearla Cookie:
		Cookie cookie = new Cookie("login", login);
		// tiempo de duracion
		cookie.setMaxAge(60 * 60 * 24 * 30);//segundos,  minutos, 1dia, 1mes 
		response.addCookie(cookie);
	
		
		this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

}
