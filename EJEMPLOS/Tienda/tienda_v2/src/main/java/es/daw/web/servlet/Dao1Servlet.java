package es.daw.web.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import es.daw.web.bd.DaoFabricante;
import es.daw.web.model.Fabricante;


@WebServlet(name = "Dao1Servlet", value = "/Dao1Servlet")
public class Dao1Servlet extends HttpServlet {

    private Connection conn = null;

    private String pathProperties = "";

    @Override
    public void init() {
        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:"+pathProperties);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DaoFabricante daoF = null;
        List<Fabricante> fabricantes = null;

        try{    
            daoF = new DaoFabricante(pathProperties);
            fabricantes = daoF.selectAll();

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // ------------ SALIDA ------------
        response.setContentType("text/html");

        try(PrintWriter out = response.getWriter()){
            out.println("<html><body>");
            out.println("<h1> LISTADO DE FABRICANTES </h1>");
            out.println("<table border='1'><tr><th>CÓDIGO</th><th>FABRICANTE</th></tr>");
    
            for (Fabricante fabricante : fabricantes) {
                out.println("<tr><td>"+fabricante.getCodigo()+"</td><td>"+fabricante.getNombre()+"</td></tr>");
            }
    
            out.println("</body></html>");
        }
    }

    @Override
    public void destroy() {
    }
}