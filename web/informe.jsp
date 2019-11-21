<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/8719a7912f.js"></script>
        <link rel="stylesheet" href="css/header.css">
        <link href="css/informe.css" rel="stylesheet" type="text/css"/>
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
            <style>
                
            </style>
            <%
                int numero = daoAdmin.ObtenerNumFilas();
            %>
            <div class="c-totalReg">
                <h3>TOTAL DE REGISTROS: </h3>
                <h4><%= numero %></h4>
            </div>
            <div class="c-tabla">
                <%
                    ArrayList<Informe> listado = daoAdmin.InformeDeMatriculados();
                %>
                <table>
                    <thead>
                    <th>DNI</th>
                    <th>NOMBRES</th>
                    <th>APELLIDOS</th>
                    <th>SEDE</th>
                    <th>CICLO</th>
                    <th>TURNO</th>
                    <th>MONTO</th>
                    <th>FECHA MATRICULA</th>
                    <th>EXPIRACIÓN</th>
                    </thead>
                    <%
                        for (Informe elem : listado) {
                    %>
                    <tr>
                        <td><%= elem.getDniE()%></td>
                        <td><%= elem.getNombreE()%></td>
                        <td><%= elem.getApellidoE()%></td>
                        <td><%= elem.getNomSede()%></td>
                        <td><%= elem.getNomCiclo()%></td>
                        <td><%= elem.getNomTurno()%></td>
                        <td><%= elem.getMonto()%></td>
                        <td><%= elem.getFechaReg()%></td>
                        <td><%= elem.getFechaExp()%></td>
                    </tr>
                    <% }%>
                </table>
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
