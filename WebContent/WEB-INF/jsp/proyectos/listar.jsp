<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<h1>Listado de Proyectos</h1>

<a href="<c:url value="/proyectos/nuevoproyecto.html" />" class="btn btn-warning btnnuevo">Nuevo Proyecto</a>

<script>
	$(document).ready(function(){
		
		hacerBusquedaProy();
		hacerBusquedaTarea();
		
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
		
		
		$("#divProyectos").delegate(".btn-ver-proyecto", "click", function(){
			var id = $(this).data("id-proyecto");
			$.get("verproyecto.html?id=" + id, function(resp){
				$("#myModalProy").html(resp);
			$("#myModalProy").modal("show");
			});
		});
		
	});
	
	function hacerBusquedaProy() {
		var proyectos = $("#miFormBuscadorProy").serialize();
		$.post("buscarproyectos.html", proyectos, function(resp) {
			$("#divProyectos").html(resp);
		});
	}
	
	function hacerBusquedaTarea() {
		var tareas = $("#miFormBuscadorTareas").serialize();
		$.post("<c:url value='/tareas/buscartareas.html'/>", tareas, function(resp){
			$("#divTareas").html(resp);
		});
	}
</script>



<form id="miFormBuscadorProy" method="post" action="buscarproyectos.html" class="form-inline">
	<div class="form-group">
		<input name="campoBuscar" class="form-control" id="campoBuscarProy" type="text" placeholder="Buscar">
	</div>
		<input type="button" class="btn btn-default" value="Buscar" id="btnBuscarProy">
</form>

<div id="divProyectos" class="table-responsive"></div>






<div id="divTareas" class="table-responsive"></div>

<div id="myModalProy" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>

<c:import url="/general/template_bottom.jsp" />