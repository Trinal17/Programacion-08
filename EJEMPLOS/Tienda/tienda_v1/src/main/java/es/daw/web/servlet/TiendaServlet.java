/*
 * Copyright 2020 Diego Silva <diego.silva at apuntesdejava.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.daw.web.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


@WebServlet(name = "TiendaServlet", value = "/TiendaServlet")
public class TiendaServlet extends HttpServlet {

    // Donde guardar la url de conexión
    private String url = "";
    //private String url = "jdbc:sqlite:/home/melola/SQLite/tienda.db";
    //private String url = "jdbc:sqlite:F:\\sqlite\\Tienda\\tienda.db";


    private Connection conn = null;

    @Override
    public void init() {
        
        String pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:"+pathProperties);

        try(FileInputStream input = new FileInputStream(pathProperties)){
            // System.out.println("1) Cargar dinámicamente la clase del contrador JDBC de SQLite en tiempo de ejecución");
            System.out.println("1) Cargar dinámicamente la clase del contrador JDBC de SQLite en tiempo de ejecución");
            Class.forName("org.sqlite.JDBC");

            System.out.println("2) Montar la URL de conexión");
            Properties props =  new Properties();
            System.out.println("input:"+input);
            props.load(input);
            System.out.println("props:"+props);
            url = props.getProperty("url");
            System.out.println("URL:"+url);

            System.out.println("3) Obtener la conexión a la BD");
            conn = DriverManager.getConnection(url);

            System.out.println("Conexión a SQLite establecida:"+conn);


        } catch(IOException | ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }



    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<Integer,String> fabricantes = new LinkedHashMap<>();

        String sql="select * from fabricante";

        try(        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                while(rs.next()){
                    fabricantes.put(rs.getInt("codigo"),rs.getString("nombre"));
                }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // ------------ SALIDA ------------
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> LISTADO DE FABRICANTES </h1>");
        out.println("<table border='1'><tr><th>CÓDIGO</th><th>FABRICANTE</th></tr>");
        for (Map.Entry<Integer,String> fila : fabricantes.entrySet()) {
            out.println("<tr><td>"+fila.getKey()+"</td><td>"+fila.getValue()+"</td></tr>");
        }
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}