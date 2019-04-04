package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.OpenBrowser;
import ru.atc.WorkingWithBrowser.Sii_2PerfоrmerWork;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;

public class Sii2_Case {
    /*
Работа СИИ2 по отправке задачи в архив
*/
    public static void SendToArchive(String r_object_id_doc,
                                     String processingGroupSii_2,
                                     String previousPerformer) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
        Assert.assertEquals(processingGroupSii_2,result_temp.get(1));
        Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSii_2());
        Sii_2PerfоrmerWork.TakeTheTask(driver);
        Sii_2PerfоrmerWork.ForwardWorkflowTask(driver);
        Sii_2PerfоrmerWork.NextStageTask(driver);
        Sii_2PerfоrmerWork.EnterText(driver);
        Sii_2PerfоrmerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя 2 по отправке в архив завершена");
    }

    /*
Работа СИИ2 по отправке задачи предыдущему исполнителю
*/
    public static void SendToPreviousPerformer(String r_object_id_doc, String processingGroupSii_2, String previousPerformer) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
        Assert.assertEquals(processingGroupSii_2,result_temp.get(1));
        Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSii_2());
        Sii_2PerfоrmerWork.TakeTheTask(driver);
        Sii_2PerfоrmerWork.ForwardWorkflowTask(driver);
        Sii_2PerfоrmerWork.NextPreviousPerformer(driver);
        Sii_2PerfоrmerWork.EnterText(driver);
        Sii_2PerfоrmerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке задачи предыдущему исполнителю завершена");
    }

    /*
Работа СИ1 по отправке задачи менеджеру
*/
    public static void SendToManager(String r_object_id_doc, String processingGroupSii_2, String previousPerformer) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
        Assert.assertEquals(processingGroupSii_2,result_temp.get(1));
        Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSii_2());
        Sii_2PerfоrmerWork.TakeTheTask(driver);
        Sii_2PerfоrmerWork.ForwardWorkflowTask(driver);
        Sii_2PerfоrmerWork.SelectSendToManager(driver);
        Sii_2PerfоrmerWork.EnterText(driver);
        Sii_2PerfоrmerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке задачи Менеджеру завершена");
    }


    /*
Работа СИ1 по отправке задачи в отложенные
*/
    public static void SendToPostpone(String r_object_id_doc, String processingGroupSii_2, String previousPerformer) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
        Assert.assertEquals(processingGroupSii_2,result_temp.get(1));
        Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSii_2());

        Sii_2PerfоrmerWork.TakeTheTask(driver);
        Sii_2PerfоrmerWork.ForwardWorkflowTask(driver);
        Sii_2PerfоrmerWork.SelectPostponeTheTask(driver);
        Sii_2PerfоrmerWork.EnterText(driver);
        Sii_2PerfоrmerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя 2 по отправке задачи в отложенные завершена");
    }

    /*
Работа СИ1 по возврату из отложенных в процесс
*/
    public static void ReturnOnPostpone(String r_object_id_doc) throws IOException, SQLException, InterruptedException {
        WebDriver driver;

        WaitState_no.WaitState_no(r_object_id_doc, GetStatePostponeDoc(), GetUserSii_2());
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSii_2());
        Sii_2PerfоrmerWork.PressButtonCancel(driver);
        Sii_2PerfоrmerWork.OpenTheNodePostpone(driver);
        Sii_2PerfоrmerWork.OpenTaskInPostpone(driver);
        Sii_2PerfоrmerWork.PressButtonReturnToProcessing(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя 2 по возврату задачи из отложенных завершена");
    }

    /*
Работа СИ1 по отправке задачи в архив задачи пришедшей из отложенных
 */
    public static void Postpone_SendToArchive(String r_object_id_doc,
                                              String processingGroupSii_2) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateSi_2PerformerDoc(), GetUserSii_2());
        Assert.assertEquals(processingGroupSii_2,result_temp.get(1));
        Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSii_2());
        Sii_2PerfоrmerWork.OpenTheTask(driver);
        Sii_2PerfоrmerWork.ForwardWorkflowTask(driver);
        Sii_2PerfоrmerWork.NextStageTask(driver);
        Sii_2PerfоrmerWork.EnterText(driver);
        Sii_2PerfоrmerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке в архив завершена");
    }

    /*
Работа СИИ2 по отправке задачи предыдущему исполнителю пришедшей из отложенных
*/
    public static void Postpone_SendPreviousPerformer(String r_object_id_doc, String processingGroupSii_2) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateSi_2PerformerDoc(), GetUserSii_2());
        Assert.assertEquals(processingGroupSii_2,result_temp.get(1));
        Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSii_2());
        Sii_2PerfоrmerWork.OpenTheTask(driver);
        Sii_2PerfоrmerWork.ForwardWorkflowTask(driver);
        Sii_2PerfоrmerWork.NextPreviousPerformer(driver);
        Sii_2PerfоrmerWork.EnterText(driver);
        Sii_2PerfоrmerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя 2 по отправке задачи предыдущему исполнителю завершена");
    }

    /*
Работа СИ1 по отправке задачи менеджеру пришедшей из отложенных
*/
    public static void Postpone_SendToManager(String r_object_id_doc, String processingGroupSii_2) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateSi_2PerformerDoc(), GetUserSii_2());
        Assert.assertEquals(processingGroupSii_2,result_temp.get(1));
        Assert.assertEquals(GetStateSi_2PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSii_2());
        Sii_2PerfоrmerWork.OpenTheTask(driver);
        Sii_2PerfоrmerWork.ForwardWorkflowTask(driver);
        Sii_2PerfоrmerWork.SelectSendToManager(driver);
        Sii_2PerfоrmerWork.EnterText(driver);
        Sii_2PerfоrmerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя 2 по отправке задачи менеджеру пришедшей из отложенных завершена");
    }
}