package ru.atc.WorkWithFile;

import java.io.File;
import java.util.ArrayList;

public class PathFile {

//получаем массив имен файлов хмл находящхся в папке
    public static ArrayList arrayPath(String PathToFolder) {
        String[] arrayNameFile;
        ArrayList temp = new ArrayList<>();

        File inputFile = new File(PathToFolder);
        arrayNameFile = inputFile.list();

        for (int i = 0; i < arrayNameFile.length; i++){

            if (arrayNameFile[i].endsWith("xml")){
                temp.add(arrayNameFile[i]);
                continue;
            }
        }
        return temp;
    }
//получаем путь до первой ХМЛ лежащей в папке и возвращаем его
    public static String getPathToFirstXML (String PathToFile) {
        String[] arrayNameFile;
        String pathToXML = null;

        File inputFile = new File(PathToFile);
        arrayNameFile = inputFile.list();

        for (int i = 0; i < arrayNameFile.length; i++) {

            if (arrayNameFile[i].endsWith("xml")) {
                pathToXML = PathToFile + arrayNameFile[i];
                break;
            }
        }
        return pathToXML;
    }
}
