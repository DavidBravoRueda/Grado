/**
 * 
 */
package Bucle;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Ingrese el número de filas: ");
		 int fila = sc.nextInt();

		 for (int i = 0; i < fila; i++) {
			 int coeficiente = 1;
			 for (int j = 0; j <= i; j++) {
				 System.out.println(coeficiente + " ");
				 coeficiente = coeficiente * (i - j) / (j + 1);
			 }
			 System.out.println();
		 }
		
		
	}
	
}
