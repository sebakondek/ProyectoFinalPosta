package edu.curso.java.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.dao.ComentarioDAO;
import edu.curso.java.dao.ProyectoDAO;
import edu.curso.java.dao.TareaDAO;

@Service
@Transactional
public class TareaServiceImp implements TareaService {

	@Autowired
	TareaDAO tareaDAO;
	
	@Autowired
	ProyectoDAO proyectoDAO;
	
	@Autowired
	private ComentarioDAO comentarioDAO;

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

	@Override
	public Long guardarComentario(Comentario comentario, Long idTarea) {

		comentario.setFecha(new Date());
		Tarea tarea = tareaDAO.recuperarTareaPorId(idTarea);
		comentarioDAO.guardarComentario(comentario);
		tarea.getComentarios().add(comentario);
		tareaDAO.editarTarea(tarea);
		return comentario.getId();
	}

}
