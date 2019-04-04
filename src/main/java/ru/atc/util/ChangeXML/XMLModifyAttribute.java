package ru.atc.util.ChangeXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XMLModifyAttribute {
    /**
     * принимаем значения атрибутов в вставляем их в хмл
     * @param path полный пусть к файлу
     * @param elementNode элемент который мы хотим изменить
     * @param valueElementNode значение которое мы хотим указать в элементе
     */
    static public void SetAttributeInXML(String path, String elementNode, String valueElementNode) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        File inputFile= new File(path);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        NodeList nList = document.getElementsByTagName("form:Documents");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                if (eElement.getElementsByTagName(elementNode).getLength() == 0){
                    System.out.println("-----АТРИБУТА   " + elementNode + "   НЕТУ В ХМЛ " + path);
                    break;
                }
                eElement.getElementsByTagName(elementNode).item(0).setTextContent(valueElementNode);

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
