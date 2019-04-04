package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.ReadInDB;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.InitiatorZkWork;
import ru.atc.WorkingWithBrowser.OpenBrowser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;
import static ru.atc.GetProperties.GetUserInitZk;

public class InitiatorZkCase {

    /*
    Работа инициатора по подтверждению ЗП
    */
    public static void ConfirmPoWork(String r_object_id_doc, String po_num, String processingGroupInitiatorWork) throws IOException, SQLException {
        WebDriver driver;

        Assert.assertEquals(processingGroupInitiatorWork, ReadInDB.GetSql_WF(r_object_id_doc));
        Assert.assertEquals(GetStateRequest_VerifyingDoc(), ReadInDB.GetSql_DocSateNo(r_object_id_doc));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserInitZk());
        InitiatorZkWork.TakeTheTask(driver);
        InitiatorZkWork.PressConfirmPO(driver);
        InitiatorZkWork.SelectConfirmPO(driver, po_num);
        InitiatorZkWork.PressOKSelectConfirmPOCard(driver);
        InitiatorZkWork.ForwardWorkflowTask(driver);
        InitiatorZkWork.CheckNextStageTask(driver);
        InitiatorZkWork.EnterText(driver);
        InitiatorZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по подтверждению ЗП завершена");
    }

    /*
Работа инициатора по подтверждению ЗП по профилю Региональные Дилеры
*/
    public static void ConfirmPoDealerWork(String r_object_id_doc, String po_num, String processingGroupInitiatorWork) throws IOException, SQLException {
        WebDriver driver;

        Assert.assertEquals(processingGroupInitiatorWork, ReadInDB.GetSql_WF(r_object_id_doc));
        Assert.assertEquals(GetStateRequest_VerifyingDoc(), ReadInDB.GetSql_DocSateNo(r_object_id_doc));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserInitZk());
        InitiatorZkWork.TakeTheTask(driver);
        InitiatorZkWork.PressConfirmPO(driver);
        InitiatorZkWork.SelectConfirmPORadio(driver, po_num);
        InitiatorZkWork.PressOKSelectConfirmPOCard(driver);
        InitiatorZkWork.ForwardWorkflowTask(driver);
        InitiatorZkWork.CheckNextStageTask(driver);
        InitiatorZkWork.EnterText(driver);
        InitiatorZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по подтверждению ЗП завершена");
    }

    /*
Работа инициатора по отправке задачи в закупки, не подтверждая ЗП
 */
    public  static void SendTaskToPurchase(String r_object_id_doc, String processingGroupInitiatorWork) throws IOException, SQLException {
        WebDriver driver;

        Assert.assertEquals(processingGroupInitiatorWork,ReadInDB.GetSql_WF(r_object_id_doc));
        Assert.assertEquals(GetStateRequest_VerifyingDoc(), ReadInDB.GetSql_DocSateNo(r_object_id_doc));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserInitZk());

        InitiatorZkWork.TakeTheTask(driver);
        InitiatorZkWork.PressConfirmPO(driver);
        InitiatorZkWork.SelectEmptyPoNumber(driver);
        InitiatorZkWork.PressOKSelectConfirmPOCard(driver);
        InitiatorZkWork.ForwardWorkflowTask(driver);
        InitiatorZkWork.CheckNextStageTask(driver);
        InitiatorZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по отправке документа в Закупки завершена");
    }

    /*
        Работа инициатора по подтверждению 2х ЗП
        */

    /**
     * Работа инициатора по подтверждению 2х ЗП
     * @param r_object_id_doc r_object_id документа
     * @param po_num первый номер ЗП для выбора
     * @param po_num2 второй номер ЗП для выбора
     * @param processingGroupInitiatorWork ГО инициаторов в конкретном кейсе
     */
    public static void Confirm2PoWork(String r_object_id_doc, String po_num, String po_num2, String processingGroupInitiatorWork) throws IOException, SQLException {
        //String Wf_temp;
        WebDriver driver;
        //Wf_temp = ParsInBD.WaitFirstWF(r_object_id_doc);

        Assert.assertEquals(processingGroupInitiatorWork, ReadInDB.GetSql_WF(r_object_id_doc));
        Assert.assertEquals(GetStateRequest_VerifyingDoc(), ReadInDB.GetSql_DocSateNo(r_object_id_doc));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserInitZk());
        InitiatorZkWork.TakeTheTask(driver);
        InitiatorZkWork.PressConfirmPO(driver);
        InitiatorZkWork.SelectConfirmPO(driver, po_num);
        InitiatorZkWork.SelectConfirmPO(driver, po_num2);
        InitiatorZkWork.PressOKSelectConfirmPOCard(driver);
        InitiatorZkWork.ForwardWorkflowTask(driver);
        InitiatorZkWork.CheckNextStageTask(driver);
        InitiatorZkWork.EnterText(driver);
        InitiatorZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по подтверждению ЗП завершена");
    }

    /**
     * Работа инициатора по подтверждению 2х ЗП и указанию разбивки по ЗП
     * @param r_object_id_doc r_object_id документа
     * @param po_num первый номер ЗП для выбора
     * @param po_num2 второй номер ЗП для выбора
     * @param processingGroupInitiatorWork ГО инициаторов в конкретном кейсе
     * @param sum сумма которая будет указана при разбивке
     */
    public static void Confirm2PoWork_SpecifyAmount(String r_object_id_doc,
                                                    String po_num,
                                                    String po_num2,
                                                    String processingGroupInitiatorWork,
                                                    String sum) throws IOException, SQLException, InterruptedException {
        //String Wf_temp;
        WebDriver driver;
        //Wf_temp = ParsInBD.WaitFirstWF(r_object_id_doc);

        Assert.assertEquals(processingGroupInitiatorWork, ReadInDB.GetSql_WF(r_object_id_doc));
        Assert.assertEquals(GetStateRequest_VerifyingDoc(), ReadInDB.GetSql_DocSateNo(r_object_id_doc));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserInitZk());
        InitiatorZkWork.TakeTheTask(driver);
        InitiatorZkWork.PressConfirmPO(driver);
        InitiatorZkWork.SelectConfirmPO(driver, po_num);
        InitiatorZkWork.SelectConfirmPO(driver, po_num2);
        InitiatorZkWork.SpecifyAmount(driver,po_num,sum);
        InitiatorZkWork.SpecifyAmount(driver,po_num2,sum);
        InitiatorZkWork.PressOKSelectConfirmPOCard(driver);
        InitiatorZkWork.ForwardWorkflowTask(driver);
        InitiatorZkWork.CheckNextStageTask(driver);
        InitiatorZkWork.EnterText(driver);
        InitiatorZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по подтверждению ЗП завершена");
    }
}
