/**
 * 
 */
package Examen2;

import java.util.Scanner;

/**
 * 
 */
public class ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un número : ");
		int num = sc.nextInt();
		int divisores = 0;
		
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				divisores += i; 
			}
		}
		
		if (divisores == num) {
			System.out.println("El número es perfecto");
		}
		
		if (divisores < num) {
			System.out.println("El número es abundante");
		}
		
		if (divisores > num) {
			System.out.println("El número es defectuoso");
		}
		
	}
}