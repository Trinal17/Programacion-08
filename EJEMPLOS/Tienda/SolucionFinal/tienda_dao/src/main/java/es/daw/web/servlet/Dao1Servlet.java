package es.daw.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import es.daw.web.bd.DaoFabricante;
import es.daw.web.bd.DaoProducto;
import es.daw.web.model.Fabricante;
import es.daw.web.model.Producto;
import es.daw.web.util.Utils;


@WebServlet(name = "Dao1Servlet", value = "/Dao1Servlet")
public class Dao1Servlet extends HttpServlet {

    // ------------------------------------
    // Os lo doy!!!!
    private String pathProperties = "";

    @Override
    public void init() {
        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:"+pathProperties);
    }
    // ------------------------------------

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DaoProducto daoP = null;
        DaoFabricante daoF = null;

        List<Fabricante> fabricantes = null;
        List<Producto> productos = null;

        String error = "";

        try {
            daoP = new DaoProducto(pathProperties);
            daoF = new DaoFabricante(pathProperties);

            productos = daoP.selectAll();
            fabricantes = daoF.selectAll();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            error = e.getMessage();
        }

        // ------------ SALIDA ------------
        response.setContentType("text/html");

        StringBuilder sb = new StringBuilder();

        for (Producto producto : productos) {
            sb.append("<tr><td>").append(producto.getCodigo()).append("</td>");
            sb.append("<td>").append(producto.getNombre()).append("</td>");
            sb.append("<td>").append(producto.getPrecio()).append("</td>");

            //  buscar en la lista de fabricantes el nombre del fabricante cuyo código es...
            //sb.append("<td>").append(producto.getCodigo_fabricante()).append("</td></tr>");
            try {
                sb.append("<td>")

                //Forma 1: vía programación
                //.append(Utils.obtenerNombreFabricante(fabricantes, producto.getCodigo_fabricante()))

                // Forma 2: vía BD
                //Obtener el nombre del fabricante a través del código consultando BD
                .append(daoF.select(producto.getCodigo_fabricante()).getNombre())
                .append("</td></tr>");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                error = e.getMessage();
            }
        }

        if (!error.equals("")){
            request.setAttribute("filas", error);    
        }
        else
            request.setAttribute("filas", sb.toString());

        getServletContext().getRequestDispatcher("/informe.jsp").forward(request, response);

    }

    @Override
    public void destroy() {
    }
}