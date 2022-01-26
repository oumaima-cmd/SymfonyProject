package Entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="FILM")
@NamedQueries({
@NamedQuery(name="findAllFilms",query="SELECT f FROM Filme f")
})
public class Filme implements Serializable {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	 //le nom du propri�taire du compte bancaire
	private String name;
	
	//price of the film
	private float price;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
