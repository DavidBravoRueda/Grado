/**ystemA
 * 
 */
package Ejercicio1;

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
		System.out.println("¿De cuantos kg de comida dispones?");
		int comida = new Scanner(System.in).nextInt();
		System.out.println("¿cuantos animales hay?");
		int animales = new Scanner (System.in).nextInt();
		System.out.println("¿Cauntos kg de comida come5 de media cada aniaml?");
		int media= new Scanner (System.in).nextInt();
		
		double resultado = media * animales;
		
		if (resultado == comida) {
			System.out.println("Hay sufiencte comidfa para alimentar a los aniamles");
		}
		
		if (resultado > comida) {
			System.out.println("Hay sufiencte comidfa para alimentar a los aniamles");
		}
		
		if (resultado > comida) {
			System.out.println("No hay sufiencte comidfa para alimentar a los aniamles");
		}
		
		
	 
       }
	
    }
        		                                                                                                