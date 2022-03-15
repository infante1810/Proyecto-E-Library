package dataaccess;

import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Implementación de la funcionalidad de data access object para Prestamo.
 * @author luisroberto
 */
public class PrestamoDbDao implements PrestamoDao {

    private final Connection connection;
    
    public PrestamoDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Prestamo getById(int prestamoId) throws Exception {
        //Implementacion de getById 
        Prestamo prestamo = null;
        String sql = "SELECT * FROM prestamos_v WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, prestamoId);
            try (ResultSet r = stmt.executeQuery()) {
                prestamo = r.next() ? toObj(r) : null;
            }
        }
        return prestamo;
    }

    @Override
    public int insert(Prestamo i) throws Exception {
        //Implementacion de metodo insert
        String sql = "CALL insert_prestamo(?, ?, ?, ?, ?)";
        int id = 0;
        // Usamos el objeto CallableStatement
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            
            // Agregamos los parámetros del stored procedure en orden.
            stmt.setInt(1, i.getLibroInventarioId());
            stmt.setInt(2, i.getAlumnoId());
            stmt.setObject(3, i.getFechaPrestamo());
            stmt.setObject(4, i.getFechaDebeDevolver());
            stmt.setInt(5, id);
       
            stmt.execute();
            return stmt.getInt(5);
        }
    }

    @Override
    public void update(Prestamo i) throws Exception {
        //Implementacion de metodo update
        String sql = "CALL update_prestamo(?, ?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, i.getId());
            stmt.setObject(2, i.getFechaDevuelto());
            stmt.execute();  // este stored procedure no regresa resultado, por lo que uasmos execute().
        }
    }
    
    //Este ya estaba
    private Prestamo toObj(ResultSet r) throws Exception {
        Prestamo i = new Prestamo();
        i.setId(r.getInt("id"));
        i.setLibroInventarioId(r.getInt("libro_inventario_id"));
        i.setAlumnoId(r.getInt("alumno_matricula"));
        i.setFechaPrestamo(r.getObject("fecha_prestamo", LocalDateTime.class));
        i.setFechaDebeDevolver(r.getObject("fecha_debe_devolver", LocalDateTime.class));
        i.setFechaDevuelto(r.getObject("fecha_devuelto", LocalDateTime.class));
        return i;
    }
    
}
