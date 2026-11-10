/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el número de entradas de adultos: ");
		int entradasadultos = sc.nextInt();
		System.out.print("Introduce el número de entradas infantiles: ");
		int entradasinfantiles = sc.nextInt();
		double precioadulto = 20.0;
		double precioinfantil = 15.5;
		double Total = (entradasadultos * precioadulto) + (entradasinfantiles * precioinfantil);
		Total = (Total >= 100.0) ? Total * 0.95 : Total;
		System.out.println("Total a pagar: " +Total+ " €");

		 


		
	}
	
}