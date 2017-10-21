<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Index</title>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <title>Insert title here</title>
	</head>
<body>
 <div class="container">
	  <div class="row">
	  	<div class="col-lg-12">
	  	<p class="text-flow">si selecciono dos personas devuelve dos objetos, si selecciono 3 un objetoe
	  	esos objetos son vehiculo que cumplen con la capacidad pedida  ver como devolver
	  	el nombre. </p>
	  		<label>Cantidad de personas:</label>
	  		<input type="number" value="${cantidad}" readonly/><br>			
	  		  	  
	  		   <c:forEach var="autos" items="${lista}">	 
	  		   	<select>
	  		   		<option value="">${autos}</option>
	  		   	</select> 
	  		  </c:forEach>
	  		  <br>
	  		  <p>
	  		  	<a href="pasajeros" class="btn btn-danger">volver</a>
	  		  </p>
	  		  
	  	</div>
	  </div>
  </div>
</body>
</html>

