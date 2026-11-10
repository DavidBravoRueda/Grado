/**
 * 
 */
package Bucle;

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
		System.out.println("Ingrese un número decimal: ");
		int num = sc.nextInt();
	        
		if (num == 0) {
			System.out.println("0");
	        } else {
	        	String binario = "";

	        	while (num > 0) {
	                int resto = num % 2;
	                binario = resto + binario;
	                num /= 2;
	            }
	        	System.out.println(binario);
	}
}}

		
