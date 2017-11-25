<%@include file='../../includes/head.jsp'%>
<title>detalle de reservas</title>
</head>
<body>
	<c:set var="usuario" value="${usuario}" scope="session" />
	<c:if
		test="${not empty usuario.administrador and not usuario.administrador}">
		<c:set var="inicio" value="login" />
	</c:if>
	<c:if
		test="${not empty usuario.administrador and usuario.administrador}">
		<div class="container">
			<header class='page-header'>
				<div class="container-fluid bg-1">
					<img src="img/logo.jpg" class="img-responsive"
						style="display: inline" alt="" width="100" height="100">
					<h1 class="margin" style="display: inline; margin-left: 100px">Auto
						Rent</h1>
					<p class="text-right text-muted">
						<b>Usuario:</b> ${usuario.nombre} para salir click <a
							href="logout">aqu&iacute;.</a>
					</p>
				</div>
				<h1>Datos de Reserva</h1>
			</header>
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">Veficar fecha de entraga, ingresar
						el costo por entrega posterior de la fecha</div>
					<div class="panel-body">
					
						<div class="row">
							<div class="col">
							
							<div class="col-xs-6">
							<div class="col-xs-12">
								<div class="panel panel-default">
									<div class="panel-heading">
									<h4 class="text-primary"><b>Datos del cliente</b></h4>
									</div>
									<div class="panel-body">
										<p><b>Nombre :</b> ${UsuarioDeLaReserva.nombre}<p>
										<p><b>Cuit :</b> ${UsuarioDeLaReserva.cuit}<p>
										<p><b>Email :</b> ${UsuarioDeLaReserva.email}<p>
										<p><b>Puntos :</b> ${UsuarioDeLaReserva.puntos}<p>
										<p><b>Equivalencia de puntos a dinero:</b> $ ${convertir}<p>
									</div>
								</div>
							</div>
							
							<div class="col-xs-12">
								<div class="panel panel-default">
									<div class="panel-heading">
									<h4 class="text-primary"><b>Datos del vehiculo</b></h4>
									</div>
									<div class="panel-body">
										<p><b>Patente :</b> ${vehiculoDeLaReserva.patente}<p>
										<p><b>Nombre :</b> ${vehiculoDeLaReserva.marca} ${vehiculoDeLaReserva.nombre}<p>
										<p><b>Capacidad de pasajeros :</b> ${vehiculoDeLaReserva.capacidadPasajeros}<p>
										<p><b>Capacidad de valijas :</b> ${vehiculoDeLaReserva.capacidadValijas}<p>
									</div>
								</div>
							</div>
							</div>
						</div>
						
							<div class="col-md-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="text-primary"><b>Datos de la reserva</b></h4>
									</div>
								</div>
								<form:form action="" method="POST">
									<div class="form-group">
										<label for="nombre" class="col-xs-12 control-label">Numero de reserva</label>
										<div class="col-xs-12">
											<input type="number" value="${reserva.idReserva}"
												name="idReserva" readonly class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label for="nombre" class="col-xs-12 control-label">Fehca
											de inicio de Reserva</label>
										<div class="col-xs-12">
											<input type="text" value="${reserva.fechaInicio}"
												name="fechaInicio" readonly class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label for="nombre" class="col-xs-12 control-label">Fecha
											de entrega acordada</label>
										<div class="col-xs-12">
											<input type="text" value="${reserva.fechaFin}"
												 class="form-control" readonly="readonly">
										</div>
									</div>
									<div class="form-group">
										<label for="nombre" class="col-xs-12 control-label">Sucursal de la reserva</label>
										<div class="col-xs-12">
											<input type="text" value="${sucursalDeLaReserva.domicilio} ${sucursalDeLaReserva.ciudad} "
												 readonly class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="col-xs-12">
											<h4 class="text-danger">En caso de no coicidir la fecha de entrega acordada, 
											cambiar fecha de entrega y costo </h4>
										</div>
									</div>
									<hr>
									<div class="form-group">
										<label for="nombre" class="col-xs-12 control-label">Fecha
											de entrega</label>
										<div class="col-xs-12">
											<input type="text" value="${reserva.fechaFin}"
												name="fechaFin" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label for="nombre" class="col-xs-12 control-label">Costo</label>
										<div class="col-xs-12">
											<input type="number" value="${reserva.costoOrigen}"
												name="costoOrigen" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<div class="col-xs-12 text-center">
										<c:forEach var="accesorio" items="${accesorios}">
											<div class="checkbox">
				 							    <label><input type="checkbox" value="${accesorio.idAccesorio}" name="accesorios"></input>${accesorio.nombre} ${accesorio.costoDia}</label>
											</div>
										</c:forEach>
										</div>
									</div>									
									
									<div class="form-group">
										<div class="col-xs-12">
											<input type="hidden" value="${fkVehiculoR}"
												name="fkVehiculoR" readonly class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="col-xs-12">
											<input type="hidden" value="${FkSucursalR}"
												name="fkSucursalR" readonly class="form-control">
										</div>
									</div>
							
									<div class="form-group">
										<div class="col-xs-12">
											<input type="hidden" value="${finalizada}" name="finalizada"
												readonly class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="col-xs-12">
											<input type="hidden" value="${UsuarioDeLaReserva.id}"
												name="idUsuario" readonly class="form-control">
										</div>
									</div>

									
									<div class="form-group">
										<div class="col-xs-12 text-center">
											<br> <a href="vista-reservas" class="btn btn-danger">Volver</a>
											<button type="submit" class="btn btn-primary" onclick=this.form.action="preparar-alquiler">Iniciar alquiler</button>
											<button type="submit" class="btn btn-primary" onclick=this.form.action="actualizar-reserva">Terminar alquiler</button>

										</div>
									</div>
								</form:form>
							</div>
							<c:if
								test="${  convertir gt reserva.costoOrigen }">
							<h4 class="text-warning">Pagar con puntos</h4>
							<button class="btn btn-success">no hago nada</button>
							<p>con otros usuario no se ve</p>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>

</body>
</html>