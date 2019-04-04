package ru.atc.Test.Test_1;

import com.jcraft.jsch.JSchException;
import org.xml.sax.SAXException;
import ru.atc.WorkWithFile.GetDataOutFile;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.SQLException;


public class TestLogic {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String args[]) throws IOException, InterruptedException, ParserConfigurationException, TransformerException, JSchException, SQLException, SAXException, ClassNotFoundException {
        GererationData.StartGenerationData();
        TestСomparisonWF();
    }

    /*
    1. Придумать как можно "отключать тесты"
     */
    public static void TestСomparisonWF() throws IOException {
        System.out.println("Тест с конечной ГО:");
        for (int i = 0; i < GetDataOutFile.GetCountCase();i++){

            if (GetDataOutFile.GetExpectedWF(i).equals(GetDataOutFile.getResultWF(i))){
                System.out.print(ANSI_GREEN + (i+1) + ANSI_RESET + " ");
            }
            else System.out.print(ANSI_RED + (i+1) + ANSI_RESET + " ");
        }
        System.out.println();
        System.out.println("Тест с конечным статусом:");
        for (int i = 0; i < GetDataOutFile.GetCountCase();i++){

            if (GetDataOutFile.GetExpectedStateNo(i).equals(GetDataOutFile.getResultStateNo(i))){
                System.out.print(ANSI_GREEN + (i+1) + ANSI_RESET + " ");
            }
            else System.out.print(ANSI_RED + (i+1) + ANSI_RESET + " ");
        }

    }

/*    private String expectedWF;
    private String resultWF;

    @Factory(dataProvider = "dataMethod")
    public TestLogic(String expectedWF, String resultWF) {
        this.expectedWF = expectedWF;
        this.resultWF = resultWF;
    }

    @DataProvider
    public static Object[][] dataMethod() throws IOException {
        return new Object[][] {
                {GetDataOutFile.GetExpectedWF(0), GetDataOutFile.getResultWF(0)},
                {GetDataOutFile.GetExpectedWF(1), GetDataOutFile.getResultWF(1)},
                {GetDataOutFile.GetExpectedWF(2), GetDataOutFile.getResultWF(2)},
                {GetDataOutFile.GetExpectedWF(3), GetDataOutFile.getResultWF(3)},
        };
    }

    @Test()
    public void TestWFPackageIN_SSC() {
        Assert.assertEquals(expectedWF,resultWF);
    }*/
}