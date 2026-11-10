package Procesos;

import java.util.Comparator;
import java.util.List;

public class FIFO {

    public static void ejecutarFIFO(List<Proceso> procesos) {
        procesos.sort(Comparator.comparingInt(Proceso::getTiempoLlegada));
        System.out.println("Algoritmo FIFO");
        for (Proceso p : procesos) {
            p.imprimirProceso();
            System.out.println("Ejecutando proceso " + p.getId() + "...");
        }
    }
}
