/**
 * 
 */
package arrays;

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
		 Scanner scanner = new Scanner(System.in);


	        System.out.println("Bienvenido a la encuesta estadística");
	        System.out.println("Introduce los sueldos de los participantes. Para finalizar, introduce -1.");

	        double sueldo = 0;
	        while (sueldo != -1) {
	            System.out.print("Introduce el sueldo (o -1 para finalizar): ");
	            while (!scanner.hasNextDouble()) {
	                System.out.print("Por favor, introduce un número válido: ");
	                scanner.next();
	            }
	            sueldo = scanner.nextDouble();

	            if (sueldo >= 0) {
	                sueldos.add(sueldo);
	            } else if (sueldo != -1) {
	                System.out.println("Por favor, introduce un sueldo válido.");
	            }
	        }

	        // Aquí puedes realizar el análisis estadístico con la lista de sueldos

	        System.out.println("Encuesta finalizada. Gracias por participar.");
	        scanner.close();
		
	}
}