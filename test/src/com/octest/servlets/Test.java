package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.beans.Auteur;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String message = "Welcome to my first servlet and jsp.";
		request.setAttribute("variable", message);
		request.setAttribute("heure", "jour");
		
		//String name = request.getParameter("name");
		//request.setAttribute("name", name);
		
		String[] noms = {"Gabriel", "Frank", "Guille", "claudia", "juan", "antonio"};
		request.setAttribute("noms", noms);
		
		Auteur auteur = new Auteur();
		auteur.setNom("Guillermo");
		auteur.setPrenom("Cortes");
		auteur.setActif(true);
		request.setAttribute("auteur", auteur);
		
		//this.getServletContext().getRequestDispatcher("/jsp/bonjour.jsp").forward(request, response);
		this.getServletContext().getRequestDispatcher("/jstl/bonjourJSTL.jsp").forward(request, response);
		
		//this.getServletContext().getRequestDispatcher("/print").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
