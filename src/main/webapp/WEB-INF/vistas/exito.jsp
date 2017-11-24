<%@include file='../../includes/head.jsp'%>
<title>Categorias</title>
</head>
<body>
	<c:set var="usuario" value="${usuario}" scope="session" />
	<c:if test="${not empty usuario}">
		<p class="text-right text-muted">
			<b>Usuario:<b> ${usuario.nombre} para salir click <a
					href="logout">aqu&iacute;.</a>
		</p>
	</c:if>
	<div class="container">
		<header class='page-header'>
			<div class="container-fluid bg-1">
				<img src="img/logo.jpg" class="img-responsive"
					style="display: inline" alt="" width="100" height="100">
				<h1 class="margin" style="display: inline; margin-left: 100px">Auto
					Rent</h1>
			</div>
		</header>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading"><h4 class="text-success">Reserva generada con exito</h4></div>
				<div class="panel-body">
					<p>Reserva para dia ${fdsd} hasta ${fhst}</p>
					<p>Retira de Sucursal: ${suc}</p>
					<p>IdVehiculo Reservado: ${idVehiculo}</p>
					<a href="index" class="btn-lg btn-danger">Volver</a>
				</div>
			</div>
		</div>
		
		<a href="accesorios" class="btn-lg btn-primary">Continuar con la reserva</a>
		

	</div>
</body>
</html>
