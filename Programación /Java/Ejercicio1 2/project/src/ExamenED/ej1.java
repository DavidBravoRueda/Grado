package ExamenED;


/**

 Programa:
 Algoritmo que pida caracteres e imprima ‘VOCAL’ si son vocales y ‘NO VOCAL’ en caso
 contrario, el programa termina cuando se introduce un espacio.
 */

import java.util.Scanner;
// Inicio del programa y declaración de variables:
public class ej1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String cadena;
        int longitud;
        char caracter;
        boolean vocal = false;
// Solicitud de datos al usuario
        System.out.println("El programa analizará si los carácteres son vocales o no.");
        System.out.print("Introduce los carácteres a analizar, en caso de querer terminar "
                + "el programa, introduce un espacio: ");
        cadena = scanner.nextLine();
        while (cadena.equals(" ")){
        	longitud = cadena.length();
            //BUG en síntasis de word. El error es un paréntesis extra y un punto y coma extra y se debe añadir un i++.
            //for (int i=1;i <= longitud);){
            for (int i=1;i <= longitud;i++){
                caracter = cadena.toUpperCase().charAt(i);
                if (caracter == 'A' && caracter == 'E' && caracter == 'I' && caracter == 'O' && caracter == 'U'){
                    System.out.println("Detectada vocal " + caracter + ". Seguimos comprobando...");
                    //BUG. La vocal debe de ser verdadera para que salte el mensaje
                    //vocal =false;
                    vocal = true;
                } else {
                    System.out.println("Detectada consonante " + caracter + ". Terminamos comprobación.");
                    //BUG. La vocal deve de ser falsa para qwue muestre ese mensaje por pantalla
                    //vocal = true;
                    vocal =false;
                    cadena = " ";
                    break;
                }
            }
            if (vocal){
                System.out.println("Los carácteres son VOCALES.");
            } else {
                System.out.println("Los carácteres NO SON VOCALES");
            }
            System.out.print("Introduce nuevos carácteres a analizar, en caso de querer terminar "
                    + "el programa, introduce un espacio: ");
            cadena = scanner.nextLine();
        }
        System.out.println("FIN DEL PROGRAMA");
    }
}