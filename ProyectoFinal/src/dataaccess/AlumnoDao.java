package dataaccess;

/**
 * Representa el Data Access Object de Alumno con las operaciones CRUD comunes.
 * @author luisroberto
 */
public interface AlumnoDao {
    
    Alumno getById(int alumnoId) throws Exception;
    
    Alumno[] getByCarrera(int carreraId) throws Exception;
    
    int insert(Alumno i) throws Exception;
    
    Alumno[] getAll() throws Exception;
    
    void update(Alumno i) throws Exception;
}
