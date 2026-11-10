/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Escribe la base: ");
	     double base = scanner.nextDouble();
	     System.out.print("Escribe el exponente: ");
	     double exponente = scanner.nextDouble();
	     double resultado = Math.pow(base, exponente);
	     System.out.println("El resultado de " + base + " elevado a la " + exponente + " es " + resultado);

		 


		
	}
	
}