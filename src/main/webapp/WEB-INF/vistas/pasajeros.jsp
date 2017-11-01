<%@include file='../../includes/head.jsp' %>
	<title>Pasajeros</title>
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
				<div class="panel-heading">Seleccione Cantidad de Pasajeros:</div>
				<div class="row">
					<div class="col-md-5 col-xs-6">
						<div class="panel-body">
						<form action="vehiculos" method="GET">
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="sel1">Cantidad de pasajeros:</label> 
										<select	class="form-control" id="sel1" name="cantidad">
											<c:forEach var="i" begin="1" end="${max}">
												<option value="${i}">${i}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-md-12">
										<label for="sel1">Sucursal de retiro:</label> 
										<select class="form-control" id="sel2" name="sucursal">
											<c:forEach var="s" items="${sucursal}">
												<option value="${s.ciudad}">${s.ciudad}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<div class="row">
									<div class="col-md-12">
										<label for="fch_desde">Reserva desde:</label> 
										<input type="date" name="fch_desde" class="form-control"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<div class="row">
									<div class="col-md-12">
										<label for="fch_hasta">Reserva hasta:</label> 
										<input type="date" name="fch_hasta" class="form-control"/>
									</div>
								</div>
							</div>
	
							<button type="submit" class="btn btn-primary">Enviar</button>
						</form>
					</div>
					</div>
					
					
					<div class="col-md-7">
						<img alt="autorent" src="<c:url value="/img/res_car.png"/>" class="img-responsive" width="100%"/>
					</div>
					
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>