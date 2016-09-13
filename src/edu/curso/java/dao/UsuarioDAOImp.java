package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Usuario;

@Repository
public class UsuarioDAOImp implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see edu.curso.java.dao.UsuarioDAO#guardarUsuario(edu.curso.java.bo.Usuario)
	 */
	@Override
	public Long guardarUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
		return usuario.getId();
	}
	
	/* (non-Javadoc)
	 * @see edu.curso.java.dao.UsuarioDAO#recuperarUsuarioPorId(java.lang.Long)
	 */
	@Override
	public Usuario recuperarUsuarioPorId(Long id) {
		return (Usuario) sessionFactory.getCurrentSession()
				.load(Usuario.class, id);
	}
	
	/* (non-Javadoc)
	 * @see edu.curso.java.dao.UsuarioDAO#recuperarUsuarios()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> recuperarUsuarios() {
		String hql = "from Usuario as u where u.activo = 1 order by u.nombreCompleto";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void borrarUsuarioPorId(Long id) {
		Usuario usuario = this.recuperarUsuarioPorId(id);
		usuario.setActivo(false);	
		editarUsuario(usuario);
	}
	
	@Override
	public void editarUsuario(Usuario usuario) {
		
		sessionFactory.getCurrentSession().update(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarUsuariosPorNombre(String campoBuscar) {
		String hql = "from Usuario as u where u.activo = 1 and (u.nombreCompleto like :textoBuscar or u.usuario like :textoBuscar)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("textoBuscar", "%" + campoBuscar + "%");
		return query.list();
	}
	
}
