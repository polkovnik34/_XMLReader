package ru.atc.Test.Test_2.Folder_Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.atc.ReadInDB;
import ru.atc.Screen;
import ru.atc.Test.CasesForUsers.ExpertApprovalCase;
import ru.atc.Test.CasesForUsers.ExpertReworkCase;
import ru.atc.Test.CasesForUsers.GettingCase;
import ru.atc.Test.CasesForUsers.Si1_Case;
import ru.atc.Test.ParsInBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;


public class Test_ExpertRework {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;

    @Test(enabled = true)
    public static void Test_1() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертНаДоработке/ЭкспертНаДоработке_1_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            Si1_Case.SendToCorrection(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            ExpertReworkCase.SendToCorrection(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_iw_bu_tmc",result_temp.get(1));
            Assert.assertEquals(GetStateSi_CorrectionDoc(),result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ЭкспертНаДоработке/ЭкспертНаДоработке_2_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            Si1_Case.SendToCorrection(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            ExpertReworkCase.SendToPreviousPerformer(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals(GetUserSi_1(),result_temp.get(1));
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
    public static void Test_3() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертНаДоработке/ЭкспертНаДоработке_1_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToCorrection(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            ExpertReworkCase.SendToCorrection(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_iw_bu_tmc",result_temp.get(1));
            Assert.assertEquals(GetStateSi_CorrectionDoc(),result_temp.get(0));
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
    public static void Test_4() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертНаДоработке/ЭкспертНаДоработке_2_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToCorrection(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            ExpertReworkCase.SendToPreviousPerformer(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals(GetUserSi_1(),result_temp.get(1));
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
}
