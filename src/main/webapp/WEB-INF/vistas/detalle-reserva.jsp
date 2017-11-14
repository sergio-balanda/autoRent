<%@include file='../../includes/head.jsp'%>
<title>detalle de reservas</title>
</head>
<body>
	<c:set var="usuario" value="${usuario}" scope="session" />
	<c:if
		test="${not empty usuario.administrador and not usuario.administrador}">
		<c:set var="inicio" value="login" />
	</c:if>
	<c:if
		test="${not empty usuario.administrador and usuario.administrador}">
		<div class="container">
			<header class='page-header'>
				<div class="container-fluid bg-1">
					<img src="img/logo.jpg" class="img-responsive"
						style="display: inline" alt="" width="100" height="100">
					<h1 class="margin" style="display: inline; margin-left: 100px">Auto
						Rent</h1>
					<p class="text-right text-muted">
						<b>Usuario:</b> ${usuario.nombre} para salir click <a
							href="logout">aqu&iacute;.</a>
					</p>
				</div>
				<h1>Zona de Admininistracion</h1>
			</header>
			<p>fehcas...</p>
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">Bienvenido</div>
					<div class="panel-body">
						<form:form action="devolver-vehiculo" method="POST">

							<input type="number" value="${reserva.idReserva}"
								name="idReserva">
							<input type="number" placeholder="costo">

						</form:form>
						<a href="vista-reservas" class="btn btn-info">Ver todas las
							reservas</a>
					</div>
				</div>
			</div>
		</div>
	</c:if>

</body>
</html>