/**ystemA
 * 
 */
package Ejercicio1;

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
		System.out.println("Dame la base");
		double base = new Scanner (System.in).nextInt();
		
		System.out.println("Dame la altura");
		double altura = new Scanner (System.in).nextInt();
		
		double area = (base * altura)/2;
		
		if (base >= 0 && altura >= 0) {
			System.out.println("El area del triangulo es "+area);
		}else {
			System.out.println("Las medidas no pueden ser negativas");
		}
		
	
	
	}
	
}