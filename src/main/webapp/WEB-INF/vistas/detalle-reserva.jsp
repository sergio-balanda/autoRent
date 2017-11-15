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
			
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">Fecha de Devolucion</div>
					<div class="panel-body">
						<form:form action="actualizar-reserva" method="POST" modelAttribute="reserva">
							<label> Reserva nro ${reserva.idReserva}</label>
							<label> Ingresar fecha de devolucion del vehiculo</label>
							<form:input path="idReserva" class="hidden" name="idReserva" value="${reserva.idReserva}" />
							<form:input path="fechaFin" type="date" name="fechaFin" />
							<button type="Submit" class="btn btn-succes">Listo</button>
						</form:form>
						<a href="listar-reservas" class="btn btn-info">Ver todas las
							reservas</a>
					</div>
				</div>
			</div>
		</div>
	</c:if>

</body>
</html>