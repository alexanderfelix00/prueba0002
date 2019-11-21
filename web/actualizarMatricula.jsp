<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACTUALIZAR MATRICULA</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/8719a7912f.js"></script>
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/matricula.css">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark navegacion">
                <a class="navbar-brand titulo" href="index.jsp">ACADEMIA SAN MARCOS</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Inicio <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="matricula.jsp">Matrícula Online</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contactanos</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Informes
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Informe 1</a>
                                <a class="dropdown-item" href="#">Informe 2</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Informe 3</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                USUARIO
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">
                                <i class="right-i fas fa-user"></i>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="ServletUsuario?accion=logout">
                                <i class="right-i fas fa-door-open"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <%
            CicloDao daoCiclo = new CicloDao();
            SedeDao daoSede = new SedeDao();
            TurnoDao daoTurno = new TurnoDao();

            int idEst = Integer.parseInt(request.getParameter("idUpdEst"));
            EstudianteDao daoE = new EstudianteDao();
            Estudiante objE = daoE.ListarEstudiantePorId(idEst);
        %>
        <main>
            <div class="c-matricula">
                <form action="ServletMatricula" method="POST" class="form_matricula">
                    <div class="form-row">
                        <div class="col">
                            <label for="">Sede</label>
                            <select class="form-control" name="cbxSede">
                                <% for (Sede elem : daoSede.ListarSede()) {%>  
                                <option value="<%= elem.getId()%>"><%= elem.getNombre()%></option>
                                <% } %>
                            </select> 
                        </div>             
                        <div class="col">
                            <label for="">Ciclo</label>
                            <select class="form-control" name="cbxCiclo">
                                <% for (Ciclo elem : daoCiclo.ListarCiclos()) {%>  
                                <option value="<%= elem.getId()%>"><%= elem.getNombre()%></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="col">
                            <label for="">Turno</label>
                            <select class="form-control" name="cbxTurno">
                                <% for (Turno elem : daoTurno.ListarTurnos()) {%>  
                                <option value="<%= elem.getId()%>"><%= elem.getNombre()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                    <div class="c-subtitulo">
                        <div class="subtitulo">
                            <p>Datos Personales:</p>
                        </div>
                        <div class="division"></div>
                    </div>
                    <input type="hidden" name="txtIdEst" value="<%= idEst %>">        
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="">Dni *</label>
                            <input type="text" name="txtDni" value="<%= objE.getDni()%>" class="form-control" placeholder="Dni">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="">Teléfono *</label>
                            <input type="text" name="txtTelefono" value="<%= objE.getTelefono()%>" class="form-control" placeholder="Teléfono">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="">Nombre *</label>
                            <input type="text" name="txtNombre" value="<%= objE.getNombre()%>" class="form-control" placeholder="Nombre">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="">Email *</label>
                            <input type="text" name="txtEmail" value="<%= objE.getCorreo()%>" class="form-control" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="">Apellido *</label>
                            <input type="text" name="txtApellido" value="<%= objE.getApellido()%>" class="form-control" placeholder="Apellido">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="">Confirmar Email *</label>
                            <input type="text" class="form-control" placeholder="Confirmar Email">
                        </div>
                    </div>
                    <div class="center-block">
                        <button type="submit" class="btn btn-primary btnRegistrar">Corregir</button>
                    </div>
                    <input type="hidden" name="accion" value="actualizarMatricula">
                </form>
            </div>
        </main>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
</html>
