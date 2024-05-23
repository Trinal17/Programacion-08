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
 * Servlet encargado de la creación de pedidos
 *
 * @author daw1a
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    private String pathJson = "";
    private String pathProperties = "";

    @Override
    public void init() {
        pathJson = getServletContext().getRealPath("/empleados.json");
        System.out.println("pathJson:"+pathJson);

        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:"+pathProperties);

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
        
        // Para leer parámetros en formato UTF-8
        request.setCharacterEncoding("UTF-8");


        
        







        // --------------------------------------
        // RESULTADO
        response.setContentType("text/html;charset=UTF-8");

        // El mensaje varía dependiendo de si ha habido error o no
        request.setAttribute("message", "Resultado Servlet 2 ??????????????????????????????");

        getServletContext().getRequestDispatcher("/resultado_mensaje.jsp").forward(request, response);
        
    	
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
        doGet(request, response);
    }


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
