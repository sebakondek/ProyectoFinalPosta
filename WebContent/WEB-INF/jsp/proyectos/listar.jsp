<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<h1>Listado de Proyectos</h1>

<a class="btn btn-warning btnnuevo" onclick="opcionProyecto(0,'crear')">Nuevo Proyecto</a>
					
<script>
	listarInit();
</script>

<form id="miFormBuscadorProy" method="post" onsubmit="opcionProyecto(0,'buscar'); return false;" class="form-inline">
	<div class="form-group">
		<input name="campoBuscar" class="form-control" id="campoBuscarProy" type="text" placeholder="Buscar">
	</div>
		<input type="submit" class="btn btn-default" value="Buscar" id="btnBuscarProy">
</form>



<div id="divProyectos" class="table-responsive"></div>

<div id="divTareas" class="table-responsive"></div>

<div id="myModalProy" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-top: 5%;"></div>

<c:import url="/general/template_bottom.jsp" />