package dataaccess;

import java.util.Date;
import java.time.LocalDateTime;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Implementación del Data Access Object de prestamo.
 * @author luisroberto
 */
public class PrestamoVDbDao implements PrestamoVDao {

    private final Connection connection;
    
    public PrestamoVDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public PrestamoV getById(int prestamoId) throws Exception {
        String sql = "SELECT * FROM prestamos_v WHERE id = ?";
        PrestamoV i = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, prestamoId);
            try (ResultSet r = stmt.executeQuery()) {
                if (r.next()) i = toObj(r);
            }
        }
        return i;
    }

    @Override
    public PrestamoV[] getByAlumno(int alumnoId) throws Exception {
        // Implementacion de getByAlumno
        ArrayList<PrestamoV> l = new ArrayList<>();
        String sql = "SELECT * FROM prestamos_v WHERE alumno_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alumnoId);
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new PrestamoV[] {});
    }

    @Override
    public PrestamoV[] getByLibroInventario(int libroInventarioId) throws Exception {
        // Implementacion de metodo libroinventario
        ArrayList<PrestamoV> l = new ArrayList<>();
        String sql = "SELECT * FROM prestamos_v WHERE libro_inventario_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroInventarioId);
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new PrestamoV[] {});
    }

    @Override
    public PrestamoV[] getByFechaPrestamoRango(Date fechaPrestamoI, Date fechaPrestamoT) throws Exception {
        //Implementacion de metodo fechaprestamo rango
        ArrayList<PrestamoV> l = new ArrayList<>();
        String sql = "SELECT * FROM prestamos_v WHERE fecha_prestamo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            //Aqui se agregaron para dos: fecha de prestamo I Y T
            stmt.setObject(1, fechaPrestamoI);
            stmt.setObject(2, fechaPrestamoT);
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new PrestamoV[] {});
    }
    //Esto ya estaba
    private PrestamoV toObj(ResultSet r) throws Exception {
        PrestamoV i = new PrestamoV();
        i.setId(r.getInt("id"));
        i.setLibroInventarioId(r.getInt("libro_inventario_id"));
        i.setLibroId(r.getInt("libro_id"));
        i.setLibroTitulo(r.getString("libro_titulo"));
        i.setLibroTipoRecursoNombre(r.getString("libro_tipo_recurso_nombre"));
        i.setLibroEdicion(r.getString("libro_edicion"));
        i.setLibroEditorialNombre(r.getString("libro_editorial_nombre"));
        i.setLibroAutores(r.getString("libro_autores"));
        i.setLibroIsbn(r.getString("libro_isbn"));
        i.setAlumnoId(r.getInt("alumno_id"));
        i.setAlumnoNombre(r.getString("alumno_nombre"));
        i.setAlumnoApellidos(r.getString("alumno_apellidos"));
        i.setAlumnoCarreraNombre(r.getString("alumno_carrera_nombre"));
        i.setFechaPrestamo(r.getObject("fecha_prestamo", LocalDateTime.class));
        i.setFechaDebeDevolver(r.getObject("fecha_debe_devolver", LocalDateTime.class));
        i.setFechaDevuelto(r.getObject("fecha_devuelto", LocalDateTime.class));
        return i;
    }
}
