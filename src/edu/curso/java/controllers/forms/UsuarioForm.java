package edu.curso.java.controllers.forms;

public class UsuarioForm {

	private Long id;
	private String nombreCompleto;
	private String usuario;
	private String password;
	private boolean estado;
	private boolean lugar;
	
	
	
	public boolean isLugar() {
		return lugar;
	}
	public void setLugar(boolean lugar) {
		this.lugar = lugar;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
