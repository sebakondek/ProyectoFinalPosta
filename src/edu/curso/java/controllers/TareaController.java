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
import edu.curso.java.controllers.forms.TareaForm;
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
	ComentarioDAO comentarioDAO;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProyectoService proyectoService;
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		log.info("Listando los tareas");
		List<Tarea> tareas = tareaService.listarTareas();
		model.addAttribute("tareas",tareas);
		return null;
	}
	
	@RequestMapping(value = "/vertarea")
	public String verTarea(@RequestParam Long idT, Long idP, Model model) {
		Tarea tarea = tareaService.recuperarTareaPorId(idT);
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(idP);
		model.addAttribute("tarea", tarea);
		model.addAttribute("proyecto", proyecto);
		return null;
	}
	
	@RequestMapping(value = "/borrartarea")
	public String borrarTarea(@RequestParam Long id, Model model) {
		tareaService.borrarTareaPorId(id);
		return "redirect:/tareas/listar.html";
	}
	
	@RequestMapping(value = "/nuevatarea")
	public String nuevaTarea(@RequestParam Long id, Model model) {
		
		TareaForm tareaForm = new TareaForm();
		tareaForm.setIdProyecto(id);
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(tareaForm.getIdProyecto());
		model.addAttribute("tiempoProyecto", proyecto.getTiempoReal());
		model.addAttribute("tareaForm", tareaForm);
		
		return "/tareas/form";
	}
	
	@RequestMapping(value = "/guardartarea", method = RequestMethod.POST)
	public String guardarTarea(@ModelAttribute("tareaForm") TareaForm tareaForm, Model model) {
		Tarea tarea = null;
		Long idActual = tareaForm.getId();
		if(idActual != null){
			tarea = tareaService.recuperarTareaPorId(idActual);
			tarea.setTitulo(tareaForm.getTitulo());
			tarea.setDuracionEstimada(tareaForm.getDuracionEstimada());
			tarea.setDuracionReal(0.0);
			tarea.setDescripcion(tareaForm.getDescripcion());
			tarea.setPrioridad(tareaForm.getPrioridad());
			proyectoService.editarTiempoProyecto(tareaForm.getDuracionEstimada(), tareaForm.getIdProyecto());
			tareaService.editarTarea(tarea);
		} else {
			//log.info("La id de PROYECTO en TareaController:" +tareaForm.getIdProyecto());
			tarea = new Tarea();
			tarea.setTitulo(tareaForm.getTitulo());
			tarea.setDuracionEstimada(tareaForm.getDuracionEstimada());
			tarea.setDuracionReal(0.0);
			tarea.setDescripcion(tareaForm.getDescripcion());
			tarea.setPrioridad(tareaForm.getPrioridad());
			proyectoService.editarTiempoProyecto(tareaForm.getDuracionEstimada(), tareaForm.getIdProyecto());
			tareaService.guardarTarea(tarea,tareaForm.getIdProyecto());
		}
	
		//return "redirect:/tareas/vertarea.html?id=" + idActual;
		return "redirect:/proyectos/listar.html";
	}
	
	@RequestMapping(value="/editartarea")
	public String editarTarea(Model model, @RequestParam Long id){
		Tarea tarea = tareaService.recuperarTareaPorId(id);
		TareaForm tareaForm = new TareaForm();
		
		tareaForm.setId(tarea.getId());
		tareaForm.setTitulo(tarea.getTitulo());
		tareaForm.setDescripcion(tarea.getDescripcion());
		tareaForm.setDuracionEstimada(tarea.getDuracionEstimada());
		tareaForm.setDuracionReal(tarea.getDuracionReal());
		tareaForm.setPrioridad(tarea.getPrioridad());
		
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(tareaForm.getIdProyecto());
		model.addAttribute("tiempoProyecto", proyecto.getTiempoReal());
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
	
	@RequestMapping(value = "/buscarcomentarios", method = RequestMethod.POST)
	public String buscarProyectos(@ModelAttribute("campoBuscar") String campoBuscar, Model model) {
		log.info("Listando los comentarios");
		List<Comentario> comentarios = tareaService.buscarComentarioPorContenido(campoBuscar);
		model.addAttribute("comentarios",comentarios);
		return "/comentarios/tarea-comentarios";
	}

}
