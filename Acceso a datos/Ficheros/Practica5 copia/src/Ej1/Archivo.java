package Ej1;

import java.io.*;
import java.util.*;

public class Archivo {

    public static Map<String, Producto> leerProductos(String archivoProductos) throws IOException {
        Map<String, Producto> productos = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoProductos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String nombre = partes[0].trim();
                double precio = Double.parseDouble(partes[1].replace("€", "").trim());
                productos.put(nombre, new Producto(nombre, precio));
            }
        }
        return productos;
    }

    public static Map<String, Integer> leerCantidades(String archivoCantidades) throws IOException {
        Map<String, Integer> cantidades = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCantidades))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int cantidad = Integer.parseInt(partes[0].trim());
                String nombreProducto = partes[1].trim();
                cantidades.put(nombreProducto, cantidad);
            }
        }
        return cantidades;
    }
}
