/**
 * 
 */
package Bucle;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer número: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese el segundo número: ");
        int num2 = sc.nextInt();
        
        int mcm = 1;
        int mayor = (num1 > num2) ? num1 : num2;

        int i = 2;
        while (i <= mayor) {
            if (num1 % i == 0 || num2 % i == 0) {
                mcm *= i;

                if (num1 % i == 0) {
                    num1 /= i;
                }

                if (num2 % i == 0) {
                    num2 /= i;
                }
            } else {
                i++;
            }
        }

        System.out.println("El mínimo común múltiplo de " + num1 + " y " + num2 + " es: " + mcm);
	}
}