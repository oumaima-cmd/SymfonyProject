package session;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entites.Compte;
import Exceptions.SoldeNegatifException;
import Exceptions.UserNotFoundException;

@Stateful
public class UtilisateurBean implements Utilisateur {
	
	@PersistenceContext()
	private EntityManager em = null;
	 private int user_id;
	 public UtilisateurBean() {
	 super();
	 }
	 
	 @Override
	public void createUtilisateur(Compte c) {
		 em.persist(c);
	 }
	 

	@Override
	public int init(String name, String passwd) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findCompteByName");
		 q.setParameter("cname",name);
		 List<Compte> res = (List<Compte>)q.getResultList();

		 if (res==null || res.size()==0) {
		 throw new UserNotFoundException();
		 }else{
		 if (res.get(0).getName().equals(name) && res.get(0).getPassword().equals(passwd)){
		 user_id = res.get(0).getId();
		 return user_id;
		 }else {
		 throw new UserNotFoundException();
		 }
		} 
	}

	@Override
	public String getName() throws UserNotFoundException {
		// TODO Auto-generated method stub
		String nom;
		Query q = em.createNamedQuery("findCompteById");
		 q.setParameter("cid",user_id);
		List<Compte> res = (List<Compte>)(q.getResultList());
		if(res.size()==0){
		 throw new UserNotFoundException();
		 }else{
		 nom = res.get(0).getName();
		}

		 return nom; 
	}

	@Override
	public float solde() throws SoldeNegatifException, UserNotFoundException {
		// TODO Auto-generated method stub
		float sld;
		 Query q = em.createNamedQuery("findCompteById");
		 q.setParameter("cid",user_id);
		 List<Compte> res = (List<Compte>)(q.getResultList());

		 if(res.size()==0)
		 throw new UserNotFoundException();
		 else
		 sld = res.get(0).getSolde(); 
		 return sld;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void debite(float somme) throws SoldeNegatifException, UserNotFoundException {
		// TODO Auto-generated method stub
			 float solde;
			 solde = solde();
			 if( solde+somme <= 0 ){
			throw new SoldeNegatifException();
			 }else{
			 Compte compte;
			 Query q = em.createNamedQuery("findCompteById");
			 q.setParameter("cid",user_id);
			 List<Compte> res = (List<Compte>)(q.getResultList());
			 if(res.size()==0){
			 throw new UserNotFoundException();
			 }else{
			 compte = res.get(0);
			 compte.setSolde(solde+somme);
			 em.merge(compte);
			 }
		}
		
	}

	@Override
	public List<Compte> getUtilisateurs() {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findAllComptes");
		List<Compte> res = (List<Compte>)(q.getResultList());
		return res;
	}
	
}
