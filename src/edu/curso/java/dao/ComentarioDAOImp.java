package edu.curso.java.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;
import edu.curso.java.controllers.ComentariosController;

@Repository
public class ComentarioDAOImp extends GenericDAOImp<Comentario, Long>implements ComentarioDAO  {

	private static final Logger log = Logger.getLogger(ComentarioDAOImp.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
		
	@Override
	public void borrarComentarioPorId(Long id) {
		Comentario comentario = super.recuperarClasePorId(id);
		comentario.setEstado(false);
		super.editarClase(comentario);
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
