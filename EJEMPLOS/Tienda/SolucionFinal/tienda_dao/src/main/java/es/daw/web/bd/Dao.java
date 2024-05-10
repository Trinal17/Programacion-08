package es.daw.web.bd;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz genérica DAO
 * @author melola
 * @param <T>
 */
public interface Dao<T> {
	
    public T select(int id) throws SQLException;

    // // Si necesito una query tipo:
    // // Select precio from producto where nombre = 'xxxxx'
    // public T select(String valor) throws SQLException;

    // // Select precio from producto where nombre ="xxxx" and fechaAlta = 'xxxx'
    // public T select(T t) throws SQLException;
    
    public List<T> selectAll() throws SQLException;
    
    public void insert(T t) throws SQLException;
    
    public void update(T t) throws SQLException;
    
    public void delete(T t) throws SQLException;
    
    public void delete(int id) throws SQLException;
    
    
}
