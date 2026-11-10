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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escribe una cadena de números: ");
		String cadena = scanner.nextLine();
		int longitud = cadena.length();
		String ultimosnumeros = longitud >= 3 ? cadena.substring(longitud - 3) : "La cadena es demasiado corta";
		System.out.println("Los tres últimos caracteres son: " + ultimosnumeros);
	

	
	}

		   
}		
