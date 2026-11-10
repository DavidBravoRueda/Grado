/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 
		System.out.println("EScribe una cadena de caracteres: ");
	    String cadena = scanner.nextLine();
	    System.out.println("EScribe el número de caracteres para la subcadena: ");
	    int longitud = scanner.nextInt();
	    String subcadena = (longitud > 0 && longitud <= cadena.length())? cadena.substring(0, longitud): "La longitud debe estar entre 1 y " + cadena.length() + ".";
	    System.out.println("La subcadena es: " + subcadena);
        }
    }
        		                                                                                                