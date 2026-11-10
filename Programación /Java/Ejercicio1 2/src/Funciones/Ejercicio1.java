/**
 * 
 */
package Funciones;

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
		System.out.println("Dame el rádio de la esfera: ");
        double radio = sc.nextDouble();
        
        resultado(radio);
    }

    public static void resultado(double radio) {
        double superficie = 4 * Math.PI * (radio * radio);
        double volumen = (4.0 / 3.0) * Math.PI * (radio * radio * radio);
        System.out.println("Superficie: " + superficie);
        System.out.println("Volumen: " + volumen);
	}
 }
