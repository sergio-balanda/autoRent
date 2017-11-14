<%@include file='../../includes/head.jsp'%>
<title>AutoRent - Registro Usuario</title>
</head>
<body>

	<div class="container-fluid">
	
		<div class="card">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="page-header">
					<h1 class="text-center"><a href="index">AutoRent</a> Registro de usuario</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<form:form action="registrar-usuario" method="POST">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="form-group">
					<label for="nombre" class="cols-sm-12 control-label">Nombre</label>
					<div class="cols-sm-10">
						<input type="text" class="form-control" name="nombre" id="nombre"
							placeholder="Nombre" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="cols-sm-12 control-label">E-mail</label>
					<div class="cols-sm-10">
						<input type="text" class="form-control" name="email" id="email"
							placeholder="E-mail" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label for="cuit" class="cols-sm-12 control-label">Cuit</label>
					<div class="cols-sm-10">
						<input type="text" class="form-control" name="cuit" id="cuit"
							placeholder="cuit" required="required" />
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-sm-offset-3">
				<div class="form-group">
					<label for="password" class="cols-sm-12 control-label">Password</label>
					<div class="cols-sm-10">
						<input type="password" class="form-control" name="password"
							id="password" placeholder="Password" required="required" />
					</div>
				</div>

			</div>
			<div class="col-sm-8 col-sm-offset-3">
				<div class="form-group++">
					<a href="login" class="btn btn-danger"><span
						class="glyphicon glyphicon-remove"></span>&nbsp;Cancelar</a>
					<button type="submit" class="btn btn-success">
						<span class="glyphicon glyphicon-ok"></span>&nbsp;Confirmar
					</button>
				</div>
			</div>
		</form:form>
		<br>
		</div>
		</div>
	</div>

</body>
</html>