package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.OpenBrowser;
import ru.atc.WorkingWithBrowser.ReceiptAvailabilityControlWork;
import ru.atc.WorkingWithBrowser.SigningInitiatorWork;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;

public class InitiatorSigningCase {
    /*
Работа инициатора по простановке подписи в документе и отправке дальше
 */
    public static void SigningWork(String r_object_id_doc , String previousUser) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetInitiatorGroupExternal(),result_temp.get(1));
        Assert.assertEquals(GetStateSigningDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSigning());
        SigningInitiatorWork.TakeTheTask(driver);
        SigningInitiatorWork.OpenDocumentProperties(driver);
        SigningInitiatorWork.SelectSignOK(driver);
        SigningInitiatorWork.PressOkInDocumentProperties(driver);
        SigningInitiatorWork.ForwardWorkflowTask(driver);
        SigningInitiatorWork.NextStageTask(driver);
        SigningInitiatorWork.EnterText(driver);
        SigningInitiatorWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по подписанию завершена");
    }

    /**
     * отправка задачи дальше, без простановки подписи в карточке документа
     * @param r_object_id_doc ID документа
     * @param previousUser предыдущий исполнитель
\     */
    public static void SendNoSigningWork(String r_object_id_doc , String previousUser) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetInitiatorGroupExternal(),result_temp.get(1));
        Assert.assertEquals(GetStateSigningDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSigning());
        SigningInitiatorWork.TakeTheTask(driver);
        SigningInitiatorWork.ForwardWorkflowTask(driver);
        SigningInitiatorWork.NextStageTask(driver);
        SigningInitiatorWork.EnterText(driver);
        SigningInitiatorWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по непроставлению подписи и отправке задачи дальше завершена");
    }

    /*
    работа инициатора по отправке на корректировку
     */
    public static void SendToCorrection(String r_object_id_doc, String previousUser) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetInitiatorGroupExternal(),result_temp.get(1));
        Assert.assertEquals(GetStateSigningDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserSigning());
        SigningInitiatorWork.TakeTheTask(driver);
        SigningInitiatorWork.ForwardWorkflowTask(driver);
        SigningInitiatorWork.SelectTaskOnCorrection(driver);
        SigningInitiatorWork.EnterText(driver);
        SigningInitiatorWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача инициатора в задаче На пописании по отправке на корректировку завершена");
    }


}
