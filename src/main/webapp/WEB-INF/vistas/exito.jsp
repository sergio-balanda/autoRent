<%@include file='../../includes/head.jsp' %>
<title>Categorias</title>
</head>
<body>
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
				<div class="panel-heading">Reserva generada con exito</div>
				<div class="panel-body">
				<p> Reserva para dia ${fdsd} hasta ${fhst} </p>
				<p> Retira de Sucursal: ${suc} </p>
				<p> IdVehiculo Reservado: ${idVehiculo}</p>
				<a href="index" class="btn-lg btn-danger">Volver</a>
			</div>
		</div>
	</div>
	</div>
</body>
</html>			