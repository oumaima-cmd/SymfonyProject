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
import Entites.Filme;
import Exceptions.SoldeNegatifException;
import Exceptions.UserNotFoundException;
import session.Cinema;
import session.Film;
import session.Utilisateur;

@WebServlet(name="cinema", urlPatterns = {"cinema.do"})
public class Connected extends HttpServlet{
	
	@EJB
	private Cinema cinema;
	
	@EJB
	private Utilisateur utilisateur;
	
	@EJB
	private Film film;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String u_id = req.getParameter("u_id");
			float f_price= Integer .parseInt(req.getParameter("f_price"));
			//System.out.println(f_price);
			utilisateur.debite(f_price);
		} catch (SoldeNegatifException | UserNotFoundException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("films", cinema.list());
		req.getRequestDispatcher("Films.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		switch (action) {
		case "Ajouter": {	
			String name = req.getParameter("name");
			String prix = req.getParameter("price");
			Filme f = new Filme();
			f.setName(name);
			f.setPrice(Integer.parseInt(prix));
			film.createFilm(f);
			List<Compte> res = utilisateur.getUtilisateurs();
			req.setAttribute("utilisateurs",res );
			req.getRequestDispatcher("Films.jsp").forward(req, resp);
		}
	}
	}
}
