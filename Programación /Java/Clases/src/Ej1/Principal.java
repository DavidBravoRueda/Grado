package Ej1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame el título del libro:");
		String titulo = sc.next();
		
		System.out.println("Dame la cantidad de paginas leidas:");
		int cantidad = sc.nextInt();
		
		System.out.println("¿Cuantas paginas tiene el libro?");
		int total = sc.nextInt();

		MarcaPagina m = new MarcaPagina(titulo, total, cantidad);
		m.incrementar(cantidad);
		
		if (cantidad>=total) {
			m.reiniciarlectura();
		}else {
			m.obtenerinformacion();
		}
	}
}
