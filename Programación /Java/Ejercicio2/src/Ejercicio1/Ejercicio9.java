/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();

        double numeroAleatorio = random.nextDouble(); // Genera un número aleatorio entre 0 y 1

        // Utilizamos el operador ternario para determinar si está más cerca de 1 o de 0
        String masCerca = (numeroAleatorio < 0.5) ? "más cerca de 0" : "más cerca de 1";

        System.out.println("Número aleatorio: " + numeroAleatorio);
        System.out.println("Está " + masCerca);

		 


		
	}
	
}