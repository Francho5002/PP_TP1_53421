import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala; // Agregación
    private List<Actividad> actividades; // Composición

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otroevento) {
        this.id = otroevento.id;
        this.titulo = otroevento.titulo;
        this.costoBase = otroevento.costoBase;
        this.gratuito = otroevento.gratuito;
        this.sala = otroevento.sala;
        this.actividades = new ArrayList<>(otroevento.actividades);
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        if (this.gratuito) {
            return 0.0;
        }
        double sumaActividades = 0.0;
        for (Actividad actividad : this.actividades) {
            sumaActividades += actividad.calcularCostoMateriales();
        }
        return (this.costoBase + sumaActividades) * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearCharla(int id, String titulo, int cupoMaximo, String disertante) {
        this.actividades.add(new Charla(id, titulo, cupoMaximo, disertante));
    }
    public void crearTaller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        this.actividades.add(new Taller(id, titulo, cupoMaximo, requiereNotebook));
    }

    public void mostrarDatos() {
        System.out.println("==============================================");
        System.out.println("ID: " + this.id);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Costo base: " + this.costoBase);
        System.out.println("Costo Estimado: " + this.calcularCostoEstimado());
        System.out.println("Gratuito: " + this.gratuito);
        if (this.sala != null) {
            System.out.println("Sala: " + this.sala.getNombre());
        } else {
            System.out.println("Sala: Sin asignar");
        }
        System.out.println("Actividades Vinculadas: ");
        for (Actividad act : actividades) {
            act.mostrarInscripciones();
            act.mostrarIdentificacion();
        }
        System.out.println("==============================================");
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public Sala getSala() {
        return sala;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}