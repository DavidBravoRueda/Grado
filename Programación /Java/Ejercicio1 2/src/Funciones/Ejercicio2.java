/**
 * 
 */
package Funciones;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame el valor de x1: ");
		double x1 = sc.nextDouble();
		System.out.println("Dame el valor de y1: ");
		double y1 = sc.nextDouble();
		System.out.println("Dame el valor de x2: ");
		double x2 = sc.nextDouble();
		System.out.println("Dame el valor de y2: ");
		double y2 = sc.nextDouble();
        
		distancia(x1, y1, x2, y2);
    }
	
	public static void distancia(double x1, double y1, double x2, double y2) {
        double X = x1 - x2;
        double Y = y1 - y2;
        double distancia = Math.sqrt((X * X) + (Y * Y));
        System.out.println("La distancia entre los puntos es: " + distancia);

	}
}