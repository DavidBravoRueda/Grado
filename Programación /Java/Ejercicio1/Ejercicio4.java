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
		Scanner sc = new Scanner(System.in);
		System.out.println("y=ax^2+ bx +c");
		System.out.println("Dame un valor para a");
		int a = sc.nextInt();
		System.out.println("Dame un valor para b");
		int b = sc.nextInt();
		System.out.println("Dame un valor para c");
		int c = sc.nextInt();
		System.out.println("Dame un valor de x");
		int x = sc.nextInt();
		int y = (a * (x ^ 2)) + (b * x) + (c);
		System.out.println("y = " +y);
		
		
	
	}
	
}