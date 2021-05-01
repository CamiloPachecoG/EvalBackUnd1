<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">CRUD SpringBoot JSP</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/usuario">Agregar Usuario</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/producto">Agregar Producto</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/venta">Venta</a>
	      </li>
	    </ul>
	  </div>
	</nav>

	<div class="container mt-5 justify-content-center">
		<h1>Lista de Productos</h1>
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Nombre</th>
		      <th scope="col">Precio</th>
		      <th scope="col">Descripción</th>
		      <th scope="col"></th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var = "productos" items="${listaProductos}">
		    <tr>
		      <td><c:out value = "${productos.nombre}"/><p></td>
		      <td><c:out value = "${productos.precio}"/><p></td>
		      <td><c:out value = "${productos.descripcion}"/><p></td>
		      <td><a href="">Editar</a></td>
		      <td><a href="/producto/${productos.id}">Eliminar</a></td>
		    </tr>
		   </c:forEach>
		  </tbody>
		</table>
		
	</div>
      
      
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</html>