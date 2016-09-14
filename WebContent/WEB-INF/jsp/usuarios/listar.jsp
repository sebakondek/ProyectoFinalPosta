<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<h1>Listado de Usuarios</h1>

<a class="btn btn-warning btnnuevo" onclick="opcionUsuario(0,'crear')">Nuevo Usuario</a>

<script>
	listarInit("Usuario");
</script>

<form id="miFormBuscadorUsu" method="post" onsubmit="opcionUsuario(0,'buscar'); return false;" class="form-inline">
	<div class="form-group">
		<input name="campoBuscar" class="form-control" id="campoBuscarProy" type="text" placeholder="Buscar">
	</div>
		<input type="submit" class="btn btn-default" value="Buscar" >
</form>


<div id="divUsuarios" class="table-responsive"></div>

<div id="myModalUsu" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>


<c:import url="/general/template_bottom.jsp" />