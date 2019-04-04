package ru.atc.WorkWithFile;

import ru.atc.GetProperties;

import java.io.FileWriter;
import java.io.IOException;

public class WriteInFileResult {

/*    public static void main(String args[]){
        CleanFileResult();
        String pathToPackage = "путь ";
        String docNumber = "12313";
        String initiator = " инициатор ";
        String idDoc_temp = "idDoc_temp";
        String Wf_temp = "Wf_temp";
        String a1 = pathToPackage + " ===> " + docNumber + " + " + initiator + ";" + idDoc_temp + ";" + Wf_temp;
        for(int i = 0; i < 10;i++){
            WriteInFileResult(a1);
        }
    }*/

    public static void WriteInFileResult(String mess){

        try(FileWriter writer = new FileWriter(GetProperties.GetPathResult(), true)) {
            // запись всей строки
            //String text = "Hello Gold!";
            writer.write(mess);
            // запись по символам
            writer.append('\n');

            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            }
        }
    public static void CleanFileResult(){
        try(FileWriter writer = new FileWriter(GetProperties.GetPathResult(), false)) {
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
