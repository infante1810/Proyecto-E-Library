package dataaccess;

import java.time.LocalDateTime;

/**
 * Representa un registro en la tabla de prestamos.
 * @author luisroberto
 */
public class Prestamo {
    
    private int id;
    private int libroInventarioId;
    private int alumnoId;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDebeDevolver;
    private LocalDateTime fechaDevuelto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibroInventarioId() {
        return libroInventarioId;
    }

    public void setLibroInventarioId(int libroInventarioId) {
        this.libroInventarioId = libroInventarioId;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDateTime getFechaDebeDevolver() {
        return fechaDebeDevolver;
    }

    public void setFechaDebeDevolver(LocalDateTime fechaDebeDevolver) {
        this.fechaDebeDevolver = fechaDebeDevolver;
    }

    public LocalDateTime getFechaDevuelto() {
        return fechaDevuelto;
    }

    public void setFechaDevuelto(LocalDateTime fechaDevuelto) {
        this.fechaDevuelto = fechaDevuelto;
    }
    
}
