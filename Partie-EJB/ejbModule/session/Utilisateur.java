package session;

import java.util.List;

import javax.ejb.Remote;

import Entites.Compte;
import Exceptions.SoldeNegatifException;
import Exceptions.UserNotFoundException;

@Remote
public interface Utilisateur {
	//Initialiser le bean compte bancaire utilisateur (authentification)
	public void createUtilisateur(Compte c);
	public int init(String name, String passwd) throws UserNotFoundException;
	public String getName() throws UserNotFoundException;
	public float solde() throws SoldeNegatifException,UserNotFoundException;
	// D�biter le compte de l'utilisateur
	public void debite(float f) throws SoldeNegatifException,UserNotFoundException;
	public List<Compte> getUtilisateurs();
} 
