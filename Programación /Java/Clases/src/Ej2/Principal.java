package Ej2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("a = ");
		double a = sc.nextDouble();
		
		System.out.println("b = ");
		double b = sc.nextDouble();
		
		System.out.println("c = ");
		double c = sc.nextDouble();
		
		Ecuacion m = new Ecuacion(a, b, c);
		m.discriminante();
		m.solucion();
		
	}
}