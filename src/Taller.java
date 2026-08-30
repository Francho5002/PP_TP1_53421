public class Taller extends Actividad{
    private  boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook){
        super(id,titulo,cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    public double calcularCostoMateriales(){
        return this.requiereNotebook ? 5000.0 : 2000.0;
    }
    public String getTipo(){
        return "Taller";
    }
    public boolean isrequiereNotebook(){
        return this.requiereNotebook;
    }

    public void setRequiereNotebook(boolean requiereNotebook){
        this.requiereNotebook = requiereNotebook;
    }

}
