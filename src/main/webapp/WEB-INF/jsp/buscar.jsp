<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.edutecno.jpacrud.modelo.Producto"%>
<%@page import="com.edutecno.jpacrud.VO.ProductoVO"%>
<%@page import="com.edutecno.jpacrud.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<title>Producto Busqueda</title>
</head>
<body>
	    <div class="card text-center">
      <div class="card-header">
   </div>
     <div class="card-body  bg-ligth">
      <h3 class="card-title">PRODUCTO</h3>
     <p class="card-text" > 
      
      
				
	
                <p class="p-2"><label for="nombre">IdProducto:</label></p>
	         	<h4><c:out value="${resultado.findById()}"/></h4>
	          
			
					<p class="p-2"><label for="nombre">NombreProducto:</label></p>
					<h4><c:out value="${resultado.getnombreProducto(id)}"/></h4>
				
			
					<p class="p-2"><label for="precio">Precio:</label></p>
					<h4><c:out value="${resultado.getprecio(id)}"/></h4>
				
				
					<p class="p-2"><label for="stock">Stock:</label></p>
					<h4>	<c:out value="${resultado.getstock(id)}"/></h4>		
							
				
     <a href="home" class="btn btn-info">Volver</a> 
     
	 <div class="card-footer text-muted">
</div>

 </div>
	
   
  
</div>

</body>
</html>