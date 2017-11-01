<%@include file='../../includes/head.jsp' %>
	<title>Reserva</title>
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
				<div class="panel-heading">Detalles de la Reserva</div>
				<div class="panel-body">
					<p> Reserva para dia ${fdsd} hasta ${fhst} </p>
					<p> Retira de Sucursal: ${suc} </p>
					<p> IdVehiculo Reservado: ${idVehiculo}</p>
					<hr>
								<div class="row">
									<div class="col-md-4">
										<img src="${vehiculo.imagen}" alt="imagen" class="img-responsive"/>
									</div>
									<div class="col-md-5">
										<div class="page-header">
											<h2>${vehiculo.nombre}</h2>
										</div>
										<p>${vehiculo.marca}</p>
										<p><span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span> ${vehiculo.capacidadPasajeros} equipajes</p>
										<p><span class="glyphicon glyphicon-user" aria-hidden="true"></span> ${vehiculo.capacidadValijas} plazas</p>
									</div>
									<div class="col-md-3">
										<h1>
											<span class="label label-success">Costo</span>
										</h1>
										<hr>
										<h1>
										<a href="guardaReserva?idVehiculo=${idVehiculo}&fchdesde=${fdsd}&fchhasta=${fhst}&sucursal=${suc}" class="btn-lg btn-primary">Continuar</a>
										</h1>
										<h1>
										<a href="pasajeros" class="btn-lg btn-danger">Volver</a>
										</h1>
									</div>
								</div>
								
				</div>
			</div>
		</div>
	</div>
</body>
</html>