package es.daw.web.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.daw.web.model.Empleado;

public class DaoEmpleado implements Dao<Empleado>{

    private Connection con = null;

    public DaoEmpleado(String pathBD) throws SQLException{
        con = DBConnection.getConnection(pathBD);
    }

    @Override
    public Empleado select(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select'");
    }

    @Override
    public List<Empleado> selectAll() throws SQLException {
        try ( PreparedStatement ps = con.prepareStatement("SELECT * FROM empleado");
        ResultSet rs = ps.executeQuery();) {

            List<Empleado> empleados = null;

            while (rs.next()) {
                if (empleados == null) {
                    empleados = new ArrayList<>();
                }

                Empleado e = new Empleado();
                e.setNombre(rs.getString("nombre"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));
                e.setCodigo(rs.getInt("codigo"));
                e.setNIF(rs.getString("NIF"));
                e.setCodigo_departamento(rs.getInt("codigo_departamento"));
                empleados.add(e);
                System.out.println(e.toString());

            }

            return empleados;

        }



    }

    @Override
    public void insert(Empleado t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Empleado t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Empleado t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
