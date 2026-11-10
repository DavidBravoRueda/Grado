/**
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa un número");
		int numero = sc.nextInt();
		int resto = numero % 7;
		int cantidad = 7 - resto;
		System.out.println("A " +numero+ " hay que sumarle " +cantidad+ " para que sea múltiplo de 7.");
	
	}

		   
}		
