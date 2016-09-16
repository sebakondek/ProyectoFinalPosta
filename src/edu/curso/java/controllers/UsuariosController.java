package edu.curso.java.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.forms.UsuarioForm;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {

	private static final Logger log = Logger.getLogger(UsuariosController.class);
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = usuarioService.recuperarUsuarios();
		
		model.addAttribute("usuarios", usuarios);
		return null;
	}

	@RequestMapping(value = "/verusuario")
	public String verUsuarioModal(@RequestParam Long id, Model model) {
		Usuario usuario = usuarioService.recuperarUsuarioPorId(id);
		model.addAttribute("usuario", usuario);
		return "/usuarios/verusuariomodal";
	}

	@RequestMapping(value = "/borrarusuario")
	public String borrarUsuario(@RequestParam Long id, Model model) {
		usuarioService.borrarUsuario(id);
		return "redirect:/usuarios/listar.html";
	}

	@RequestMapping(value = "/nuevousuario")
	public String nuevoUsuario(@RequestParam boolean lugar, Model model) {
		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setLugar(lugar);
		model.addAttribute("usuarioForm", usuarioForm);
		return "/usuarios/form";
	}

	@RequestMapping(value = "/guardarusuario", method = RequestMethod.POST)
	public String guardarUsuario(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm, Model model) {

		boolean lugar = usuarioForm.isLugar();
		
		Usuario usuario = new Usuario();
		usuario.setNombreCompleto(usuarioForm.getNombreCompleto());
		usuario.setUsuario(usuarioForm.getUsuario());
		usuario.setPassword(usuarioForm.getPassword());
		
		Long idGenerado = usuarioService.crearNuevoUsuario(usuario);

		if(lugar)
			return "redirect:/proyectos/listar.html";
		return "redirect:/usuarios/listar.html";
	}

	@RequestMapping(value = "/editarusuario")
	public String editarUsuario(@RequestParam Long id, Model model) {
		Usuario usuario = usuarioService.recuperarUsuarioPorId(id);
		UsuarioForm usuarioForm= new UsuarioForm();
		
		usuarioForm.setEstado(usuario.getEstado());
		usuarioForm.setNombreCompleto(usuario.getNombreCompleto());
		usuarioForm.setUsuario(usuario.getUsuario());
		usuarioForm.setPassword(usuario.getPassword());
		usuarioForm.setId(usuario.getId());
		model.addAttribute("usuarioForm", usuarioForm);
		return "/usuarios/formeditado";
	}
	
	@RequestMapping(value = "/guardaredicion", method = RequestMethod.POST)
	public String guardarEdicion(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm, Model model,@RequestParam Long id) {

		Usuario usuario = usuarioService.recuperarUsuarioPorId(id);
		usuario.setNombreCompleto(usuarioForm.getNombreCompleto());
		usuario.setUsuario(usuarioForm.getUsuario());
		usuario.setPassword(usuarioForm.getPassword());
		usuario.setEstado(usuarioForm.getEstado());
		usuario.setId(id);
		usuarioService.editarUsuario(usuario);

		return "redirect:/usuarios/listar.html";
	}
	
	@RequestMapping(value = "/buscarusuarios", method = RequestMethod.POST)
	public String buscarUsuarios(@ModelAttribute("campoBuscar") String campoBuscar, Model model) {
		List<Usuario> usuarios = usuarioService.buscarUsuarios(campoBuscar);
		model.addAttribute("usuarios",usuarios);
		return "/usuarios/buscadorusuarios";
	}
}
