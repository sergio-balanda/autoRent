<%@include file='../../includes/head.jsp' %>
</head>
<body class='bgbars'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='index'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li><a href='index'>Home</a></li>
					<li class='disabled'><a href='#'>Sucursales</a></li>
					<li><a href='listado-vehiculos'>Vehiculos</a></li>
					<li class='disabled'><a href='#'>Accesorios</a></li>
					<li class='disabled'><a href='#'>Servicios</a></li>
				</ul>
				<ul class='nav navbar-nav navbar-right'>
					<c:set var="usuario" value="${usuario}" scope="session" />
					<c:if test="${empty usuario.nombre}">

						<li><a href='registro-usuario'><span class='glyphicon glyphicon-user'></span>&nbsp;Registrarse</a></li>
						<li><a href='login'><span class='glyphicon glyphicon-log-in'></span>&nbsp;Login</a></li>
					</c:if>
					<c:if test="${not empty usuario.nombre}">
						<li style="color: #9d9d9d; padding-top: 1em;">
								Bienvenido, ${usuario.nombre}.
						</li>
						<li><a href='logout'><span class='glyphicon glyphicon-log-out'></span>&nbsp;Logout</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; margin-top: 20px; min-height: 709px;'>
			<div class="alert alert-warning" style='margin-top: 20px; margin-bottom: 5em;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
				Tu reserva ya casi est&aacute; lista.
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
			<c:choose>
				<c:when test="${not empty usuario}">
					<div class="col-md-4">
						<h5 class='text-muted text-center'>
							Retirado de la sucursal: ${sucursal}.
						</h5>
						<h5 class='text-muted text-center'>
							Plazo entre: ${fechaDesde} ~ ${fechaHasta}.
						</h5>
						<h5 class='text-muted text-center'>
							Cantidad de d&iacute;as: ${cantidadDias}.
						</h5>
						<h5 class='text-muted text-center'>
							Costo por d&iacute;a: $ ${costoPorDia}
						</h5>
						<h2 class='text-success text-center'>
							Total: $ ${precioVehiculo}
						</h2>
						<div class='text-center'>
							<form:form action="guardar-reserva" method="POST">
								<input type="hidden" name="idVehiculo" id="idVehiculo" value="${idVehiculo}" />
								<input type="hidden" name="usuario" id="usuario" value="${usuario.id}" />
								<input type="hidden" name="fechaDesde" id="fechaDesde" value="${fechaDesde}" />
								<input type="hidden" name="fechaHasta" id="fechaHasta" value="${fechaHasta}" "/>
								<input type="hidden" value="${sucursal}" name="sucursal" id="sucursal" />
								<a href="index" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span>&nbsp;Cancelar
								</a>
								<button type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-ok"></span>&nbsp;Confirmar
								</button>
							</form:form>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="row text-center">
						<br>
						<br>
						<br>
						<h4 class='text-danger text-center'>Necesitas estar logueado para</h4>
						<h4 class='text-danger text-center'>efectuar una reserva</h4>
						<a href="login" class="btn btn-primary">Login</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</main>
</body>
</html>