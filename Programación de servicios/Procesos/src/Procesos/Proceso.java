package Procesos;

public class Proceso {
    private String id;
    private int tiempoLlegada;
    private int duracion;
    private int tiempoRestante;

    public Proceso(String id, int tiempoLlegada, int duracion) {
        this.id = id;
        this.tiempoLlegada = tiempoLlegada;
        this.duracion = duracion;
        this.tiempoRestante = duracion;
    }

    public String getId() {
        return id;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public void imprimirProceso() {
        System.out.println("ID: " + id + ", Tiempo de llegada: " + tiempoLlegada 
            + ", Duración: " + duracion + ", Tiempo restante: " + tiempoRestante);
    }
}
		
