package edu.curso.java.bo;

import java.util.Date;

import javax.persistence.*;


public class Comentario {

	@Id
	@GeneratedValue
	private Long id;
	private String comentario;
	@ManyToOne
	private Usuario usuario;
	private Date fecha;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
