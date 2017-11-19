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
							<div class="col-md-4 col-md-offset-4">
								<form:form action="actualizar-reserva" method="POST">
									<div class="form-group">
										<input type="hidden" value="${reserva.idReserva}"
											name="idReserva" readonly class="form-control">
									</div>
									<div class="form-group">
										<label for="nombre" class="col-xs-12 control-label">Fehca
											de inicio</label>
										<div class="col-xs-12">
											<input type="text" value="${reserva.fechaInicio}"
												name="fechaInicio" readonly class="form-control">
										</div>
									</div>
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
											<input type="hidden" value="${id_usuario}" name="idUsuario"
												readonly class="form-control">
										</div>
									</div>

									<div class="form-group">
										<div class="col-xs-12 text-center">
											<br> <a href="vista-reservas" class="btn btn-danger">Volver</a>
											<button type="submit" class="btn btn-primary">Modificar</button>

										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>

</body>
</html>