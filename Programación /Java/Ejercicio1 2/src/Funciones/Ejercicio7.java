/**
 * 
 */
package Funciones;

import java.util.Random;

/**
 * 
 */
public class Ejercicio7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numerosaleatorios(5, 1, 100);
    }

    public static void numerosaleatorios(int cantidad, int min, int max) {
       
        if (cantidad <= 0 || min >= max) {
     
        } else {
        	Random sc = new Random();
            System.out.println("Números aleatorios entre " + min + " y " + max + ":");
            for (int i = 0; i < cantidad; i++) {
                int num = sc.nextInt(max - min + 1) + min;
                System.out.println(num);
            }
        }
	}
}