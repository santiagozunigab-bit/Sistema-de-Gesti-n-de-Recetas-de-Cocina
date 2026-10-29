
    public class Ingrediente {
   private String nombre;
   private double cantidad;
   private String unidad;

   public static void main(String[] var0) {
   }

   public Ingrediente(String var1, double var2, String var4) {
      if (var1 != null && !extracted(var1).isEmpty()) {
         if (var2 <= (double)0.0F) {
            throw new IllegalArgumentException("La cantidad del ingrediente debe ser mayor a 0.");
         } else if (var4 != null && !extracted(var4).isEmpty()) {
            this.nombre = extracted(var1);
            this.cantidad = var2;
            this.unidad = extracted(var4);
         } else {
            throw new IllegalArgumentException("La unidad de medida no puede estar vacía.");
         }
      } else {
         throw new IllegalArgumentException("El nombre del ingrediente no puede estar vacío.");
      }
   }

   private String extracted(String var1) {
    return var1.trim();
   }

   public String getNombre() {
      return this.nombre;
   }

   public double getCantidad() {
      return this.cantidad;
   }

   public String getUnidad() {
      return this.unidad;
   }

   public String toString() {
      return "- " + this.nombre + ": " + this.cantidad + " " + this.unidad;
   }
}
