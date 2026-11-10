package Procesos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Proceso> listaProcesos = new ArrayList<>();
        listaProcesos.add(new Proceso("P1", 0, 5));
        listaProcesos.add(new Proceso("P2", 1, 3));
        listaProcesos.add(new Proceso("P3", 2, 7));
        listaProcesos.add(new Proceso("P4", 3, 2));
        listaProcesos.add(new Proceso("P5", 4, 6));

        FIFO.ejecutarFIFO(listaProcesos);
        SRT.ejecutarSRT(listaProcesos);
    }
}


