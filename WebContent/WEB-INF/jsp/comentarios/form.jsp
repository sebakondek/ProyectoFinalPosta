<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	formInit("Comentarios");
</script>

<div class="modal-dialog" role="dialog">
	 <div class="modal-content">
	    <div class="modal-header">
       		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        	<h4 class="modal-title" id="myModalLabel"><b>Nuevo Comentario</b></h4>
      </div>
		<div class="modal-body" id="modal-body">

			<div class="form form-group table">
				<form:form method="post" modelAttribute="comentarioForm" action="../comentarios/guardarcomentario.html" 
						class="form" id="form">
					<form:input path="id" type="hidden" />
					<form:input path="idTarea" type="hidden" />
					<form:input path="idProyecto" type="hidden" />
					<div class="form-group">
						<label for="comentario">Comentario</label>
						<form:textarea class="form-control required" minlength="8" path="comentario" type="text" />
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success" value="Guardar">
					</div>
				</form:form>
			</div>
			
		</div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
</div>
