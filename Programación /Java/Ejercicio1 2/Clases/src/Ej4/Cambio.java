package Ej4;

import java.util.Scanner;


public class Cambio {
	public double precioproducto;
	public double cantidadrecibida;
	public double cambio;

	public Cambio(double precioproducto, double cantidadrecibida, double cambio) {
		super();
		this.precioproducto = precioproducto;
		this.cantidadrecibida = cantidadrecibida;
		this.cambio = 0;
	}
		
		public void calcular(double cambio) {
			cambio = cantidadrecibida - precioproducto;
			System.out.println("La cantidad a delvolver es: " +cambio);
			
		}
	}