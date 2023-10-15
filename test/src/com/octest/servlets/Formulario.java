package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formulario
 */
@WebServlet("/Formulario")
public class Formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// para cuando se le llama a traves de la url tenemos las dos opciones siguientes:
		//primera:
			//doPost(request, response);
		//segunda:
		this.getServletContext().getRequestDispatcher("/jsp/formulario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupero el parametro de la pagina jsp;
		String nom = request.getParameter("nom");
		//y ahora se lo vuelvo a mandar
		request.setAttribute("nom", nom);
		this.getServletContext().getRequestDispatcher("/jsp/formulario.jsp").forward(request, response);
	}

}
