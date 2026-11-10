package XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class ModificarXMLCasa {

    public static void main(String[] args) {
        String URI = "/Users/davidbravorueda/eclipse-workspace/Ejercicio2/Casa.xml/";
        AnadirCaracteristica(URI);
    }

    public static void AnadirCaracteristica(String URI) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File(URI));
            document.getDocumentElement().normalize();
            
            Element terraza = document.createElement("Terraza");

            Element tamano = document.createElement("Tamano");

            Text valor = document.createTextNode("20m2");

            NodeList nodoRaiz = document.getDocumentElement().getElementsByTagName("Casa");
            nodoRaiz.item(0).appendChild(terraza);
            terraza.appendChild(tamano);
            tamano.appendChild(valor);

            Source source = new DOMSource(document);

            Result result = new StreamResult(new File("CasaModificada.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

            System.out.println("XML modificado correctamente.");

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            System.err.println("Error: " + e);
        }
    }
}