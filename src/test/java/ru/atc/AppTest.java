package ru.atc;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.PropertyConfigurator;
import org.junit.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

//https://habr.com/post/120101/

public class AppTest {
    /*@Test
    public void wr() {
        String DocPackageCase = "resources/DocPackageCase1.txt";
        String log = "Logs/log_file.log";
        String pathToFileDir;
        String pathToFileDir1;
        String[] a1 = new String[2];
        String[] b1 = new String[2];
        int i = 0;
        int i1 = 0;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(DocPackageCase))) {

            while ((pathToFileDir = br.readLine()) != null) {
                String[] pathToPackage = pathToFileDir.split(";");
                a1[i] = pathToPackage[1];
                //System.out.println(a1[i]);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br1 = new BufferedReader(new java.io.FileReader(log))) {

            while ((pathToFileDir1 = br1.readLine()) != null) {
                String[] pathToPackage = pathToFileDir1.split(";");
                b1[i1] = pathToPackage[2];
                //System.out.println(b1[i1]);
                i1++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int b = 0;b < a1.length;b++) {
            assertEquals(a1[b],b1[b]);
            System.out.println(a1[b] + " " + b1[b]);
        }
    }*/
}
