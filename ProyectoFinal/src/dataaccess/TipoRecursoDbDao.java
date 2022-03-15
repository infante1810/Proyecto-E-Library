package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author leilany
 */
public class TipoRecursoDbDao implements TipoRecursoDao{
    
    private final Connection connection;
    
    /**
     * Inicializa una nueva instancia de AlumnoDbDao.
     * @param connection Objeto Connection a usar.
     */
    
    //Aca cree la clase TipoRecursoDbDao y agregue el metodo getall segun lo que
    //se pide en el TipoRecursoDao
    //Aca no agregue toobj porque no lo pide 
    public TipoRecursoDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public TipoRecurso[] getAll() throws Exception {
        //Implementacion de metodo getall
        ArrayList<TipoRecurso> l = new ArrayList<>();
        String sql = "SELECT * FROM tipos_recursos WHERE Activo = 1 ORDER BY nombre";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new TipoRecurso[] {});
    }
    
    public int getRecurso(String nombreRecurso) throws Exception {
        //Implementacion de metodo getall
        int recurso;
        ArrayList<TipoRecurso> tipoRecurso = new ArrayList<>();
        
         String sql = "SELECT * FROM tipos_recursos ORDER BY nombre";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
             try (ResultSet r = stmt.executeQuery()) {
                System.out.println("executenms");
                while (r.next()){
              
                    if(r.getString("nombre").equals(nombreRecurso)){
                        tipoRecurso.add(toObj(r));
                        System.out.println("executing succesfull-concidencia");
                    }
                    
                };
                System.out.println("executing succesfullsi");
            }
        }
        TipoRecurso[] recursoObtenido =tipoRecurso.toArray(new TipoRecurso[]{});
        recurso =recursoObtenido[0].getId();
        return recurso;
    }
    private TipoRecurso toObj(ResultSet r) throws Exception {
        TipoRecurso i = new TipoRecurso();
        i.setId(r.getInt("id"));
        i.setNombre(r.getString("nombre"));        
        i.setActivo(true);           
        return i;
    }   
}
