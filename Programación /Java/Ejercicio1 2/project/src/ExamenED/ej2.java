package ExamenED;

import java.util.Scanner;
/**
 *
 * Escribe un programa que lea un número n e imprima una pirámide de números con n filas como en la imagen de arriba.
 Ejemplo de ejecución:

 Introduce el número de niveles que tendrá la pirámide:
 6
      1
     121
    12321
   1234321
  123454321
 12345654321


 */
public class ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el número de niveles que tendrá la pirámide: ");
        int numeroNiveles = scanner.nextInt();
        int numeroPosiciones = numeroNiveles * 2 -1;
        int posInicial = numeroNiveles;
        int posFinal = numeroNiveles;

        //BUG. EL igual debemos de eliminarlo quedando solo que i es memnos a numero de niveles
        //for (int i = 0; i <= numeroNiveles; i++) {
        for (int i = 0; i < numeroNiveles; i++) {
        	//BUG. El contador empieza por 1
        	//int contador = 0;
            int contador = 1;
            String resultado = "";

            for (int j=0; j <= numeroPosiciones; j++) {
                if ((j < posInicial) || (j > posFinal)) {
                    resultado += " ";
                } else {
                    if (j < numeroNiveles) {
                        resultado += contador;
                        contador++;
                    } else {
                        resultado += contador;
                        //BUG. Se debe de cambiar los menos por mas
                        //contador++;
                        contador--;
                    }
                }
            }
            System.out.println(resultado);
            posFinal++;
            posInicial--;
        }
    }
}