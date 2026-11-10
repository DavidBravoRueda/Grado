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
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa un número");         
        int n = sc.nextInt();
        System.out.println("Ingresa otro número");    	                                                                                                 
        int m = sc.nextInt();                                                                                               
       	int resto = n % m;                                                                                               
       	int cantidad = (m - resto) % m;
       	System.out.println("A " +n+ " hay que sumarle " +cantidad+ " para que sea múltiplo de " +m+ ".");
    
        }
    }
        		                                                                                                