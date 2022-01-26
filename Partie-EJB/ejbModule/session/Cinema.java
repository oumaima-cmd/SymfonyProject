package session;


import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import Entites.Filme;
import Entites.SalleProg;
import Entites.Seance;
import Exceptions.PlusDePlaceException;
import Exceptions.SoldeInsuffisantException;
import Exceptions.SoldeNegatifException;
import Exceptions.UserNotFoundException;

@Remote
public interface Cinema {
	// Lister l'ensemble de films disponible au cinema.
	 public List<Filme> list ();
	 // Trouver les films correspondants au pattern donn� en entr�e.
	 public Set<Filme> findByPattern (String pattern);
	 // Trouver un film � partir d'un id.
	 public Filme findFilm (int id);
	 // R�server une s�ance pour un utilisateur.
	 public void reserve (Seance seance, Utilisateur u) throws PlusDePlaceException, SoldeInsuffisantException, UserNotFoundException, SoldeNegatifException;
	 public Set<SalleProg> getAllSalleProg ();
	 public Filme createFilm (String name);
	 public void update (Filme f);
	 public float getTarif (); 
}
