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
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame una cantidad de segundos");
		int segundos = sc.nextInt();
		int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int resto = segundos % 60;
        System.out.println(segundos+ " segundos equivale a " +horas+ " horas, " +minutos+ " minutos y " +resto+ " segundos");
	
	
	}
	
}