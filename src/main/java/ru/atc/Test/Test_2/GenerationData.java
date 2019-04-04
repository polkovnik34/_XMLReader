package ru.atc.Test.Test_2;

import org.xml.sax.SAXException;
import ru.atc.WorkWithFile.Filetranfer;
import ru.atc.XMLTransform;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static ru.atc.WorkWithFile.FindFileInFolder.processFilesFromFolder;

public class GenerationData {
    static String pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_6_Аренда/";
    static String pathToPackage1 = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_3_Внешние/";
    static String pathToPackage2 = "resources/Test_2/ИнициаторПодписание/ИнициаторПодписание_3_ЭДО/";



    public static void main(String args[]) throws IOException, ParserConfigurationException, TransformerException, SAXException {
        //GenerationData.Generation("resources/Test_2/ИсполнительСИ1/");
        GenerationData.Generation(pathToPackage);
        //GenerationData.Generation(pathToPackage2);
/*        GenerationData.Generation(pathToPackage3);
        GenerationData.Generation(pathToPackage4);*/
        //GenerationData.Generation(pathToPackage1);


    }

    public static void Generation(String pathToPackage) throws IOException, TransformerException, SAXException, ParserConfigurationException {

        File folder = new File(pathToPackage);
        Filetranfer.ConnectionSFTP();
        processFilesFromFolder(folder);
        Filetranfer.DisconnectSFTP();

    /*    Scanner in = new Scanner(System.in);
        System.out.print("Документы загружены? ");
        String num = in.nextLine();*/

/*        Filetranfer.ConnectionSFTP();
        XMLTransform.setNumberInXML(pathToPackage);
        Filetranfer.sendFile(pathToPackage);
        Filetranfer.DisconnectSFTP();

        Scanner in = new Scanner(System.in);
        System.out.print("Документы загружены? ");
        String num = in.nextLine();*/
    }
}
