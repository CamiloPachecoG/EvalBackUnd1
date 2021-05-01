<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Producto</title>
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
	
	
	<div class="container mt-5 justify-content-center col-md-5">
		<h1>Agregar Producto</h1>
		<form action="/productoAdd" method="POST">
			<div class="form-group">
				<label for="nombre">Nombre: </label>
				<input type="text" id="nombre" name="nombre" class="form-control">
			</div>
			<div class="form-group">
				<label for="precio">Precio: </label>
				<input type="number" id="precio" name="precio" class="form-control">
			</div>
			<div class="form-group">
				<label for="descripcion">Descripción: </label>
				<input type="text-area" id="descripcion" name="descripcion" class="form-control">
				<div style="color: red">${alerta}</div>
			</div>
			
			<button class="btn btn-block btn-outline-primary">Agregar</button>
		</form>
			<a href="listaProductos"><button class="btn btn-block btn-outline-primary mt-4" type="submit">Lista de Productos</button></a>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</html>