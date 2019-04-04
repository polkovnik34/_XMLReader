package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.OpenBrowser;
import ru.atc.WorkingWithBrowser.Si_1PerformerWork;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;
import static ru.atc.GetProperties.GetUserCorrection;

public class Si1_Case {
    /*
Работа СИ1 по отправке задачи в архив
 */
    public static void SendToArchive(String r_object_id_doc,
                                     String processingGroupSi_1,
                                     String previousPerformer) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
        Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
        Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.TakeTheTask(driver);
        Si_1PerformerWork.ForwardWorkflowTask(driver);
        Si_1PerformerWork.NextStageTask(driver);
        Si_1PerformerWork.EnterText(driver);
        Si_1PerformerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке в архив завершена");
    }

    /*
Работа СИ1 по отправке задачи в архив
*/
    public static void SendToCorrection(String r_object_id_doc, String processingGroupSi_1, String previousPerformer) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
        Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
        Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.TakeTheTask(driver);
        Si_1PerformerWork.ForwardWorkflowTask(driver);
        Si_1PerformerWork.SelectTaskOnCorrection(driver);
        Si_1PerformerWork.EnterText(driver);
        Si_1PerformerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке на корректировку завершена");
    }

    /*
Работа СИ1 по отправке задачи менеджеру
*/
    public static void SendToManager(String r_object_id_doc, String processingGroupSi_1, String previousPerformer) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
        Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
        Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.TakeTheTask(driver);
        Si_1PerformerWork.ForwardWorkflowTask(driver);
        Si_1PerformerWork.SelectSendToManager(driver);
        Si_1PerformerWork.EnterText(driver);
        Si_1PerformerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке задачи Скорректировать процесс / группу обработки завершена");
    }

    /*
Работа СИ1 по отправке задачи в СИИ2
*/
    public static void SendToSii2(String r_object_id_doc, String processingGroupSi_1, String previousPerformer) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
        Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
        Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.TakeTheTask(driver);
        Si_1PerformerWork.ForwardWorkflowTask(driver);

        Si_1PerformerWork.NextStageSii2(driver);

        Si_1PerformerWork.EnterText(driver);
        Si_1PerformerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке задачи /Отправить исполнителю 2 на обработку/ завершена");
    }

    /*
Работа СИ1 по отправке задачи в отложенные
*/
        public static void SendToPostpone(String r_object_id_doc, String processingGroupSi_1, String previousPerformer) throws IOException, SQLException, InterruptedException {
            ArrayList result_temp;
            WebDriver driver;

            result_temp = ParsInBD.WaitNewFW_and_StateNo(previousPerformer, r_object_id_doc);
            Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
            Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));
            driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());

            Si_1PerformerWork.TakeTheTask(driver);
            Si_1PerformerWork.ForwardWorkflowTask(driver);
            Si_1PerformerWork.SelectPostponeTheTask(driver);
            Si_1PerformerWork.EnterText(driver);
            Si_1PerformerWork.PressButtonOK(driver);
            ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке задачи в отложенные завершена");
    }

    /*
Работа СИ1 по возврату из отложенных в процесс
*/
    public static void ReturnOnPostpone(String r_object_id_doc, String processingGroupSi_1, String previousPerformer) throws IOException, SQLException, InterruptedException {
        WebDriver driver;

        WaitState_no.WaitState_no(r_object_id_doc, GetStatePostponeDoc(), GetUserSi_1());
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.PressButtonCancel(driver);
        Si_1PerformerWork.OpenTheNodePostpone(driver);
        Si_1PerformerWork.OpenTaskInPostpone(driver);
        Si_1PerformerWork.PressButtonReturnToProcessing(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по возврату задачи из отложенных завершена");
    }

    /*
Работа СИ1 по отправке задачи в архив задачи пришедшей из отложенных
 */
    public static void Postpone_SendToArchive(String r_object_id_doc,
                                     String processingGroupSi_1) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateSi_1PerformerDoc(), GetUserSi_1());
        Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
        Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.OpenTheTask(driver);
        Si_1PerformerWork.ForwardWorkflowTask(driver);
        Si_1PerformerWork.NextStageTask(driver);
        Si_1PerformerWork.EnterText(driver);
        Si_1PerformerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке в архив завершена");
    }

    /*
Работа СИ1 по отправке задачи в архив пришедшей из отложенных
*/
    public static void Postpone_SendToCorrection(String r_object_id_doc, String processingGroupSi_1) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateSi_1PerformerDoc(), GetUserSi_1());
        Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
        Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.OpenTheTask(driver);
        Si_1PerformerWork.ForwardWorkflowTask(driver);
        Si_1PerformerWork.SelectTaskOnCorrection(driver);
        Si_1PerformerWork.EnterText(driver);
        Si_1PerformerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке на корректировку завершена");
    }

    /*
Работа СИ1 по отправке задачи менеджеру пришедшей из отложенных
*/
    public static void Postpone_SendToManager(String r_object_id_doc, String processingGroupSi_1) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateSi_1PerformerDoc(), GetUserSi_1());
        Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
        Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.OpenTheTask(driver);
        Si_1PerformerWork.ForwardWorkflowTask(driver);
        Si_1PerformerWork.SelectSendToManager(driver);
        Si_1PerformerWork.EnterText(driver);
        Si_1PerformerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке задачи Скорректировать процесс / группу обработки завершена");
    }

    /*
Работа СИ1 по отправке задачи в Сии2 пришедшей из отложенных
*/
    public static void Postpone_SendToSii2(String r_object_id_doc, String processingGroupSi_1) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitState_no(r_object_id_doc, GetStateSi_1PerformerDoc(), GetUserSi_1());
        Assert.assertEquals(processingGroupSi_1,result_temp.get(1));
        Assert.assertEquals(GetStateSi_1PerformerDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSi_1());
        Si_1PerformerWork.OpenTheTask(driver);
        Si_1PerformerWork.ForwardWorkflowTask(driver);
        Si_1PerformerWork.NextStageSii2(driver);
        Si_1PerformerWork.EnterText(driver);
        Si_1PerformerWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по исполнителя по отправке задачи из отложенных /Исполнителю 2/ завершена");
    }

}
