package dataaccess;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author luisroberto
 */
public class LibroInventarioVDbDao implements LibroInventarioVDao {

    private Connection connection;
    
    public LibroInventarioVDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public LibroInventarioV[] getByLibroId(int libroId) throws Exception {
        //Este ya estaba
        ArrayList<LibroInventarioV> l = new ArrayList<>();
        String sql = "SELECT * FROM libros_inventario_v WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroId);
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new LibroInventarioV[0]);
    }

    @Override
    public LibroInventarioV getByLibroInventarioId(int libroInventarioId) throws Exception {
        //Este fue el que agregue, implementacion del metodo para libroinventario id
        LibroInventarioV libroinventariov = null;
        String sql = "SELECT * FROM libros_inventario_v WHERE inventario_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroInventarioId);
            try (ResultSet r = stmt.executeQuery()) {
                libroinventariov = r.next() ? toObj(r) : null;
            }
        }
        return libroinventariov;
    }
    
    /**
     * Obtiene un objeto de tipo LibroInventarioV a partir del ResultSet.
     * @param r
     * @return
     * @throws Exception 
     */
    
    //Esto ya estaba
    private LibroInventarioV toObj(ResultSet r) throws Exception {
        LibroInventarioV i = new LibroInventarioV();
        i.setId(r.getInt("id"));
        i.setInventarioId(r.getInt("inventario_id"));
        i.setTitulo(r.getString("titulo"));
        i.setTipoRecursoId(r.getInt("tipo_recurso_id"));
        i.setTipoRecursoNombre(r.getString("tipo_recurso_nombre"));
        i.setEdicion(r.getString("edicion"));
        i.setEditorialNombre(r.getString("editorial_nombre"));
        i.setEditorialPais(r.getString("editorial_pais"));
        i.setEditorialEmail(r.getString("editorial_emial"));
        i.setAutores(r.getString("autores"));
        i.setIsbn(r.getString("isbn"));
        i.setEstado(r.getString("estado"));
        i.setDisponible(r.getBoolean("disponible"));
        return i;
    }

    
}
