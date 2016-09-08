/************************************FORM FUNCTIONS****************************************/

function formInit(clase){
	
	$(".form").validate();
	
	if (clase=="proyecto") {
		$("#select-single").select2();
		$(".js-example-basic-multiple").select2();	
	}
	
}


/****************************************LIST FUNCTIONS************************************/

$("#btnBuscarProy").click(function(){
	hacerBusquedaProy();
});

$("#campoBuscarProy").keypress(function (e) {
    if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
    	hacerBusquedaProy();
        return false;
    } else {
        return true;
    }
});

function listarInit(){
	hacerBusquedaProy();
	//hacerBusquedaTarea();
}

function hacerBusquedaProy() {
	var proyectos = $("#miFormBuscadorProy").serialize();
	$.post("buscarproyectos.html", proyectos, function(resp) {
		$("#divProyectos").html(resp);
	});
}

function hacerBusquedaTarea() {
	var tareas = $("#miFormBuscadorTareas").serialize();
	$.post("../tareas/buscartareas.html", tareas, function(resp){
		$("#divTareas").html(resp);
	});
}

/*********************************ABM Listado***********************************/
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
		case "borrar":
			break;
	}
			
		
}
	



