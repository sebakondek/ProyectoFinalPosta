<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<script>
$(function(){
	formInit("proyecto");
});

</script>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:choose>
	<c:when test="${proyectoForm.nombre != null}">
		<div class="modal-dialog" role="dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel"><b>${proyectoForm.nombre}</b></h4>
	    </div>
	    <div class="modal-body" id="modal-body">
	</c:when>
</c:choose>

<div class="form form-group table">
	<form:form method="post" modelAttribute="proyectoForm" action="guardaredicionproyecto.html">
		<form:input path="id" type="hidden" />
		<div class="form-group">
			<label for="nombre">Nombre</label>
			<form:input class="form-control required" path="nombre" type="text" minlength="4" required="true" />
		</div>
		<div class="form-group">
			<label for="descripcion">Descripcion</label>
			<form:textarea class="form-control required" path="descripcion" minlength="8" required="true"/>
		</div>
		<div class="form-group">
			<label for="idUsuarioPrincipal">Usuario Principal</label>
			<form:select path="idUsuarioPrincipal" id="select-single" class="js-example-basic-single js-states form-control" 
				items="${usuarios}" itemLabel="nombreCompleto" itemValue="id">
			<option></option>
			</form:select>
		</div>
		<div class="form-group">
			<label for="idUsuarios">Usuarios</label>
			<form:select id="select-multiple" class="js-example-basic-multiple js-states form-control" multiple="multiple" 
				path="idUsuarios" items="${usuarios}" itemLabel="nombreCompleto" itemValue="id">
			</form:select>
		</div>
		<div>	
			<input type="submit" class="btn btn-success" value="Editar">
			<a href="listar.html" class="btn btn-danger">Cancelar</a>
		</div>
	</form:form>
</div>
<c:choose>
	<c:when test="${ proyectoForm.nombre != null}">
	 </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
	      </div>
	    </div>
	</div>
	</c:when>
</c:choose>
<c:import url="/general/template_bottom.jsp" />