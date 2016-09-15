package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;

@Repository
public class ComentarioDAOImp implements ComentarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Long guardarComentario(Comentario comentario) {
		return (Long) sessionFactory.getCurrentSession().save(comentario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> listarComentarios() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Comentario where estado=1");
		return query.list();
	}

	@Override
	public Comentario recuperarComentarioPorId(Long id){
		return (Comentario) sessionFactory.getCurrentSession().load(Comentario.class, id);
	}
	
	@Override
	public void borrarComentarioPorId(Long id) {
		Comentario comentario = this.recuperarComentarioPorId(id);
		comentario.setEstado(false);
		editarComentario(comentario);
	}

	@Override
	public void editarComentario(Comentario comentario) {
		sessionFactory.getCurrentSession().update(comentario);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> buscarComentario(String campoBuscar, Long idTarea) {
		String sql = "SELECT * FROM tarea_comentario as t INNER JOIN comentario as c ON t.comentarios_id = c.id where t.Tarea_id = :idTarea AND c.estado = 1 AND c.comentario LIKE :textoBuscar ORDER BY c.fecha";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Comentario.class);
		query.setLong("idTarea", idTarea );
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		return query.list();
	}
	
}
