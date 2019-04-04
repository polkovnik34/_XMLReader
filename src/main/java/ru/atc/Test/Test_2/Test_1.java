package ru.atc.Test.Test_2;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.atc.ReadInDB;
import ru.atc.Screen;
import ru.atc.Test.CasesForUsers.*;
import ru.atc.Test.ParsInBD;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import static ru.atc.GetProperties.*;

public class Test_1 {

    public static void Test_1() throws InterruptedException, SQLException, IOException {
        String pathToPackage = "resources/Test_2/Внешние_1/";
        String processingGroupSi_1 = "bs_hq_pw_bu_zatrat";

        String r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);

        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074079", GetInitiatorGroupExternal());

            //ExpertCase.ApprovalWork(r_object_id_doc, GetUserInitZk());

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            InitiatorSigningCase.SigningWork(r_object_id_doc, GetUserExpert());

            //Si1_Case.SendToArchive(r_object_id_doc, processingGroupSi_1, GetUserSigning(), false);

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


    public static void test_2() throws SQLException, InterruptedException, IOException {
        String pathToPackage = "resources/Test_2/Внешние_2/";
        String processingGroupSi_1 = "bs_hq_pw_bu_tmc";

        String r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);

        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.ConfirmPoWork(r_object_id_doc, "18074087", GetInitiatorGroupExternal());

            //ExpertCase.ApprovalWork(r_object_id_doc, GetUserInitZk());

            ReceiptAvailabilityCase.SendNextWork(r_object_id_doc, GetUserExpert());

            //Si1_Case.SendToArchive(r_object_id_doc, processingGroupSi_1, GetUserLogist(), false);

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


    public static void test_3() throws SQLException, IOException, InterruptedException {
        String pathToPackage = "resources/Test_2/Внешние_3/";
        String processingGroupSi_1 = "bs_hq_pw_bu_zatrat";

        String r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);

        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            //ExpertCase.ApprovalWork(r_object_id_doc, null);

            CBOCase.AcceptTheTask(r_object_id_doc, "2", GetUserExpert());

            InitiatorCorrectionCase.SendToSupplierCorrectionAndReturn(r_object_id_doc, GetUserExpert());

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserCorrection());

            //Si1_Case.SendToArchive(r_object_id_doc, processingGroupSi_1, GetUserSigning(), false);

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


    public static void test_4() throws SQLException, IOException, InterruptedException {
        String pathToPackage = "resources/Test_2/Внешние_4/";
        String processingGroupSi_1 = "bs_hq_pw_bu_zatrat";

        String r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);

        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.SendTaskToPurchase(r_object_id_doc, GetInitiatorGroupExternal());

            //PerformerZkCase.PerformerConfirmPoWork(r_object_id_doc,"18074079");

            //ExpertCase.ApprovalWork(r_object_id_doc, GetUserPerfZk());

            CBOCase.AddOptionalExpert(r_object_id_doc, GetUserExpert());

            CBOCase.OptionalExpertWork(r_object_id_doc, "2", GetUserCbo());

            CBOCase.AcceptTheTask(r_object_id_doc, "1", GetUserExpert());

            //Si1_Case.SendToArchive(r_object_id_doc, processingGroupSi_1, GetUserExpert(), false);

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


    public static void test_5() throws SQLException, IOException, InterruptedException {
        String pathToPackage = "resources/Test_2/Внешние_5/";
        String processingGroupSi_1 = "bs_hq_pw_bu_tmc";

        String r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);

        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            InitiatorZkCase.SendTaskToPurchase(r_object_id_doc, GetInitiatorGroupExternal());

            //PerformerZkCase.SendToCorrection(r_object_id_doc);

            InitiatorCorrectionCase.SendToSupplierCorrectionAndReturn(r_object_id_doc, GetUserPerfZk());

            //PerformerZkCase.PerformerConfirmPoWork(r_object_id_doc,"18074088");

            //ExpertCase.SendToCorrection(r_object_id_doc, GetUserPerfZk());

            InitiatorCorrectionCase.SendToSupplierCorrectionAndReturn(r_object_id_doc, GetUserExpert());

            //ExpertCase.ApprovalWork(r_object_id_doc, GetUserCorrection());

            //PurchasePerformerCase.SendToCorrection(r_object_id_doc, GetUserExpert(), false);

            InitiatorCorrectionCase.SendToSupplierCorrectionAndReturn(r_object_id_doc, GetUserLimitChecking());

            //PurchasePerformerCase.ConfirmPoWork(r_object_id_doc, GetUserCorrection(), true);

            //ReceiptAvailabilityCase.SendToCorrection(r_object_id_doc, GetUserLimitChecking(), false);

            InitiatorCorrectionCase.SendToSupplierCorrectionAndReturn(r_object_id_doc, GetUserPerfZk());

            ReceiptAvailabilityCase.SendNextWork(r_object_id_doc, GetUserCorrection());

            //PurchasePerformerCase.SendToCorrection(r_object_id_doc, GetUserLogist(), false);

            InitiatorCorrectionCase.SendToSupplierCorrectionAndReturn(r_object_id_doc, GetUserLimitChecking());

            //PurchasePerformerCase.ConfirmPoWork(r_object_id_doc, GetUserCorrection(), true);

            //Si1_Case.SendToArchive(r_object_id_doc, processingGroupSi_1, GetUserLimitChecking(), false);

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


    public static void test_6() throws SQLException, IOException, InterruptedException, AWTException {
        String pathToPackage = "resources/Test_2/Внешние_6/";
        String processingGroupSi_1 = "bs_hq_pw_bu_tmc";

        String r_object_id_doc = GettingCase.ObjectIdDoc(pathToPackage);

        try {
            ReadInDB.ConnectionBD();

            ParsInBD.WaitFirstWF(r_object_id_doc);

            //ExpertCase.ApprovalWork(r_object_id_doc, null);

            //InitiatorSigningCase.SendToCorrection(r_object_id_doc, GetUserExpert(), false);

            InitiatorCorrectionCase.SendToSupplierCorrectionAndReturn(r_object_id_doc, GetUserSigning());

            InitiatorSigningCase.SigningWork(r_object_id_doc, GetUserCorrection());

            Si1_Case.SendToCorrection(r_object_id_doc,processingGroupSi_1, GetUserSigning());

            //ExpertCase.ReworkSendToCorrection(r_object_id_doc, GetUserSi_1());

            InitiatorCorrectionCase.SendToSupplierCorrectionAndReturnSi(r_object_id_doc, GetUserExpert(), "bs_hq_iw_bu_tmc");

           // ExpertCase.ReworkSendToPreviousUser(r_object_id_doc, GetUserCorrection());

            //Si1_Case.SendToArchive(r_object_id_doc, processingGroupSi_1, GetUserExpert(), true);

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
