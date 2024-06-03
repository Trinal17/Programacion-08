package es.daw.web;

import java.io.IOException;

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

    private String pathCSV = "";

    @Override
    public void init() {
        pathCSV = getServletContext().getRealPath("/clientes.csv");
        System.out.println("pathCSV:"+pathCSV);
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
        request.setAttribute("message", "SERVLET 2 OK!!!");

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
        super.destroy();
    }
}
