/**
 * 
 */
package Funciones;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un valor para a: ");
		int a = sc.nextInt();
		System.out.println("Dame un valor para b: ");
		int b = sc.nextInt();
        calcular(a, b);
    }

    public static void calcular(int a, int b) {
        if (a >= b && b > 0) {
            calcular(a - b, b);
        } else if (b > a && a > 0) {
            calcular(a, b - a);
        } else if (a == 0) {
            System.out.println("El MCD es: " + b);
        } else if (b == 0) {
            System.out.println("El MCD es: " + a);
        } else {
            System.out.println("Número no válido");
        }
    }
}
