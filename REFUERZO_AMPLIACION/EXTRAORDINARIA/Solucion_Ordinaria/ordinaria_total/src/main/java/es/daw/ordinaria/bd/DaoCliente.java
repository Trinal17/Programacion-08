
package es.daw.ordinaria.bd;

import es.daw.ordinaria.modelBD.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melola
 */
public class DaoCliente implements Dao<Cliente>{
    
    private Connection con = null;

    public DaoCliente() throws SQLException {
        con = DBConnection.getConnection();
    }
    

    @Override
    public Cliente select(int id) throws SQLException {
        ResultSet rs = null;
        try ( PreparedStatement ps = con.prepareStatement("SELECT nombre,apellido1,apellido2 FROM cliente where id = ?")
         ) {

            ps.setInt(1, id);
            rs = ps.executeQuery();

            Cliente c = null;
            if (rs.next()) {
                c = new Cliente();
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));
                c.setApellido2(rs.getString("apellido2"));
            }
            // else{
            //     c = new Cliente();
            //     c.setNombre("Desconocido");
            //     c.setApellido1("");
            // }

            return c;

        }
        finally{
            if (rs != null)
                rs.close();
        }
        
    }

    @Override
    public List<Cliente> selectAll() throws SQLException {
        try ( PreparedStatement ps = con.prepareStatement("SELECT * FROM cliente");
        ResultSet rs = ps.executeQuery();) {

            List<Cliente> clientes = null;

            while (rs.next()) {
                if (clientes == null) {
                    clientes = new ArrayList<>();
                }

                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));
                c.setApellido2(rs.getString("apellido2"));
                c.setCiudad(rs.getString("ciudad"));
                c.setCategoría(rs.getInt("categoría"));
                clientes.add(c);


            }

            return clientes;

        }
        
        
    }

    @Override
    public void insert(Cliente t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Cliente t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Cliente t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
