import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("50444", "Juan Pérez"));
        estudiantes.add(new Estudiante("45909", "Marta Hernández"));
        estudiantes.add(new Estudiante("51234", "Lucas Silva"));

        EventoUniversitario evento1 = new EventoUniversitario("EV1", "Taller de programación", 20000.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("EV2", "Taller Progresar", 0.0, true);

        Sala aula1 = new Sala(101, "Aula Magna");
        Sala aula2 = new Sala(102, "Laboratorio de Sistemas");
        evento1.asignarSala(aula1);
        evento2.asignarSala(aula2);

        evento1.crearTaller(1, "Clase Máquina BLUE", 20, true);
        evento2.crearCharla(2, "Vida Universitaria", 20, "Lic. Jorge Pascal");

        evento1.getActividades().get(0).inscribir(estudiantes.get(0));
        evento1.getActividades().get(0).inscribir(estudiantes.get(2));

        evento2.getActividades().get(0).inscribir(estudiantes.get(0));
        evento2.getActividades().get(0).inscribir(estudiantes.get(1));


        evento1.mostrarDatos();
        evento2.mostrarDatos();

        System.out.println("Cantidad de eventos creados en total: " + EventoUniversitario.getCantidadEventos());
    }
}