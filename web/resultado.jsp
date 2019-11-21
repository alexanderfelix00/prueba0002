<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Document</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/8719a7912f.js"></script>       
        <link rel="stylesheet" href="css/header.css">
        <link href="css/resultado.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String nombre = "";
            AdministradorDao daoAdmin = new AdministradorDao();
            Administrador objA = new Administrador();
            int id = 0;
            if (sesion.getAttribute("idUsuario") != null) {
                id = Integer.parseInt(sesion.getAttribute("idUsuario").toString());
                objA = daoAdmin.ListarDatosPorId(id);
                nombre = objA.getNombre() + " " + objA.getApellido();
            }
        %>
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
                        <%
                            String estado2 = "";
                            if (nombre.equals("")) {
                                estado2 = "disabled";
                            }%>
                        <li class="nav-item">
                            <a class="nav-link <%=estado2%>" href="informe.jsp">Informes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <%= nombre%>
                            </a>
                        </li>
                        <%  if (nombre.equals("")) {%>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">
                                <i class="right-i fas fa-user"></i>
                            </a>
                        </li>
                        <% }%>

                        <%  if (!nombre.equals("")) {%>
                        <li class="nav-item">
                            <a class="nav-link" href="ServletAdministrador?accion=logout">
                                <i class="right-i fas fa-door-open"></i>
                            </a>
                        </li>
                        <% }%>
                    </ul>
                </div>
            </nav>
        </header>
        <main>
            <%
                Estudiante obj = new Estudiante();
                int idEst = Integer.parseInt(request.getParameter("idEstudiante"));

                EstudianteDao daoE = new EstudianteDao();
                obj = daoE.ListarEstudiantePorId(idEst);

                Matricula obj2 = new Matricula();
                MatriculaDao daoM = new MatriculaDao();

                obj2 = daoM.DatosMatriculaPorID(idEst);
            %>
            <div class="form-row c-respuesta">
                <div class="o-verificar">
                    <div class="titulo-verificar">
                        <p>Verifique sus Datos</p>
                    </div>
                    <div></div>
                    <div class="col c-datos">
                        <div class="o-divisor_datos">
                            <label class="o-dato ">Apellidos:</label>
                            <label class="o-dato ">Nombres:</label>
                            <label class="o-dato ">DNI:</label>
                            <label class="o-dato ">Sede:</label>
                            <label class="o-dato ">Ciclo:</label>
                            <label class="o-dato ">Turno:</label>
                            <label class="o-dato ">Correo:</label>
                            <label class="o-dato ">Monto:</label>
                        </div>
                        <div class="o-divisor_datos">
                            <label class="o-dato "><%= obj.getApellido()%></label>
                            <label class="o-dato "><%= obj.getNombre()%></label>
                            <label class="o-dato "><%= obj.getDni()%></label>
                            <label class="o-dato "><%= obj2.getNomSede()%></label>
                            <label class="o-dato "><%= obj2.getNomCiclo()%></label>
                            <label class="o-dato "><%= obj2.getNomTurno()%></label>
                            <label class="o-dato "><%= obj.getCorreo()%></label>
                            <label class="o-dato ">S/ <%= obj2.getMonto()%></label>
                        </div>
                    </div>
                    <div class="botones-verificar">
                        <a href="index.jsp" class="btnFinalizar">
                            <input type="button" class="btn btn-primary btnFinalizar" value="Finalizar">
                        </a>
                        <input type="button" class="btn btn-primary btnCorregir" value="Corregir"  onclick="location.href = 'actualizarMatricula.jsp?idUpdEst=<%= idEst%>'">
                    </div>
                </div>
                <div class="o-final">
                    <div class="titulo-verificar">
                        <p>Importante</p>
                    </div>
                    <div class="mensaje-final">
                        <p>
                            Para <b>FINALIZAR TU MATRÍCULA</b>, puedes acercarte en una hora a las agencias del <b>Banco Scotiabank</b>
                            para realizar el pago a nombre de la Academia San Marcos con el DNI N° <b><%= obj.getDni()%></b>. Luego te
                            llegará la constancia de matrícula al correo que indicaste (revisar en Spam o en Correo No Deseado).
                        </p>
                        <p>
                            La vacante reservada estará disponible hasta la fecha <b><%= obj2.getFechaExpiracion()%> a las 5:30 pm</b>.
                        </p>
                    </div>
                </div>
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
