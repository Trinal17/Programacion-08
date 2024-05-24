package es.daw.web;

import es.daw.web.bd.DBConnection;
import es.daw.web.bd.DaoEmpleado;
import es.daw.web.model.Empleado;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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


        DaoEmpleado daoE = null;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String message = "";
        boolean error = false;

        try(FileReader reader = new FileReader(pathJson)){

            Empleado[] empleados = gson.fromJson(reader, Empleado[].class);

            Set<Empleado> empleadosSet = new HashSet<>();
            System.out.println("****** EMPLEADOS DEL JSON *********");
            for (Empleado empleado : empleados) {
                System.out.println("NIF: " + empleado.getNIF());
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido1: " + empleado.getApellido1());
                System.out.println("Apellido2: " + empleado.getApellido2());
                System.out.println("Código departamento: " + empleado.getCodigo_departamento());
                System.out.println();

                empleadosSet.add(empleado);
            }      

            // Meter los objetos del array en un Set
            //Set<Empleado> empleadosSet = new HashSet<>(Arrays.asList(empleados));

            System.out.println("************* EMPLEADOS DEL JSON SIN REPETIR **********");
            empleadosSet.forEach(System.out::println);

            

            try {
                daoE = new DaoEmpleado(pathProperties);

                for (Empleado empleado : empleadosSet) {
                    daoE.insert(empleado);
                    message += empleado.getNIF()+" ";
                }

            } catch (SQLException e) {
                
                e.printStackTrace();
                System.out.println(e.getMessage());
                message = e.getMessage();
                error = true;
            }

        }


        // --------------------------------------
        // RESULTADO
        response.setContentType("text/html;charset=UTF-8");

        // El mensaje varía dependiendo de si ha habido error o no
        if (error)
            request.setAttribute("message", " [ERROR] "+message);    
        else
            request.setAttribute("message", "Insertados los empleados con NIF "+message);

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
