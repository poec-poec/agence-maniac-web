package com.poecpoec.maniac.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poecpoec.agence.dao.ClientDao;
import com.poecpoec.agence.model.Client;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(urlPatterns={"/client"})
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // On traite les clients, on instancie donc la dao client
	    ClientDao clientDao = new ClientDao();
	    
	    // On vérifie si on reçoit un client en paramètre, sinon on s'occupe de tous les clients
	    if(request.getParameter("client") != null) {
	        // on récupère le paramètre, à savoir l'id du client
	        int id = Integer.parseInt(request.getParameter("client"));
	        // on récupère le client correspondant à l'id récupéré
	        Client client = clientDao.findById(id);
	        // on transmet le client via les attributs de la requète
            request.setAttribute("client", client);
            // on utilise le dispatcher de la requète auquel on lui donne le chemin de la jsp de la vue
            RequestDispatcher rDispatcher = request.getRequestDispatcher("WEB-INF/client.jsp");
            // on lui transmet la requète et la réponse
            rDispatcher.forward(request, response);
	        
	    } else {
	        // on récupère l'ensemble des clients que l'on stocke dans une liste
	        List<Client> listeClients = clientDao.findAll();
	        // on transmet la liste via les attributs de la requète
	        request.setAttribute("listeClients", listeClients);
	        // on utilise le dispatcher de la requète auquel on lui donne le chemin de la jsp de la vue
	        RequestDispatcher rDispatcher = request.getRequestDispatcher("WEB-INF/clients.jsp");
	        // on lui transmet la requète et la réponse
	        rDispatcher.forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
