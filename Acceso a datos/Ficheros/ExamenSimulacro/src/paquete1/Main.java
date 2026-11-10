package paquete1;

public class Main {

	public static void main(String[] args) {
		ModificadorXML modificador = new ModificadorXML("xml.xml");
		modificador.añadirCaracterística("Casa1", "Piscina");
		modificador.quitarCaracterística("Casa1", "Piscina");
	}
}
