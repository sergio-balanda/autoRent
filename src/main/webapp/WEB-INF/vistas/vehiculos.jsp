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
				<div class="panel-heading">Los vehiculos disponibles entre dia ${fch_desde} y dia ${fch_hasta} en Sucursal ${sucursal} </div>
				<div class="panel-body">
					<form action="generaReserva" method="GET">
					<!--  Lo unico que se me ocurrio para pasar datos al controlador que no selecciona el usuario 
					<input type="text" style="visibility:hidden;" name="fchdesde" value="${fch_desde}" />
					<input type="text" style="visibility:hidden;" name="fchhasta" value="${fch_hasta}" />
					<input type="text" style="visibility:hidden;" name="sucursal" value="${sucursal}" />-->
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
							<!--<c:set var="id_vehiculo" value="${0}" />-->
							<c:forEach items="${vehiculos}" var="vehiculo" >
								<tr>
									<td><img src="" /></td>
									<td><c:out value="${vehiculo.patente}"/></td>
									<td><c:out value="${vehiculo.marca}" /></td>
									<td><c:out value="${vehiculo.nombre}" /></td>
									<td><c:out value="${vehiculo.capacidadPasajeros}" /></td>
									<td><c:out value="${vehiculo.capacidadValijas}" /></td>
									<!-- Tambien trate con esto pero me muestra la url y no la manda por GET -->
									<!--<c:url value="/vehiculos" >
										<c:param name="id_vehiculo" value="${vehiculo.idVehiculo}" />
										<c:param name="fchdesde" value="${fch_desde}" />
										<c:param name="fchhasta" value="${fch_hasta}" />
										<c:param name="sucursal" value="${sucursal}" />
									</c:url>--> 
									<td><button type="submit" class="btn btn-primary">Generar Reserva</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>