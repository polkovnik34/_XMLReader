package ru.atc.Test.Test_2.Folder_Test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.atc.ReadInDB;
import ru.atc.Screen;
import ru.atc.Test.CasesForUsers.ExpertApprovalCase;
import ru.atc.Test.CasesForUsers.GettingCase;
import ru.atc.Test.CasesForUsers.InitiatorZkCase;
import ru.atc.Test.ParsInBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;
import static ru.atc.GetProperties.GetInitiatorGroupExternal;

public class Test_ExpertApproval {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;

    @Test(enabled = true)
    public static void Test_1() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_1_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals(GetReceiptAvailabilityGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateReceiptAvailabilityControlDoc(),result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_2_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.SendToCorrection(r_object_id_doc, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
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

    //тест нерабочий до исправления http://ecm.at-consulting.ru/youtrack/issue/VK_SSC-1350
    @Test(enabled = true)
    public static void Test_3() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_3_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074085", GetInitiatorGroupExternal());

            ExpertApprovalCase.CheckNewPoNumber(r_object_id_doc, GetUserInitZk(), "18074085", "18074086");

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals(GetReceiptAvailabilityGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateReceiptAvailabilityControlDoc(),result_temp.get(0));
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
    public static void Test_5() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_1_Счет/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_sp",result_temp.get(1));
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
    public static void Test_6() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_2_Счет/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals(GetUserCbo(),result_temp.get(1));
            Assert.assertEquals(GetStateCBODoc(),result_temp.get(0));
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
    public static void Test_7() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_3_Счет/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals(GetLimitCheckingGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateLimitChecking(),result_temp.get(0));
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
    public static void Test_8() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_4_Счет/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals(GetReceiptAvailabilityGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateReceiptAvailabilityControlDoc(),result_temp.get(0));
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
    public static void Test_9() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_5_Счет/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_iw_bu_sp",result_temp.get(1));
            Assert.assertEquals(GetStateSigningDoc(),result_temp.get(0));
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
    public static void Test_10() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ЭкспертОдобрение/ЭкспертОдобрение_6_Счет/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals(GetReceiptAvailabilityGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateReceiptAvailabilityControlDoc(),result_temp.get(0));
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
