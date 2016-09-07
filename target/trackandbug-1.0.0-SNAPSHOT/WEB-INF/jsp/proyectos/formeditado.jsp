<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<script>
$(function(){
	$(".form").validate();
	$("#select-single").select2();
	$(".js-example-basic-multiple").select2();
});

</script>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="form form-group">
	<form:form method="post" modelAttribute="proyectoForm" action="guardaredicionproyecto.html">
		<form:input path="id" type="hidden" />
			<div class="form-group">
				<label for="nombre">Titulo</label>
				<form:input class="form-control" path="nombre" type="text" minlength="4" required="true" />
			</div>
			<div class="form-group">
				<label for="descripcion">Descripcion</label>
				<form:textarea class="form-control" path="descripcion" minlength="8" required="true"/>
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
					path="idUsuarios" items="${usuarios}" itemLabel="nombreCompleto" itemValue="id"></form:select>
			</div>
			
		<input type="submit" class="btn btn-success" value="Editar">
		<a href="listar.html" class="btn btn-danger">Cancelar</a>
		
	</form:form>
</div>

<c:import url="/general/template_bottom.jsp" />