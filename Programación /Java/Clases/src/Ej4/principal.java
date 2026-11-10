package Ej4;

import java.util.Scanner;

import Ej1.MarcaPagina;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Precio del producto: ");
		double precioproducto = sc.nextDouble();
		
		System.out.println("Cantidad recibida: ");
		double cantidadrecibida = sc.nextDouble();
		
		
		Cambio m = new Cambio(precioproducto, cantidadrecibida, 0);
		m.calcular(cantidadrecibida);
		
}}