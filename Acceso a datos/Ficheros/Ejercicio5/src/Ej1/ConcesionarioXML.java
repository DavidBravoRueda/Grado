package Ej1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ConcesionarioXML {

    public static void main(String[] args) {
        try {
            File inputFile = new File("/Users/davidbravorueda/eclipse-workspace/Ejercicio5/concesionario.xml/");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element nuevoCoche = doc.createElement("coche");
            Element matricula = doc.createElement("matricula");
            matricula.appendChild(doc.createTextNode("MMM4567"));
            Element marca = doc.createElement("marca");
            marca.appendChild(doc.createTextNode("Renault"));
            Element precio = doc.createElement("precio");
            precio.appendChild(doc.createTextNode("32000"));

            nuevoCoche.appendChild(matricula);
            nuevoCoche.appendChild(marca);
            nuevoCoche.appendChild(precio);

            Node coches = doc.getElementsByTagName("coches").item(0);
            coches.appendChild(nuevoCoche);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/Users/davidbravorueda/eclipse-workspace/Ejercicio5/concesionario.xml"));
            transformer.transform(source, result);

            System.out.println("Coche añadido correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}