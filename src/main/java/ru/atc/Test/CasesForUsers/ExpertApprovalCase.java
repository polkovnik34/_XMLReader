package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.ExpertWork;
import ru.atc.WorkingWithBrowser.OpenBrowser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;

public class ExpertApprovalCase {
    /*
Отправка пакета экспертом дальше по процессу
 */
    public static void ApprovalWork(String r_object_id_doc, String previousUser) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(GetUserExpert(),result_temp.get(1));
        Assert.assertEquals(GetStateExpertDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpert());
        ExpertWork.OpenTaskCard(driver);
        ExpertWork.PressConfirmPO(driver);
        ExpertWork.PressOKSelectConfirmPOCard(driver);
        ExpertWork.ForwardWorkflowTask(driver);
        ExpertWork.NextStageTask(driver);
        ExpertWork.EnterText(driver);
        ExpertWork.PressButtonOKSelectionOFTasks(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по акцептованию экспертом завершена");
    }

    /*
Отправка пакета экспертом на корректировку
*/
    public static void SendToCorrection(String r_object_id_doc, String previousUser) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetUserExpert(),result_temp.get(1));
        Assert.assertEquals(GetStateExpertDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpert());
        ExpertWork.OpenTaskCard(driver);
        ExpertWork.ForwardWorkflowTask(driver);
        ExpertWork.SelectTaskOnCorrection(driver);
        ExpertWork.EnterText(driver);
        ExpertWork.PressButtonOKSelectionOFTasks(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по отправки задачи экспертом на корректировку завершена");
    }

    /**
     * выбор определенной ЗП и отправка задача дальше
     * @param r_object_id_doc r_object_id документа в задаче
     * @param previousUser предыдущий исполнитель
     * @param oldPo_num старый номер ЗП с которого нужно убрать отметку
     * @param newPo_num новый номер ЗП который нужно выбрать.
     */
    public static void CheckNewPoNumber(String r_object_id_doc, String previousUser, String oldPo_num, String newPo_num) throws InterruptedException, SQLException, IOException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetUserExpert(),result_temp.get(1));
        Assert.assertEquals(GetStateExpertDoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpert());
        ExpertWork.OpenTaskCard(driver);
        ExpertWork.PressConfirmPO(driver);
        ExpertWork.SelectConfirmPO(driver, oldPo_num);
        ExpertWork.SelectConfirmPO(driver, newPo_num);
        ExpertWork.PressOKSelectConfirmPOCard(driver);
        ExpertWork.ForwardWorkflowTask(driver);
        ExpertWork.NextStageTask(driver);
        ExpertWork.EnterText(driver);
        ExpertWork.PressButtonOKSelectionOFTasks(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача эксперта по выбору новой ЗП и отправке дальше завершена");
    }






    /*
Отправка пакета экспертом на корректировку из задачи "На доработке у эксперта"
*/
    public static void ReworkSendToCorrection(String r_object_id_doc, String previousUser) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetUserExpert(),result_temp.get(1));
        Assert.assertEquals(GetStateExpertRework(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpert());
        ExpertWork.OpenTaskCard(driver);
        ExpertWork.ForwardWorkflowTask(driver);
        ExpertWork.SelectTaskOnCorrection2(driver);
        ExpertWork.EnterText(driver);
        ExpertWork.PressButtonOKSelectionOFTasks(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по отправки задачи экспертом на корректировку завершена");
    }

    /*
Отправка пакета экспертом предыдущему исполнителю из задачи "На доработке у эксперта"
*/
    public static void ReworkSendToPreviousUser(String r_object_id_doc, String previousUser) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetUserExpert(),result_temp.get(1));
        Assert.assertEquals(GetStateExpertRework(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpert());
        ExpertWork.OpenTaskCard(driver);
        ExpertWork.ForwardWorkflowTask(driver);
        ExpertWork.CheckReturnToPreviousPerformer(driver);
        ExpertWork.EnterText(driver);
        ExpertWork.PressButtonOKSelectionOFTasks(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по отправки задачи экспертом на корректировку завершена");
    }


}
