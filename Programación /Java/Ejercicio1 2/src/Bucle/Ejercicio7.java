/**
 * 
 */
package Bucle;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio7 {

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
        
        int mcd = 1;
        int menor = (num1 < num2) ? num1 : num2;

        int i = menor;
        while (i >= 1 && mcd == 1) {
            if (num1 % i == 0 && num2 % i == 0) {
                mcd = i;
            }
            i--;
        }

        System.out.println("El máximo común divisor es: " + mcd);
	}
}