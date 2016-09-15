package edu.curso.java.controllers.forms;

public class BuscarForm {

	private Long idTarea;
	private Long idProy;
	private String campoBuscar;
	
	
	public Long getIdProy() {
		return idProy;
	}
	public void setIdProy(Long idProy) {
		this.idProy = idProy;
	}
	public Long getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}
	public String getCampoBuscar() {
		return campoBuscar;
	}
	public void setCampoBuscar(String campoBuscar) {
		this.campoBuscar = campoBuscar;
	}
	
	
}
