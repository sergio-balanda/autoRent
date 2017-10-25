<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<div class="container">
		<header class='page-header'>
					<div class="container-fluid bg-1">
						<img src="img/logo.jpg" class="img-responsive" style="display:inline" alt="" width="100" height="100">
						<h1 class="margin" style="display:inline;margin-left:100px" >Auto Rent</h1>
					</div>
		</header>
		
		<div class="panel-group">
	    	<div class="panel panel-default">
	      		<div class="panel-heading">Seleccione Cantidad de Pasajeros:</div>
	      			<div class="panel-body">
	    				<form action="vehiculos" method="GET">
							<div class="form-group">
  								<label for="sel1">Select list:</label>
  								<select class="form-control" id="sel1" name="cantidad" >
    								<c:forEach var="i" begin="1" end="${max}">
 							    		<option value="${i}">${i}</option>
 							    	</c:forEach>
  								</select>
							</div>
							<button type="submit" class="btn btn-primary">Enviar</button>
						</form>
					</div>
				</div>
	     </div>
	</div>		
</body>
</html>