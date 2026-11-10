/**
 * 
 */
package junit;

import java.util.Scanner;

/**
 * 
 */
public class funciones {

	/**
	 * @param args
	 */
	 public static boolean esCapicua(int num) {
	        int original = num;
	        int invertido = 0;

	        while (num > 0) {
	            int digito = num % 10;
	            invertido = invertido * 10 + digito;
	            num = num / 10;
	        }

	        return original == invertido;
	    }

	    public static boolean esPrimo(int num) {
	        if (num <= 1) {
	            return false;
	        }

	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }

	        return true;
	    }
	    
	    public static int siguientePrimo(int numero) {
	        int siguiente = num + 1;
	        while (!esPrimo(siguiente)) {
	            siguiente++;
	        }
	        return siguiente;
	    }

	    
	    public static int digitos(int num) {
	        if (num== 0) {
	            return 1;
	        }

	        int c = 0;
	        while (num != 0) {
	            num = num / 10;
	            c++;
	        }

	        return c;
	    }
	    
	    public static int voltea(int num) {
	        int invertido = 0;
	        while (num != 0) {
	            int digito = num % 10;
	            invertido = invertido * 10 + digito;
	            num = num / 10;
	        }
	        return invertido;
	    }
	    
	    public static int digitoN(int num, int n) {
	        for (int i = 0; i < n; i++) {
	            num = num / 10;
	        }
	        return num % 10;
	    }
	    
	    public static int quitaPorDetras(int num, int n) {
	        return num / (int) Math.pow(10, n);
	    }
	    
	    public static int quitaPorDelante(int num, int n) {
	        int longitud = digitos(num);
	        return num % (int) Math.pow(10, longitud - n);
	    }
	    
	    public static int pegaPorDetras(int num, int digito) {
	        return num * 10 + digito;
	    }
	    
	    public static int pegaPorDelante(int num, int digito) {
	        int longitud = digitos(num);
	        return digito * (int) Math.pow(10, longitud) + num;
	    }
	}
}