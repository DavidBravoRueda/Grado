/**
 * 
 */
package Examen;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String palabra = sc.next();
		
		while (!palabra.equals("adios")) {
			if (palabra.equals("hola")) {
				System.out.println("Hola, ¿qué tal estás?");
			} else if (palabra.equals("encantado")) {
				System.out.println("Encantada de conocerte yo también.");
			} else if (palabra.equals("dias")) {
				System.out.println("Buenos días para ti también.");
			} else if (palabra.equals("hora")) {
				System.out.println("Lo siento, no tengo reloj.");
			} else if (palabra.equals("noches")) {
				System.out.println("Buenas noches, que descanses.");
			} else if (palabra.equals("nombre")) {
				System.out.println("Mi nombre es Eliza.");
			} else {
				System.out.println("Lo siento, no te comprendo.");
			}

			palabra = sc.next();
		}
		
		
		if (palabra.equals("adios")) {
			System.out.println("Adios, espero volver a verte pronto");
		}
		
		
	
		
	
			
			
			
	}
}