package dataaccess;

/**
 * Definición del Data Access Object de Editorial (tabla editoriales).
 * @author luisroberto
 */
public interface EditorialDao {
    
    Editorial getById(int editorialId) throws Exception;
    
    Editorial[] getAll() throws Exception;
    Editorial[] getByName(String editorialName) throws Exception;

    int getIdEditorial(String nombreEditorial) throws Exception;

    void Delete(int i) throws Exception;

    String[] getComboData() throws Exception;
    
    int insert(Editorial i) throws Exception;
    
    void update(Editorial i) throws Exception;
}
