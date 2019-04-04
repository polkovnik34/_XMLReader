package ru.atc.util.ChangeXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XMLModifyAttributeBatch {
    static public void SetAttributeInXML(String path,
                                         String FileName,
                                         String batchNumber) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        File inputFile= new File(path);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        NodeList nList = document.getElementsByTagName("form:Documents");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                eElement.getElementsByTagName("_BatchNumber").item(0).setTextContent(batchNumber);
                eElement.getElementsByTagName("_filename").item(0).setTextContent(FileName);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File(String.valueOf(inputFile)));

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                transformer.transform(source, result);

            }
        }
    }
}
