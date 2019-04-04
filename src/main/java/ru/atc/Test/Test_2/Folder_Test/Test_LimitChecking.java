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

public class Test_LimitChecking {
    private static ArrayList result_temp;
    private static String r_object_id_doc;
    private static String pathToPackage;

    @Test(enabled = true)
    public static void Test_1() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_1_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            LimitCheckingCase.ConfirmPoWork(r_object_id_doc, GetUserExpert(), GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals(GetUserCbo(), result_temp.get(1));
            Assert.assertEquals(GetStateCBODoc(), result_temp.get(0));
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
    public static void Test_2() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_2_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            ExpertApprovalCase.ApprovalWork(r_object_id_doc, null);

            LimitCheckingCase.SendToCorrection(r_object_id_doc, GetUserExpert(), GetPerformerGroupExternal());

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
    public static void Test_3() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_3_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074085", GetInitiatorGroupExternal());

            ExpertApprovalCase.ApprovalWork(r_object_id_doc, GetUserInitZk());

            LimitCheckingCase.ConfirmNewPoWork(r_object_id_doc, GetUserExpert(), "18074086", "18074085", GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateWaitApprovalPoDoc(), GetUserPerfZk());
            Assert.assertEquals( GetUserPerfZk(), result_temp.get(1));
            Assert.assertEquals(GetStateWaitApprovalPoDoc(), result_temp.get(0));
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
    public static void Test_4() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_4_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074085", GetInitiatorGroupExternal());

            ExpertApprovalCase.ApprovalWork(r_object_id_doc, GetUserInitZk());

            LimitCheckingCase.CheckRadioNewPoWork(r_object_id_doc, GetUserExpert(), "18074086", GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateWaitApprovalPoDoc(), GetUserPerfZk());
            Assert.assertEquals( GetUserPerfZk(), result_temp.get(1));
            Assert.assertEquals(GetStateWaitApprovalPoDoc(), result_temp.get(0));
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
    public static void Test_5() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_5_Внешние/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074085", GetInitiatorGroupExternal());

            ExpertApprovalCase.ApprovalWork(r_object_id_doc, GetUserInitZk());

            LimitCheckingCase.Confirm2PoWork(r_object_id_doc, GetUserExpert(), "18074086", "18074085","2.50", GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateWaitApprovalPoDoc(), GetUserPerfZk());
            Assert.assertEquals( GetUserPerfZk(), result_temp.get(1));
            Assert.assertEquals(GetStateWaitApprovalPoDoc(), result_temp.get(0));
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
    public static void Test_6() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_1_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            LimitCheckingCase.ConfirmPoWork(r_object_id_doc, null, GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals(GetReceiptAvailabilityGroupExternal(), result_temp.get(1));
            Assert.assertEquals(GetStateReceiptAvailabilityControlDoc(), result_temp.get(0));
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
    public static void Test_7() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_2_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            LimitCheckingCase.SendToCorrection(r_object_id_doc, null, GetPerformerGroupExternal());

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
    public static void Test_8() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_3_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074088", GetInitiatorGroupExternal());

            LimitCheckingCase.ConfirmNewPoWork(r_object_id_doc, GetUserInitZk(), "18074085", "18074088", GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateWaitApprovalPoDoc(), GetUserPerfZk());
            Assert.assertEquals( GetUserPerfZk(), result_temp.get(1));
            Assert.assertEquals(GetStateWaitApprovalPoDoc(), result_temp.get(0));
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
    public static void Test_9() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_4_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074088", GetInitiatorGroupExternal());

            LimitCheckingCase.CheckRadioNewPoWork(r_object_id_doc, GetUserInitZk(), "18074085", GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateWaitApprovalPoDoc(), GetUserPerfZk());
            Assert.assertEquals( GetUserPerfZk(), result_temp.get(1));
            Assert.assertEquals(GetStateWaitApprovalPoDoc(), result_temp.get(0));
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
    public static void Test_10() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_5_ЭДО/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074088", GetInitiatorGroupExternal());

            LimitCheckingCase.Confirm2PoWork(r_object_id_doc, GetUserInitZk(), "18074085", "18074088","2.50", GetPerformerGroupExternal());

            result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateWaitApprovalPoDoc(), GetUserPerfZk());
            Assert.assertEquals( GetUserPerfZk(), result_temp.get(1));
            Assert.assertEquals(GetStateWaitApprovalPoDoc(), result_temp.get(0));
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
    public static void Test_11() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_1_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            LimitCheckingCase.ConfirmPoWork(r_object_id_doc, null, GetPerformerGroupDealer());

            result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserPerfZk(), r_object_id_doc);
            Assert.assertEquals("bs_hq_pw_bu_agvoz", result_temp.get(1));
            Assert.assertEquals(GetStateSi_1PerformerDoc(), result_temp.get(0));
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
    public static void Test_12() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_2_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            LimitCheckingCase.SendToCorrection(r_object_id_doc, null,GetPerformerGroupDealer());

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
    public static void Test_13() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_3_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoDealerWork(r_object_id_doc, "18074088", GetInitiatorGroupDealer());

            LimitCheckingCase.ConfirmNewPoDealerWork(r_object_id_doc, GetUserInitZk(), "18074085", GetPerformerGroupDealer());

            result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateWaitApprovalPoDoc(), GetUserPerfZk());
            Assert.assertEquals(GetUserPerfZk(), result_temp.get(1));
            Assert.assertEquals(GetStateWaitApprovalPoDoc(), result_temp.get(0));
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
    public static void Test_14() throws IOException, InterruptedException, SQLException {
        pathToPackage = "resources/Test_2/ИсполнительЛимит/ИсполнительЛимит_4_Дилеры/";

        r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);
        try {
            ReadInDB.ConnectionBD();
            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoDealerWork(r_object_id_doc, "18074088", GetInitiatorGroupDealer());

            LimitCheckingCase.CheckRadioNewPoWork(r_object_id_doc, GetUserInitZk(), "18074085", GetPerformerGroupDealer());

            result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateWaitApprovalPoDoc(), GetUserPerfZk());
            Assert.assertEquals( GetUserPerfZk(), result_temp.get(1));
            Assert.assertEquals(GetStateWaitApprovalPoDoc(), result_temp.get(0));
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
