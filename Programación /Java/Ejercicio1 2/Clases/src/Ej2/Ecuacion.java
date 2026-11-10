package Ej2;

import java.util.Scanner;


public class Ecuacion {
	public double a;
	public double b;
	public double c;

	public Ecuacion(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double discriminante() {
		return Math.pow(b, 2) - 4 * a * c;
	}
	
	public void solucion() {
		double discri = discriminante();
		
		if (discri > 0) {
			double x1 = (-b + Math.sqrt(discri)) / (2 * a);
            double x2 = (-b - Math.sqrt(discri)) / (2 * a);
            System.out.println("Tiene dos soluciones: X1 = " + x1 + "  X2 = " + x2);
		} else if (discri == 0) {
			 double x = -b / (2 * a);
			 System.out.println("Tiene una sola solución: X = " + x);
		}else {
			System.out.println("No tiene solución");
		}
		 
	}}