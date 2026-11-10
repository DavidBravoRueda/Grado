/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Random;
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
		int num1 = new Random().nextInt(99)+1;
        int num2 = new Random().nextInt(99)+1;
        int num3 = new Random().nextInt(3)+1;
        
        String operación = null;
        if (num3 ==1) {
        	operación = "+";
        }
        
        if (num3 ==2) {
        	operación = "-";
        }
        
        if (num3 ==3) {
        	operación = "*";
        }
        
        System.out.println(num1+ "" +operación+ "" +num2+ "=");
        
        int respuesta = new Scanner (System.in).nextInt();
        
        if (num3 == 1 ) {
        	int resultado = num1 + num2;
        	if (resultado == respuesta) {
              	 System.out.println("La respuesta es correcta");
               }else {
              	 System.out.println("La respuesta es incorrecta");
               }
        }
        
        if (num3 == 1 ) {
        	int resultado = num1 - num2;
        	if (resultado == respuesta) {
              	 System.out.println("La respuesta es correcta");
               }else {
              	 System.out.println("La respuesta es incorrecta");
               }
        }
        
        if (num3 == 1 ) {
        	int resultado = num1 * num2;
        	if (resultado == respuesta) {
              	 System.out.println("La respuesta es correcta");
               }else {
              	 System.out.println("La respuesta es incorrecta");
               }
        }
        
		 


		
	}
	
}