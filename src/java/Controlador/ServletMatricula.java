package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMatricula extends HttpServlet {

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
                RegistrarMatricula(request, response);
            }
            if (accion.equals("actualizarMatricula")) {
                ActualizarMatricula(request, response);
            }
        }
    }
    
    protected void RegistrarMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dniEst = request.getParameter("txtDni");
        String nombreEst = request.getParameter("txtNombre");
        String apellidoEst = request.getParameter("txtApellido");
        String correoEst = request.getParameter("txtEmail");
        String telefonoEst = request.getParameter("txtTelefono");
        int idSede = Integer.parseInt(request.getParameter("cbxSede"));
        int idTurno = Integer.parseInt(request.getParameter("cbxTurno"));
        int idCiclo = Integer.parseInt(request.getParameter("cbxCiclo"));

        Estudiante oEst = new Estudiante(dniEst, nombreEst, apellidoEst, correoEst, telefonoEst);
        EstudianteDao daoEst = new EstudianteDao();
        boolean resp1 = daoEst.RegistrarEstudiante(oEst);
        
        Matricula oMat = new Matricula(idSede, idTurno, idCiclo);
        MatriculaDao daoMat = new MatriculaDao();
        boolean resp2 = daoMat.RegistrarMatricula(oMat);
        
        int idEstudiante = daoMat.GetIdEst();
        
        if (resp1 && resp2) {
            response.sendRedirect("resultado.jsp?idEstudiante="+idEstudiante+"");
        } else {
            response.sendRedirect("matricula.jsp");
        }
        
    }
    
    protected void ActualizarMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idEst = Integer.parseInt(request.getParameter("txtIdEst"));
        String dniEst = request.getParameter("txtDni");
        String nombreEst = request.getParameter("txtNombre");
        String apellidoEst = request.getParameter("txtApellido");
        String correoEst = request.getParameter("txtEmail");
        String telefonoEst = request.getParameter("txtTelefono");
        
        int idSede = Integer.parseInt(request.getParameter("cbxSede"));
        int idTurno = Integer.parseInt(request.getParameter("cbxTurno"));
        int idCiclo = Integer.parseInt(request.getParameter("cbxCiclo"));

        Estudiante oEst = new Estudiante(idEst,dniEst, nombreEst, apellidoEst, correoEst, telefonoEst);
        EstudianteDao daoEst = new EstudianteDao();
        boolean resp1 = daoEst.ActualizarEstudiante(oEst);
        
        Matricula oMat = new Matricula(idSede, idTurno, idCiclo);
        oMat.setId(idEst);
        MatriculaDao daoMat = new MatriculaDao();
        boolean resp2 = daoMat.ActualizarMatricula(oMat);

        if (resp1 && resp2) {
            response.sendRedirect("resultado.jsp?idEstudiante="+idEst+"");
        } else {
            response.sendRedirect("matricula.jsp");
        }
        
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
