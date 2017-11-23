<%@include file='../../includes/head.jsp' %>
</head>
<body>
	<c:set var="usuario" value="${usuario}" scope="session"/>
	<c:if test="${not empty usuario}">
		<p class="text-right text-muted"><b>Usuario:<b> <a href="detalle-usuario">${usuario.nombre}</a> para salir click <a href="logout">aqu&iacute;.</a></p>
	</c:if>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='#'>AutoRent</a>
				</div>
				<ul class='nav navbar-nav'>
					<li><a href='index'>Home</a></li>
					<li><a href='#'>Sucursales</a></li>
					<li class='active'><a href=#>Vehiculos</a></li>
					<li><a href='#'>Accesorios</a></li>
					<li><a href='#'>Servicios</a></li>
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
	<main>
		<div class='container'>	
			<c:forEach items="${vehiculos}" var="vehiculo" >
				
					<div class='vehiculoContainer'>
						<h3><c:out value="${vehiculo.marca}" /></h3>
						<h4><c:out value="${vehiculo.nombre}" /></h4>
						<br>
						<img src="${vehiculo.imagen}" class="img-responsive" 
					style="display: inline" alt="" width="200" height="200"/>
						<br>
						<h5>
							<span style="margin-left: 1em;" class="glyphicon glyphicon-user" aria-hidden="true"></span><c:out value="${vehiculo.capacidadPasajeros}" />
							<span style="margin-left: 1em;" class="glyphicon glyphicon-briefcase" aria-hidden="true"><c:out value="${vehiculo.capacidadValijas}" />
						</h5>
					</div>
				
			</c:forEach>
		</div>
	</main>
	
	
	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">Los vehiculos disponibles entre dia ${fechaDesde} y dia ${fechaHasta} en Sucursal ${sucursal} </div>
				<div class="panel-body">
					<form action="generar-reserva" method="GET">
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>Imagen</th>
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
									<td><c:out value="${vehiculo.marca}" /></td>
									<td><c:out value="${vehiculo.nombre}" /></td>
									<td><c:out value="${vehiculo.capacidadPasajeros}" /></td>
									<td><c:out value="${vehiculo.capacidadValijas}" /></td>
									
									<c:url value="/generar-reserva" var="displayURL">
										<c:param name="idVehiculo" value="${vehiculo.idVehiculo}" />
										<c:param name="fechaDesde" value="${fechaDesde}" />
										<c:param name="fechaHasta" value="${fechaHasta}" />
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