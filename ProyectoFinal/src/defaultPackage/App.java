package defaultPackage;

import java.sql.*;
import dataaccess.*;
import java.text.SimpleDateFormat;
import UI.Dashboard;
import UI.Login_final;


public class App {

    private static final String DB_URL = 
            "jdbc:mysql://localhost:3306/biblioteca";
    
    private static final String DB_USERNAME = "root";
    
    private static final String DB_PASSWORD = "root";
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new App().run();
        
    }
    
    public static Connection getConnection() throws SQLException {
        //DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    
    public static CarreraDao getCarreraDao(Connection connection) {
        // return new CarreraDbDaoOracle(connection);
        return new CarreraDbDao(connection);
    }
    
    public static LibroDao getLibroDao(Connection connection) {
        // return new CarreraDbDaoOracle(connection);
        return new LibroDbDao(connection);
    }
    
    public static EditorialDao getEditoriaDao(Connection connection) {
        return new EditorialDbDao(connection);
    }
    
    
    public static AlumnoDao getAlumnoDao(Connection connection){
        return new AlumnoDbDao(connection);
    }
    public static PrestamoDao getPrestamoDao(Connection connection){
        return new PrestamoDbDao(connection);
    }
    public static TipoRecursoDao getTipoRecursoDao(Connection connection){
        return new TipoRecursoDbDao(connection);
    }
    
    
    public void run() {
        String sql = "SELECT * FROM alumnos_v WHERE genero = ?";
        
        try (Connection connection = getConnection()) {
           
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "masc");
            ResultSet r = stmt.executeQuery();
            
            while (r.next()) {
                int id = r.getInt("ID");
                String nombre = r.getString("nombre");
                String apellidos = r.getString("apellidos");
                String carreraNombre = r.getString("carrera_nombre");
                boolean carreraActivo = r.getBoolean("carrera_activo");
                Date fechaIngreso = r.getDate("fecha_ingreso");
                Date fechaNacimiento = r.getDate("fecha_nacimiento");
                System.out.printf(
                        "%s %s (id %d, carrera %s, fecha ingresó %s) %s\n", 
                        nombre, apellidos, id, carreraNombre, fechaIngreso,
                        carreraActivo);
            }
            
            r.close();
            stmt.close();
            
            CarreraDao carreraDao = getCarreraDao(connection);
            Carrera[] carreras = carreraDao.getAll();
            for (Carrera i : carreras) System.out.println(i);
            
            Carrera n = new Carrera();
            n.setNombre("Ingeniería en Tecnologías de Manofactura");
            n.setActivo(true);
            int id = carreraDao.insert(n);
            System.out.println("Se guardó la carrera y regresó id " + id);
            
            carreras = carreraDao.getAll();
          
            
            for (Carrera i : carreras) System.out.println(i);
            
           
            System.out.println("actualizando registro con id 1");
            Carrera aActualizar = carreraDao.getById(1);
            aActualizar.setNombre("Ingeniería en Tecnologías de Información y Comunicaciones");
            carreraDao.update(aActualizar);
            
            carreras = carreraDao.getAll();
            for (Carrera i : carreras) System.out.println(i);
            
            
            
        }
        catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
        
        new Login_final().setVisible(true);
    } 
            
}

    

    
