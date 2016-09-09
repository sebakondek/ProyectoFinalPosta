package edu.curso.java.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Comentario;
import edu.curso.java.controllers.forms.ComentarioForm;
import edu.curso.java.dao.ComentarioDAO;
import edu.curso.java.services.TareaService;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping("/comentarios")
public class ComentariosController {
	
	@Autowired
	ComentarioDAO comentarioDAO;
	
	@Autowired
	TareaService tareaService;
	
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value="/listarcomentarios", method = RequestMethod.GET)
	public String listarComentarios(Model model) {
		List<Comentario> comentarios = comentarioDAO.listarComentarios();
		model.addAttribute("comentarios", comentarios);
		return "/comentarios/listar";
	}
	
	@RequestMapping(value="/vercomentario")
	public String verComentario(@RequestParam Long id, Model model) {
		Comentario comentario = comentarioDAO.recuperarComentarioPorId(id);
		model.addAttribute("comentario", comentario);
		return "/comentarios/vercomentariomodal";
	}
	
	@RequestMapping(value="/nuevocomentario")
	public String nuevoComentario(@RequestParam Long id, Model model) {
		model.addAttribute("comentarioForm", new ComentarioForm());
		model.addAttribute("tarea", tareaService.recuperarTareaPorId(id));
		return "comentarios/form";
	}
	
	@RequestMapping(value="/borrarcomentario")
	public String borrarComentario(@RequestParam Long id) {
		comentarioDAO.borrarComentarioPorId(id);
		return "redirect:/comentarios/listar.html";
	}
	
	@RequestMapping(value = "/guardarcomentario", method = RequestMethod.POST)
	public String guardarComentario(@ModelAttribute("comentarioForm") ComentarioForm comentarioForm, Model model) {
		Comentario comentario = null;
		Long idActual = comentarioForm.getId();
		Long idUsuario = comentarioForm.getIdUsuario();
		if(idActual != null){
			comentario = comentarioDAO.recuperarComentarioPorId(idActual);
			comentario.setComentario(comentarioForm.getComentario());
			comentario.setUsuario(usuarioService.recuperarUsuarioPorId(idUsuario));
			comentario.setFecha(new Date());
			comentarioDAO.editarComentario(comentario);
		} else {
			comentario = new Comentario();
			comentario.setComentario(comentarioForm.getComentario());
			comentario.setUsuario(usuarioService.recuperarUsuarioPorId(idUsuario));
			comentario.setFecha(new Date());
			comentarioDAO.guardarComentario(comentario);
		}
	
		return "redirect:/tareas/vertarea.html?id=" + idActual;
	}
}
