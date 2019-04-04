package ru.atc.Test.CasesForUsers;

import org.testng.Assert;
import org.xml.sax.SAXException;
import ru.atc.ReadInDB;
import ru.atc.WorkWithFile.PathFile;
import ru.atc.XMLTransform;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

public class GettingCase{
    //Получение r_object_id документа
    public static String ObjectIdDoc(String pathToPackage)  {
        ReadInDB.ConnectionBD();
        String firstXML = PathFile.getPathToFirstXML(pathToPackage);
        try {
            String docNumber = XMLTransform.getDocNumber(firstXML);
            String initiator = XMLTransform.getIinitiatorInumber(firstXML);
            String r_object_id_doc = ReadInDB.GetSql_DocRobjectID(docNumber, initiator);

            if (r_object_id_doc == null){
                System.out.println("ID документа не найден =(");
                ReadInDB.CloseDB();
                Assert.assertTrue(false);
            }
            ReadInDB.CloseDB();
            return r_object_id_doc;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
