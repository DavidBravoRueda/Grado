/**
 * 
 */
package Funciones;

import java.util.Random;

/**
 * 
 */
public class Ejercicio8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 numerosaleatorios(5);
    }
   public static void numerosaleatorios(int cantidad) {
    
        if (cantidad <= 0) {;
        } else {
        	Random sc = new Random();
            System.out.println("Números aleatorios reales entre 0 y 1:");
            for (int i = 0; i < cantidad; i++) {
                double num = sc.nextDouble();
                System.out.println(num);
            }
        }
	}
}