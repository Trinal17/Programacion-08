package es.daw.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import es.daw.web.bd.DBConnection;
import es.daw.web.bd.DaoFabricante;
import es.daw.web.bd.DaoProducto;
import es.daw.web.model.Fabricante;
import es.daw.web.model.Producto;
import es.daw.web.util.Utils;

@WebServlet(name = "Dao2Servlet", value = "/Dao2Servlet")
public class Dao2Servlet extends HttpServlet {

    private String pathProperties = "";

    @Override
    public void init() {
        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:" + pathProperties);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Recoger datos enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio"); // como String
        String codigo_fabricante = request.getParameter("codigo_fabricante");
        String operacion = request.getParameter("operacion");
        String codigo = request.getParameter("codigo");

        System.out.println("operacion: "+operacion);
        System.out.println("nombre: "+nombre);
        System.out.println("precio: "+precio);
        System.out.println("codigo_fabricante: "+codigo_fabricante);
        System.out.println("codigo: "+codigo);

        DaoProducto daoP = null;
        DaoFabricante daoF = null;
        List<Producto> productos = null;
        List<Fabricante> fabricantes = null;

        // ---------- operando contra BD ---------------
        try {
            daoP = new DaoProducto(pathProperties);
            daoF = new DaoFabricante(pathProperties);

            Producto p = null;
            switch (operacion) {
                case "insert":
                    System.out.println("Voy a insertar...");
                    p = new Producto();
                    p.setNombre(nombre);
                    p.setPrecio(Float.parseFloat(precio));
                    p.setCodigo_fabricante(Integer.parseInt(codigo_fabricante));
                    // Necesito un objeto producto
                    daoP.insert(p);
                    System.out.println("[insert] se ha creado el producto...");
                    break;
                case "update":
                    p = new Producto();
                    p.setCodigo(Integer.parseInt(codigo));
                    p.setNombre(nombre);
                    daoP.update(p);
                    break;
                case "delete":
                    daoP.delete(Integer.parseInt(codigo));
                    break;
           
            }

            // Cargo la lista de productos actualizada
            productos = daoP.selectAll();
            fabricantes = daoF.selectAll();


        } catch (SQLException e) {
            System.out.println("[ERROR] EN LA OPERACIÓN "+operacion);
            e.printStackTrace();
            System.out.println(e.getMessage());

            // Podría pedir pintar en un fichero de log los mensajes de error...

        }
        // ---------------------



        // ------------ SALIDA ------------
        response.setContentType("text/html"); // os lo doy yo...

        StringBuffer sb = new StringBuffer();
        
        if (productos != null){
            productos.sort(Comparator.reverseOrder());

            for (Producto p : productos) {
                sb.append("<tr><td>").append(p.getCodigo()).append("</td>");
                sb.append("<td>").append(p.getNombre()).append("</td>");
                sb.append("<td>").append(p.getPrecio()).append("</td>");
                sb.append("<td>").append(Utils.obtenerNombreFabricante(fabricantes, p.getCodigo_fabricante())).append("</td></tr>");
            }
        }

        request.setAttribute("filas", sb.toString());
        getServletContext().getRequestDispatcher("/informe.jsp").forward(request, response);

    }

    @Override
    public void destroy() {
        super.destroy();

        try {
            DBConnection.closeConnection();
        } catch (SQLException ex) {
            System.err.println("[processRequest][ERROR AL CERRA LA CONEXIÓN]" + ex.getMessage());
        }

    }
}