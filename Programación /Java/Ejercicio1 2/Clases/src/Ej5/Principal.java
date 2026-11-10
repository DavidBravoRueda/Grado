package Ej5;

import java.util.Scanner;

import Ej4.Cambio;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Día actual: ");
		int dia = sc.nextInt();
		
		System.out.println("Mes actual: ");
		int mes = sc.nextInt();
		
		System.out.println("Año actual: ");
		int año = sc.nextInt();
		
		System.out.println("Cantidad de años que deseas aumentar: ");
		int cantidad = sc.nextInt();
		
		Calendario m = new Calendario(dia, mes, año);
		m.diasEnMes(año, mes);
		m.esBisiesto(año);
		m.incrementarDia();
		m.incrementarMes();
		m.incrementarAño(cantidad);
		m.main();
		

	}
}