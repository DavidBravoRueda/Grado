package Ej2;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
        // Crear una tabla con 5 futbolistas
        List<Futbolista> futbolistas = new ArrayList<>();
        futbolistas.add(new Futbolista("12345678A", "Lionel Messi", 34, 700));
        futbolistas.add(new Futbolista("98765432B", "Cristiano Ronaldo", 36, 750));
        futbolistas.add(new Futbolista("11122333C", "Neymar Jr", 29, 150));
        futbolistas.add(new Futbolista("44556677D", "Kylian Mbappé", 23, 120));
        futbolistas.add(new Futbolista("99988877E", "Robert Lewandowski", 33, 550));

        // Mostrar la tabla ordenada por DNI
        System.out.println("Ordenado por DNI:");
        futbolistas.sort(Futbolista::compareTo);
        for (Futbolista futbolista : futbolistas) {
            System.out.println(futbolista);
        }

        // Mostrar la tabla ordenada por nombre
        System.out.println("\nOrdenado por Nombre:");
        futbolistas.sort(Futbolista.COMPARADOR_NOMBRE);
        for (Futbolista futbolista : futbolistas) {
            System.out.println(futbolista);
        }

        // Mostrar la tabla ordenada por edad
        System.out.println("\nOrdenado por Edad:");
        futbolistas.sort(Futbolista.COMPARADOR_EDAD);
        for (Futbolista futbolista : futbolistas) {
            System.out.println(futbolista);
        }
    }
}


