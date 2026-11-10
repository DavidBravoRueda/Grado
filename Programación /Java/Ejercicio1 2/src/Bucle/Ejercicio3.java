/**
 * 
 */
package Bucle;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese la hora: ");
        int hora = sc.nextInt();
        
        System.out.println("Ingrese los minutos: ");
        int minutos = sc.nextInt();

        System.out.println("Ingrese los segundos: ");
        int segundos = sc.nextInt();

        System.out.println("Ingrese cuántos segundos se incrementa: ");
        int incremento = sc.nextInt();

        while (incremento > 0) {
            segundos++;
            if (segundos == 60) {
                segundos = 0;
                minutos++;
                if (minutos == 60) {
                    minutos = 0;
                    hora = (hora + 1) % 24;
                }
            }
        
            
            incremento--;
        }
        System.out.println("La nueva hora es: " +hora+ ":" +minutos+ ":" +segundos);
        
        
		
       }
}