package es.daw.web.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import es.daw.web.model.Fabricante;

public class DaoFabricante implements Dao<Fabricante>{
    
	private Connection con;
	
    public DaoFabricante(String dbSettingsPropsFilePath) throws SQLException {
		super();
		con = DBConnection.getConnection(dbSettingsPropsFilePath);
	}

    @Override
    public Fabricante select(int id) throws SQLException {

        ResultSet rs = null;
        try(PreparedStatement ps = con.prepareStatement("SELECT nombre from fabricante where codigo = ?")){

            // Indicar qué es cada ?
            ps.setInt(1, id);

            // Ejecuto la query
            rs = ps.executeQuery();

            // Devuelve un único registro
            if (rs.next()){
                Fabricante f = new Fabricante();
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
    public List<Fabricante> selectAll() throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM fabricante");
        ResultSet rs = ps.executeQuery()){

	        List<Fabricante> result = null;
	
	        while (rs.next()) {
	            if (result == null) {
	                result = new ArrayList<>();
	            }
	
	            Fabricante p = new Fabricante();
	            p.setCodigo(rs.getInt("codigo"));
	            p.setNombre(rs.getString("nombre"));
	            result.add(p);
	            
	        }
	        return result;
        }
		
    }

    @Override
    public void insert(Fabricante t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Fabricante t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Fabricante t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
