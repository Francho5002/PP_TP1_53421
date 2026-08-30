import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int CUPO_MINIMO = 5;
    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        if (this.inscripciones.size() < this.cupoMaximo) {
            Inscripcion nuevaInscripcion = new Inscripcion(estudiante, "CONFIRMADA");
            this.inscripciones.add(nuevaInscripcion);
            return nuevaInscripcion;
        } else {
            System.out.println("Cupo agotado para: " + this.titulo);
            return null;
        }
    }

    public void mostrarInscripciones() {
        System.out.println("  Inscripciones para " + this.titulo + ":");
        for (Inscripcion ins : inscripciones) {
            System.out.println("   - Alumno: " + ins.getEstudiante().getNombre() + " (Legajo: " + ins.getEstudiante().getLegajo() + ") | Estado: " + ins.getEstado());
        }
    }

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();

    public final void mostrarIdentificacion(){
        System.out.println(getTipo() + " ID: " + getId() + " Título: " + getTitulo() + " Costo de materiales: " + calcularCostoMateriales() );
    }


    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

}