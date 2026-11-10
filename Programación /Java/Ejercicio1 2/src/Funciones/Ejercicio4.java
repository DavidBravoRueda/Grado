/**
 * 
 */
package Funciones;

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame los dias: ");
		int dias = sc.nextInt();
		System.out.println("Dame las horas: ");
        int horas = sc.nextInt();
        System.out.println("Dame los minutos: ");
        int minutos = sc.nextInt();

        calcularsegundos(dias, horas, minutos);
    }

    public static void calcularsegundos(int dias, int horas, int minutos) {
        int segundosporminuto = 60;
        int minutosporhora = 60;
        int horaspordia = 24;

        int segundosdias = dias * horaspordia * minutosporhora * segundosporminuto;
        int segundoshoras = horas * minutosporhora * segundosporminuto;
        int segundosminutos = minutos * segundosporminuto;

        int segundos = segundosdias + segundoshoras + segundosminutos;
        
        System.out.println("El total de segundos es: " + segundos);
	}
}