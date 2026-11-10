package Ej3;

import java.util.Scanner;

import Ej4.Cambio;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Numero de colores: ");
		int num = sc.nextInt();
		
		Colores m = new Colores();
		m.numero(num);
		
		
	}
}