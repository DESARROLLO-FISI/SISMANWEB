<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Gestion Alumno</title>
	<link rel="stylesheet" href="https://bootswatch.com/sandstone/bootstrap.min.css" type="text/css"/>
</head>

<%
        if(session.getAttribute("sesion")==null){
            response.sendRedirect("login.html");
        }
        //else{
       //     response.sendRedirect("cursos.jsp");
        //}
    %> 
<body>

	
		<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#ejemplo1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#">SISTEMA DE MANTENIMIENTO WEB</a>
			    </div>

			    <div class="collapse navbar-collapse" id="ejemplo1">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="#">Accion <span class="sr-only">(current)</span></a></li>
			        <li><a href="#">Accion</a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Opciones <span class="caret"></span></a>
			          <ul class="dropdown-menu" role="menu">
			            <li><a href="#">Accion</a></li>
			            <li><a href="#">otra action</a></li>
			            <li><a href="#">ejemplo</a></li>
			            <li class="divider"></li>
			            <li><a href="#">Separador</a></li>
			            <li class="divider"></li>
			            <li><a href="#">un separador</a></li>
			          </ul>
			        </li>
			      </ul>
			      <form class="navbar-form navbar-left" role="search">
			        <div class="form-group">
			          <input type="text" class="form-control" placeholder="BUSCAR">
			        </div>
			        <button type="submit" class="btn btn-primary">Buscar</button>
			      </form>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="cerrar_sesion.jsp">CERRAR SESION</a></li>
			      </ul>
			    </div>
			  </div>
		</nav>
	
	<div class="container ">
		<h3>OPCIONES</h3>
		<div class="container well ">
			<div class="row">
				<div class="col-xs-2 ">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
                                                            <a href="Gestion_Curso.jsp">
									<span class="glyphicon glyphicon-user" aria-expanded="true"></span>CURSOS
								</a>
								</h4>
							
						</div>

							
							<div class="panel-collapse collapse " id="cursoBARRA">
								<div class="panel-body">
									<li>agregar</li>
									<li>ver</li>
									<li>eliminar</li>
									
								</div>
							</div>	
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
									<a href="Gestion_Alumno.jsp">
									<span class="glyphicon glyphicon-user" aria-expanded="true"></span>ALUMNO
								</a>
								</h4>
							
						</div>

							
							<div class="panel-collapse collapse in" id="alumnoBARRA">
								<div class="panel-body">
									<li>agregar</li>
									<li>ver</li>
									<li>eliminar</li>
									
								</div>
							</div>	
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
									<a href="Gestion_Docente.jsp">
									<span class="glyphicon glyphicon-user" aria-expanded="true"></span>DOCENTE
								</a>
								</h4>
							
						</div>

							
							<div class="panel-collapse collapse" id="docenteBarra">
								<div class="panel-body">
									<li>agregar</li>
									<li>ver</li>
									<li>eliminar</li>
									
								</div>
							</div>	
					</div>
					<!--<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
									<a href="Gestion_Persona.jsp">
									<span class="glyphicon glyphicon-user" aria-expanded="true"></span>Persona
								</a>
								</h4>
							
						</div>

							
							<div class="panel-collapse collapse" id="personaBarra">
								<div class="panel-body">
									<li>agregar</li>
									<li>ver</li>
									<li>eliminar</li>
									
								</div>
							</div>	
					</div>-->
						

					

					</div>
					
					<div class="col-xs-10 ">
					<div >
								<h2>GESTION DE ALUMNOS</h2>

							</div>

					<div class="panel panel-default well">
						<ul class="nav nav-tabs ">

								 <li class="active"><a href="#añadir" role="tab" data-toggle="tab"><span class="glyphicon glyphicon-plus"></span> Añadir</a></li>
								 <li><a href="#mostrar" role="tab" data-toggle="tab"><span class="glyphicon glyphicon-eye-open"></span> Mostrar</a></li>
								 <li><a href="#eliminar" role="tab" data-toggle="tab"><span class="glyphicon glyphicon-remove"></span> Elliminar</a></li>

							
						</ul>	
						<ul class="tab-content">
					
					  <div class="tab-pane fade in active" id="añadir">
					  	<h1>AÑADIR ALUMNO</h1>

					  	<form role="form">
							  <div class="form-group">
							  <br>
							  <br>


								    <label for="nombre">Nombre (*)</label>
								    <input type="text " class="form-control" id="nombre" placeholder="Ingrese Nombre" required="">
									<br>
								    <label for="Apellido_paterno_p">Apellido Paterno(*)</label>
								    <input type="text " class="form-control" id="Apellido_paterno" placeholder="Ingrese Apellido_p" required="">
									<br>
									<label for="Apellido_materno_m">Apellido Materno(*)</label>
								    <input type="text " class="form-control" id="Apellido_materno" placeholder="Ingrese Apellido_m" required="">
									<br>
									<label >Escuela (*)</label>
					                    <select name="escuela" class="form-control">
					                        <option value="200">E.A.P. Ingenieria de Sistemas</option>
					                        <option value="201">E.A.P. Ingenieria de Software</option>
					                    </select>
					                    <br>
									<label >Plan (*)</label>
					                    <select name="plan" class="form-control">
					                        <option value="1">ID plan 1</option>
					                        <option value="2">ID plan 2</option>
					                        <option value="3">ID plan 3</option>
					                        <option value="4">ID plan 4</option>
					                        <option value="5">ID plan 5</option>
					                        <option value="6">ID plan 6</option>
					                        <option value="7">ID plan 7</option>
					                    </select>
					                    <br>
								  </div>

								  

								  <br>
								  <h2>Datos Opcionales</h2>
								  <br>
								  	
								 <div class="form-group " >
					                   <label >Fecha de Nacimiento</label>
					                   <input type="date" name="fechaInicio" class="form-control"  >
					                   <br>
					                   <label for="DNI">DNI</label>
								       <input type="text " class="form-control" id="DNI" placeholder="DNI">
								       <br>
									   <label for="Telefono">Telefono</label>
								       <input type="text " class="form-control" id="Telefono" placeholder="Telefono">
								       <br>
									   <label for="ejemplo_email_1">Email</label>
								       <input type="email" class="form-control" id="ejemplo_email_1" placeholder="Introduce email">
								       
									   <label for="direccion">Direccion</label>
									   <input type="text " class="form-control" id="direccion" placeholder="Direccion"s>
										


					             </div>
								 
								 <label>(*) Campoa obligatorios</label>
								 <!-- <div class="form-group">
								    <label for="ejemplo_archivo_1">Adjuntar un archivo</label>
								    <input type="file" id="ejemplo_archivo_1">
								    <p class="help-block">Ejemplo de texto de ayuda.</p>
								  </div>
								  -->
								  <br><br><br>
								  <button type="submit" class="btn btn-default">Enviar</button>
							</form>
 
					  </div>
						
 
						
						<div class="tab-pane fade" id="eliminar">
 
						<h1>ELIMINAR ALUMNO</h1>
 
					</div>
 
							<div class="tab-pane fade" id="mostrar">
							  	<br>
							  		<ul class="list-group">
							  			<li class="list-group-item">alumno 1</li>
							  			<li class="list-group-item">alumno 2</li>
							  			<li class="list-group-item">alumno 3</li>
							  			<li class="list-group-item">alumno 4</li>
							  			<li class="list-group-item">alumno 5</li>
									</ul>
							 </div>
 				  
					</ul>
					</div>
						

					</div>
				</div>
	
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
				<div class="col-xs-1 well">pruebas para ver las columans </div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
</body>
</html>