package Ej6;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Coordenada X1: ");
        double x1 = sc.nextDouble();
        
        System.out.print("Coordenada Y1: ");
        double y1 = sc.nextDouble();
        
        Punto m = new Punto(x1, y1);
        
        System.out.print("Coordenada X2: ");
        double x2 = sc.nextDouble();
        
        System.out.print("Coordenada Y2: ");
        double y2 = sc.nextDouble();
        
        Punto mm = new Punto(x2, y2);
        
        m.muestra();
        mm.muestra();
        
        System.out.print("Desplazamiento en X: ");
        double desplazamientoX = sc.nextDouble();
        
        System.out.print("Desplazamiento en Y: ");
        double desplazamientoY = sc.nextDouble();
        
        m.desplaza(desplazamientoX, desplazamientoY);
        m.muestra();
        
        System.out.println("Distancia entre los puntos: " + m.distanciaEuclidea(mm));

        
	}
}