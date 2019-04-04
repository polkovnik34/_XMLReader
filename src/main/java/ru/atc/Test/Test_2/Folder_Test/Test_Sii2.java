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

public class Test_Sii2 {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;

    @Test(enabled = true)
    public static void Test_1() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_1_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToArchive(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

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
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_2_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToPreviousPerformer(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSii_2(), r_object_id_doc);
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
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_3_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToManager(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSii_2(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_podotchet_m",result_temp.get(1));
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
    public static void Test_4() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_4_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToPostpone(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            Sii2_Case.ReturnOnPostpone(r_object_id_doc);

            Sii2_Case.Postpone_SendPreviousPerformer(r_object_id_doc, GetUserSii_2());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSii_2(), r_object_id_doc);
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
    public static void Test_5() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_5_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToPostpone(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            Sii2_Case.ReturnOnPostpone(r_object_id_doc);

            Sii2_Case.Postpone_SendToArchive(r_object_id_doc, GetUserSii_2());

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
    public static void Test_6() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_6_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToPostpone(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            Sii2_Case.ReturnOnPostpone(r_object_id_doc);

            Sii2_Case.Postpone_SendToManager(r_object_id_doc, GetUserSii_2());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSii_2(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_podotchet_m",result_temp.get(1));
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
    public static void Test_7() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_1_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToArchive(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

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
    public static void Test_8() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_2_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToPreviousPerformer(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSii_2(), r_object_id_doc);
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
    public static void Test_9() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_3_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToManager(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSii_2(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_podotchet_m",result_temp.get(1));
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
    public static void Test_10() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_4_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToPostpone(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            Sii2_Case.ReturnOnPostpone(r_object_id_doc);

            Sii2_Case.Postpone_SendPreviousPerformer(r_object_id_doc, GetUserSii_2());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSii_2(), r_object_id_doc);
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
    public static void Test_11() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_5_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToPostpone(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            Sii2_Case.ReturnOnPostpone(r_object_id_doc);

            Sii2_Case.Postpone_SendToArchive(r_object_id_doc, GetUserSii_2());

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
    public static void Test_12() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительСИИ2/ИсполнительСИИ2_6_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            Si1_Case.SendToSii2(r_object_id_doc,"bs_hq_pw_zk_pzp", GetUserExpert());

            Sii2_Case.SendToPostpone(r_object_id_doc, "bs_hq_pw_bu_podotchet", GetUserSi_1());

            Sii2_Case.ReturnOnPostpone(r_object_id_doc);

            Sii2_Case.Postpone_SendToManager(r_object_id_doc, GetUserSii_2());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserSii_2(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_podotchet_m",result_temp.get(1));
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




}
