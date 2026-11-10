package Calculadora;

import java.util.Scanner;

import java.util.Scanner;

public class calculadora {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     boolean continuar = true;

     while (continuar) {
         System.out.print("Ingresa el primer número: ");
         double num1 = sc.nextDouble();

         System.out.print("Ingresa el segundo número: ");
         double num2 = sc.nextDouble();

         System.out.println("Selecciona una operación:");
         System.out.println("1. Sumar");
         System.out.println("2. Restar");
         System.out.println("3. Multiplicar");
         System.out.println("4. Dividir");
         System.out.print("Ingrese el número de la operación que deseas realizar: ");
         int opcion = sc.nextInt();

         double resultado = 0;

         switch (opcion) {
             case 1:
                 resultado = operaciones.sumar(num1, num2);
                 break;
             case 2:
                 resultado = operaciones.restar(num1, num2);
                 break;
             case 3:
                 resultado = operaciones.multiplicar(num1, num2);
                 break;
             case 4:
                 resultado = operaciones.dividir(num1, num2);
                 break;
             default:
                 System.out.println("Opción inválida.");
                 continue;
         }

         System.out.println("El resultado es: " + resultado);
         
         System.out.print("¿Deseas realizar otra operación? (s/n): ");
         String respuesta = sc.next();

         if (!respuesta.equalsIgnoreCase("s")) {
             continuar = false;
         }
     }
 }
}
