package Ej1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ElimiarRenaul {

    public static void main(String[] args) {
        try {
            File inputFile = new File("/Users/davidbravorueda/eclipse-workspace/Ejercicio3/concesionario.xml/");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList cocheList = doc.getElementsByTagName("coche");

            for (int i = 0; i < cocheList.getLength(); i++) {
                Node coche = cocheList.item(i);
                if (coche.getNodeType() == Node.ELEMENT_NODE) {
                    Element cocheElement = (Element) coche;
                    String marca = cocheElement.getElementsByTagName("marca").item(0).getTextContent();
                    if (marca.equalsIgnoreCase("Renault")) {
                        coche.getParentNode().removeChild(coche);
                        break;
                    }
                }
            }

            // Sobrescribir el archivo original con los cambios
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/Users/davidbravorueda/eclipse-workspace/Ejercicio3/concesionario.xml/"));
            transformer.transform(source, result);

            System.out.println("Elemento Renault eliminado y archivo actualizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
