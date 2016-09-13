/************************************FORM FUNCTIONS****************************************/

function formInit(clase){
	
	$(".form").validate();
	
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
		$.post("buscarUsuarios.html", datosDelForm, function(resp) {
			$("#divUsuarios").html(resp);
		});	
		break;

	case "Proyecto":
		var datosDelForm = $("#miFormBuscadorProy").serialize();
		$.post("buscarproyectos.html", datosDelForm, function(resp) {
			$("#divProyectos").html(resp);
		});	
		break;
		
	case "Comentarios":
		var datosDelForm = $("#miFormBuscadorComent").serialize();
		$.post("buscarcomentarios.html",datosDelForm, function(resp){
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
					$.get("editarUsuario.html?id=" + id, function(resp){
						$("#myModalUsu").html(resp);
						$("#myModalUsu").modal("show");
					});
					break;
				
				case "ver":	
					$.get("verUsuario.html?id=" + id, function(resp){
						$("#myModalUsu").html(resp);
						$("#myModalUsu").modal("show");
					});
					break;
				case "crear":
					$.get("nuevoUsuario.html", function(resp){
						$("#myModalUsu").html(resp);
						$("#myModalUsu").modal("show");
					});
					break;

				case "buscar":
					var usuarios = $("#miFormBuscadorUsu").serialize();
					$.post("buscarUsuarios.html", usuarios, function(resp){
						$("#divUsuarios").html(resp);
					});
					break;
					
				default:
					 Alert("Acaba de ocurrir un error. Por favor contactese con los areperos...")
					break;
			}	
}
/*********************************ABM Listado COMENTARIOS***********************************/
function opcionComentario(opcion){
	
	switch (opcion) {
		case "buscar":
			var datosDelForm = $("#miFormBuscadorComent").serialize();
			$.post("buscarcomentarios.html",datosDelForm, function(resp){
				$("#divComentarios").html(resp);
			});
			break;
			
		default:
			 Alert("Acaba de ocurrir un error. Por favor contactese con los areperos...")
			break;
	}	
}
/*******************************ALERTS************************************************/
function noTieneHorasAsignadas(usuarioPpal){
	alert("Usted no tiene horas para asignarle a la tarea, contactese con "+ usuarioPpal +" para que le asigne");
}