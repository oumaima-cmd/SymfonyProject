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
public interface Film {
	// Lister l'ensemble de films disponible au cinema.

	float createFilm(Filme f); 
}
