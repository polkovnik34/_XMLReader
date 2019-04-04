package ru.atc.Test.Test_2.Folder_Test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.atc.ReadInDB;
import ru.atc.Screen;
import ru.atc.Test.CasesForUsers.*;
import ru.atc.Test.ParsInBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;
import static ru.atc.GetProperties.GetUserSi_1;

public class Test_Si1 {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;

    @Test(enabled = true)
    public static void Test_1() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_1_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            Si1_Case.SendToArchive(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            ArrayList result_temp = ParsInBD.WaitArchivedStateNo(r_object_id_doc);
            Assert.assertEquals(null,result_temp.get(1));
            Assert.assertEquals(GetStateArchivedDoc(),result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_2_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            Si1_Case.SendToCorrection(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals(GetUserExpert(),result_temp.get(1));
            Assert.assertEquals(GetStateExpertRework(),result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_3_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            Si1_Case.SendToManager(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_tmc_m",result_temp.get(1));
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
    public static void Test_4() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_tmc";
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_4_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToArchive(r_object_id_doc, GetUserSi_1());

            ArrayList result_temp = ParsInBD.WaitArchivedStateNo(r_object_id_doc);
            Assert.assertEquals(null,result_temp.get(1));
            Assert.assertEquals(GetStateArchivedDoc(),result_temp.get(0));
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
        String processingGroup = "bs_hq_pw_bu_tmc";
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_5_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToCorrection(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals(GetUserExpert(),result_temp.get(1));
            Assert.assertEquals(GetStateExpertRework(),result_temp.get(0));
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
        String processingGroup = "bs_hq_pw_bu_tmc";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_6_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToManager(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_tmc_m",result_temp.get(1));
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
    public static void Test_7() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_zk_pzp";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_7_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            Si1_Case.SendToSii2(r_object_id_doc, processingGroup, GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_podotchet",result_temp.get(1));
            Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));
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
        String processingGroup = "bs_hq_pw_zk_pzp";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_8_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToSii2(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_podotchet",result_temp.get(1));
            Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_1_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToArchive(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            ArrayList result_temp = ParsInBD.WaitArchivedStateNo(r_object_id_doc);
            Assert.assertEquals(null,result_temp.get(1));
            Assert.assertEquals(GetStateArchivedDoc(),result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_2_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToCorrection(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals(GetUserExpert(),result_temp.get(1));
            Assert.assertEquals(GetStateExpertRework(),result_temp.get(0));
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
    public static void Test_11() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_3_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToManager(r_object_id_doc,"bs_hq_pw_bu_tmc", GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_tmc_m",result_temp.get(1));
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
    public static void Test_12() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_tmc";
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_4_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToArchive(r_object_id_doc, GetUserSi_1());

            ArrayList result_temp = ParsInBD.WaitArchivedStateNo(r_object_id_doc);
            Assert.assertEquals(null,result_temp.get(1));
            Assert.assertEquals(GetStateArchivedDoc(),result_temp.get(0));
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
    public static void Test_13() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_tmc";
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_5_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToCorrection(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals(GetUserExpert(),result_temp.get(1));
            Assert.assertEquals(GetStateExpertRework(),result_temp.get(0));
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
    public static void Test_14() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_tmc";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_6_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToManager(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_tmc_m",result_temp.get(1));
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
    public static void Test_15() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_zk_pzp";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_7_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToSii2(r_object_id_doc, processingGroup, GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_podotchet",result_temp.get(1));
            Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));
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
    public static void Test_16() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_zk_pzp";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_8_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToSii2(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_podotchet",result_temp.get(1));
            Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));
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
    public static void Test_17() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_1_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToArchive(r_object_id_doc,"bs_hq_pw_bu_agvoz", GetUserExpert());

            ArrayList result_temp = ParsInBD.WaitArchivedStateNo(r_object_id_doc);
            Assert.assertEquals(null,result_temp.get(1));
            Assert.assertEquals(GetStateArchivedDoc(),result_temp.get(0));
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
    public static void Test_18() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_2_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToCorrection(r_object_id_doc,"bs_hq_pw_bu_agvoz", GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals("bs_hq_iw_bu_agvoz",result_temp.get(1));
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
    public static void Test_19() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_3_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToManager(r_object_id_doc,"bs_hq_pw_bu_agvoz", GetUserExpert());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_agvoz_m",result_temp.get(1));
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
    public static void Test_20() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_agvoz";
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_4_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToArchive(r_object_id_doc, GetUserSi_1());

            ArrayList result_temp = ParsInBD.WaitArchivedStateNo(r_object_id_doc);
            Assert.assertEquals(null,result_temp.get(1));
            Assert.assertEquals(GetStateArchivedDoc(),result_temp.get(0));
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
    public static void Test_21() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_agvoz";
        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_5_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToCorrection(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals("bs_hq_iw_bu_agvoz",result_temp.get(1));
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
    public static void Test_22() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_agvoz";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_6_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToManager(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserExpert(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_agvoz_m",result_temp.get(1));
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
    public static void Test_23() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_bs";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_1_Аренда/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToArchive(r_object_id_doc,processingGroup, GetUserExpert());

            ArrayList result_temp = ParsInBD.WaitArchivedStateNo(r_object_id_doc);
            Assert.assertEquals(null,result_temp.get(1));
            Assert.assertEquals(GetStateArchivedDoc(),result_temp.get(0));
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
    public static void Test_24() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_bs";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_2_Аренда/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToManager(r_object_id_doc, processingGroup, null);

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_bs_m",result_temp.get(1));
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
    public static void Test_25() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_bs";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_3_Аренда/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToArchive(r_object_id_doc, GetUserSi_1());

            ArrayList result_temp = ParsInBD.WaitArchivedStateNo(r_object_id_doc);
            Assert.assertEquals(null,result_temp.get(1));
            Assert.assertEquals(GetStateArchivedDoc(),result_temp.get(0));
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
    public static void Test_26() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_bs";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_4_Аренда/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToManager(r_object_id_doc, GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSi_1(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_bs_m",result_temp.get(1));
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
    public static void Test_27() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_bs";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_5_Аренда/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToCorrection(r_object_id_doc, processingGroup, null);

            WaitState_no.WaitState_no(r_object_id_doc, GetStateSi_CorrectionDoc(), GetUserSi_1());
            result_temp = ParsInBD.WaitNewFW_and_StateNo(null, r_object_id_doc);
            Assert.assertEquals(GetUserSi_1(),result_temp.get(1));
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
    public static void Test_28() throws SQLException, IOException, InterruptedException {
        String processingGroup = "bs_hq_pw_bu_bs";

        pathToPackage = "resources/Test_2/ИсполнительСИ1/ИсполнительСИ1_6_Аренда/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToPostpone(r_object_id_doc,processingGroup, GetUserExpert());

            Si1_Case.ReturnOnPostpone(r_object_id_doc,processingGroup, GetUserSi_1() );

            Si1_Case.Postpone_SendToCorrection(r_object_id_doc, GetUserSi_1());

            WaitState_no.WaitState_no(r_object_id_doc, GetStateSi_CorrectionDoc(), GetUserSi_1());
            result_temp = ParsInBD.WaitNewFW_and_StateNo(null, r_object_id_doc);
            Assert.assertEquals(GetUserSi_1(),result_temp.get(1));
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



}
