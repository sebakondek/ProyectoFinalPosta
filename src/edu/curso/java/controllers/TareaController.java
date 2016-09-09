package edu.curso.java.controllers;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.forms.ComentarioForm;
import edu.curso.java.controllers.forms.ProyectoForm;
import edu.curso.java.controllers.forms.TareaForm;
import edu.curso.java.controllers.forms.UsuarioForm;
import edu.curso.java.dao.ComentarioDAO;
import edu.curso.java.services.ProyectoService;
import edu.curso.java.services.TareaService;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping("/tareas")
public class TareaController {

	private static final Logger log = Logger.getLogger(TareaController.class);
	
	@Autowired
	private TareaService tareaService;
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	ComentarioDAO comentarioDAO;
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		log.info("Listando los tareas");
		List<Tarea> tareas = tareaService.listarTareas();
		model.addAttribute("tareas",tareas);
		return null;
	}
	
	@RequestMapping(value = "/vertarea")
	public String verTarea(@RequestParam Long id, Model model) {
		Tarea tarea = tareaService.recuperarTareaPorId(id);
		model.addAttribute("tarea", tarea);
		return "/tareas/vertareamodal";
	}
	
	@RequestMapping(value = "/borrartarea")
	public String borrarTarea(@RequestParam Long id, Model model) {
		tareaService.borrarTareaPorId(id);
		return "redirect:/tareas/listar.html";
	}
	
	@RequestMapping(value = "/nuevatarea")
	public String nuevaTarea(@RequestParam Long id, Model model) {
		model.addAttribute("tareaForm", new TareaForm());
		model.addAttribute("proyecto", proyectoService.recuperarProyectoPorId(id));
		return "/tareas/form";
	}
	
	@RequestMapping(value = "/guardartarea", method = RequestMethod.POST)
	public String guardarTarea(@ModelAttribute("tareaForm") TareaForm tareaForm, Model model) {
		Tarea tarea = null;
		Long idActual = tareaForm.getId();
		if(idActual != null){
			tarea = tareaService.recuperarTareaPorId(idActual);
			tarea.setTitulo(tareaForm.getTitulo());
			tarea.setDuracionEstimada(tareaForm.getDuracion());
			tareaService.editarTarea(tarea);
		} else {
			tarea = new Tarea();
			tarea.setTitulo(tareaForm.getTitulo());
			tarea.setDuracionEstimada(tareaForm.getDuracion());
			tareaService.guardarTarea(tarea);
		}
	
		return "redirect:/tareas/vertarea.html?id=" + idActual;
	}
	
	@RequestMapping(value="/editartarea")
	public String editarTarea(Model model, @RequestParam Long id){
		Tarea tarea = tareaService.recuperarTareaPorId(id);
		TareaForm tareaForm = new TareaForm();
		
		tareaForm.setId(tarea.getId());
		tareaForm.setTitulo(tarea.getTitulo());
		tareaForm.setDuracion(tarea.getDuracionEstimada());
	
		model.addAttribute("tareaForm", tareaForm);
		return "/tareas/formeditado";
	}
	
		
	@RequestMapping(value = "/buscartareas", method = RequestMethod.POST)
	public String buscarTareas(@ModelAttribute String campoBuscar, Model model) {
		log.info("Listando los proyectos");
		List<Tarea> tareas = tareaService.buscarTareaPorNombre(campoBuscar);
		model.addAttribute("tareas",tareas);
		return "/tareas/buscadortareas";
	}
	
	
	
	
//	Seccion Comentarios
	
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
