<%@include file='../../includes/head.jsp' %>
</head>
<body class='bgbars'>
	<header class='page-header'>
		<nav class='navbar navbar-inverse navbar-fixed-top'>
			<div class='container-fluid'>
				<div class='navbar-header'>
					<a class='navbar-brand' href='#'>AutoRent</a>
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
						<li><a href='registro-usuario'><span class='glyphicon glyphicon-user'></span>Registrarse</a></li>
						<li><a href='login'><span class='glyphicon glyphicon-log-in'></span>Login</a></li>
					</c:if>
					<c:if test="${not empty usuario.nombre}">
						<li style="color: #9d9d9d; padding-top: 1em;">
								Bienvenido, ${usuario.nombre}.
						</li>
						<li><a href='logout'><span class='glyphicon glyphicon-log-out'></span>Logout</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; margin-top: 20px; min-height: 709px;'>
			<div class="alert alert-warning" style='margin-top: 20px; margin-bottom: 5em;'>
				<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-ok" aria-hidden="true"></span>
				Tu reserva se ha ejecutado con &eacute;xito.
			</div>
			<div>
			</div>
	</main>
</body>
</html>