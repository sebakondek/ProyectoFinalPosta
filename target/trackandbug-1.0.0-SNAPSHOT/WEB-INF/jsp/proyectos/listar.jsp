<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<h1>Listado de Proyectos</h1>

<button type="button" data-toggle="modal" onclick="opcionProyecto(0,'crear')" class="btn btn-primary">Editar</button>
					
<script>
	listarInit();
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