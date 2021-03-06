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
						<li><a href='logout'><span
								class='glyphicon glyphicon-log-out'></span>&nbsp;Logout</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<main style='margin-top: -20px;'>
		<div class='container' style='background: white; margin-top: 20px; min-height: 709px;'>
			<div class="panel panel-warning" style='margin-top: 200px; margin-bottom: 5em;'>
				<div class="panel-heading">
					<span style="margin-left: 1em; margin-right: 0.5em;" class="glyphicon glyphicon-ok" aria-hidden="true"></span>
					�Felicidades!
				</div>
				<div class="panel-body">
					<h1 class="text-uppercase text-warning text-center">
						�El alquiler se ha generado con &eacute;xito!
					</h1>
					<blockquote>
						<h3>
							El costo a abonar por el cliente es:&nbsp;$&nbsp;${alquiler.precioFinal}
						</h3>
						<footer class="blockquote-footer">
							El c�digo del alquiler es:&nbsp;&nbsp;${alquiler.idAlquiler}
						</footer>
					</blockquote>
				</div>
		    </div>
		    <div class="col-sm-12 text-center">
		    	<br>
		    	<a href="listado-alquileres" class="btn btn-primary">Volver al inicio</a>
		    </div>
		</div>
	</main>
</body>
</html>