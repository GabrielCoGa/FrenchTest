package com.octest.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Fichier
 */
@WebServlet("/Fichier")
public class Fichier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final int TAILLE_TAMPON = 10240;
	public static final String CHEMIN_FICHERS="/";//pour moi /Users/Gabriel/Documents/
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fichier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/jsp/formFichero.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//on recupere le champ(campo) comme d'hatitude
		String description = request.getParameter("description");
		request.setAttribute("description", description);
		
		//on recupere le champ du ficher
		Part part = request.getPart("fichier");
		
		//on verifie qu'on a bien recu un fichier
		String nomFichier = getNomFichier(part);
		
		//si on na bien un ficher
		String nomChamp="";
		if(nomFichier != null && !nomFichier.isEmpty()) {
			nomChamp = part.getName();
			//corrige un bug du fonctionnement d'internet Explorer
			nomFichier =nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
					.substring(nomFichier.lastIndexOf('\\') + 1);
			
		}
		
		//on ecrit definitivement le fichier sur le disque
		ecrireFichier(part,nomFichier, CHEMIN_FICHERS);
		request.setAttribute(nomChamp, nomFichier);
	}
	
	private void ecrireFichier(Part part, String nomFichier, String cheminFichers)throws IOException {
		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		try {
			entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(cheminFichers + nomFichier )), TAILLE_TAMPON);
			
			byte[] tampon = new byte[TAILLE_TAMPON];
			int longueur;
			while((longueur = entree.read(tampon)) > 0) {
				
				sortie.write(tampon, 0, longueur);
				
			}
		} 
		finally {
			try {
				
				sortie.close();
				
			}catch(IOException ignore) {
				
			}
		}
		try {
			
			entree.close();
			
		}catch(IOException ignore) {
			
		}
		
	}

	private static String getNomFichier(Part part) {
		for(String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if(contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('-') + 1).trim().replace("\"","");
			}
				
		}
		return null;
	}

}
