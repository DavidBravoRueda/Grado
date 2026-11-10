/**
 * 
 */
package Funciones;

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un número: ");
		int num = sc.nextInt();

        System.out.println("Capicua: " + capicua(num));
        System.out.println("Primo " + primo(num));
        System.out.println("Siguiente primo: " + siguienteprimo(num));
        System.out.println("Número de dígitos: " + digitos(num));
        System.out.println("Número volteado: " + voltea(num));
        System.out.println("Dígito en la posición 2: " + digitonum(num, 2));
        System.out.println("Quitando un dígitos por detrás: " + quitardetras(num, 1));
        System.out.println("Quitando un dígitos por delante: " + quitardelante(num, 1));
        System.out.println("Añadiendo un dígito por detrás: " + pegardetras(num, 1));
        System.out.println("Añadiendo un digito por delante: " + pegardelante(num, 1));
    }
    static boolean capicua(int num) {
        return num == voltea(num);
    }

    static boolean primo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int siguienteprimo(int num) {
        int siguiente = num + 1;
        while (!primo(siguiente)) {
            siguiente++;
        }
        return siguiente;
    }

    static int digitos(int num) {
    	int cantidaddigitos = 0;
        int numtemporal = num;

        while (numtemporal != 0) {
            numtemporal /= 10;
            cantidaddigitos++;
        }

        System.out.println(cantidaddigitos);
		return numtemporal;
    }
    

    static int voltea(int num) {
    	
    	
    	
    	
    	
        int resultado = 0;
        while (num > 0) {
            resultado = resultado * 10 + num % 10;
            num /= 10;
        }
        return resultado;
    }

    static int digitonum(int num, int posicion) {
    	int longitud = digitos(num);

        if (posicion >= 0 && posicion < longitud) {
            int divisor = (int) Math.pow(10, longitud - posicion - 1);
            int digito = (num / divisor) % 10;
            System.out.println(digito);
        } else {
            System.out.println("no valido");
        }
		return longitud;
    }

    static int quitardetras(int num, int n) {
        return num / (int) Math.pow(10, n);
    }

    static int quitardelante(int num, int n) {
        int longitud = digitos(num);
        return num % (int) Math.pow(10, longitud - n);
    }

    static int pegardetras(int numero, int digito) {
        return numero * 10 + digito;
    }

    static int pegardelante(int num, int digito) {
        return digito * (int) Math.pow(10, digitos(num)) + num;
	}
}