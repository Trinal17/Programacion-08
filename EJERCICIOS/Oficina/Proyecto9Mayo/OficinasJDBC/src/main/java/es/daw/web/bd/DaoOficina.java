package es.daw.web.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.daw.web.model.Oficina;

public class DaoOficina implements Dao<Oficina>{

    private Connection con = null;

    public DaoOficina(String pathPropString) throws SQLException{
        con = DBConnection.getConnection(pathPropString);
    }

    @Override
    public Oficina select(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select'");
    }

    @Override
    public List<Oficina> selectAll() throws SQLException {

        // SELECT * FROM OFICINA
        // private String codigo_oficina;
        // private String ciudad,pais,region,codigo_postal,telefono;
        // private String linea_direccion1, linea_direccion2;

        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM oficina");
            ResultSet rs = ps.executeQuery()){

            List<Oficina> oficinas = new ArrayList<>();

            while(rs.next()){
                Oficina o = new Oficina();
                o.setCodigo_oficina(rs.getString("codigo_oficina"));
                o.setCiudad(rs.getString("ciudad"));
                o.setPais(rs.getString("pais"));
                o.setRegion(rs.getString("region"));
                o.setCodigo_postal(rs.getString("codigo_postal"));
                o.setTelefono(rs.getString("telefono"));
                o.setLinea_direccion1(rs.getString("linea_direccion1"));
                o.setLinea_direccion2(rs.getString("linea_direccion2"));
                oficinas.add(o);
            }

            return oficinas;

        }
        
    }

    @Override
    public void insert(Oficina t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Oficina t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Oficina t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
