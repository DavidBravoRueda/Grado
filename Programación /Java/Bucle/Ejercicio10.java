/**
 * 
 */
package Bucle;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		double suma = 0.0;
		double cantidad = 1.0;

		while (cantidad != 0) {
			System.out.println("Ingrese la cantidad de dinero o 0 para terminar): ");
	            cantidad = sc.nextDouble();

	            suma += cantidad;
	        }

	        System.out.println("La suma total de dinero es: " + suma);

	}
}