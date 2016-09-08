<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<h1>Listado de Usuarios</h1>

<a href="nuevousuario.html" class="btn btn-warning btnnuevo">Nuevo Usuario</a>

<script>
	$(document).ready(function(){
		var datos = $("#miFormBuscador").serialize();
		$.post("buscarusuarios.html", datos, function(resp) {
			$("#divResultado").html(resp);
		});
	
		$("#btnBuscar").click(function(){
			var datos = $("#miFormBuscador").serialize();
			$.post("buscarusuarios.html", datos, function(resp) {
				$("#divResultado").html(resp);
			});
		});
		
		$("#divResultado").delegate(".btn-ver-usuario", "click", function(){
			var id = $(this).data("id-usuario");
			$.get("verusuario.html?id=" + id, function(resp){
				$("#myModal").html(resp);
			$("#myModal").modal("show");
			});
		});
		
	});
</script>


<form id="miFormBuscador" method="post" action="buscarusuarios.html" class="form-inline">
	<div class="form-group">
		<input name="campoBuscar" class="form-control" id="campoBuscar" type="text" placeholder="Buscar">
	</div>
		<input type="button" class="btn btn-default" value="Buscar" id="btnBuscar">
</form>

<div id="divResultado" class="table-responsive"></div>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>


<c:import url="/general/template_bottom.jsp" />