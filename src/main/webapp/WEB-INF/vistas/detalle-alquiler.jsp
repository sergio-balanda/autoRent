<%@include file='../../includes/head.jsp'%>
</head>
<body class='bgbars'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='listado-reservas'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li><a href='listado-reservas'>Reservas</a></li>
					<li class='active'><a href='listado-alquileres'>Alquileres</a></li>
					<li><a href='listado-usuarios'>Usuarios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<c:set var="usuario" value="${usuario}" scope="session" />
					<c:if test="${not empty usuario.nombre}">
						<li style="color: #9d9d9d; padding-top: 1em;">Bienvenido,
							${usuario.nombre}.</li>
						<li><a href='logout'>
							<span class='glyphicon glyphicon-log-out'></span>&nbsp;Logout</a>
							</li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; margin-top: 20px; min-height: 709px;'>
			<div class="alert alert-warning" style='margin-top: 20px; margin-bottom: 2em;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-book" aria-hidden="true"></span>
				Detalle del alquiler.
			</div>
			<div class="row">
				<div class="col col-sm-6">
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h3><strong>Datos del cliente</strong></h3>
						</div>
						<div class="panel-body">
							<p><b>Nombre :</b> ${usuarioReserva.nombre}<p>
							<p><b>Cuit :</b> ${usuarioReserva.cuit}<p>
							<p><b>Email :</b> ${usuarioReserva.email}<p>
							<p><b>Puntos :</b> ${usuarioReserva.puntos}<p>
							<p><b>Equivalencia de puntos a dinero:</b> $ ${convertir}<p>
						</div>
					</div>
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h3><strong>Datos del veh&iacute;culo</strong></h3>
						</div>
						<div class="panel-body">
							<p><b>Patente :</b> ${vehiculo.patente}<p>
							<p><b>Nombre :</b> ${vehiculo.marca} ${vehiculo.nombre}<p>
							<p><b>Capacidad de pasajeros :</b> ${vehiculo.capacidadPasajeros}<p>
							<p><b>Capacidad de valijas :</b> ${vehiculo.capacidadValijas}<p>
						</div>
					</div>
				</div>
				<div class="col col-sm-6">
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h3><strong>Datos de la reserva</strong></h3>
						</div>
						<div class="panel-body">
							<p><b>C&oacute;digo :</b> ${reserva.idReserva}</p>
							<p><b>Sucursal :</b> ${sucursal.domicilio}, ${sucursal.ciudad}</p>
							<p><b>Fecha de inicio :</b> ${reserva.fechaInicio}</p>
							<p><b>Fecha de fin :</b> ${reserva.fechaFin}</p>
							<p><b>Costo :</b> $ ${reserva.costoOrigen}</p>
						</div>
					</div>
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h3><strong>Datos del alquiler</strong></h3>
						</div>
						<div class="panel-body">
							<p><b>C&oacute;digo :</b> ${alquiler.idAlquiler}<p>
							<p><b>Estado :</b>
							<c:choose>
								<c:when test="${alquiler.finalizada eq true}">
									Finalizado</p>
								</c:when>
								<c:when test="${alquiler.finalizada eq false}">
									Vigente</p>
								</c:when>
							</c:choose>
							<p><b>Accesorios Contratados :</b></p>
							<c:forEach items="${accesorios}" var="accesorio">
								<p>&emsp;&emsp;&emsp;&emsp;<small><span class="glyphicon glyphicon-plus"></span></small>
								&emsp;${accesorio.nombre}
								<br>
							</c:forEach>
							</p>
							<p><b>Costo total :</b> $ ${alquiler.precioFinal}<p>
							<c:choose>
								<c:when test="${alquiler.finalizada eq false}">
									<hr>
									<form:form action="finalizar-alquiler" method="POST">
										<input type="hidden" name="idAlquiler" id="idAlquiler" value="${alquiler.idAlquiler}" />
										<br>
										<button type="submit" class="btn btn-block btn-danger">
											Terminar Alquiler&nbsp;
											<span class="glyphicon glyphicon-arrow-right"></span>
										</button>
									</form:form>
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</main>	
</body>
</html>