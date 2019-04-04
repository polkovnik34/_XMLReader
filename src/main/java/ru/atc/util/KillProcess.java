package ru.atc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillProcess {
    public static void main(String args[]){
        String line = null;

        String TASKLIST = "tasklist /FI \"IMAGENAME eq ChromeDriver.exe\"";

        String KILL = "TASKKILL  /IM ChromeDriver.exe *32";
        try {
            Process p = Runtime.getRuntime().exec(TASKLIST);

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            //p = Runtime.getRuntime().exec(KILL);
            System.out.println("Удалил");
            break;
        }
        System.out.println("Нету такого процесса");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
