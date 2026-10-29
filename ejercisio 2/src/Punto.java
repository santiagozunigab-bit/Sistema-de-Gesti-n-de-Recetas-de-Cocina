public class Punto {
    // Atributos privados
    private double x;
    private double y;

    // Constructor 1: Crea un punto en el origen (0,0)
    public Punto() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Constructor 2: Recibe las coordenadas x e y
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setters
    public void setX(double nuevoX) {
        this.x = nuevoX;
    }

    public void setY(double nuevoY) {
        this.y = nuevoY;
    }

    // Desplaza el punto sumando deltaX y deltaY
    public void mover(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    // Calcula la distancia desde el origen (0,0) usando Pitágoras
    public double calcularDistanciaDesdeOrigen() {
        return Math.sqrt(x * x + y * y);
    }

    // Imprime las coordenadas en formato (x, y)
    public void mostrarCoordenadas() {
        System.out.println("(" + x + ", " + y + ")");
    }
}