
package es.daw.web.bd;

import es.daw.web.model.Empleado;
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
public class DaoEmpleado implements Dao<Empleado>{
    
    private Connection con = null;

    public DaoEmpleado(String dbSettingsPropsFilePath) throws SQLException {
        con = DBConnection.getConnection(dbSettingsPropsFilePath);
    }
    

    @Override
    public Empleado select(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Empleado> selectAll() throws SQLException {
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM empleado")){
            
            ResultSet rs = ps.executeQuery();

            List<Empleado> empleados = new ArrayList<>();

            while (rs.next()) {
                Empleado e = new Empleado();
                e.setCodigo_empleado(rs.getInt("codigo_empleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));
                e.setExtension(rs.getString("extension"));
                e.setEmail(rs.getString("email"));
                e.setCodigo_oficina(rs.getString("codigo_oficina"));
                e.setPuesto(rs.getString("puesto"));
                empleados.add(e);

            }

            return empleados;

        }
        
        
    }

    @Override
    public void insert(Empleado t) throws SQLException {
        
        // MariLuz, Elola, Rubio, 2519, melola@educa.madrid.org, ALCALA-ES, Subdirector oficina
        try(PreparedStatement ps = con.prepareStatement("INSERT INTO empleado "
                + "(nombre, apellido1, apellido2, extension, email, codigo_oficina, puesto) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)")){
            
            ps.setString(1,t.getNombre());
            ps.setString(2, t.getApellido1());
            ps.setString(3, t.getApellido2());
            ps.setString(4, t.getExtension());
            ps.setString(5, t.getEmail());
            ps.setString(6, t.getCodigo_oficina());
            ps.setString(7, t.getPuesto());
            
            ps.executeUpdate();
            System.out.println("[INSERT] Nuevo empleado dado de alta "+t.toString());
        }
        
    }

    @Override
    public void update(Empleado t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Empleado t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
