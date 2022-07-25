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
<title>EMPRESA LOGISTICA</title>
</head>
<body>
	
	

	<form action="handleLogin" method="POST" class="p-3">
	<h1>Iniciar sesi�n</h1>
	<c:if test="${mensaje != null ? true : false}">
		<div class="alert alert-secondary  alert-dismissible fade show"
			role="alert">${mensaje}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
		<div class="form-row align-items-center">
			<div class="col-auto">
				<label class="sr-only" for="nombre">Nombre</label> <input
					type="text" class="form-control mb-2" id="nombre" name="nombre"
					placeholder="Nombre de usuario">
			</div>
			<div class="col-auto">
				<label class="sr-only" for="clave">Contrase�a</label> <input
					type="password" class="form-control mb-2" id="clave" name="clave"
					placeholder="Contrase�a">
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-primary mb-2">Enviar</button>
			</div>
		</div>
	</form>



</body>
</html>
