package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.CorrectionInitiatorWork;
import ru.atc.WorkingWithBrowser.OpenBrowser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static ru.atc.GetProperties.*;

public class InitiatorCorrectionCase {
    /**
     *работа Инициатора ОО на корректировке по отправке на корректировку поставщиком
     * @param r_object_id_doc передаваемый id документа
     * @param previousUser предыдущий пользователь, который отправил на корректировку документ
     * @param InitiatorGroup ГО, в которую придет задача на корректировку из СИ
     * @param waitStateNo ожидаемый статус документа на корректировке, т.к. в ОД 2 корректировки - из ОЦО и ОД и у них разные коды статусов
     */
    public static void SendToSupplierCorrection(String r_object_id_doc, String previousUser, String InitiatorGroup, String waitStateNo) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(InitiatorGroup,result_temp.get(1));
        Assert.assertEquals(waitStateNo,result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserCorrection());
        CorrectionInitiatorWork.TakeTheTask(driver);
        CorrectionInitiatorWork.ForwardWorkflowTask(driver);
        CorrectionInitiatorWork.CheckSupplierCorrection(driver);
        CorrectionInitiatorWork.EnterText(driver);
        CorrectionInitiatorWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по отправке на Корректировку поставщиком завершена");
    }

    /*
принятие задачи  на корректировку, отправка на корректировку поставщиком и возврат задачи обратно предыдущему исполнителю
*/
    public static void SendToSupplierCorrectionAndReturn(String r_object_id_doc, String previousUser) throws IOException, SQLException, InterruptedException {
        SendToSupplierCorrection(r_object_id_doc, previousUser, GetInitiatorGroupExternal(), GetStateCorrectionDoc());
        WaitState_no.WaitState_no(r_object_id_doc, GetStateSupplierCorrectionDoc(), GetUserCorrection());
        taskReturnFromSupplierCorrection(r_object_id_doc);
        ReturnToPreviousPerformer(r_object_id_doc, GetUserCorrection(), GetStateCorrectionDoc());
    }

    /*
принятие задачи  на корректировку, отправка на корректировку поставщиком и возврат задачи обратно предыдущему исполнителю
*/
    public static void SendToSupplierCorrectionAndReturnSi(String r_object_id_doc, String previousUser, String InitiatorGroup) throws IOException, SQLException, InterruptedException {
        SendToSupplierCorrection(r_object_id_doc, previousUser, InitiatorGroup, GetStateSi_CorrectionDoc());
        WaitState_no.WaitState_no(r_object_id_doc, GetStateSupplierCorrectionDoc(), GetUserCorrection());
        taskReturnFromSupplierCorrection(r_object_id_doc);
        ReturnToPreviousPerformer(r_object_id_doc, GetUserCorrection(), GetStateSi_CorrectionDoc());
    }

    //возврат задачи с корректировки поставщика обратно на корректировку инициатору ОО
    public static void taskReturnFromSupplierCorrection(String r_object_id_doc) throws IOException, InterruptedException {
        WebDriver driver;

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserCorrection());
        CorrectionInitiatorWork.PressButtonCancel(driver);
        CorrectionInitiatorWork.OpenTheNodeSupplierCorrection(driver);
        CorrectionInitiatorWork.OpenTaskInSupplierCorrection(driver);
        CorrectionInitiatorWork.PressButtonReturnToProcessingInNodeSupplierCorrection(driver);
        sleep(1500);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по возврату задачи с корректировки поставщика завершена");
    }

    //возврат задачи "На корректировке" предыдущему исполнителю
    public static void ReturnToPreviousPerformer(String r_object_id_doc, String previousUser, String waitStateNo) throws SQLException, InterruptedException, IOException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitState_no(r_object_id_doc, waitStateNo, previousUser);
        Assert.assertEquals(GetUserCorrection(),result_temp.get(1));
        Assert.assertEquals(waitStateNo,result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserCorrection());
        CorrectionInitiatorWork.OpenTaskCard(driver);
        CorrectionInitiatorWork.ForwardWorkflowTask(driver);
        CorrectionInitiatorWork.CheckReturnToPreviousPerformer(driver);
        CorrectionInitiatorWork.EnterText(driver);
        CorrectionInitiatorWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по возврату предудщему исполнителю завершена");
    }
}
