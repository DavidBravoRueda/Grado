/**
 * 
 */
package Bucle;

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
		Scanner sc = new Scanner(System.in);
		 System.out.println("Ingrese un número natural: ");
	     int num = sc.nextInt();

	        double aproximacion = num / 2.0;

	        for (int i = 0; i < 10; i++) {
	            aproximacion = 0.5 * (aproximacion + num / aproximacion);
	        }

	        System.out.println("La raíz cuadrada es aproximadamente: " + aproximacion);
	}
}