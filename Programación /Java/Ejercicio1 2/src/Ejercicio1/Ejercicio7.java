/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Random;
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
		 int num1 = new Random().nextInt(99)+1;
         int num2 = new Random().nextInt(99)+1;
         System.out.println(num1+ "+" +num2+ "=");
         
         int respuesta = new Scanner (System.in).nextInt();
         int resultado = num1 + num2;
         
         if (resultado == respuesta) {
        	 System.out.println("La respuesta es correcta");
         }else {
        	 System.out.println("La respuesta es incorrecta");
         }
         
		 
		 
		 
    
	    
		
	}
	
}