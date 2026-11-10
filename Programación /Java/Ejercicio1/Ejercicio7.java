/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Número de hormigas");
		int hormigas = sc.nextInt();
		System.out.println("Número de arañas");
		int arañas = sc.nextInt();
		System.out.println("Número de cochinillas");
		int cochinillas = sc.nextInt();
		int patas = (hormigas * 6) + (arañas * 8) + (cochinillas * 14);
		System.out.println("El numero total de patas es: " +patas);
		
		
	}
	
}