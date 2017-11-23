<%@include file='../../includes/head.jsp' %>
</head>
<body class='bgbars'>
	<c:set var="usuario" value="${usuario}" scope="session"/>
	<c:if test="${not empty usuario}">
		<p class="text-right text-muted"><b>Usuario:<b> <a href="detalle-usuario">${usuario.nombre}</a> para salir click <a href="logout">aqu&iacute;.</a></p>
	</c:if>
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
					<li><a href='#'><span class='glyphicon glyphicon-user'></span>
							Registrarse</a></li>
					<li><a href='login'><span class='glyphicon glyphicon-log-in'></span>
							Login</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; min-height: 709px; margin-top: 20px;'>
			<div class="alert alert-warning alert-dismissable" style='margin-top: 20px;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
				Se muestran los veh&iacute;culos disponibles entre el ${fechaDesde} y el ${fechaHasta} en la sucursal de ${sucursal}
			</div>
			<form action="generar-reserva" method="GET">
				<c:forEach items="${vehiculos}" var="vehiculo" >
						<div class='col-sm-4 well' style="text-align: center; background: rgba(255, 255, 255, 0.8) !important;">
							<h3><c:out value="${vehiculo.marca}" /></h3>
							<h4><c:out value="${vehiculo.nombre}" /></h4>
							<br>
							<img src="${vehiculo.imagen}" class="img" style="display: inline" width="220" height="150"/>
							<br>
							<h5>
								<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-user" aria-hidden="true"></span>
								<c:out value="${vehiculo.capacidadPasajeros}" />
								<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
								<c:out value="${vehiculo.capacidadValijas}" />
							</h5>
							<c:url value="/generar-reserva" var="displayURL">
								<c:param name="idVehiculo" value="${vehiculo.idVehiculo}" />
								<c:param name="fechaDesde" value="${fechaDesde}" />
								<c:param name="fechaHasta" value="${fechaHasta}" />
								<c:param name="sucursal" value="${sucursal}" />
							</c:url> 
							<a href='<c:out value="${displayURL}" />'class="btn btn-warning" role="button">Seleccionar</a>
						</div>
				</c:forEach>
			</form>
		</div>
	</main>
</body>
</html>