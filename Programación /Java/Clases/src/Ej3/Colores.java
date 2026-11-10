package Ej3;

import java.util.Scanner;


public class Colores {
	public String[] colores;
	public int total;

	public Colores() {
		colores = new String[] {"Rojo", "Verde", "Azul", "Amarillo", "Naranja", "Burdeos", "Turquesa", "Celeste", "Magenta", "Fucsia", "Morado", "Lila", "Rosa", "Marrón", "Beige", "Blanco", "Plata", "Gris", "Negro"};
	}

	public void numero(int num) {
		for (int i = 0; i < num; i++) {
			String a = colores[(int) (Math.random() * 18)];
			System.out.println(a);
		}
	}}