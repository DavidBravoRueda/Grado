package negocio;
import java.time.LocalDateTime;
public class Prestamo {
   private String nombreLibro;
   private String nombreUsuario;
   private LocalDateTime fechaHoraPrestamo;
   public Prestamo(String nombreLibro, String nombreUsuario, LocalDateTime fechaHoraPrestamo) {
       this.nombreLibro = nombreLibro;
       this.nombreUsuario = nombreUsuario;
       this.fechaHoraPrestamo = fechaHoraPrestamo;
   }
   public String getNombreLibro() {
       return nombreLibro;
   }
   public void setNombreLibro(String nombreLibro) {
       this.nombreLibro = nombreLibro;
   }
   public String getNombreUsuario() {
       return nombreUsuario;
   }
   public void setNombreUsuario(String nombreUsuario) {
       this.nombreUsuario = nombreUsuario;
   }
   public LocalDateTime getFechaHoraPrestamo() {
       return fechaHoraPrestamo;
   }
   public void setFechaHoraPrestamo(LocalDateTime fechaHoraPrestamo) {
       this.fechaHoraPrestamo = fechaHoraPrestamo;
   }
}
