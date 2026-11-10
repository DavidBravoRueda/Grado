/**
 * 
 */
package Examen2;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 
 */
public class ejercicio5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		System.out.println("Buenas, ¿cuantas personas sois?");
		int personas = sc.nextInt();
		
		if  (personas > 4) {
			System.out.println("Lo siento, no admitimos grupos de " +personas+ ", haga grupos de 4 personas como máximo e intentelo de nuevo");
		}
	}
}