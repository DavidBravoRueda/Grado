package Paquete1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

//En esta clase añadiremos todos los métodos necesarios para manipular el xml
public class Modificador {
	private String uri;
	//Metemos la ruta en una vafriable
	public Modificador(String uri) {
		this.uri = "/Users/davidbravorueda/eclipse-workspace/ExamenAD/src/xml.xml";
	}
	
	//Método para añadir inmuebles.
	public void añadirPropieda(Propiedad propiedad) {
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder b = f.newDocumentBuilder();
			Document doc = b.parse(uri);
			
			//añade una nueva propiedad
			Element nuevaPropiedad = doc.createElement("Propiedad");
			
			//añade elementos hijos y crea nuevas propiedades
			Element elementoId = doc.createElement("Id");
			elementoId.setTextContent(propiedad.getId());
			
			Element elementoTipo = doc.createElement("Tipo");
			elementoTipo.setTextContent(propiedad.getTipo());
			
			Element elementoHabitaciones = doc.createElement("Habitaciones");
			elementoHabitaciones.setTextContent(String.valueOf(propiedad.getHabitaciones()));
			
			Element elementoPoblacion = doc.createElement("Poblacion");
			elementoPoblacion.setTextContent(propiedad.getPoblacion());
			
			nuevaPropiedad.appendChild(elementoId);
			nuevaPropiedad.appendChild(elementoTipo);
			nuevaPropiedad.appendChild(elementoHabitaciones);
			nuevaPropiedad.appendChild(elementoPoblacion);
			
			doc.getDocumentElement().appendChild(nuevaPropiedad);
			
			//Guarda la modificación
			guardarDocumento(doc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Método para eliminar propiedades segun el tipo
	public void eliminarPropiedad(String tipo) {
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder b = f.newDocumentBuilder();
			Document doc = b.parse(uri);
			
			//Busca el tipo que coincide y cuabndo lo encuentra lo elimina del xml
			NodeList propiedades = doc.getElementsByTagName("Propiedad");
			for (int i = 0; i < propiedades.getLength(); i++) {
				Element propiedad = (Element) propiedades.item(i);
				String tipoPropiedad = propiedad.getElementsByTagName("Tipo").item(0).getTextContent();
				if (tipoPropiedad.equalsIgnoreCase(tipo)) {
					propiedad.getParentNode().removeChild(propiedad);
					break;
				}
			}
			
			//Guarda los cambios
			guardarDocumento(doc);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Consulta las propiedades según la población
	public void consultarPropiedadesPorPoblacion(String poblacion){ 
		try { 
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder b = f.newDocumentBuilder(); 
			Document doc = b.parse(uri);
			
			//Busca la población que se ingresa y si coincida la muestra
			NodeList propiedades = doc.getElementsByTagName("Propiedad");
			for (int i = 0; i < propiedades.getLength(); i++) {
				Element propiedad = (Element) propiedades.item(i);
				String poblacionPropiedad = propiedad.getElementsByTagName("Poblacion").item(0).getTextContent();
				if (poblacionPropiedad.equalsIgnoreCase(poblacion)) {
					String id = propiedad.getElementsByTagName("Id").item(0).getTextContent();
					String tipo = propiedad.getElementsByTagName("Tipo").item(0).getTextContent();
					String habitaciones = propiedad.getElementsByTagName("Habitaciones").item(0).getTextContent();
					System.out.println("ID: " + id + ", Tipo: " + tipo + ", Habitaciones: " + habitaciones + ", Población: " + poblacionPropiedad);
				}
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	//método para guardar los cambios
	//utiliza el transformer para guardar los cambios en el archivo seleccionado
	private void guardarDocumento(Document doc) {
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(uri));
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
