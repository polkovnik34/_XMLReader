package ru.atc.Test.Test_2.Folder_Test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.atc.ReadInDB;
import ru.atc.Screen;
import ru.atc.Test.CasesForUsers.ExpertRequestInformationCase;
import ru.atc.Test.CasesForUsers.GettingCase;
import ru.atc.Test.CasesForUsers.PerformerZkCase;
import ru.atc.Test.ParsInBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;

public class Test_ExpertRequestInformation {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;

    @Test(enabled = true)
    public static void Test_1() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертЗк/ЭкспертЗк_1_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToExpert(r_object_id_doc, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals(GetUserExpertRequestInformation(), result_temp.get(1));
            Assert.assertEquals(GetStateRequestInformationDoc(), result_temp.get(0));

            ExpertRequestInformationCase.ReturnWork(r_object_id_doc);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals(GetPerformerGroupExternal(), result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        } catch (NoSuchElementException e) {
            ReadInDB.CloseDB();
            Screen.GetScreen(pathToPackage);
            e.printStackTrace();
            Assert.assertTrue(false);
        } catch (NoSuchFrameException e) {
            ReadInDB.CloseDB();
            Screen.GetScreen(pathToPackage);
            e.printStackTrace();
            Assert.assertTrue(false);
        } catch (AssertionError e) {
            ReadInDB.CloseDB();
            e.printStackTrace();
            Assert.assertTrue(false);
        }
        ReadInDB.CloseDB();
    }

    @Test(enabled = true)
    public static void Test_2() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертЗк/ЭкспертЗк_1_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToExpert(r_object_id_doc, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals(GetUserExpertRequestInformation(), result_temp.get(1));
            Assert.assertEquals(GetStateRequestInformationDoc(), result_temp.get(0));

            ExpertRequestInformationCase.ReturnWork(r_object_id_doc);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals(GetPerformerGroupExternal(), result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        } catch (NoSuchElementException e) {
            ReadInDB.CloseDB();
            Screen.GetScreen(pathToPackage);
            e.printStackTrace();
            Assert.assertTrue(false);
        } catch (NoSuchFrameException e) {
            ReadInDB.CloseDB();
            Screen.GetScreen(pathToPackage);
            e.printStackTrace();
            Assert.assertTrue(false);
        } catch (AssertionError e) {
            ReadInDB.CloseDB();
            e.printStackTrace();
            Assert.assertTrue(false);
        }
        ReadInDB.CloseDB();
    }

    @Test(enabled = true)
    public static void Test_3() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертЗк/ЭкспертЗк_1_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToExpert(r_object_id_doc, GetPerformerGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals(GetUserExpertRequestInformation(), result_temp.get(1));
            Assert.assertEquals(GetStateRequestInformationDoc(), result_temp.get(0));

            ExpertRequestInformationCase.ReturnWork(r_object_id_doc);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals(GetPerformerGroupDealer(), result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));

        } catch (NoSuchElementException e) {
            ReadInDB.CloseDB();
            Screen.GetScreen(pathToPackage);
            e.printStackTrace();
            Assert.assertTrue(false);
        } catch (NoSuchFrameException e) {
            ReadInDB.CloseDB();
            Screen.GetScreen(pathToPackage);
            e.printStackTrace();
            Assert.assertTrue(false);
        } catch (AssertionError e) {
            ReadInDB.CloseDB();
            e.printStackTrace();
            Assert.assertTrue(false);
        }
        ReadInDB.CloseDB();
    }
}
