package Procesos;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SRT {

    public static void ejecutarSRT(List<Proceso> procesos) {
        PriorityQueue<Proceso> cola = new PriorityQueue<>(Comparator.comparingInt(Proceso::getTiempoRestante));
        cola.addAll(procesos);
        int tiempo = 0;

        System.out.println("Algoritmo SRT");
        while (!cola.isEmpty()) {
            Proceso proceso = cola.poll();
            if (proceso.getTiempoRestante() > 1) {
                proceso.setTiempoRestante(proceso.getTiempoRestante() - 1);
                tiempo++;
                cola.add(proceso);
                System.out.println("Proceso " + proceso.getId() + " ejecutado por 1 unidad de tiempo. Tiempo restante: " + proceso.getTiempoRestante());
            } else {
                tiempo += proceso.getTiempoRestante();
                proceso.setTiempoRestante(0);
                System.out.println("Proceso " + proceso.getId() + " completado en tiempo " + tiempo);
            }
        }
    }
}
