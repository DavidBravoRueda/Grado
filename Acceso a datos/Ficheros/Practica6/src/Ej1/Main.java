package Ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String fichero1 = "/Users/davidbravorueda/eclipse-workspace/Practica6/src/Fichero1.txt/";
        String fichero2 = "/Users/davidbravorueda/eclipse-workspace/Practica6/src/Fichero2.txt/";
        
        int[] datosFichero1 = leerFichero(fichero1);
        int[] datosFichero2 = leerFichero(fichero2);
        
        Ordenamiento ordenamiento = new Ordenamiento();

        int[] datosCombinados = ordenamiento.combinarArrays(datosFichero1, datosFichero2);

        ordenamiento.quickSort(datosCombinados, 0, datosCombinados.length - 1);

        try (FileWriter writer = new FileWriter("/Users/davidbravorueda/eclipse-workspace/Practica6/src/resultado_ordenado.txt/")) {
            for (int num : datosCombinados) {
                writer.write(num + "\n");
            }
            System.out.println("Archivo 'resultado_ordenado.txt' generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static int[] leerFichero(String nombreFichero) {
        ArrayList<Integer> listaDatos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] numeros = linea.split(";");
                for (String num : numeros) {
                    listaDatos.add(Integer.parseInt(num.trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        int[] datos = new int[listaDatos.size()];
        for (int i = 0; i < listaDatos.size(); i++) {
            datos[i] = listaDatos.get(i);
        }
        return datos;
    }
}