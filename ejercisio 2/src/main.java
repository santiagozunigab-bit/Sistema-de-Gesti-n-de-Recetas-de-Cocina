import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CREACIÓN DE UN PUNTO 2D ===");
        
        // Solicitar coordenadas al usuario
        System.out.print("Ingresa la coordenada X: ");
        double x = scanner.nextDouble();

        System.out.print("Ingresa la coordenada Y: ");
        double y = scanner.nextDouble();

        // Crear el punto con los valores ingresados
        Punto punto = new Punto(x, y);

        // Mostrar coordenadas e información inicial
        System.out.print("\nEl punto ingresado es: ");
        punto.mostrarCoordenadas();

        System.out.println("Distancia desde el origen (0,0): " + punto.calcularDistanciaDesdeOrigen());

        // Desplazar el punto
        System.out.println("\n=== DESPLAZAR EL PUNTO ===");
        System.out.print("¿Cuánto deseas mover en el eje X (deltaX)?: ");
        double deltaX = scanner.nextDouble();

        System.out.print("¿Cuánto deseas mover en el eje Y (deltaY)?: ");
        double deltaY = scanner.nextDouble();

        punto.mover(deltaX, deltaY);

        System.out.print("\nNuevas coordenadas después de moverlo: ");
        punto.mostrarCoordenadas();
        System.out.println("Nueva distancia al origen: " + punto.calcularDistanciaDesdeOrigen());

        // Cerrar el scanner
        scanner.close();
    }
}