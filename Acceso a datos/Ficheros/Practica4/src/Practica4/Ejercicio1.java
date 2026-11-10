package Practica4;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author administrador
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "/Users/davidbravorueda/Documents/";
        String nombre = "gastos.txt";
        FileReader fr;
        String desc;
        int n;
        File archivo = new File(ruta + nombre);

        if (archivo.exists()) {
            try {
                fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                System.out.println("Tus gastos son los siguientes:");

                String s;
                while ((s = br.readLine()) != null) {
                    System.out.println(s);
                }

                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println("Fallo 1º bloque");
                e.printStackTrace();
            }
        } else {
            n = 0;
            try {
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);

                System.out.println("¿Qué compraste?");
                desc = sc.nextLine();
                bw.write("Descripción: " + desc);
                bw.newLine();

                System.out.println("¿Cuánto gastaste?");
                n = sc.nextInt();
                bw.write("Gasto: " + n);
                bw.newLine();
         
                bw.close();
                fw.close();

            } catch (Exception e) {
                System.out.println("Fallo 2o bloque");
                e.printStackTrace();
            }
        }
    }
}
