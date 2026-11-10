package Ej1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Text;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
*
* @author administrador
*/
public class Ej1 {
public static void main(String[] args) {
// Document document = null;
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
try{
DocumentBuilder builder = factory.newDocumentBuilder();
DOMImplementation implementation = builder.getDOMImplementation();
Document document = (Document)
implementation.createDocument(null,"hola",null);
//Creación de elementos
//creamos el elemento principal casa
Element casa = document.createElement("Casa");

//creamos un nuevo elemento. Casa contiene habitaciones
Element habitacion= document.createElement("Habitacion");
//creamos un nuevo elemento. Habitación tiene color
Element color = document.createElement("Color");
//Ingresamos la info. El color de esta habitación es azul
Text valorColor = document.createTextNode("Azul");
//Asignamos la versión de nuestro XML
document.setXmlVersion("1.0");
//Añadimos la casa al documento
document.getDocumentElement().appendChild(casa);
//Añadimos el elemento hijo a la raíz
casa.appendChild(habitacion);
//Añadimos elemento
habitacion.appendChild(color);
//Añadimos valor
color.appendChild(valorColor);
Source source = new DOMSource(document);
// Creo el Result, indicado que fichero se va a crear
Result result = new StreamResult(new File("hola.xml"));
// Creo un transformer, se crea el fichero XML
Transformer transformer =
TransformerFactory.newInstance().newTransformer();
transformer.transform(source, result);
}catch(ParserConfigurationException | TransformerException |
DOMException e){
System.err.println("Error: "+e);
}
}
}
