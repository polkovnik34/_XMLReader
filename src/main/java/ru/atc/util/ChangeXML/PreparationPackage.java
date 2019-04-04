package ru.atc.util.ChangeXML;

import org.xml.sax.SAXException;
import ru.atc.WorkWithFile.PathFile;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//формируем новые пакеты с документами
public class PreparationPackage {
    private static String path = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_6_Аренда/";

    static public void main(String args[]) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        RenameFiles();
        //ChangeAttributeInXML();

        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Изменена ХМЛ -" + path);
        System.out.println("Изменение ХМЛ завершено, время окончания - " +  time.format( new Date() ));
    }

    public static void ChangeAttributeInXML() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String xmlName;
        String fullPathToFile;

        ArrayList FileName = PathFile.arrayPath(path);

        for (int i = 0; i < FileName.size(); i++) {
            xmlName = String.valueOf(FileName.get(i));
            fullPathToFile = path + xmlName;

            //добавляем значения атрибутов в хмл
            XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_supplier_id", "10005");
            XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_supplier_name", "ООО \"ТИТАН\" Г. КАЛИНИНГРАД ");
            //XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_is_signature", "true");
            //XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_receipt_number", "000");
            XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_purchase_order_number", "18074086");
            XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_contract_number", "SSC_OD7");
            //XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_date_contract", "2018-03-05");
            //XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_profile_name", "AP_Счет_на_предоплату");
            //XMLModifyAttribute.SetAttributeInXML(fullPathToFile, "_filial_code", "hq");
        }
    }

    //изменение filename и BatchNumber в пакете
    public static void RenameFiles() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String[] pdfName;
        String xmlName;
        String newFileName;
        String fullPathToFile;

        ArrayList FileName = PathFile.arrayPath(path);
        String newBatch = GenerationBatch.generate();

        for (int i = 0; i < FileName.size(); i++) {
            xmlName = String.valueOf(FileName.get(i));
            fullPathToFile = path + xmlName;

            newFileName = GenerationBatch.generate();

            //добавляем значения атрибутов в хмл
            XMLModifyAttributeBatch.SetAttributeInXML(fullPathToFile, newFileName, newBatch);

            //переименовываем хмл
            RenameFile.rename(fullPathToFile, path + newFileName, "xml");

            //берем название хмл, убираем .xml и считаем это старым названием пдф
            pdfName = xmlName.split("\\.");

            //переименовываем пдф
            RenameFile.rename(path + pdfName[0] + ".pdf", path + newFileName, "pdf");
        }
    }
}
