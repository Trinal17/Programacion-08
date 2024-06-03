package es.daw.web;

import es.daw.web.bd.DBConnection;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author melola
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {


    private String pathProperties = "";

    @Override
    public void init() {
        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:"+pathProperties);
    }


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
        // --------------------------------------
        // 1. LEER DATOS DE LA PÁGINA HTML

        // Para leer parámetros en formato UTF-8
        request.setCharacterEncoding("UTF-8");

        // Leer parámetros
        String id_cliente = request.getParameter("id_cliente");
        System.out.println("==========> id_cliente: "+id_cliente);

        // --------------------------------------



















        // DOS TIPOS DE SALIDA SEGÚN ESPECIFICACIONES ( O UNO U OTRA)
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("message", "SERVLET 1 OK!!!!!");
        //request.setAttribute("message", "[ERROR] No existe el cliente seleccionado");
        getServletContext().getRequestDispatcher("/resultado_mensaje.jsp").forward(request, response);


        request.setAttribute("cliente", "???????");
        request.setAttribute("filas", "???????");
        getServletContext().getRequestDispatcher("/resultado_tabla.jsp").forward(request, response);


    }

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

    @Override
    public void destroy() {
        try {
            super.destroy();
            DBConnection.closeConnection();

        } catch (SQLException ex) {
        	ex.printStackTrace();
        }

    }

}
