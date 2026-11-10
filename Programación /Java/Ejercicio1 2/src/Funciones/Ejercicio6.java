/**
 * 
 */
package Funciones;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame el primer número: ");
		int num1 = sc.nextInt();
		System.out.println("Dame el segundo número: ");
		int num2 = sc.nextInt();

        verificar(num1, num2);
	
	}

       public static void verificar(int num1, int num2) {
            int sumadivisores1 = divisorespropios(num1);
            int sumadivisores2 = divisorespropios(num2);
            
            if (sumadivisores1 == num2 && sumadivisores2 == num1) {
                System.out.println(num1 + " y " + num2 + " son números amigos.");
            } else {
                System.out.println(num1 + " y " + num2 + " no son números amigos.");
            }
        }
	
       public static int divisorespropios(int num) {
            int suma = 1;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    suma += i;

                    if (i != num / i) {
                        suma += num / i;
                    }
                }
            }
            System.out.println("La suma de los divisores propios de es: " + suma);
			return suma;
       }
     }
            
   


