package services;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import session.Cinema;
import session.CinemaBean;

@Stateful
@WebService
public class CinemaService {
	@EJB
	private Cinema cinema;
	
	@WebMethod
	public void addFilm(@WebParam(name="name")String name) {
		cinema.createFilm(name);
	}
}
