<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="form form-group">
	<form:form method="post" modelAttribute="usuarioForm" action="guardaredicion.html">
		<form:input path="id" type="hidden" />
		<div class="form-group">
			<label for="nombreCompleto">Nombre Completo</label>
			<form:input class="form-control" path="nombreCompleto" type="text" />
		</div>
		<div class="form-group">
			<label for="usuario">Usuario</label>
			<form:input class="form-control" path="usuario" type="text" />
		</div>
		<div class="form-group">
			<label for="password">Contraseña</label>
			<form:input class="form-control" path="password" type="password" />
		</div>
		<div class="form-group">
			<label for="activo">Activo<form:checkbox  path="activo"/></label>
		</div>
		
	</form:form>
	
	<input type="submit" class="btn btn-success" value="Crear">
	<a href="<c:url value="/usuarios/listar.html" />" class="btn btn-danger">Cancelar</a>
	
</div>
	

<c:import url="/general/template_bottom.jsp" />