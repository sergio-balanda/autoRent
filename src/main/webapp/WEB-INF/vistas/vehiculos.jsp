<%@include file='../../includes/head.jsp' %>
<title>Vehiculos</title>
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
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>Imagen</th>
								<th>Patente</th>
								<th>Marca</th>
								<th>Modelo</th>
								<th>Capacidad Pasajeros</th>
								<th>Capacidad Valijas</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<!--<c:set var="id_vehiculo" value="${0}" />-->
							<c:forEach items="${vehiculos}" var="vehiculo" >
								<tr>
									<td><img src="${vehiculo.imagen}" class="img-responsive" 
									style="display: inline" alt="" width="100" height="100"/></td>
									<td><c:out value="${vehiculo.patente}"/></td>
									<td><c:out value="${vehiculo.marca}" /></td>
									<td><c:out value="${vehiculo.nombre}" /></td>
									<td><c:out value="${vehiculo.capacidadPasajeros}" /></td>
									<td><c:out value="${vehiculo.capacidadValijas}" /></td>
									
									<c:url value="/generaReserva" var="displayURL">
										<c:param name="idVehiculo" value="${vehiculo.idVehiculo}" />
										<c:param name="fchdesde" value="${fch_desde}" />
										<c:param name="fchhasta" value="${fch_hasta}" />
										<c:param name="sucursal" value="${sucursal}" />
									</c:url> 
									<td><a href='<c:out value="${displayURL}" />'class="btn btn-primary" role="button">Seleccionar</a></td>
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