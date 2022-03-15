package dataaccess;

/**
 * Representa un registro del view libros_inventario_existencia_v que contiene
 * en si representa el registro de un libro y cuantos de estos libros hay en
 * existencia en el inventario.
 * @author luisroberto
 */
public class LibroInventarioExistenciaV {
    
    
    private int id;
    private String titulo;
    private int tipoRecursoId;
    private String tipoRecursoNombre;
    private String edicion;
    private Integer editorialId;
    private String editorialNombre;
    private String editorialPais;
    private String editorialEmail;
    private String autores;
    private String isbn;
    private boolean activo;
    private int cantidadEnInventario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTipoRecursoId() {
        return tipoRecursoId;
    }

    public void setTipoRecursoId(int tipoRecursoId) {
        this.tipoRecursoId = tipoRecursoId;
    }

    public String getTipoRecursoNombre() {
        return tipoRecursoNombre;
    }

    public void setTipoRecursoNombre(String tipoRecursoNombre) {
        this.tipoRecursoNombre = tipoRecursoNombre;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getEditorialNombre() {
        return editorialNombre;
    }

    public void setEditorialNombre(String editorialNombre) {
        this.editorialNombre = editorialNombre;
    }

    public String getEditorialPais() {
        return editorialPais;
    }

    public void setEditorialPais(String editorialPais) {
        this.editorialPais = editorialPais;
    }

    public String getEditorialEmail() {
        return editorialEmail;
    }

    public void setEditorialEmail(String editorialEmail) {
        this.editorialEmail = editorialEmail;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public int getCantidadEnInventario() { return cantidadEnInventario; }
    
    public void setCantidadEnInventario(int value) { 
        cantidadEnInventario = value; 
    }
}
