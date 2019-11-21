<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        <link href="css/logeo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            String mensaje = "";
            if (request.getParameter("mens") != null) {
                mensaje = request.getParameter("mens");
            }
        %>
        <div class="contenedor">
            <div class="c-cabecera">
                <h1>INICIAR SESIÓN</h1>
            </div>
            <div class="c-datos">
                <form action="ServletAdministrador" method="POST">
                    <input type="text" name="txtUsu" placeholder="Usuario"  class="o-dato ">
                    <input type="password" name="txtClave" placeholder="Contraseña" class="o-dato ">
                    <span><%= mensaje %></span>
                    <input type="submit" value="Acceder" class="o-dato ">
                    <input type="hidden" name="accion" value="login">
                </form>
            </div>
        </div>
    </body>
</html>
