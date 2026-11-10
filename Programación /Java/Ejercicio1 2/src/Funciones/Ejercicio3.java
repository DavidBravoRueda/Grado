/**
 * 
 */
package Funciones;

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
		System.out.println("Dame un número: ");
		int num = sc.nextInt();
        pares(num);
    }

	public static void pares(int num) {
        if (num <= 0) {
            System.out.println("Dame un valor mayor que O: ");
        } else {
            System.out.println("Los primeros " + num + " números pares son: ");

            for (int i = 1; i <= num; i++) {
                int par = 2 * i;
                System.out.println(par);
            }
        }
	}
}