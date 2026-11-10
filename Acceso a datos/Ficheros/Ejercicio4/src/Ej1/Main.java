package Ej1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;

public class Main {

    public static Document document;

    public static void eliminarHabitacionAzul(String URI) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(new File(URI));
            document.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        NodeList listaNodos = document.getDocumentElement().getElementsByTagName("Habitacion");
        Node nodo;
        for (int i = 0; i < listaNodos.getLength(); i++) {
            nodo = listaNodos.item(i);
            NodeList listaCaracteristicas = nodo.getChildNodes();
            Node caracteristica;
            for (int z = 0; z < listaCaracteristicas.getLength(); z++) {
                caracteristica = listaCaracteristicas.item(z);
                if (caracteristica.getNodeName().equals("Color") && caracteristica.getTextContent().equals("Azul")) {
                    nodo.getParentNode().removeChild(nodo);
                    break;
                }
            }
        }

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(URI));

            transformer.transform(source, result);

            System.out.println("Fichero XML modificado con éxito.");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String rutaArchivoXML = "/Users/davidbravorueda/eclipse-workspace/Ejercicio4/casa.xml/";
        eliminarHabitacionAzul(rutaArchivoXML); 
    }
}
