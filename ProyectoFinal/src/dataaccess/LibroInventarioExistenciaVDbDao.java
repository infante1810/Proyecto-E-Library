package dataaccess;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementación del Data Access Object de LibroInventario, que representa el
 * view de libros_inventario_existencia que son los libros con la cantidad de
 * estos disponibles en el inventario.
 * @author luisroberto
 */
public class LibroInventarioExistenciaVDbDao 
        implements LibroInventarioExistenciaVDao {

    @Override
    public LibroInventarioExistenciaV getById(int libroId) throws Exception {
        //Implemente el getById antes visto
       LibroInventarioExistenciaV libroinventarioexistenciav = null;
        String sql = "SELECT * FROM libro_inventario_existencia_v WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroId);
            try (ResultSet r = stmt.executeQuery()) {
                libroinventarioexistenciav = r.next() ? toObj(r) : null;
            }
        }
        return libroinventarioexistenciav;
    }

    @Override
    public LibroInventarioExistenciaV[] searchByTitulo(String titulo) throws Exception {
      //solo me falta esto :(
      ArrayList<LibroInventarioExistenciaV> libroInventarioExistenciaV = null;
        String sql = "SELECT * FROM libro_inventario_existencia_v WHERE titulo LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,"'%"+titulo+"%'");
            try (ResultSet r = stmt.executeQuery()) {
                libroInventarioExistenciaV.add(r.next() ? toObj(r) : null);
            }
        }
        LibroInventarioExistenciaV result[] = new LibroInventarioExistenciaV[libroInventarioExistenciaV.size()];
        libroInventarioExistenciaV.toArray(result);
        if (result.length==0){
            return null;
        }else{

         return result;
        }
    }
    
    //De igual manera agregue en toObj cada uno
    private LibroInventarioExistenciaV toObj(ResultSet r) throws Exception {
        LibroInventarioExistenciaV i = new LibroInventarioExistenciaV();
        i.setId(r.getInt("id"));
        i.setTitulo(r.getString("titulo"));
        i.setTipoRecursoId(r.getInt("tipo_recursos_id"));
        i.setTipoRecursoNombre(r.getString("tipo_recurso_nombre"));
        i.setEdicion(r.getString("edicion"));        
        i.setEditorialId(r.getInt("editorial_id"));
        i.setEditorialNombre(r.getString("editorial_nombre"));
        i.setEditorialPais(r.getString("editorial_pais"));
        i.setEditorialEmail(r.getString("editorial_email"));
        i.setAutores(r.getString("autores"));
        i.setIsbn(r.getString("isbn"));
        i.setActivo(r.getBoolean("activo"));
        i.setCantidadEnInventario(r.getInt("cantidad_en_inventario"));
        return i;
    }
}
