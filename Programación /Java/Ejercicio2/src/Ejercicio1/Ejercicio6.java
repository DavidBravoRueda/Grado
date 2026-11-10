/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int dado1 = random.nextInt(6) + 1;
	    int dado2 = random.nextInt(6) + 1;
	    int dado3 = random.nextInt(6) + 1;
	    int total = dado1 + dado2 + dado3;
	    System.out.println("Tirada del primer dado: " + dado1);
	    System.out.println("Tirada del segundo dado: " + dado2);
	    System.out.println("Tirada del tercer dado: " + dado3);
        System.out.println("Suma total de los tres dados: " + total);
		
	
	}
		
}