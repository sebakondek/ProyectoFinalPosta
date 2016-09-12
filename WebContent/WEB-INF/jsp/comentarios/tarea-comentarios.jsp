<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <table class="table">
    <tr>
		<th class="text-center">Comentarios</th>
	</tr>

	<c:forEach items="${comentarios}" var="c">
		<tr>
			<td>${c.comentario}</td>
		</tr>
	</c:forEach>
	
  </table>