/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Dame los grados");
		double grados = new Scanner (System.in).nextDouble();
		
		if (grados <= 360 ) {
			double radianes = grados * Math.PI / 180;
			System.out.println(grados+ " grados equivalen a " +radianes+ " radianes");
		}else {
			double grados2 = grados - 360;
			double radianes = grados2 * Math.PI / 180;
			System.out.println(grados+ " grados equivalen a " +radianes+ " radianes");
		}
		
		

		 


		
	}
	
}