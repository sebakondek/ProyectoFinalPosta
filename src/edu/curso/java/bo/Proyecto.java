package edu.curso.java.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Proyecto {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String descripcion;
	@ManyToOne
	private Usuario usuarioPrincipal;
	@ManyToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	@OneToMany(cascade=CascadeType.ALL)
	private List<Tarea> tareas = new ArrayList<>();
	private Boolean estado;
	private double tiempoEstimado;
	private Date fechaAlta;
	
	public Proyecto(){
		this.estado = true;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

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
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuarioPrincipal() {
		return usuarioPrincipal;
	}

	public void setUsuarioPrincipal(Usuario usuarioPrincipal) {
		this.usuarioPrincipal = usuarioPrincipal;
	}

	public double getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(double tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
	
}
