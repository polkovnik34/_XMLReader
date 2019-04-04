package ru.atc.Test.Test_2.Folder_Test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.atc.ReadInDB;
import ru.atc.Screen;
import ru.atc.Test.CasesForUsers.ExpertApprovalCase;
import ru.atc.Test.CasesForUsers.GettingCase;
import ru.atc.Test.CasesForUsers.InitiatorSigningCase;
import ru.atc.Test.ParsInBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;

public class Test_InitiatorSigning {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;

    @Test(enabled = true)
    public static void Test_1() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторПодписание/ИнициаторПодписание_1_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            InitiatorSigningCase.SigningWork(r_object_id_doc, GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSigning(), r_object_id_doc);
            Assert.assertEquals(GetSi1PerformerWorkExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИнициаторПодписание/ИнициаторПодписание_2_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            InitiatorSigningCase.SendToCorrection(r_object_id_doc, GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSigning(), r_object_id_doc);
            Assert.assertEquals(GetInitiatorGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateCorrectionDoc(),result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИнициаторПодписание/ИнициаторПодписание_3_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            InitiatorSigningCase.SendNoSigningWork(r_object_id_doc, GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSigning(), r_object_id_doc);
            Assert.assertEquals(GetInitiatorGroupExternal(), result_temp.get(1));
            Assert.assertEquals(GetStateSigningDoc(), result_temp.get(0));
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
