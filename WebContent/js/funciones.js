/************************************FORM FUNCTIONS****************************************/

function formInit(clase){
	
	var campotexto= "<span style='color: red;'>Solo caracteres de A-z estan permitidos </span>";
	$("#form").validate({
	
		messages : {
			nombre : campotexto,
			nombreCompleto : campotexto,
			usuario : campotexto,
			descripcion: campotexto,
			titulo : "<span style='color: red;'>El titulo debe ser alfanumerico</span>",
			duracionEstimada: "<span style='color: red;'>solo puede ingresar numeros hasta la duracion estimada del proyecto</span>", 
			tiempoEstimado: "<span style='color: red;'>solo puede ingresar numeros</span>",
			password : "<span style='color: red;'>Solo se permiten caracteres A-z y 0-9</span>"		
		}
	});
	
	if (clase=="proyecto") {
		$("#select-single").select2();
		$(".js-example-basic-multiple").select2();	
	}
	
}


/****************************************LIST FUNCTIONS************************************/

function listarInit(clase){
		hacerBusqueda(clase);	
}

function hacerBusqueda(clase) {
	
	switch (clase) {
	
	case "Usuario":
		var datosDelForm = $("#miFormBuscadorUsu").serialize();
		$.post("buscarusuarios.html", datosDelForm, function(resp){
			$("#divUsuarios").html(resp);
		});
		break;

	case "Proyecto":
		var datosDelForm = $("#miFormBuscadorProy").serialize();
		$.post("buscarproyectos.html", datosDelForm, function(resp) {
			$("#divProyectos").html(resp);
		});	
		break;
		
	case "Comentario":
		var datosDelForm = $("#miFormBuscadorComent").serialize();
		$.post("../comentarios/buscarcomentarios.html", datosDelForm, function(resp){
			$("#divComentarios").html(resp);
		});
		break;

	default:
		break;
	}
	
}

function hacerBusquedaTarea() {
	var tareas = $("#miFormBuscadorTareas").serialize();
	$.post("../tareas/buscartareas.html", tareas, function(resp){
		$("#divTareas").html(resp);
	});
}

/*********************************ABM Listado PROYECTO***********************************/
function opcionProyecto(id, opcion){
	
	switch (opcion) {
	
	
		case "editar":
			$.get("editarProyecto.html?id=" + id, function(resp){
				$("#myModalProy").html(resp);
				$("#myModalProy").modal("show");
			});
			break;
		
		case "ver":	
			$.get("verproyecto.html?id=" + id, function(resp){
				$("#myModalProy").html(resp);
				$("#myModalProy").modal("show");
			});
			break;
		case "crear":
			$.get("nuevoproyecto.html", function(resp){
				$("#myModalProy").html(resp);
				$("#myModalProy").modal("show");
			});
			break;
			
		case "crearUsuario":
			$("myModalProy").modal("hide");
			$.get("../usuarios/nuevousuario.html?lugar=" + id, function(resp){
				$("#myModalProy").html(resp);
				$("#myModalProy").modal("show");
			});
			break;

		case "buscar":
			var proyectos = $("#miFormBuscadorProy").serialize();
			$.post("buscarproyectos.html", proyectos, function(resp){
				$("#divProyectos").html(resp);
			});
			break;
			
		default:
			 Alert("Acaba de ocurrir un error. Por favor contactese con los areperos...")
			break;
	}
		
}
		
/*******************************ABM LISTADO USUARIO************************************/
function opcionUsuario(id, opcion){
			
			switch (opcion) {
			
				case "editar":
					$.get("editarusuario.html?id=" + id, function(resp){
						$("#myModalUsu").html(resp);
						$("#myModalUsu").modal("show");
					});
					break;
				
				case "ver":	
					$.get("verusuario.html?id=" + id, function(resp){
						$("#myModalUsu").html(resp);
						$("#myModalUsu").modal("show");
					});
					break;
				case "crear":
					$.get("nuevousuario.html?lugar=" + id, function(resp){
						$("#myModalUsu").html(resp);
						$("#myModalUsu").modal("show");
					});
					break;

				case "buscar":
					var usuarios = $("#miFormBuscadorUsu").serialize();
					$.post("buscarusuarios.html", usuarios, function(resp){
						$("#divUsuarios").html(resp);
					});
					break;
					
				default:
					 Alert("Acaba de ocurrir un error. Por favor contactese con los areperos...")
					break;
			}	
}
/*********************************ABM Listado COMENTARIOS***********************************/
function opcionComentario(idC, idT, idP, opcion){
	
	switch (opcion) {
	
		case "buscar":
			var datosDelForm = $("#miFormBuscadorComent").serialize();
			$.post("../comentarios/buscarcomentarios.html", datosDelForm, function(resp){
				$("#divComentarios").html(resp);
			});
			break;
			
		case "crear":
			$.get("../comentarios/nuevocomentario.html?idT=" + idT + "&idP=" + idP, function(resp){
				$("#myModalComent").html(resp);
				$("#myModalComent").modal("show");
			});
			break;
			
		case "editar":
			$.get("../comentarios/editarcomentario.html?idC=" + idC + "&idT=" + idT + "&idP=" + idP, function(resp){
				$("#myModalComent").html(resp);
				$("#myModalComent").modal("show");
			});
			break;
			
		default:
			 alert("Acaba de ocurrir un error. Por favor contactese con los areperos...")
			break;
	}	
}

/*******************************Tareas************************************************/


function opcionTarea(idP, idT, opcion){
	
	switch (opcion) {
	
		case "crear":
				$("#myModalProy").modal("hide");
			$.get("../tareas/nuevatarea.html?idP=" + idP, function(resp){
				$("#myModalProy").html(resp);
				$("#myModalProy").modal("show");
			});
			break;
			
		case "editar":
			$.get("../tareas/editartarea.html?idT=" + idT + "&idP=" + idP, function(resp){
				$("#myModalTarea").html(resp);
				$("#myModalTarea").modal("show");
			});
			break;
	}
}
/*******************************ALERTS************************************************/
function noTieneHorasAsignadas(usuarioPpal){
	alert("Usted no tiene horas para asignarle a la tarea, contactese con "+ usuarioPpal +" para que le asigne");
}