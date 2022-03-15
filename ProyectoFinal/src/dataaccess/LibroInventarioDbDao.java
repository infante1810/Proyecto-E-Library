package dataaccess;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementación del Data Access Object de LibroInventario, que representa un
 * registro de la tabla libros_inventario.
 * @author luisroberto
 */
public class LibroInventarioDbDao implements LibroInventarioDao {
    
    private final Connection connection;
    
    public LibroInventarioDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public LibroInventario getById(int libroInventarioId) throws Exception {
        //Leilany: Agregue el implementar funcionalidad de metodo getById
        LibroInventario libroinventario = null;
        String sql = "SELECT * FROM libro_inventario_v WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroInventarioId);
            try (ResultSet r = stmt.executeQuery()) {
                libroinventario = r.next() ? toObj(r) : null;
            }
        }
        return libroinventario; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(LibroInventario i) throws Exception {
        // Implemente el insert segun los ejemplos en alumno y carrera.
        String sql = "CALL insert_libro_inventario(?, ?, ?)";
        
        // Usamos el objeto CallableStatement
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            
            // Agregamos los parámetros del stored procedure en orden.
            stmt.setInt(1, i.getLibroId());
            stmt.setObject(2, i.getEstado());
            stmt.setObject(3, i.isDisponible());
            
            // El stored procedure regresa una consulta (instrucción SELECT),
            // por lo que obtenemos el resultset para obtener le resultado,
            // para este caso es el id del registro insertado.
            try (ResultSet r = stmt.executeQuery()) {
                r.next();  // nos movemos a la primera fila de la consulta
                i.setId(r.getInt("id"));  // obtenemos el resultado, el id...
            }
        }
        return i.getId();
    }

    @Override
    public void update(LibroInventario i) throws Exception {
        // Implemente el update de igual forma
        String sql = "CALL update_libro_inventario(?, ?, ?, ?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, i.getId());
            stmt.setInt(2, i.getLibroId());
            stmt.setObject(3, i.getEstado());
            stmt.setObject(4, i.isDisponible());
            stmt.execute();  // este stored procedure no regresa resultado, por lo que uasmos execute().
        }
    }
    
    //Agregue en toObj cada uno
    private LibroInventario toObj(ResultSet r) throws Exception {
        LibroInventario i = new LibroInventario();
        i.setId(r.getInt("id"));
        i.setLibroId(r.getInt("libroId"));
        i.setEstado(r.getString("estado"));
        i.setDisponible(r.getBoolean("disponible"));
        return i;
    }
        
}
