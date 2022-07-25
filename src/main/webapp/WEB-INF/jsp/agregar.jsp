<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.edutecno.jpacrud.modelo.Producto"%>
<%@page import="com.edutecno.jpacrud.VO.ProductoVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<title>JSP CRUD</title>
</head>
<body>

	<!-- Inicio Contenido -->
	<div class="p-3">

		<h1>Agregar Producto</h1>
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary  alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<form action="agregar" method="post">
			<table>
				<tr>
					<td class="p-2"><label for="idProducto">Id:</label></td>
					<td><input class="form-control" type="number" name="id"
						placeholder="Id_producto" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="nombreProducto">Nombre Producto:</label></td>
					<td><input class="form-control" type="text"
						placeholder="nombreProducto" name="nombreProducto" /></td>
				</tr>
				<tr>

					<td class="p-2"><label for="precio">Precio:</label></td>
					<td><input class="form-control" type="number"
						placeholder="precio" name="precio" /></td>
				  </tr>
				  <tr>
                   <td class="p-2"><label for="stock">Stock:</label></td>
					<td><input class="form-control" type="number"
						placeholder="stock" name="stock" /></td>
					</tr>
				<tr>
					<td colspan="2"><input type="submit"
						class="btn m-2 btn-primary" value="Agregar" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
