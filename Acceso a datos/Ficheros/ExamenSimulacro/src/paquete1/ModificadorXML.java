
package paquete1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class ModificadorXML implements caracteristicas {

	private Document doc;

	public ModificadorXML(String xmlFilePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(new File(xmlFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void añadirCaracterística(String casa, String característica) {
		NodeList casas = doc.getElementsByTagName("Casa");
		if (casas.getLength() > 0) {
			Element casaElement = (Element) casas.item(0);
			Element nuevaCaracteristica = doc.createElement("Característica");
			nuevaCaracteristica.setTextContent(característica);
			casaElement.appendChild(nuevaCaracteristica);
			guardarCambios();
		}
	}

	@Override
	public void quitarCaracterística(String casa, String característica) {
		NodeList casas = doc.getElementsByTagName("Casa");
		if (casas.getLength() > 0) {
			Element casaElement = (Element) casas.item(0);
			NodeList caracteristicas = casaElement.getElementsByTagName("Característica");
			for (int i = 0; i < caracteristicas.getLength(); i++) {
				if (caracteristicas.item(i).getTextContent().equals(característica)) {
					casaElement.removeChild(caracteristicas.item(i));
					break;
				}
			}
			guardarCambios();
		}
	}

	private void guardarCambios() {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("xml.xml"));
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}




