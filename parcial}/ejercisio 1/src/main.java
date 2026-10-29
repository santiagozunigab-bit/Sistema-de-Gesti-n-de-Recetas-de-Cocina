import java.util.ArrayList;
import java.util.List;

class Main { 
    public static void main(String[] args) {
        // Inicializamos el gestor con capacidad reducida (2) para probar el límite
        GestorRecetas gestor = new GestorRecetas(2);

        System.out.println("\n--- 1. REGISTRO DE RECETAS VÁLIDAS ---");
        try {
            List<Ingrediente> ingredientesPancakes = new ArrayList<>();
            ingredientesPancakes.add(new Ingrediente("Harina", 200, "gramos"));
            ingredientesPancakes.add(new Ingrediente("Leche", 250, "ml"));
            ingredientesPancakes.add(new Ingrediente("Huevo", 1, "unidad"));

            Receta receta1 = new Receta("Pancakes", ingredientesPancakes, "Mezclar ingredientes y cocinar en sartén.", 4);
            gestor.registrarReceta(receta1);

            List<Ingrediente> ingredientesCafe = new ArrayList<>();
            ingredientesCafe.add(new Ingrediente("Café molido", 15, "gramos"));
            ingredientesCafe.add(new Ingrediente("Agua", 250, "ml"));

            Receta receta2 = new Receta("Café Filtrado", ingredientesCafe, "Verter agua caliente sobre el café.", 1);
            gestor.registrarReceta(receta2);

        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }

        System.out.println("\n--- 2. PRUEBA DE ERRORES: DATOS INCOMPLETOS O INVÁLIDOS ---");
        try {
            // Intento de porciones negativas
            List<Ingrediente> ingEnsalada = new ArrayList<>();
            ingEnsalada.add(new Ingrediente("Lechuga", 1, "unidad"));
            new Receta("Ensalada", ingEnsalada, "Lavar y cortar", -2);
        } catch (IllegalArgumentException e) {
            System.out.println(" Capturado correctamente: " + e.getMessage());
        }

        System.out.println("\n--- 3. PRUEBA DE ERROR: EXCEDER CAPACIDAD MÁXIMA ---");
        try {
            List<Ingrediente> ingTe = new ArrayList<>();
            ingTe.add(new Ingrediente("Té", 1, "bolsa"));
            Receta recetaExtra = new Receta("Té", ingTe, "Infusionar en agua", 1);
            gestor.registrarReceta(recetaExtra);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- 4. CONSULTA Y LISTADO DE RECETAS ---");
        gestor.listarRecetas();

        Receta recetaBuscada = gestor.buscarReceta("Pancakes");
        if (recetaBuscada != null) {
            System.out.println(recetaBuscada.mostrarDetalle());
        }

        System.out.println("\n--- 5. PRUEBA DE ERROR: BUSCAR RECETA INEXISTENTE ---");
        gestor.buscarReceta("Pizza");

        System.out.println("\n--- 6. ACTUALIZACIÓN DE RECETAS ---");
        // Actualización exitosa
        gestor.actualizarReceta("Pancakes", "Mezclar bien, dorar 2 min por lado.", 6);

        // Intento de actualización con datos inválidos
        gestor.actualizarReceta("Pancakes", null, -1);

        // Verificamos los cambios
        Receta recetaModificada = gestor.buscarReceta("Pancakes");
        if (recetaModificada != null) {
            System.out.println(recetaModificada.mostrarDetalle());
        }
    }
}