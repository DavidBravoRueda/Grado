/**ystemA
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercicio10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nota = 0;
		
		System.out.println("1. ¿Que clase utilizo para un número aleatorio en java?");
        System.out.println("A) Random");
        System.out.println("B) Scanner");
        System.out.println("C) null");
        String respuesta1 = new Scanner (System.in).nextLine();
        
        if (respuesta1 == "A") {
        	nota++;
        }
        
        System.out.println("2. ¿Que lenguaje sirve para programar el aspecto de una pagian web?");
        System.out.println("A) Pythom");
        System.out.println("B) HTML");
        System.out.println("C) Java");
        String respuesta2 = new Scanner (System.in).nextLine();
        
        if (respuesta2 == "B") {
        	nota++;
        }
        
        System.out.println("3. ¿Con que erramienta se hace un boceto para una pagina web?");
        System.out.println("A) Eclipse");
        System.out.println("B) Wix");
        System.out.println("C) ErMarker");
        String respuesta3 = new Scanner (System.in).nextLine();
        
        if (respuesta3 == "B") {
        	nota++;
        }
        
        System.out.println("4. ¿Como se llama la erramienta par hacer diagramas de base de datos?");
        System.out.println("A) Eclipse");
        System.out.println("B) Wix");
        System.out.println("C) ErMarker");
        String respuesta4 = new Scanner (System.in).nextLine();
        
        if (respuesta4 == "C") {
        	nota++;
        }
        
        System.out.println("5. ¿Como se llama lo que relaciona una cosa con otra?");
        System.out.println("A) Entidad");
        System.out.println("B) Diversificación");
        System.out.println("C) Relación");
        String respuesta5 = new Scanner (System.in).nextLine();
        
        if (respuesta5 == "C") {
        	nota++;
        }
        
        System.out.println("6. ¿Cuál de las siguientes opciones no es un sistema operativo?");
        System.out.println("A) Windows");
        System.out.println("B) Microsoft Office");
        System.out.println("C) Linux");
        String respuesta6 = new Scanner (System.in).nextLine();
        
        if (respuesta6 == "B") {
        	nota++;
        }
        
        System.out.println("7. ¿Qué acrónimo representa la tecnología inalámbrica utilizada para la conexión a Internet?");
        System.out.println("A) HTML");
        System.out.println("B) Wi-Fi");
        System.out.println("C) VPN");
        String respuesta7 = new Scanner (System.in).nextLine();
        
        if (respuesta7 == "B") {
        	nota++;
        }        
        
        System.out.println("8. ¿Cuál de las siguientes no es una base de datos relacionales?");
        System.out.println("A) MySQL");
        System.out.println("B) MongoDB");
        System.out.println("C) Oracle");
        String respuesta8 = new Scanner (System.in).nextLine();
        
        if (respuesta8 == "B") {
        	nota++;
        }
        
        System.out.println("9. ¿Cuál es el término utilizado para un programa malicioso que se disfraza como software legítimo?");
        System.out.println("A) Malware");
        System.out.println("B) Firewall");
        System.out.println("C) Freeware");
        String respuesta9 = new Scanner (System.in).nextLine();
        
        if (respuesta9 == "A") {
        	nota++;
        }
        
        System.out.println("10. ¿Cuál es el propósito de un firewall en una red informática?");
        System.out.println("A) Proteger contra virus");
        System.out.println("B) Mejorar la velocidad de la conexión");
        System.out.println("C) Controlar el acceso a la red");
        String respuesta10 = new Scanner (System.in).nextLine();
        
        if (respuesta10 == "C") {
        	nota++;
        }
        
        System.out.println("Tu nota es: " +nota);
        
		
		
		
	}
	
}