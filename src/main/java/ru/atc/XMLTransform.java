package ru.atc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.atc.WorkWithFile.PathFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLTransform {

//принимаем номер документа и путь, по которому расположены ХМЛ. Меняем в них номера документов на переданные
    public static void setDocNumber(Integer number, String path) throws IOException, SAXException, ParserConfigurationException, TransformerException {
    File inputFile= new File(path);

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document document = dBuilder.parse(inputFile);

    NodeList nList = document.getElementsByTagName("form:Documents");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                eElement.getElementsByTagName("_doc_number").item(0).setTextContent(String.valueOf(number));

                //document.getDocumentElement().normalize();
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File(String.valueOf(inputFile)));

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                transformer.transform(source, result);

            }
        }
    }

//получаем номер документа в хмл
    public static String getDocNumber (String path) throws ParserConfigurationException, IOException, SAXException {
        String doc_number = null;
        String int_doc_number;
        File inputFile= new File(path);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        NodeList nList = document.getElementsByTagName("form:Documents");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                doc_number =  eElement.getElementsByTagName("_doc_number").item(0).getTextContent();

            }
        }
        int_doc_number = doc_number;
        return int_doc_number;
    }
//получаем номер инициатора из хмл
    public static String getIinitiatorInumber (String path) throws ParserConfigurationException, IOException, SAXException {
        String initiator_number = null;
        File inputFile= new File(path);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(inputFile);

        NodeList nList = document.getElementsByTagName("form:Documents");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                initiator_number =  eElement.getElementsByTagName("_initiator_number").item(0).getTextContent();

            }
        }
        return initiator_number;
    }
//пишем в хмл рандомные номера договоров
    public static Integer setNumberInXML (String Path) throws SAXException, TransformerException, ParserConfigurationException, IOException {
        ArrayList arrayPath = PathFile.arrayPath(Path);

        Integer rundomNumber = null;

        for (int i = 0; i < arrayPath.size(); i++) {

            rundomNumber = RandomNumber.RandomNun();
            XMLTransform.setDocNumber(rundomNumber, Path + arrayPath.get(i));

        }
        return rundomNumber;
    }
}

