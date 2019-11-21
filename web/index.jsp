<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAN MARCOS</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/8719a7912f.js"></script>
        <link rel="stylesheet" href="css/header.css">
    </head>
    <body style="background: #154A97">
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
                        <%
                            String estado = "";
                            if (!nombre.equals("")) {
                                estado = "disabled";
                            }%>
                        <li class="nav-item">
                            <a class="nav-link <%=estado%>" href="matricula.jsp">Matrícula Online</a>
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
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="imagenes/01.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="imagenes/02.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="imagenes/03.png" class="d-block w-100" alt="...">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Anterior</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Siguiente</span>
                </a>
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
