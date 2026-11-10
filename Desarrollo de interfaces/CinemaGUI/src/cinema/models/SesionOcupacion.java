package cinema.models;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SesionOcupacion {
    private String nombrePelicula;
    private Map<String, Boolean> butacas;

    public SesionOcupacion(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
        this.butacas = new HashMap<>();

        for (char fila = 'A'; fila <= 'I'; fila++) {
            for (int columna = 1; columna <= 8; columna++) {
                String asiento = fila + String.valueOf(columna);
                butacas.put(asiento, true); // Todas las butacas comienzan libres
            }
        }
    }

    public void ocuparAsiento(String asiento) {
        if (butacas.containsKey(asiento)) {
            butacas.put(asiento, false);
        }
    }

    public boolean estaLibreAsiento(String asiento) {
        return butacas.getOrDefault(asiento, true);
    }

    public Color obtenerColorAsiento(String asiento) {
        return estaLibreAsiento(asiento) ? Color.GREEN : Color.RED;
    }

    public int getNumeroButacasLibres() {
        return (int) butacas.values().stream().filter(v -> v).count();
    }

    public int getNumeroButacasOcupadas() {
        return (int) butacas.values().stream().filter(v -> !v).count();
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }
}

