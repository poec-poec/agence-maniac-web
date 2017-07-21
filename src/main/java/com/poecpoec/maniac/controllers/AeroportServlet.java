package com.poecpoec.maniac.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poecpoec.agence.dao.AeroportDao;
import com.poecpoec.agence.model.Aeroport;

/**
 * Servlet implementation class AeroportServlet
 */
@WebServlet("/VueAeroports")
public class AeroportServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AeroportServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // On traite les clients, on instancie donc la dao client
        AeroportDao aeroportDao = new AeroportDao();

        // On vérifie si on reçoit un client en paramètre, sinon on s'occupe de
        // tous les clients
        if (request.getParameter("aeroport") != null)
        {
            // on récupère le paramètre, à savoir l'id du client
            int id = Integer.parseInt(request.getParameter("aeroport"));
            // on récupère le client correspondant à l'id récupéré
            Aeroport aeroport = aeroportDao.findById(id);
            // on transmet le client via les attributs de la requète
            request.setAttribute("aeroport", aeroport);
            // on utilise le dispatcher de la requète auquel on lui donne le
            // chemin de la jsp de la vue
            RequestDispatcher rDispatcher = request.getRequestDispatcher("WEB-INF/aeroport.jsp");
            // on lui transmet la requète et la réponse
            rDispatcher.forward(request, response);

        }
        else
        {
            // on récupère l'ensemble des clients que l'on stocke dans une liste
            List<Aeroport> listeAeroports = aeroportDao.findAll();
            // on transmet la liste via les attributs de la requète
            request.setAttribute("listeAeroports", listeAeroports);
            // on utilise le dispatcher de la requète auquel on lui donne le
            // chemin de la jsp de la vue
            RequestDispatcher rDispatcher = request.getRequestDispatcher("WEB-INF/aeroports.jsp");
            // on lui transmet la requète et la réponse
            rDispatcher.forward(request, response);
        }
    }

}
