/**
 * 
 */
package Funciones;

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
		System.out.println("Dame la hora1: ");
		int hora1 = sc.nextInt();
		System.out.println("Dame el minuto1: ");
		int minuto1 = sc.nextInt();
		System.out.println("Dame la hora2: ");
        int hora2 = sc.nextInt(); 
        System.out.println("Dame el minuto2: ");
        int minuto2 = sc.nextInt();

        diferencia(hora1, minuto1, hora2, minuto2);
    }
    
	public static void diferencia(int hora1, int minuto1, int hora2, int minuto2) {
        int totalminutos1 = hora1 * 60 + minuto1;
        int totalminutos2 = hora2 * 60 + minuto2;
        
        System.out.println("La diferencia en minutos es: " + Math.abs(totalminutos1 - totalminutos2));
	}
}