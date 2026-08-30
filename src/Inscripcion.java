import java.time.LocalDate;

public class Inscripcion {
    private String estado;
    private LocalDate fecha;
    private Estudiante estudiante;

    public Inscripcion(Estudiante estudiante, String estado) {
        this.estudiante = estudiante;
        this.fecha = LocalDate.now();
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}