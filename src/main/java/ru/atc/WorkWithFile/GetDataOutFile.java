package ru.atc.WorkWithFile;

import ru.atc.GetProperties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GetDataOutFile {
//получение ожидаемого результата из файла с кейсами
    public static String GetExpectedWF(Integer i) throws IOException {

        String pathToFileDir;
        ArrayList a1 = new ArrayList();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(GetProperties.GetPathCasePackage()))) {

            while ((pathToFileDir = br.readLine()) != null) {

                String[] pathToPackage = pathToFileDir.split(";");
                a1.add(pathToPackage[1]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(a1.get(i));
    }
//получение фактического результата из файла с фактическим результатом
    public static String getResultWF(Integer i) throws IOException {

        String pathToFileDir1;
        ArrayList b1 = new ArrayList();

        try (BufferedReader br1 = new BufferedReader(new java.io.FileReader(GetProperties.GetPathResult()))) {

            while ((pathToFileDir1 = br1.readLine()) != null) {
                String[] pathToPackage = pathToFileDir1.split(";");
                b1.add(pathToPackage[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (b1.get(i) == null){
            return "ARCHIVED";
        }

        return String.valueOf(b1.get(i));
    }
//получаем количество кейсов
    public static Integer GetCountCase(){
        String pathToFileDir;
        Integer countCase = 0;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(GetProperties.GetPathCasePackage()))) {

            while ((pathToFileDir = br.readLine()) != null) {
                countCase = countCase + 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countCase;
    }

    //получение ожидаемого результата из файла с кейсами
    public static String GetExpectedStateNo(Integer i) throws IOException {

        String pathToFileDir;
        ArrayList a1 = new ArrayList();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(GetProperties.GetPathCasePackage()))) {

            while ((pathToFileDir = br.readLine()) != null) {

                String[] pathToPackage = pathToFileDir.split(";");
                a1.add(pathToPackage[2]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(a1.get(i));
    }

    //получение фактического статуса из файла с фактическим результатом
    public static String getResultStateNo(Integer i) throws IOException {

        String pathToFileDir1;
        ArrayList b1 = new ArrayList();

        try (BufferedReader br1 = new BufferedReader(new java.io.FileReader(GetProperties.GetPathResult()))) {

            while ((pathToFileDir1 = br1.readLine()) != null) {
                String[] pathToPackage = pathToFileDir1.split(";");
                b1.add(pathToPackage[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(b1.get(i));
    }
}
