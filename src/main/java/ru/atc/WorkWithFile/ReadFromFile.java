package ru.atc.WorkWithFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFile {
    //чтение их файла, по пути переданного в pathToFile и возврат результата в массиве
    public static ArrayList ReadFile(String pathToFile, String prefixCase) throws IOException {
        ArrayList pathCase = new ArrayList<>();

        //в переменной prefixCase передается значение префикса, по которому понятно какие строки нужно прочесть
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith(prefixCase)){
                    pathCase.add(line.split(";"));
                    continue;
                }
            }
            return pathCase;
        }

    }
}
