package edu.curso.java.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.dao.ProyectoDAO;
import edu.curso.java.dao.TareaDAO;

@Repository
public class TareaServiceImp implements TareaService {

	@Autowired
	TareaDAO tareaDAO;
	
	@Autowired
	ProyectoDAO proyectoDAO;

	@Override
	public Long guardarTarea(Tarea tarea) {
		return tareaDAO.guardarTarea(tarea);
	}

	@Override
	public List<Tarea> listarTareas() {
		return tareaDAO.listarTareas();
	}

	@Override
	public Tarea recuperarTareaPorId(Long id) {
		return tareaDAO.recuperarTareaPorId(id);
	}

	@Override
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto) {
		tareaDAO.agregarTareaProyecto(tarea, idProyecto);
	}

	@Override
	public void borrarTareaPorId(Long id) {
		tareaDAO.borrarTareaPorId(id);
	}

	@Override
	public void editarTarea(Tarea tarea) {
		tareaDAO.editarTarea(tarea);
	}

	@Override
	public List<Tarea> buscarTareaPorNombre(String campoBuscar) {
		return tareaDAO.buscarTareaPorNombre(campoBuscar);
	}

}
