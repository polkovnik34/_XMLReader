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

public class Test_InitiatorZk {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;


    @Test(enabled=true)
    public static void Test_1() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_1_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.SendTaskToPurchase(r_object_id_doc, GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(),result_temp.get(0));
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

    @Test(enabled=true)
    public static void Test_2() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_2_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074079", GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetUserExpert(),result_temp.get(1));
            Assert.assertEquals(GetStateExpertDoc(),result_temp.get(0));
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

    @Test(enabled=true)
    public static void Test_3() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_3_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074089", GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(),result_temp.get(0));
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

    @Test(enabled=true)
    public static void Test_4() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_4_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.Confirm2PoWork(r_object_id_doc, "18074085","18074086",  GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetUserExpert(),result_temp.get(1));
            Assert.assertEquals(GetStateExpertDoc(),result_temp.get(0));
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

    @Test(enabled=true)
    public static void Test_5() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_5_Внешние/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.Confirm2PoWork(r_object_id_doc, "18074085","18074089",  GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(),result_temp.get(0));
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

    @Test(enabled=true)
    public static void Test_6() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_1_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.SendTaskToPurchase(r_object_id_doc, GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(),result_temp.get(0));
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

    @Test(enabled=true)
    public static void Test_7() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_2_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074087", GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

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

    @Test(enabled=true)
    public static void Test_8() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_3_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074089", GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(),result_temp.get(0));
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

    @Test(enabled=true)
    public static void Test_9() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_4_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.Confirm2PoWork_SpecifyAmount(r_object_id_doc, "18074085","18074086",  GetInitiatorGroupExternal(), "0.50");

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals("bs_hq_pw_bu_zatrat",result_temp.get(1));
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

    @Test(enabled=true)
    public static void Test_10() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_5_ЭДО/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.Confirm2PoWork_SpecifyAmount(r_object_id_doc, "18074085","18074089",  GetInitiatorGroupExternal(), "0.50");

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(),result_temp.get(0));
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

    @Test()
    public static void Test_11() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_1_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.SendTaskToPurchase(r_object_id_doc, GetInitiatorGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupDealer(),result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(),result_temp.get(0));
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

    @Test()
    public static void Test_12() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_2_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.ConfirmPoDealerWork(r_object_id_doc, "18074085", GetInitiatorGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals("bs_hq_pw_bu_agvoz",result_temp.get(1));
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

    @Test()
    public static void Test_13() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИнициаторЗк/ИнициаторЗк_3_Дилеры/";
        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            InitiatorZkCase.ConfirmPoDealerWork(r_object_id_doc, "18074089", GetInitiatorGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupDealer(),result_temp.get(1));
            Assert.assertEquals(GetStateRequestVerifyingCreating(),result_temp.get(0));
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
