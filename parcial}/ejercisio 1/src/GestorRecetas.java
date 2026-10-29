import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorRecetas {
    private int capacidadMaxima;
    private Map<String, Receta> recetas;
    private SistemaLogger logger;

    public GestorRecetas(int capacidadMaxima, SistemaLogger logger) {
        this.capacidadMaxima = capacidadMaxima;
        this.recetas = new HashMap<>();
        this.logger = (logger != null) ? logger : new SistemaLogger();
    }

    public GestorRecetas(int capacidadMaxima) {
        this(capacidadMaxima, new SistemaLogger());
    }

    public boolean registrarReceta(Receta receta) {
        if (receta == null) {
            System.out.println(" No se puede registrar una receta nula.");
            return false;
        }

        if (recetas.size() >= capacidadMaxima) {
            String msgError = "Error al registrar '" + receta.getNombre() + "': Capacidad máxima del sistema alcanzada (" + capacidadMaxima + ").";
            logger.registrarError(msgError);
            System.out.println(" " + msgError);
            return false;
        }

        String claveNombre = receta.getNombre().toLowerCase();
        if (recetas.containsKey(claveNombre)) {
            String msgWarn = "Intento de registro duplicado: Ya existe una receta llamada '" + receta.getNombre() + "'.";
            logger.registrarAdvertencia(msgWarn);
            System.out.println(" " + msgWarn);
            return false;
        }

        recetas.put(claveNombre, receta);
        logger.registrarInfo("Receta registrada con éxito: '" + receta.getNombre() + "'.");
        System.out.println(" Receta '" + receta.getNombre() + "' registrada exitosamente.");
        return true;
    }

    public Receta buscarReceta(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println(" Nombre de búsqueda no válido.");
            return null;
        }

        String claveNombre = nombre.trim().toLowerCase();
        if (recetas.containsKey(claveNombre)) {
            Receta receta = recetas.get(claveNombre);
            logger.registrarInfo("Consulta realizada con éxito para la receta: '" + nombre + "'.");
            return receta;
        }

        String msgFail = "Búsqueda fallida: No existe la receta '" + nombre + "'.";
        logger.registrarAdvertencia(msgFail);
        System.out.println(" " + msgFail);
        return null;
    }

    public boolean actualizarReceta(String nombre, String nuevasInstrucciones, Integer nuevasPorciones) {
        Receta receta = buscarReceta(nombre);
        if (receta == null) {
            logger.registrarError("Fallo de actualización: La receta '" + nombre + "' no fue encontrada.");
            return false;
        }

        try {
            if (nuevasInstrucciones != null && !nuevasInstrucciones.trim().isEmpty()) {
                receta.setInstrucciones(nuevasInstrucciones);
            }
            if (nuevasPorciones != null) {
                receta.setPorciones(nuevasPorciones);
            }

            logger.registrarInfo("Receta '" + receta.getNombre() + "' actualizada correctamente.");
            System.out.println(" Receta '" + receta.getNombre() + "' actualizada exitosamente.");
            return true;
        } catch (IllegalArgumentException e) {
            logger.registrarError("Error al actualizar '" + nombre + "': " + e.getMessage());
            System.out.println(" Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public List<String> listarRecetas() {
        logger.registrarInfo("Consulta de lista general de recetas realizada.");
        if (recetas.isEmpty()) {
            System.out.println(" No hay recetas registradas en el sistema.");
            return new ArrayList<>();
        }

        List<String> nombres = new ArrayList<>();
        System.out.println("\n--- Lista de Recetas Registradas ---");
        int i = 1;
        for (Receta r : recetas.values()) {
            nombres.add(r.getNombre());
            System.out.println(i + ". " + r.getNombre());
            i++;
        }
        return nombres;
    }
}
