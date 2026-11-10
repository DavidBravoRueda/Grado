/**
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercici1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.println("EScribe una cadena de caracteres: ");
        String cadena = scanner.nextLine();
        String dosPrimerosCaracteres = cadena.length() >= 2 ? cadena.substring(0, 2) : "La cadena es demasiado corta";
        System.out.println("Los dos primeros caracteres son: " + dosPrimerosCaracteres);

	}

}
