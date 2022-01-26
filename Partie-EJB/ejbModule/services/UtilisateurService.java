package services;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import Entites.Compte;
import Exceptions.UserNotFoundException;
import session.Utilisateur;
import session.UtilisateurBean;

@Stateless
@WebService
public class UtilisateurService {
	@EJB
	private Utilisateur utilisateur;
	
	@WebMethod
	public void addCompe(@WebParam(name="solde") int soldeInit, @WebParam(name = "name") String name, @WebParam(name="password") String password) {
		Compte c = new Compte();
		c.setName(name);
		c.setPassword(password);
		c.setSolde(soldeInit);
		utilisateur.createUtilisateur(c);
	}
}
