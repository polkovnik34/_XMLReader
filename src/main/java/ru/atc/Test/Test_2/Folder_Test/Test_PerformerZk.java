package ru.atc.Test.Test_2.Folder_Test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.atc.ReadInDB;
import ru.atc.Screen;
import ru.atc.Test.CasesForUsers.GettingCase;
import ru.atc.Test.CasesForUsers.InitiatorZkCase;
import ru.atc.Test.CasesForUsers.PerformerZkCase;
import ru.atc.Test.ParsInBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;

public class Test_PerformerZk {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;

    @Test(enabled = true)
    public static void Test_1() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_1_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToExpert(r_object_id_doc, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetUserExpertRequestInformation(), result_temp.get(1));
            Assert.assertEquals(GetStateRequestInformationDoc(), result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_2_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToCorrection(r_object_id_doc, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetInitiatorGroupExternal(), result_temp.get(1));
            Assert.assertEquals(GetStateCorrectionDoc(), result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_3_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToManager(r_object_id_doc, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetManagerGroupExternal(), result_temp.get(1));
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
    public static void Test_4() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_4_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.PerformerConfirmPoWork(r_object_id_doc, "18074089", GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

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

    @Test(enabled = true)
    public static void Test_5() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_5_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToFindNewPoNum(r_object_id_doc, GetPerformerGroupExternal(), "18074088");

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

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

    @Test(enabled = true)
    public static void Test_6() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_6_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.SendTaskToPurchase(r_object_id_doc, GetInitiatorGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);
            PerformerZkCase.PerformerConfirm2PoWork(r_object_id_doc, "18074085", "18074088");

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

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

    @Test(enabled = true)
    public static void Test_7() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_1_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToExpert(r_object_id_doc, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals("SAIsaev", result_temp.get(1));
            Assert.assertEquals(GetStateRequestInformationDoc(), result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_2_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToCorrection(r_object_id_doc, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetInitiatorGroupExternal(), result_temp.get(1));
            Assert.assertEquals(GetStateCorrectionDoc(), result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_3_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToManager(r_object_id_doc, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetManagerGroupExternal(), result_temp.get(1));
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
    public static void Test_10() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_4_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.PerformerConfirmPoWork(r_object_id_doc, "18074089", GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

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
    public static void Test_11() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_5_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToFindNewPoNum(r_object_id_doc, GetPerformerGroupExternal(), "18074088");

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
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
    public static void Test_12() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_6_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.SendTaskToPurchase(r_object_id_doc, GetInitiatorGroupExternal());

            PerformerZkCase.Confirm2PoWork_SpecifyAmount(r_object_id_doc, "18074085", "18074088", GetPerformerGroupExternal(), "0.50");

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

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
    public static void Test_13() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_1_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToExpert(r_object_id_doc, GetPerformerGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetUserExpertRequestInformation(), result_temp.get(1));
            Assert.assertEquals(GetStateRequestInformationDoc(), result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_2_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToCorrection(r_object_id_doc, GetPerformerGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetInitiatorGroupDealer(), result_temp.get(1));
            Assert.assertEquals(GetStateCorrectionDoc(), result_temp.get(0));
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
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_3_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToManager(r_object_id_doc, GetPerformerGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetManagerGroupDealer(), result_temp.get(1));
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
    public static void Test_16() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_4_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.PerformerConfirmPoWorkDealer(r_object_id_doc, "18074089", GetPerformerGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

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

    @Test(enabled = true)
    public static void Test_17() throws SQLException, IOException, InterruptedException {
        pathToPackage = "resources/Test_2/ИсполнительЗк/ИсполнительЗк_5_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);
            PerformerZkCase.SendToFindNewPoNum(r_object_id_doc, GetPerformerGroupDealer(), "18074088");

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);

            Assert.assertEquals(GetPerformerGroupDealer(),result_temp.get(1));
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
}