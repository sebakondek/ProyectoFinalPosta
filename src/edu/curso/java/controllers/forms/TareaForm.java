package edu.curso.java.controllers.forms;

import java.util.ArrayList;
import java.util.List;

import edu.curso.java.bo.Comentario;

public class TareaForm {

	private Long id;
	private String titulo;
	private Double duracionEstimada;
	private Double duracionReal;
	private String descripcion;
	private List<Comentario> comentarios = new ArrayList<>();
	private Long idProyecto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getDuracionEstimada() {
		return duracionEstimada;
	}
	public void setDuracionEstimada(Double duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}
	public Double getDuracionReal() {
		return duracionReal;
	}
	public void setDuracionReal(Double duracionReal) {
		this.duracionReal = duracionReal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public Long getIdProyecto(){
		return idProyecto;
	}
	public void setIdProyecto(Long idProyecto) {
		this.idProyecto=idProyecto;
	}
}
