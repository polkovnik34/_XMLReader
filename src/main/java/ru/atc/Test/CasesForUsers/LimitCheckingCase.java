package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.LimitCheckingPurchaseWork;
import ru.atc.WorkingWithBrowser.OpenBrowser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;
import static ru.atc.GetProperties.GetUserLimitChecking;

public class LimitCheckingCase {
    /**
     * работа исполнителем закупок по отправки задачи "На контроль лимита" на корректировку
     * @param r_object_id_doc r_object_id документа
     * @param previousUser предыдущий пользователь
     */
    public static void SendToCorrection(String r_object_id_doc, String previousUser, String processingGroupPerformerWork) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateLimitChecking(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserLimitChecking());

        LimitCheckingPurchaseWork.TakeTheTask(driver);
        LimitCheckingPurchaseWork.ForwardWorkflowTask(driver);
        LimitCheckingPurchaseWork.SelectTaskOnCorrection(driver);
        LimitCheckingPurchaseWork.EnterText(driver);
        LimitCheckingPurchaseWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Отправка задачи На контроле лимита на корректировку завершена");
    }

    /**
     * работа исполнителем закупок по отправки задачи "На контроль лимита" на дальше по процессу
     * @param r_object_id_doc r_object_id документа
     * @param previousUser предыдущий пользователь
     */
    public static void ConfirmPoWork(String r_object_id_doc, String previousUser, String processingGroupPerformerWork) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateLimitChecking(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserLimitChecking());

        LimitCheckingPurchaseWork.TakeTheTask(driver);
        LimitCheckingPurchaseWork.PressConfirmPO(driver);
        LimitCheckingPurchaseWork.PressOKSelectConfirmPOCard(driver);
        LimitCheckingPurchaseWork.ForwardWorkflowTask(driver);
        LimitCheckingPurchaseWork.NextStageTask(driver);
        LimitCheckingPurchaseWork.EnterText(driver);
        LimitCheckingPurchaseWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Отправка задачи На контроле лимита дальше по процессу завершена");
    }

    /**
     * работа исполнителем закупок по выбору другой ЗП и отправки задачи "На кортроль лимита" на дальше по процессу
     * @param r_object_id_doc r_object_id документа
     * @param previousUser предыдущий пользователь
     * @param newPo_num новый номер ЗП
     * @param oldPo_num старый номер ЗП
     */
    public static void ConfirmNewPoWork(String r_object_id_doc,
                                        String previousUser,
                                        String newPo_num,
                                        String oldPo_num,
                                        String processingGroupPerformerWork) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateLimitChecking(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserLimitChecking());

        LimitCheckingPurchaseWork.TakeTheTask(driver);
        LimitCheckingPurchaseWork.PressConfirmPO(driver);
        LimitCheckingPurchaseWork.SelectConfirmPO(driver, oldPo_num);
        LimitCheckingPurchaseWork.SelectConfirmPO(driver, newPo_num);
        LimitCheckingPurchaseWork.PressOKSelectConfirmPOCard(driver);
        LimitCheckingPurchaseWork.ForwardWorkflowTask(driver);
        LimitCheckingPurchaseWork.NextStageTask(driver);
        LimitCheckingPurchaseWork.EnterText(driver);
        LimitCheckingPurchaseWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Отправка задачи На контроле лимита с другой ЗП завершена");
    }

    /**
     * работа исполнителем закупок по выбору другой ЗП и отправки задачи "На кортроль лимита" на дальше по процессу
     * @param r_object_id_doc r_object_id документа
     * @param previousUser предыдущий пользователь
     * @param newPo_num новый номер ЗП
     */
    public static void CheckRadioNewPoWork(String r_object_id_doc,
                                           String previousUser,
                                           String newPo_num,
                                           String processingGroupPerformerWork) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateLimitChecking(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserLimitChecking());

        LimitCheckingPurchaseWork.TakeTheTask(driver);
        LimitCheckingPurchaseWork.PressConfirmPO(driver);
        LimitCheckingPurchaseWork.CheckRadioNewPoNum(driver, newPo_num);
        LimitCheckingPurchaseWork.PressOKSelectConfirmPOCard(driver);
        LimitCheckingPurchaseWork.ForwardWorkflowTask(driver);
        LimitCheckingPurchaseWork.NextStageTask(driver);
        LimitCheckingPurchaseWork.EnterText(driver);
        LimitCheckingPurchaseWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Отправка задачи На контроле лимита по указанию новового номера ЗП завершена");
    }

    /**
     * работа исполнителем закупок по выбору нескольких ЗП и отправке дальше по процессу
     * @param r_object_id_doc r_object_id документа
     * @param previousUser предыдущий пользователь
     * @param newPo_num новый номер ЗП
     * @param summ разбивка суммы на несколько ЗП
     */
    public static void Confirm2PoWork(String r_object_id_doc,
                                      String previousUser,
                                      String newPo_num,
                                      String oldPo_num,
                                      String summ,
                                      String processingGroupPerformerWork) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateLimitChecking(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserLimitChecking());

        LimitCheckingPurchaseWork.TakeTheTask(driver);
        LimitCheckingPurchaseWork.PressConfirmPO(driver);
        LimitCheckingPurchaseWork.SelectConfirmPO(driver, newPo_num);
        LimitCheckingPurchaseWork.SpecifyAmount(driver, newPo_num, summ);
        LimitCheckingPurchaseWork.SpecifyAmount(driver, oldPo_num, summ);
        LimitCheckingPurchaseWork.PressOKSelectConfirmPOCard(driver);
        LimitCheckingPurchaseWork.ForwardWorkflowTask(driver);
        LimitCheckingPurchaseWork.NextStageTask(driver);
        LimitCheckingPurchaseWork.EnterText(driver);
        LimitCheckingPurchaseWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Отправка задачи На контроле лимита с несколькими ЗП завершена");
    }

    /**
     * работа исполнителем закупок по выбору другой ЗП и отправки задачи "На кортроль лимита" дальше по процессу по профилю АР_Дилеры
     * @param r_object_id_doc r_object_id документа
     * @param previousUser предыдущий пользователь
     * @param newPo_num новый номер ЗП
     */
    public static void ConfirmNewPoDealerWork(String r_object_id_doc,
                                              String previousUser,
                                              String newPo_num,
                                              String processingGroupPerformerWork) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateLimitChecking(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserLimitChecking());

        LimitCheckingPurchaseWork.TakeTheTask(driver);
        LimitCheckingPurchaseWork.PressConfirmPO(driver);
        LimitCheckingPurchaseWork.SelectConfirmPORadio(driver, newPo_num);
        LimitCheckingPurchaseWork.PressOKSelectConfirmPOCard(driver);
        LimitCheckingPurchaseWork.ForwardWorkflowTask(driver);
        LimitCheckingPurchaseWork.NextStageTask(driver);
        LimitCheckingPurchaseWork.EnterText(driver);
        LimitCheckingPurchaseWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Отправка задачи На контроле лимита с другой ЗП завершена");
    }

}
