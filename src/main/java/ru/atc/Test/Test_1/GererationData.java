package ru.atc.Test.Test_1;

import com.jcraft.jsch.JSchException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import ru.atc.*;
import ru.atc.WorkWithFile.Filetranfer;
import ru.atc.WorkWithFile.PathFile;
import ru.atc.WorkWithFile.WriteInFileResult;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Thread.sleep;
import static ru.atc.WorkWithFile.WriteInFileResult.CleanFileResult;

public class GererationData {

    private static final org.apache.log4j.Logger log = Logger.getLogger(GererationData.class);

    public static void StartGenerationData() throws SAXException, TransformerException, ParserConfigurationException, IOException, InterruptedException, SQLException, ClassNotFoundException, JSchException {
        WriteInFileResult.CleanFileResult();

        GenerationPackageP2P();

        Scanner in = new Scanner(System.in);
        System.out.print("Документы загружены? ");
        String num = in.nextLine();

        GenerationWF();

        //TestLogic.TestСomparisonWF();
    }

    public static void GenerationPackageP2P() throws SAXException, ParserConfigurationException, IOException, TransformerException, JSchException {

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(GetProperties.GetPathCasePackage()))) {
            String line;

            Filetranfer.ConnectionSFTP();

            while ((line = br.readLine()) != null) {

                String [] pathToPackage = line.split(";");

                XMLTransform.setNumberInXML(pathToPackage[0]);
                Filetranfer.sendFile(pathToPackage[0]);
            }
            Filetranfer.DisconnectSFTP();
        }
    }

    //ждем и получаем результаты того, куда пришел документ и с каким статусом
    public static void GenerationWF( ) throws SQLException, ParserConfigurationException, SAXException, InterruptedException {
        String idDoc_temp;
        String Wf_temp;
        String firstXML;
        String pathToFileDir;
        String initiator;
        String docNumber;
        String state_no;

        ReadInDB.ConnectionBD();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(GetProperties.GetPathCasePackage()))) {

            CleanFileResult();

            while ((pathToFileDir = br.readLine()) != null) {
                String [] pathToPackage = pathToFileDir.split(";");

                firstXML = PathFile.getPathToFirstXML(pathToPackage[0]);

                docNumber = XMLTransform.getDocNumber(firstXML);
                initiator = XMLTransform.getIinitiatorInumber(firstXML);

                idDoc_temp = ReadInDB.GetSql_DocRobjectID(docNumber, initiator);

                if (idDoc_temp == null){
                    WriteInFileResult.WriteInFileResult(pathToPackage[0] + " ===> " + docNumber + " + " + initiator + ";" + idDoc_temp + ";" + "" + ";" + "~~~~НЕ НАЙДЕНО В СИСТЕМЕ~~~~");
                    System.out.println("~~~~~Документ не найден в системе, смотри файл с результатом поиска~~~~~");
                    continue;
                }

                state_no = ReadInDB.GetSql_DocSateNo(idDoc_temp);
                Wf_temp = ReadInDB.GetSql_WF(idDoc_temp);

                while (((Wf_temp == null) & (state_no.equals("1") | state_no.equals("2")) ))  {
                    sleep(15000);
                    state_no = ReadInDB.GetSql_DocSateNo(idDoc_temp);
                    Wf_temp = ReadInDB.GetSql_WF(idDoc_temp);

                    if (((Wf_temp == null) & (state_no.equals("1") | state_no.equals("2")) )) {
                        System.out.println("Документ еще не пришел в конечную ГО, подожди еще чуть чуть");
                    }
                }

//если задача сразу уходит в архив, то присваиваем "исполнителя ГО" как "ARCHIVED"
                if(state_no.equals("6")){
                    Wf_temp = "ARCHIVED";
                }

                System.out.println("Документ из " + firstXML + " пришел в " + "" + Wf_temp + "");

                WriteInFileResult.WriteInFileResult(pathToPackage[0] + " ===> " + docNumber + " + " + initiator + ";" + idDoc_temp + ";" + Wf_temp + ";" + state_no);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadInDB.CloseDB();
    }


}
