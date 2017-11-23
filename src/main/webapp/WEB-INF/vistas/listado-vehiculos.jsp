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
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; margin-top: 20px;'>
		<div class="alert alert-warning alert-dismissable" style='margin-top: 20px;'>
			<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-road" aria-hidden="true"></span>
			Se muestran los veh&iacute;culos que integran nuestra flota.
		</div>
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
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>