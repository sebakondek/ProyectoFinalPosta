package edu.curso.java.bo;

import javax.persistence.*;

@Entity
public class Roles {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
