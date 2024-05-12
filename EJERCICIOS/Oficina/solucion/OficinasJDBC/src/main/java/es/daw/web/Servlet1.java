package es.daw.web;

import es.daw.web.bd.DBConnection;
import es.daw.web.bd.DaoOficina;
import es.daw.web.model.Oficina;
import es.daw.web.util.Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
        String cod_oficina = request.getParameter("cod_oficina");
        System.out.println("==========> CODIGO DE OFICINA: "+cod_oficina);

        String[] campos = request.getParameterValues("campo");
        System.out.println("==========>  campos: "+Arrays.toString(campos));
        //List<String> idCampos = Arrays.asList(campos);
        // --------------------------------------

        // 2. DECLARANDO VARIABLES, OBJETOS... 
        DaoOficina daoO = null;
        List<Oficina> oficinas = null;

        StringBuilder sb = new StringBuilder(); // salida

        // 3. INICIALIZO LOS DAO... NECESITO EL TRY ... CATCH

        try {
            daoO = new DaoOficina(pathProperties);
            oficinas = daoO.selectAll();

            if (campos == null){
                response.sendRedirect("error.html");
            }else{
                System.out.println("===========>");
                Oficina oficina = Utils.getOficinaByCod(cod_oficina,oficinas);

                // Montar dinámicamente el encabezado de la tabla
                sb.append("<tr>");
                for (String campo : campos) {
                    sb.append("<th>").append(campo).append("</th>");
                }
                sb.append("</tr>");

                // Montar el cuerpo (fila con los valores)
                sb.append("<tr>");
                for (String campo : campos) {
                    switch (campo) {
                        case "ciudad":
                            sb.append("<td>").append(oficina.getCiudad()).append("</td>");
                            break;
                        case "pais":
                            sb.append("<td>").append(oficina.getPais()).append("</td>");
                            break;
                        case "telefono":
                            sb.append("<td>").append(oficina.getTelefono()).append("</td>");
                            break;
                        case "direccion":
                            sb.append("<td>").append(oficina.getLinea_direccion1()+","+oficina.getLinea_direccion2()).append("</td>");
                            break;

                    }
                }
                sb.append("</tr>");

                // --------------------------------------
                // 4. RESULTADO
                // Os proporciono este código, vosotros rellenáis el sb según el resultado
                response.setContentType("text/html;charset=UTF-8");
                request.setAttribute("cod_oficina", cod_oficina);
                request.setAttribute("filas", sb.toString());
                getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
