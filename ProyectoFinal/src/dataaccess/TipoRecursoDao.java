package dataaccess;

/**
 * Define el Data Access Object de tipo recurso (tabla tipos_recursos).
 * @author luisroberto
 */
public interface TipoRecursoDao {
    
    TipoRecurso[] getAll() throws Exception;   
    
    int getRecurso(String nombreRecurso) throws Exception;
    
}

