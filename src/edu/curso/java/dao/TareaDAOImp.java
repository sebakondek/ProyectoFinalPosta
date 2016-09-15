package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarea> listarTareas() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Tarea as t where t.estado = 1 ORDER BY t.prioridad ASC, t.fecha DESC");
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarea> recuperarTareasProyecto(Long idProy) {
		String sql = "SELECT * FROM tarea as t INNER JOIN proyecto_tarea as p ON t.id = p.tareas_id WHERE p.Proyecto_id = :idProyecto " +
					"AND t.estado = 1 ORDER BY t.prioridad, t.fecha DESC";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Tarea.class);
		query.setLong("idProyecto", idProy);
		return query.list();
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Tarea> buscarTarea(String campoBuscar) {
//		String hql = "from Tarea as t where t.estado=1 and (t.titulo like :textoBuscar OR t.descripcion like :textoBuscar)";
//		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		query.setString("textoBuscar", "%" + campoBuscar + "%");
//		return query.list();
//	}

}
