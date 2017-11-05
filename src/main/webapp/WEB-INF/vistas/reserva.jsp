<%@include file='../../includes/head.jsp'%>
<title>Reserva</title>
</head>
<body>
	<c:set var="usuario" value="${usuario}" scope="session"/>
	<c:if test="${not empty usuario}">
		<p class="text-right text-muted"><b>Usuario:<b> ${usuario.nombre} para salir click click <a href="logout">aqu&iacute;.</a></p>
	</c:if>
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
				<div class="panel-heading">Detalles de la Reserva</div>
				<div class="panel-body">
					<p>Reserva para dia ${fechaDesde} hasta ${fechaHasta}</p>
					<p>Retira de Sucursal: ${sucursal}</p>
					<p>IdVehiculo Reservado: ${idVehiculo}</p>
					<hr>
					<div class="row">
						<div class="col-md-4">
							<img src="${vehiculo.imagen}" alt="imagen" class="img-responsive" />
						</div>
						<div class="col-md-5">
							<div class="page-header">
								<h2>${vehiculo.nombre}</h2>
							</div>
							<h3>${vehiculo.nombre}&nbsp;${vehiculo.marca}</h3>
							<p>
								<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
								${vehiculo.capacidadPasajeros} equipajes
							</p>
							<p>
								<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
								${vehiculo.capacidadValijas} plazas
							</p>
						</div>
						<div class="col-md-3">
							<h1>
								<span class="label label-success"> ${precioVehiculo} </span>
							</h1>
							<hr>
							<form:form action="guardar-reserva" method="POST">
								<input type="hidden" name="idVehiculo" id="idVehiculo"
									value="${idVehiculo}" />
								<input type="hidden" name="usuario" id="usuario"
									value="${usuario.id}" />
								<input type="hidden" name="fechaDesde" id="fechaDesde"
									value="${fechaDesde}" />
								<input type="hidden" name="fechaHasta" id="fechaHasta"
									value="${fechaHasta}" "/>
								<input type="hidden" value="${sucursal}" name="sucursal"
									id="sucursal" />
								<a href="pasajeros" class="btn btn-danger"><span
									class="glyphicon glyphicon-remove"></span>&nbsp;Cancelar</a>
								<button type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-ok"></span>&nbsp;Confirmar
								</button>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>