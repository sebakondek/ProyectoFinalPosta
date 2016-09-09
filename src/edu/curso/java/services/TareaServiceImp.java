package edu.curso.java.services;

import java.util.Date;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.dao.ComentarioDAO;
import edu.curso.java.dao.ProyectoDAO;
import edu.curso.java.dao.TareaDAO;

@Service
@Transactional
public class TareaServiceImp implements TareaService {

	private static final Logger log = Logger.getLogger(TareaServiceImp.class);
	
	@Autowired
	TareaDAO tareaDAO;
	
	@Autowired
	ProyectoDAO proyectoDAO;
	
	@Autowired
	private ComentarioDAO comentarioDAO;

	@Override
	public void guardarTarea(Tarea tarea, Long idProyecto) {
		tareaDAO.guardarTarea(tarea);
		//log.info("ID de Proyecto en TAREA SERVICE: "+idProyecto);
		Proyecto proyecto = proyectoDAO.recuperarProyectoPorId(idProyecto);
		proyecto.getTareas().add(tarea);
		proyectoDAO.editarProyecto(proyecto);
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
