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
@Table(name="SEANCE")
@NamedQueries({
	@NamedQuery(name="findAllSeance",query="SELECT s FROM Seance s")
})
public class Seance implements Serializable {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	 //le nom du propri�taire du compte bancaire
	private String name;
	
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
