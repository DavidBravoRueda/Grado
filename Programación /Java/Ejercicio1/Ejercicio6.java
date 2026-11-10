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
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame una medida en milímetros");
		int num1 = sc.nextInt();
		System.out.println("Dame una medida en centímetros");
		int centimetros = sc.nextInt();
		System.out.println("Dame una medida en metros");
		int num2 = sc.nextInt();
		int milimetros = num1 / 10;
		int metros = num2 * 100;
		int resultado = centimetros + milimetros + metros;
		System.out.println("La suma de las tres medidas es " +resultado+ " centímetros");
		
		
	
	}
		
}