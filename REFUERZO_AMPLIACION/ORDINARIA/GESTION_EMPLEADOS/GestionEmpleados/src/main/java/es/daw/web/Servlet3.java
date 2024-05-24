package es.daw.web;

import es.daw.web.bd.DBConnection;
import es.daw.web.model.Empleado;
import es.daw.web.util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author daw1a
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {

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


        Map<Integer,String> departamentos = new LinkedHashMap<>();
        departamentos.put(1,"Desarrollo");
        departamentos.put(2,"Sistemas");
        departamentos.put(3,"Contabilidad");


        // Path al directorio padre CSV_EXAM
        Path home = Paths.get(System.getProperty("user.home"),"CSV_EXAM");
        // Path home2 = Paths.get(System.getProperty("user.home")+"/CSV_EXAM");
        // Path home3 = Paths.get(System.getProperty("user.home")+File.separator+"CSV_EXAM");

        // Si no existe el CSV_EXAM lo creo
        // if (!Files.exists(home))
        //         Files.createDirectory(home);

        // Crear los subdirectorios
        for (Map.Entry<Integer,String> departamento : departamentos.entrySet()){
            Utils.crearCSV(home, departamento.getValue());
        }

        // Obtener los empleados a insertar en los distintos CSV
        List<Empleado> empleados = Utils.obtenerEmpleadosServlet3();

        for (Empleado empleado : empleados) {
            Integer cod_dpto = empleado.getCodigo_departamento();

            String nombreDepartamento = departamentos.get(cod_dpto);

            Utils.escribirEnCSV(empleado,home,nombreDepartamento);

        }

        // --------------------------------------
        // RESULTADO
        response.setContentType("text/html;charset=UTF-8");

        // El mensaje varía dependiendo de si ha habido error o no
        request.setAttribute("message", "Realizada la exportación correctamente");

        getServletContext().getRequestDispatcher("/resultado_mensaje.jsp").forward(request, response);



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
