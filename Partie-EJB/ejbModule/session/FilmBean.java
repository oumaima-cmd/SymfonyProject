package session;

import java.util.List;
import java.util.Set;

import javax.ejb.EntityContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entites.Compte;
import Entites.Filme;
import Entites.SalleProg;
import Entites.Seance;
import Exceptions.PlusDePlaceException;
import Exceptions.SoldeInsuffisantException;
import Exceptions.SoldeNegatifException;
import Exceptions.UserNotFoundException;


@Stateless
public class FilmBean implements Film{
	
	@PersistenceContext()
	private EntityManager em = null;
	private int film_id;
	public FilmBean() {
		super();
	}
	@Override
	public float createFilm(Filme f) {
		// TODO Auto-generated method stub
		em.persist(f);
		return 0;
	}
	
	
	
	
	
}
