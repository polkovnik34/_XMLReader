package ru.atc.WorkWithFile;

import org.xml.sax.SAXException;
import ru.atc.RandomNumber;
import ru.atc.XMLTransform;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FindFileInFolder {

    //получаем все файлы во всех подпапках в директории "resources/Test_2"
    //https://ru.stackoverflow.com/questions/465935/Как-обойти-все-файлы-в-папке-и-подпапках-и-прочитать-текстовые-файлы-в-массив
    public static void processFilesFromFolder(File folder) throws IOException, TransformerException, SAXException, ParserConfigurationException {
        Integer rundomNumber;

        ArrayList fileName = new ArrayList();
        File[] folderEntries = folder.listFiles();

        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry);
                continue;
            }

            fileName.add(entry.getParent());
        }

        ArrayList arrayPath = PathFile.arrayPath(String.valueOf(folder));
        //меняем номера в хмл в найденной папке
        for (int i = 0; i < arrayPath.size(); i++) {
            rundomNumber = RandomNumber.RandomNun();
            XMLTransform.setDocNumber(rundomNumber, folder + "/" + arrayPath.get(i));
        }
        //отправляем на фтп хмл+пдф из папки
        Filetranfer.sendFile(folder + "/");
    }
}
