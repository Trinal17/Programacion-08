package es.daw.web;

import es.daw.web.bd.DBConnection;
import es.daw.web.bd.DaoEmpleado;
import es.daw.web.bd.DaoOficina;
import es.daw.web.model.Empleado;
import es.daw.web.model.Oficina;
import es.daw.web.util.Utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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

    private String pathProperties = "";

    @Override
    public void init() {
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
        
        // ---------------------------------- FICHERO DE LOG DE REGISTRO DE NUEVOS EMPLEADOS ------------------
        String path_log = System.getProperty("user.home")+File.separator+"LOG";
        // --------------------------------------------------------------------------------------------------
        
        // Leer parámetros. Siempre se leen como String, luego habría que parsearlos correctamente según corresponda
        String info_empleado = request.getParameter("empleado");
        //MariLuz,Elola,Rubio,2519,melola@educa.madrid.org,ALCALA-ES,Subdirector oficina
        String[] info = info_empleado.split(",");
        String cod_oficina = info[5]; // está en la posición 5

        
        String mensaje = "";
        
        DaoEmpleado daoE = null;
        DaoOficina daoO = null;

        List<Oficina> oficinas = null;

        try {
            daoE = new DaoEmpleado(pathProperties);
            daoO = new DaoOficina(pathProperties);

            oficinas = daoO.selectAll();

            // Necesito saber si el cod_oficina se encuentra en la lista de oficinas (busco en sus códigos)
            if (Utils.existeOficina(cod_oficina, oficinas)){
                Empleado e = new Empleado();
                //MariLuz,Elola,Rubio,2519,melola@educa.madrid.org,ALCALA-ES,Subdirector oficina
                e.setNombre(info[0]);
                e.setApellido1(info[1]);
                e.setApellido2(info[2]);
                e.setExtension(info[3]);
                e.setEmail(info[4]);
                e.setCodigo_oficina(info[5]);
                e.setPuesto(info[6]);
                daoE.insert(e);

                // si pasa por aquí es que ha ido bien!!!
                mensaje = String.format("El cliente %s %s se ha dado de alta correctamente",info[0],info[1]);

                Utils.writeLog(path_log,"empleados.log",Utils.getDateTime()+" "+e.toString());

            }else{
                mensaje = String.format("ERROR: el código de oficina %s no existe en la BD ",cod_oficina);
                request.setAttribute("message", mensaje);
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // --------------------------------------
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> "+mensaje+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    	
    	
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
