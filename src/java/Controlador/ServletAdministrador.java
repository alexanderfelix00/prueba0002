package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aimar
 */
public class ServletAdministrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String accion = request.getParameter("accion");

            if (accion.equals("registrarMatricula")) {
                Login(request, response);
            }if (accion.equals("login")) {
                Login(request, response);
            }if (accion.equals("logout")) {
                CerrarSesion(request, response);
            }
        }
    }

    protected void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("txtUsu");
        String clave = request.getParameter("txtClave");

        try {
            AdministradorDao daoAd = new AdministradorDao();
            Administrador objA = daoAd.ValidarUsuario(usuario);

            if (usuario.equals(objA.getUsuario())) {
                if (clave.equals(objA.getClave())) {
                    request.getSession().setAttribute("idUsuario", objA.getId());
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("login.jsp?mens=Datos no Validos *");
                }
            } else {
                response.sendRedirect("login.jsp?mens=Datos no Validos *");
            }
        } catch (Exception ex) {
            out.println(ex);
        }
    }
    protected void CerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
