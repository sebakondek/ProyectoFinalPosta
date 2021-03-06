package edu.curso.java.bo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"usuario"}))
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombreCompleto;
	private String usuario;
	private String password;
	private boolean estado;
	@OneToMany
	private List<Roles> rol;
	
	
	public Usuario(){
		this.estado=true;
	}
	
	
	public Usuario(String nombreCompleto, String usuarioPassword, String usuarioPerfil) {
		// TODO Auto-generated constructor stub
		this.setNombreCompleto(nombreCompleto);
		this.setPassword(usuarioPassword);
		this.setUsuario(usuarioPerfil);
	}


	public List<Roles> getRol() {
		return rol;
	}
	public void setRol(List<Roles> rol) {
		this.rol = rol;
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
	public void setEstado(boolean activo) {
		this.estado = activo;
	}
	
}
