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
		System.out.println("Dame el número");
		int num = new Scanner (System.in).nextInt();
		
		int valorabsoluto;
		
		if (num >= 0) {
			valorabsoluto = num;
		}else {
			valorabsoluto = -num;
		}
		
		System.out.println("El valor absoluto de "+num+ " es " +valorabsoluto);
		
	
	}
		
}