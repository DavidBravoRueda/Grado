/**
 * 
 */
package Ejercicio1;

import java.util.Scanner;

/**
 * 
 */
public class Ejercici1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame una base imponible");
		int base=sc.nextInt();
		Scanner sc2=new Scanner(System.in);
		System.out.println("Dame el porcentaje de iva");
		int porcentaje=sc2.nextInt();
		int IVA =(base*porcentaje)/(100);
		int Total=(base+IVA);
		System.out.println("El IVA es "+IVA+" euros y el total es de "+Total+" Euros");
		

	}

}
