package Ej4;

import java.awt.Menu;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
        Supercola supercola = new Supercola();
        Menu menu = new Menu(supercola);
        menu.ejecutar();
    }

}
