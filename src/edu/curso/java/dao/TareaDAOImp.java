package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.services.ProyectoService;

@Repository
public class TareaDAOImp implements TareaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProyectoService proyectoService;
	
	

	@Override
	public Long guardarTarea(Tarea tarea) {
		return (Long) sessionFactory.getCurrentSession().save(tarea);
	}

	@Override
	public List<Tarea> listarTareas() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Tarea where estado=1");
		return query.list();
	}

	@Override
	public Tarea recuperarTareaPorId(Long id) {
		return (Tarea) sessionFactory.getCurrentSession().load(Tarea.class, id);
	}

	@Override
	public void agregarTareaProyecto(Tarea tarea, Long idProyecto) {
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(idProyecto);
		proyecto.getTareas().add(tarea);		
	}

	@Override
	public List<Comentario> borrarTareaPorId(Long id) {
		Tarea tarea = this.recuperarTareaPorId(id);
		List<Comentario> comentarios = tarea.getComentarios();
		
		tarea.setEstado(false);
		editarTarea(tarea);
		
		return comentarios;
	}

	@Override
	public void editarTarea(Tarea tarea) {
		sessionFactory.getCurrentSession().update(tarea);
	}

	@Override
	public List<Tarea> buscarTareaPorNombre(String campoBuscar) {
		String hql = "from Tarea as t where t.titulo like :textoBuscar and estado=1";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		return query.list();
	}

}
