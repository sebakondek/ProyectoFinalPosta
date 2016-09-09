<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
$(function(){
	formInit("usuario");
})

</script>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="modal-dialog" role="dialog">
	 <div class="modal-content">
	    <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel"><b>${usuarioForm.nombreCompleto}</b></h4>
	    </div>
		<div class="modal-body" id="modal-body">
		<div class="form form-group table">
			<form:form method="post" modelAttribute="usuarioForm" action="guardaredicion.html" class="form">
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
					<input type="submit" class="btn btn-success" value="Editar">
					<a href="<c:url value="/usuarios/listar.html" />" class="btn btn-danger">Cancelar</a>
				</div>
			</form:form>
	  </div>
	  </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
</div>

