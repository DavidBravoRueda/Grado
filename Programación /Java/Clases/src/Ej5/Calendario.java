package Ej5;

import java.util.Scanner;


public class Calendario {
	public int dia;
	public int mes;
	public int año;
	public int diaincrementado;
	public int mesincrementado;
	public int añoincrementado;
	
	public Calendario(int año, int mes, int dia) {
		this.dia = dia;
		this.mes = mes;
		this.dia = año;
	}
	
	public int diasEnMes(int año, int mes) {
        switch (mes) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(año) ? 29 : 28;
            default:
                return 31;
        }
    }
	 
	public boolean esBisiesto(int año) {
		return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
	}
	
	public void incrementarDia() {
        int maxDias = diasEnMes(año, mes);
        if (dia < maxDias) {
        	diaincrementado = dia + 1;
        }else {
        	diaincrementado = 1;
        	mesincrementado = mes + 1;
        }
	}
	
	public void incrementarMes() {
		if (mes < 12) {
			mesincrementado = mes + 1;
		}else {
			mesincrementado = 1;
			añoincrementado = año + 1;
		}
	}
	
	public void incrementarAño(int cantidad) {
		añoincrementado = año + cantidad;
	}
	
	public void main() {
		System.out.println("Fecha actial: " +dia+ " / " +mes+ " / " +año);
		System.out.println("Fecha despues de incremenatr un día: " +diaincrementado+ " / " +mes+ " / " +año);
		System.out.println("Fecha despues de incrementar un mes: " +dia+ " / " +mesincrementado+ " / " +año);
		System.out.println("Fecha despues de incrementar la cantidad de años: " +dia+ " / " +mes+ " / " +añoincrementado);
	}
	
	
}