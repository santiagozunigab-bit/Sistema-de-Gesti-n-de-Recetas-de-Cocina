
import java.util.List;

class Receta {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private String instrucciones;
    private int porciones;

    public Receta(String nombre, List<Ingrediente> ingredientes, String instrucciones, int porciones) {
        if (nombre == null || normalizar(nombre).isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (ingredientes == null || ingredientes.isEmpty()) {
            throw new IllegalArgumentException("Debe tener al menos un ingrediente.");
        }
        if (instrucciones == null || normalizar(instrucciones).isEmpty()) {
            throw new IllegalArgumentException("Las instrucciones no pueden estar vacías.");
        }
        if (porciones <= 0) {
            throw new IllegalArgumentException("Las porciones deben ser mayores a 0.");
        }

        this.nombre = normalizar(nombre);
        this.ingredientes = ingredientes;
        this.instrucciones = normalizar(instrucciones);
        this.porciones = porciones;
    }

    private static String normalizar(String valor) {
        return valor == null ? "" : valor.trim();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public List<Ingrediente> getIngredientes() { return ingredientes; }
    public String getInstrucciones() { return instrucciones; }
    public int getPorciones() { return porciones; }

    public void setInstrucciones(String instrucciones) {
        if (instrucciones == null || normalizar(instrucciones).isEmpty()) {
            throw new IllegalArgumentException("Las instrucciones no pueden estar vacías.");
        }
        this.instrucciones = normalizar(instrucciones);
    }

    public void setPorciones(int porciones) {
        if (porciones <= 0) {
            throw new IllegalArgumentException("Las porciones deben ser mayores a 0.");
        }
        this.porciones = porciones;
    }

    public String mostrarDetalle() {
        String texto = "\n=== " + nombre.toUpperCase() + " ===\n";
        texto += "Porciones: " + porciones + "\n";
        texto += "Ingredientes:\n";
        for (Ingrediente ing : ingredientes) {
            texto += "  " + ing + "\n";
        }
        texto += "Instrucciones:\n  " + instrucciones + "\n";
        return texto;
    }
}