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

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.forms.ProyectoForm;
import edu.curso.java.services.ProyectoService;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping("/proyectos")
public class ProyectosController {

	private static final Logger log = Logger.getLogger(ProyectosController.class);
	
	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		log.info("Listando los proyectos");
		List<Proyecto> proyectos = proyectoService.listarProyectos();
		model.addAttribute("proyectos",proyectos);
		return null;
	}
	
	@RequestMapping(value = "/verproyecto")
	public String verProyecto(@RequestParam Long id, Model model) {
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(id);
		model.addAttribute("proyecto", proyecto);
		return "/proyectos/verproyectomodal";
	}
	
	@RequestMapping(value = "/borrarproyecto")
	public String borrarProyecto(@RequestParam Long id, Model model) {
		proyectoService.borrarProyectoPorId(id);
		return "redirect:/proyectos/listar.html";
	}
	
	@RequestMapping(value = "/nuevoproyecto")
	public String nuevoProyecto(Model model) {
		model.addAttribute("proyectoForm", new ProyectoForm());
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", usuarioService.recuperarUsuarios());
		return "/proyectos/form";
	}
	
	@RequestMapping(value = "/guardarproyecto", method = RequestMethod.POST)
	public String guardarProyecto(@ModelAttribute("proyectoForm") ProyectoForm proyectoForm, Model model) {
		Proyecto proyecto= null;
		Long idActual = proyectoForm.getId();
		Long idUsuarioPrincipal = proyectoForm.getIdUsuarioPrincipal();
		Long [] idUsuarios = proyectoForm.getIdUsuarios();
		
		if(idActual != null){
			proyecto= proyectoService.recuperarProyectoPorId(idActual);
			proyecto.setNombre(proyectoForm.getNombre());
			proyecto.setDescripcion(proyectoForm.getDescripcion());
			proyecto.setTiempoEstimado(proyectoForm.getTiempoEstimado());
			proyecto.setTiempoReal(proyectoForm.getTiempoEstimado() - proyecto.getTiempoAcumulado());
			idActual = proyectoService.actualizarProyecto(proyecto,idUsuarioPrincipal, idUsuarios);
		} else {
			proyecto = new Proyecto();
			proyecto.setFechaAlta(new Date());
			proyecto.setNombre(proyectoForm.getNombre());
			proyecto.setDescripcion(proyectoForm.getDescripcion());
			proyecto.setTiempoEstimado(proyectoForm.getTiempoEstimado());
			proyecto.setTiempoReal(proyectoForm.getTiempoEstimado());
			proyecto.setTiempoAcumulado(0.0);
			idActual = proyectoService.actualizarProyecto(proyecto, idUsuarioPrincipal, idUsuarios);
		}
	
		return "redirect:/proyectos/listar.html";
	}
	
	@RequestMapping(value="/editarProyecto")
	public String editarUsuario(Model model, @RequestParam Long id){
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(id);
		ProyectoForm proyectoForm = new ProyectoForm();
		
		proyectoForm.setId(proyecto.getId());
		proyectoForm.setDescripcion(proyecto.getDescripcion());
		proyectoForm.setNombre(proyecto.getNombre());
		proyectoForm.setIdUsuarioPrincipal(proyecto.getUsuarioPrincipal().getId());
		proyectoForm.setUsuarios(proyecto.getUsuarios());
		proyectoForm.setTareas(proyecto.getTareas());
		proyectoForm.setTiempoEstimado(proyecto.getTiempoEstimado());
		model.addAttribute("proyectoForm", proyectoForm);
		model.addAttribute("usuarios", usuarioService.recuperarUsuarios());
		return "/proyectos/formeditado";
	}
	
	
		
	@RequestMapping(value = "/buscarproyectos", method = RequestMethod.POST)
	public String buscarProyectos(@ModelAttribute("campoBuscar") String campoBuscar, Model model) {
		log.info("Listando los proyectos");
		List<Proyecto> proyectos = proyectoService.buscarProyectosPorNombre(campoBuscar);
		model.addAttribute("proyectos",proyectos);
		return "/proyectos/buscadorproyectos";
	}
	
	
}
