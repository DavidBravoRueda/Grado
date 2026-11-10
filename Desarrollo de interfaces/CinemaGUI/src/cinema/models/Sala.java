package cinema.models;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nombre;
    private List<SesionOcupacion> sesiones;

    public Sala(String nombre) {
        this.nombre = nombre;
        this.sesiones = new ArrayList<>();
    }

    public void generarSesiones() {
        for (int i = 1; i <= 4; i++) {
            sesiones.add(new SesionOcupacion("Película " + i));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<SesionOcupacion> getSesiones() {
        return sesiones;
    }
}

