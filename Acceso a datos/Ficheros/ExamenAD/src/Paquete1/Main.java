package Paquete1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String uri = "xml.xml";
		Modificador m = new Modificador(uri);
		
		//Añadimos las 3 propiedadades
		m.añadirPropieda(new Propiedad("P5", "Atico", 3, "Málaga"));
		m.añadirPropieda(new Propiedad("P6", "Piso", 2, "Mijas"));
		m.añadirPropieda(new Propiedad("P7", "Charlet adosado", 5, "Málaga"));
		
		//Eliminamos las propiedades que son tipo Atico
		m.eliminarPropiedad("Atico");
		
		//informamos de las propiedades en Málaga
		System.out.println("Propiedades en Málaga:");
		m.consultarPropiedadesPorPoblacion("Málaga");
		
	}

}
