<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehiculos</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<header class='page-header'>
		<div class="container-fluid bg-1">
			<img src="img/logo.jpg" class="img-responsive"
				style="display: inline" alt="" width="100" height="100">
			<h1 class="margin" style="display: inline; margin-left: 100px">Auto
				Rent</h1>
		</div>
		</header>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">Los vehiculos disponibles para su
					seleccion son:</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Imagen</th>
								<th>Patente</th>
								<th>Marca</th>
								<th>Modelo</th>
								<th>Capacidad Pasajeros</th>
								<th>Capacidad Valijas</th>
								<th>Seleccionar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${vehiculos}" var="vehiculo">
								<tr>
									<td><img src="" /></td>
									<td><c:out value="${vehiculo.patente}" /></td>
									<td><c:out value="${vehiculo.marca}" /></td>
									<td><c:out value="${vehiculo.nombre}" /></td>
									<td><c:out value="${vehiculo.capacidadPasajeros}" /></td>
									<td><c:out value="${vehiculo.capacidadValijas}" /></td>
									<td><a href="" class="btn btn-info">Ver</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>