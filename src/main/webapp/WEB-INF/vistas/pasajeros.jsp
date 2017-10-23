<!DOCTYPE html>
<html>
	<head>
		<title>Pasajeros</title>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
<body>
	<div class="page-header">
		<h1 class="text-center">Empezar con la reserva</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col">
				<form action="reservar" method="GET">
					
					<div class="form-group">
                            <span class="">Cantidad de personas</span>
                            <select id="cantidad" name="cantidad">
                                <option value="1" > 1 </option> 
                                <option value="2" > 2 </option>
                                <option value="3" > 3 </option>
                                <option value="4" > 4 </option>
                                <option value="5" > 5 </option>
                            </select>
                     </div>
					
					
					<button type="submit" class="btn btn-primary">Enviar</button>
				</form>
			</div>
		</div>
	</div>
	<hr>	
	<div class="row">
		<div class="alert alert-success">
		  funciona con <strong>2 y 3</strong>
		</div>
	</div>
	
</body>
</html>