<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.edutecno.jpacrud.modelo.Producto"%>
<%@page import="com.edutecno.jpacrud.VO.ProductoVO"%>
<%@page import="com.edutecno.jpacrud.controlador.ProductoController"%>

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
	<!-- Inicio Header -->
	<nav class="navbar navbar-dark bg-info">
		<a class="navbar-brand" href="#">EMPRESA LOGISTICA</a>
		<div class="navbar">
		
           
			<div class="navbar-nav">
				<form action="handleLogout" class="form-inline" method="POST">
					<a class="nav-item nav-link disabled mr-sm-2" href="#"
						tabindex="-1" aria-disabled="true">${usuarioConectado}</a> <input
						type="submit" class="btn btn-secondary my-2 my-sm-0"
						name="btnEnviar" value="Cerrar sesión">
				</form>
				
			</div>
		</div>
	</nav>
	<!-- Fin Header -->

	<!-- Inicio Contenido -->
	<div class="p-3">

		<!-- Inicio Mensajes -->
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<!-- Fin Mensajes -->
		<div class="fadeIn first">
				<img src="http://blog.desafiolatam.com/wp-content/uploads/2017/06/giphy-1.gif"
					id="icon" alt="User Icon" /></div>

	<aside>
	  	  <c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary  alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
			<form action="buscarForm" method="post"> </form>
          	
          		<p class="p-2"><label for="idProducto"></label></p>
					<p><input class="form-control" type="number" name="id"
						placeholder="Id_producto" ></p>
				
           <a href="buscarForm"  type="submit" 
					class="btn m-2 btn-secondary" value="buscar" >Buscar Producto</a>
			
        
       
     </aside>
     
     	<!-- Botón agregar usuario -->
     	<div>
		<a href="agregarForm" class="btn m-2 btn-primary">Agregar Producto</a>

			<ul class="pagination pagination-lg justify-content-center">
				<c:forEach items="${paginas}" var="pagina">
					<li class="page-item ${paginaActual == pagina ? 'disabled' : ''}"><a class="page-link" href="home?p=${pagina}" tabindex="-1">${pagina}</a></li>
				</c:forEach>
			</ul>
			
      </div>
      
      
		<!-- Inicio Tabla -->
		<table border="1" class="table table-hover">
			<thead class="thead-info">
				<tr>
					<th scope="col">IdProducto</th>
					<th scope="col">NombreProducto</th>
					<th scope="col">Precio</th>
					<th scope="col">Stock</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="productos"  items="${VO.productos}">
					<tr>
						<td><c:out value="${productos.idProducto}"/></td>
						<td><c:out value="${productos.nombreProducto}"/></td>
						<td><c:out value="${productos.precio}"/></td>
						<td><c:out value="${productos.stock}"/></td>
					
			
	                <td>
							<a href="editarForm?idProducto=${productos.idProducto}" class="btn btn-secondary btn-sm">Editar</a>
							<a href="eliminar?idProducto=${productos.idProducto}" class="btn btn-info btn-sm">Eliminar</a>
				    </td>
							</tr>
							</c:forEach>
			</tbody>
		</table>
		<!-- Fin tabla -->
	</div>

	<!-- Fin Contenido -->
</body>
</html>
