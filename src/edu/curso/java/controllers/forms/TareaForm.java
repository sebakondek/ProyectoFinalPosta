package edu.curso.java.controllers.forms;

public class TareaForm {

	private Long id;
	private String titulo;
	private Double duracionEstimada;
	private Double duracion;
	
	
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
	public Double getDuracion() {
		return duracion;
	}
	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	
}
