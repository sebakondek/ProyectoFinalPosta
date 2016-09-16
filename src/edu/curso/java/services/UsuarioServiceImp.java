package edu.curso.java.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.bo.Usuario;
import edu.curso.java.dao.UsuarioDAO;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {

	private static final Logger log = Logger.
			getLogger(UsuarioServiceImp.class);
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/* (non-Javadoc)
	 * @see edu.curso.java.services.UsuarioService#crearNuevoUsuario(edu.curso.java.bo.Usuario)
	 */
	@Override
	public Long crearNuevoUsuario(Usuario usuario) {

		return usuarioDAO.guardarClase(usuario);
	}
	
	/* (non-Javadoc)
	 * @see edu.curso.java.services.UsuarioService#recuperarUsuarios()
	 */
	@Override
	public List<Usuario> recuperarUsuarios() {
		return usuarioDAO.listarClase(new Usuario());
	}
	
	/* (non-Javadoc)
	 * @see edu.curso.java.services.UsuarioService#recuperarUsuarioPorId(java.lang.Long)
	 */
	@Override
	public Usuario recuperarUsuarioPorId(Long id) {
		log.info("Recuperando el usuario con id: " + id);
		return usuarioDAO.recuperarClasePorId(id);
	}

	@Override
	public void borrarUsuario(Long id) {
		usuarioDAO.borrarUsuarioPorId(id);
	}
	
	public void editarUsuario(Usuario usuario) {
		usuarioDAO.editarClase(usuario);
	}

	@Override
	public List<Usuario> buscarUsuariosPorNombre(String campoBuscar) {
		return usuarioDAO.buscarUsuariosPorNombre(campoBuscar);
	}
}
