package Ej6;

import java.util.Scanner;


public class Punto {
	public double x;
	public double y;
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void desplazaX(double dx) {
		this.x += dx;
	}

	public void desplazaY(double dy) {
		this.y += dy;
	}
	 
	public void desplaza(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public double distanciaEuclidea(Punto otro) {
		double diferenciaX = this.x - otro.X();
		double diferenciaY = this.y - otro.Y();
		return Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
	}
	
	public void muestra() {
		System.out.println("Punto en el plano: (" + this.x + ", " + this.y + ")");
	}

	public double X() {
		return this.x;
	}

	public double Y() {
		return this.y;
	}
}