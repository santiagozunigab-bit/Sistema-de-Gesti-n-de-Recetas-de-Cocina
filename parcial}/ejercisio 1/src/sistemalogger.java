
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class SistemaLogger {
    private String archivoLog;
    private DateTimeFormatter formatter;

    public SistemaLogger(String archivoLog) {
        this.archivoLog = archivoLog;
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public SistemaLogger() {
        this("sistema_receta.log");
    }

    private void escribirLog(String nivel, String mensaje) {
        String timestamp = LocalDateTime.now().format(formatter);
        String entrada = String.format("%s - [%s] - %s", timestamp, nivel, mensaje);

        try (FileWriter fw = new FileWriter(archivoLog, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(entrada);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de log: " + e.getMessage());
        }
    }

    public void registrarInfo(String mensaje) {
        escribirLog("INFO", mensaje);
    }

    public void registrarError(String mensaje) {
        escribirLog("ERROR", mensaje);
    }

    public void registrarAdvertencia(String mensaje) {
        escribirLog("WARNING", mensaje);
    }
}