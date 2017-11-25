<%@include file='../../includes/head.jsp'%>
</head>
<body>

	<c:forEach items="${accesorios}" var="accesorio">
	${accesorio}
	</c:forEach>
	
	<!-- 	
	El código de la reserva es: ${idReserva} <br>
	El costo de la reserva es : ${costoOrigen}-->
	<div class='container'
		style='background: white; margin-top: 20px; min-height: 709px;'>
		<div class="alert alert-warning"
			style='margin-top: 20px; margin-bottom: 5em;'>
			<span style="margin-left: 1em; margin-right: 0.5em;"
				class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
			Reserva con código: ${reserva.idReserva}
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
		<div class="col-md-4">
			<h5 class='text-muted text-center'>Retirado de la sucursal:
				${sucursal.ciudad}.</h5>
			<h5 class='text-muted text-center'>Plazo entre: ${reserva.fechaInicio} ~
				${reserva.fechaFin}.</h5>
			<h5 class='text-muted text-center'>Cantidad de d&iacute;as:
				${cantidadDias}.</h5>
			<h5 class='text-muted text-center'>Costo por d&iacute;a: $
				${costoPorDia}</h5>
			<h2 class='text-success text-center'>Total: $ ${precioVehiculo}
			</h2>
		</div>
	</div>
	
	<form:form action="confirmar-alquiler" method="POST">
		<input type="hidden" value="${reserva.idReserva}" name="idReserva">
		<button type="submit"> CONFIRMAR</button>
	</form:form>
</body>
</html>