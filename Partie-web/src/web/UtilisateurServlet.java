package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entites.Compte;
import Exceptions.UserNotFoundException;
import session.Utilisateur;


@WebServlet(name="utilisateur", urlPatterns = {"user.do"})
public class UtilisateurServlet extends HttpServlet{
	
	@EJB
	private Utilisateur utilisateur;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Compte> res = utilisateur.getUtilisateurs();
		req.setAttribute("utilisateurs",res);
		req.getRequestDispatcher("Utilisateur.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		switch (action) {
		case "Ajouter": {	
			String name = req.getParameter("name");
			String solde = req.getParameter("solde");
			String password = req.getParameter("password");
			Compte c = new Compte();
			c.setName(name);
			c.setPassword(password);
			c.setSolde(Integer.parseInt(solde));
			utilisateur.createUtilisateur(c);
			List<Compte> res = utilisateur.getUtilisateurs();
			req.setAttribute("utilisateurs",res );
			req.getRequestDispatcher("Utilisateur.jsp").forward(req, resp);
		}
		case "Connecter":{
			try {
				int u_id = utilisateur.init(req.getParameter("name"), req.getParameter("password"));
				req.setAttribute("u_id",u_id );
				resp.sendRedirect("listFIlm.do");
				//req.getRequestDispatcher("listFilm.jsp").forward(req, resp);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		default:
			//throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}
}
