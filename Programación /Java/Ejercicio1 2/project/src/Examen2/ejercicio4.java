/**
 * 
 */
package Examen2;

import java.util.Scanner;

/**
 * 
 */
public class ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe un número: ");
		double num = sc.nextDouble();
		
		System.out.print("¿Desea obtener la parte entera o la parte decimal del número?(1 para parte entera,2 para parte decimal)");
		int mostrar = sc.nextInt();
		
		if (mostrar == 1) {
			getParteEntera(num);
		}
		
		if (mostrar == 2) {
			getParteDecimal(num);
		}
		
	
	}
	public static void getParteEntera (double num) {
		int entero = (int) num;
		System.out.println(entero);
	}
	
	public static void getParteDecimal (double num) {
		int entero2 = (int)num;
		double decimal = (double) num - (int) num;
		int decimal2 =  (int) (decimal * 100);
		System.out.println(decimal2);
		
	}
}