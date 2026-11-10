package Calculadora;

public class operaciones {
 public static double sumar(double a, double b) {
     return a + b;
 }

 public static double restar(double a, double b) {
     return a - b;
 }

 public static double multiplicar(double a, double b) {
     return a * b;
 }

 public static double dividir(double a, double b) {
     if (b == 0) {
         System.out.println("No se puede dividir por cero");
         return 0;
     }
     return a / b;
 }
}

