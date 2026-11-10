package Ej1;

import java.util.Scanner;


public class MarcaPagina {
	public String titulo;
	public int total;
	public int actual;

	public MarcaPagina(String titulo, int total, int paginaActual) {
		super();
		this.titulo = titulo;
		this.total = total;
		this.actual = 1;
	}

	public void incrementar(int cantidad) {
		actual = Math.min(actual + cantidad, total);
	}
	
	public void obtenerinformacion() {
		System.out.println("Libro: " + titulo + ", pagina actual:" + actual);
	}
	
	public void reiniciarlectura() {
		actual=1;
		System.out.println("Lectura reiniciada. Comenzando desde página 1.");
	}
	}
