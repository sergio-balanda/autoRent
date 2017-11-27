<%@include file='../../includes/head.jsp'%>
</head>
<body class='bgbars'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='#'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li class='active'><a href='#'>Reservas</a></li>
					<li><a href='#'>Alquileres</a></li>
					<li><a href='#'>Usuarios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<c:set var="usuario" value="${usuario}" scope="session" />
					<c:if test="${not empty usuario.nombre}">
						<li style="color: #9d9d9d; padding-top: 1em;">Bienvenido,
							${usuario.nombre}.</li>
						<li><a href='logout'><span
								class='glyphicon glyphicon-log-out'></span>&nbsp;Logout</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<main style='margin-top: -20px;'>
		<div class='container'
		style='background: white; margin-top: 20px; min-height: 709px;'>
		<div class="alert alert-warning"
			style='margin-top: 20px; margin-bottom: 5em;'>
			<span style="margin-left: 1em; margin-right: 0.5em;"
				class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
			Reserva con c�digo: ${reserva.idReserva}
		</div>
		<div class="col-md-4">
			<img src="${vehiculo.imagen}" alt="imagen" class="img-responsive" />
		</div>
		<div class="col-md-4">
			<div class="page-header">
				<h2>${vehiculo.marca}&nbsp;${vehiculo.nombre}</h2>
			</div>
			<p>
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				${vehiculo.capacidadPasajeros} Personas
			</p>
			<p>
				<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
				${vehiculo.capacidadValijas} Valijas
			</p>
		</div>
		<div class="col-md-4">
			<h5 class='text-muted text-center'>
				Retirado de la sucursal:&nbsp;${sucursal.ciudad}.
			</h5>
			<h5 class='text-muted text-center'>
				Plazo entre:&nbsp;${reserva.fechaInicio}<br>~ ${reserva.fechaFin}.
			</h5>
			<h5 class='text-muted text-center'>
				Cantidad de d&iacute;as:&nbsp;${cantidadDias}.
			</h5>
			<h5 class='text-muted text-center'>
				Costo por d&iacute;a:&nbsp;$&nbsp;${costoPorDia}
			</h5>
			<h5>
				Accesorios:<br>
				<c:forEach items="${listAccesorios}" var="accesorios">
				<p><c:out value="${accesorios.nombre}" /></p>
				</c:forEach>
				${accesorio1.nombre}
			<h5 class='text-muted text-center'>
				Costo por accesorios:&nbsp;$&nbsp;${costoTotalDeAccesorios}
			</h5>
			<h2 class='text-success text-center'>
				Total:&nbsp;$&nbsp;${costoFinal}
			</h2>
			<form:form action="confirmar-alquiler" method="POST">
				<input type="hidden" value="${reserva.idReserva}" name="idReserva">
				<input type="hidden" value="${costoFinal}" name="costoFinal">
				<button class="btn btn-success" type="submit"
					style="margin-left: 125px;">
					<span class="glyphicon glyphicon-ok"></span>&nbsp;Confirmar
					Alquiler
				</button>
			</form:form>

		</div>
	</div>
	</main>
</body>
</html>