<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<script>
$(function(){
	$("#formusuario").validate();
})

</script>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="form form-group table">
	<form:form method="post" modelAttribute="usuarioForm" action="guardarusuario.html" id="formusuario">
		<form:input path="id" type="hidden" />
		<div class="form-group">
			<label for="nombreCompleto">Nombre Completo</label>
			<form:input class="form-control required" path="nombreCompleto" type="text" />
		</div>
		<div class="form-group">
			<label for="usuario">Usuario</label>
			<form:input class="form-control required" path="usuario" type="text" />
		</div>
		<div class="form-group">
			<label for="password">Contraseña</label>
			<form:input class="form-control required" path="password" type="password" />
		</div>
		<div class="form-group">
			<label for="activo">Activo<form:checkbox  path="activo"/></label>
		</div>
		<div>
			<input type="submit" class="btn btn-success" value="Guardar">
			<a href="<c:url value="/usuarios/listar.html" />" class="btn btn-danger">Cancelar</a>
		</div>
	</form:form>
</div>
	

<c:import url="/general/template_bottom.jsp" />