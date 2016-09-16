package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Usuario;

@Repository
public class UsuarioDAOImp extends GenericDAOImp<Usuario, Long> implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	


	@Override
	public void borrarUsuarioPorId(Long id) {
		Usuario usuario = super.recuperarClasePorId(id);
		usuario.setEstado(false);	
		super.editarClase(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarUsuarios(String campoBuscar) {
		String hql = "from Usuario as u where u.estado = 1 and (u.nombreCompleto like :textoBuscar or u.usuario like :textoBuscar) ORDER BY u.nombreCompleto";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		return query.list();
	}
	
}
