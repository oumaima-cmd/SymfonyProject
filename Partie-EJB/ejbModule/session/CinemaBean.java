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
public class CinemaBean implements Cinema{
	
	@PersistenceContext()
	private EntityManager em = null;
	private int cinema_id;
	public CinemaBean() {
		super();
	}
	
	
	
	@Override
	public List<Filme> list() {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findAllFilms");
		List<Filme> res = (List<Filme>)(q.getResultList());
		return res;
	}

	@Override
	public Set<Filme> findByPattern(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filme findFilm(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reserve(Seance seance, Utilisateur u)
			throws PlusDePlaceException, SoldeInsuffisantException, UserNotFoundException, SoldeNegatifException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<SalleProg> getAllSalleProg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filme createFilm(String name) {
		// TODO Auto-generated method stub
		Filme f= new Filme();
		f.setName(name);
		em.persist(f);
		return null;
	}

	@Override
	public void update(Filme f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getTarif() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
