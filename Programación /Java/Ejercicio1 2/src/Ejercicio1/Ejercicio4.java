/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] unidades = {"", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve"};
	     String[] decenas = {"", "", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"};
		 
	     Scanner sc = new Scanner(System.in);
	     System.out.print("Introduce un número entre 1 y 99 ");
	        int numero = sc.nextInt();
	    		 
	     if (numero >= 1 && numero <= 99) {
	            if (numero <= 19) {
	                System.out.println("El número " + numero + " escrito es " + unidades[numero]);
	            } else {
	               int unidad = numero % 10;
	               int decena = numero / 10;
	               String representacion = decenas[decena];
	               if (unidad > 0) {
	               representacion += " y " + unidades[unidad];
	               }
	               System.out.println("El número " + numero + " escrito es " + representacion);
	            }
	     } else {
	    	 System.out.println("El número no está en el rango válido");
	     }
	}
	
}