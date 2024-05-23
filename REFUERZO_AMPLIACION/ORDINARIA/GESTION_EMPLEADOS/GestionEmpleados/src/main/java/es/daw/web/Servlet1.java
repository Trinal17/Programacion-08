package es.daw.web;

import es.daw.web.bd.DBConnection;
import es.daw.web.bd.DaoDepartamento;
import es.daw.web.bd.DaoEmpleado;
import es.daw.web.model.ComparatorByName;
import es.daw.web.model.Departamento;
import es.daw.web.model.Empleado;
import es.daw.web.util.Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
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

        // -----------------------
        // Para leer parámetros en formato UTF-8
        request.setCharacterEncoding("UTF-8");

        // Leer parámetros
        String cod_departamento = request.getParameter("cod_departamento");
        System.out.println("==========> DEPARTAMENTO: "+cod_departamento);

        String orden = request.getParameter("orden");
        System.out.println("==========> ORDEN: "+orden);
        // -----------------------

        // -----------------------
        
        DaoEmpleado daoE = null;
        DaoDepartamento daoD = null;
        List<Empleado> empleados = null;
        List<Departamento> departamentos = null;

        StringBuilder sb = new StringBuilder(); 

        try {
            daoE = new DaoEmpleado(pathProperties);
            daoD = new DaoDepartamento(pathProperties);

            empleados = daoE.selectAll();
            departamentos = daoD.selectAll();

            // En el caso de que no sea TODOS compruebo si el cod_departemento existe
            if (!cod_departamento.equals("0")){
                // comprobar que existe el departamento

                if (!Utils.existeDepartamento(departamentos,cod_departamento)){
                    // Si no existe la oficina seleccionada de la lista html...
                    request.setAttribute("message", "No existe el departamento seleccionado");
                    getServletContext().getRequestDispatcher("/resultado_mensaje.jsp").forward(request, response);
                }else{
                    // Existe el departamento y tengo que filtrar por empleados de ese departamento
                    empleados = Utils.obtenerEmpleadoByDepartamento(empleados, cod_departamento);
                }


            }


            // Gestionar el orden. Pendiente!!!!
            if (orden.equals("orden_nif")){
                System.out.println("Ordenar de forma natural...");
                // ordenar de forma natural => Comparable
                Collections.sort(empleados);
                // sort
            }
            else if (orden.equals("orden_nombre")){
                // ordenar por nombre ==> Comparator

                // sort
                //empleados.sort( (e1,e2) -> e1.getNombre().compareTo(e2.getNombre()));

                empleados.sort(new ComparatorByName());
            }

            for (Empleado e : empleados) {
                sb.append("<tr><td>").append(e.getCodigo()).append("</td>")
                .append("<td>").append(e.getNIF()).append("</td>")    
                .append("<td>").append(e.getNombre()).append(" ").append(e.getApellido1()).
                append(" ").append(e.getApellido2()).append("</td>");

                //sb.append("<td>"+e.getCodigo_departamento()+"</td></tr>");

                // pendiente obtener el nombre del dpto
                Departamento d = daoD.select(e.getCodigo_departamento());
                if (d != null){
                    sb.append("<td>").append(d.getNombre()).append("</td></tr>");
                }else{
                    sb.append("<td>Sin departamento</td></tr>");
                }


            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());

            // A parte de pintarse por consola las excepciones que se escriban en un fichero de log...
        }


        // --------------------------------------
        // CÓDIGO PARA UTILIZAR COMO RESULTADO...
        // Pendiente que controléis cuándo utilizar uno u otro
        response.setContentType("text/html;charset=UTF-8");

        // Para devolver la tabla con los empleados correspondientes...
        request.setAttribute("filas", sb.toString());
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
