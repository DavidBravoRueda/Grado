package Ej1;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String archivoProductos = "productos.txt";
        String archivoCantidades = "cantidades.txt";
        String archivoSalida = "resultado.txt";

        try {
            Map<String, Producto> productos = Archivo.leerProductos(archivoProductos);
            Map<String, Integer> cantidades = Archivo.leerCantidades(archivoCantidades);

            // Calcular el total y generar la salida con IVA
            calcularTotalConIVA(productos, cantidades, archivoSalida);

        } catch (IOException e) {
            System.err.println("Error al leer los archivos: " + e.getMessage());
        }
    }
    public static void calcularTotalConIVA(Map<String, Producto> productos, Map<String, Integer> cantidades, String archivoSalida) throws IOException {
        double totalGeneral = 0;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (Map.Entry<String, Integer> entrada : cantidades.entrySet()) {
                String nombreProducto = entrada.getKey();
                int cantidad = entrada.getValue();

                if (productos.containsKey(nombreProducto)) {
                    Producto producto = productos.get(nombreProducto);
                    double totalProducto = producto.getPrecio() * cantidad;
                    double iva = totalProducto * 0.21;  
                    totalGeneral += totalProducto + iva;

                    String lineaSalida = String.format("%s;  %.2f €;  iva;  %.2f €%n", nombreProducto, totalProducto, iva);
                    System.out.print(lineaSalida);  
                    bw.write(lineaSalida); 
                }
            }

            bw.write("\n----\n");
            String totalGeneralStr = String.format("   Total con IVA = %.2f €%n", totalGeneral);
            bw.write(totalGeneralStr);
            System.out.println("\n----");
            System.out.printf("   Total con IVA = %.2f €%n", totalGeneral);
        }
     } }
