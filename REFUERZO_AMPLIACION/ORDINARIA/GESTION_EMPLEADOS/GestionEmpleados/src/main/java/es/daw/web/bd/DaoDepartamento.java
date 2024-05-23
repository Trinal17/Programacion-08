package es.daw.web.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.daw.web.model.Departamento;

public class DaoDepartamento implements Dao<Departamento>{

    private Connection con = null;

    public DaoDepartamento(String pathBD) throws SQLException{
        con = DBConnection.getConnection(pathBD);

    }

    @Override
    public Departamento select(int id) throws SQLException {

        ResultSet rs = null;
        try(PreparedStatement ps = con.prepareStatement("SELECT nombre from departamento where codigo = ?")){

            // Indicar qué es cada ?
            ps.setInt(1, id);

            // Ejecuto la query
            rs = ps.executeQuery();

            // Devuelve un único registro
            if (rs.next()){
                Departamento f = new Departamento();
                f.setNombre(rs.getString("nombre")); // puedo poner 
                return f;
            }
            
        }finally{
            if (rs != null)
                rs.close();
        }        

        return null;        


    }

    @Override
    public List<Departamento> selectAll() throws SQLException {
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM departamento");
        ResultSet rs = ps.executeQuery();){

            List<Departamento> departamentos = null;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<>();
                }

                Departamento d = new Departamento();
                d.setCodigo(rs.getInt("codigo"));
                d.setNombre(rs.getString("nombre"));
                d.setGastos(rs.getDouble("gastos"));
                d.setPresupesto(rs.getDouble("presupuesto"));
                departamentos.add(d);

            }

            return departamentos;

        }
        
    }

    @Override
    public void insert(Departamento t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Departamento t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Departamento t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
}
