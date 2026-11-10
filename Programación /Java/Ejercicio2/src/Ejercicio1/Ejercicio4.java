/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Escribe una cadena de texto: ");
		 String cadena = scanner.nextLine();
		 System.out.print("Escribe el carácter con el que deseas reemplazar los espacios: ");
		 char remplazo = scanner.next().charAt(0);
		 String cadenaremplazo = cadena.replace(' ', remplazo);
		 System.out.println("La cadena con espacios reemplazados es: " + cadenaremplazo);
		
		
	
	}
	
}