package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.OpenBrowser;
import ru.atc.WorkingWithBrowser.PerformerZkWork;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;
import static ru.atc.GetProperties.GetUserPerfZk;

public class PerformerZkCase {
    /*
Работа исполнителя Закупок по отправке задачи дальше
 */
    public static void PerformerConfirmPoWork(String r_object_id_doc, String po_num, String processingGroupPerformerWork) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);
        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserPerfZk());

        PerformerZkWork.TakeTheTask(driver);
        PerformerZkWork.PressConfirmPO(driver);
        PerformerZkWork.SelectConfirmPO(driver, po_num);
        PerformerZkWork.PressOKSelectConfirmPOCard(driver);
        PerformerZkWork.PressForwardWorkflowTask(driver);
        PerformerZkWork.CheckNextStageTask(driver);
        PerformerZkWork.EnterText(driver);
        PerformerZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача исполнителя закупок по отправке задачи эксперту завершена");
    }

    /*
Работа исполнителя Закупок по отправке задачи на корректировку
*/
    public static void SendToCorrection(String r_object_id_doc, String processingGroupPerformerWork) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);
        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserPerfZk());

        PerformerZkWork.TakeTheTask(driver);
        PerformerZkWork.PressForwardWorkflowTask(driver);

        PerformerZkWork.CheckSendToCorrection(driver);

        PerformerZkWork.EnterText(driver);
        PerformerZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача исполнителя закупок по отправке задачи на корректировку завершена");
    }

    /*
Работа исполнителя Закупок по отправке задачи на "Запрос информации" Эксперту
*/
    public static void SendToExpert(String r_object_id_doc, String processingGroupPerformerWork) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);
        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserPerfZk());

        PerformerZkWork.TakeTheTask(driver);
        PerformerZkWork.PressForwardWorkflowTask(driver);

        PerformerZkWork.chooseAnExpert(driver, GetUserExpertRequestInformation());
        driver.switchTo().frame(0).switchTo().frame(0);
        PerformerZkWork.EnterText(driver);
        PerformerZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача исполнителя закупок по отправке задачи на \"Запрос информации\" Эксперту завершена");
    }

    /*
Работа исполнителя Закупок по отправке задачи менеджеру на изменение филиала
*/
    public static void SendToManager(String r_object_id_doc, String processingGroupPerformerWork) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);
        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserPerfZk());

        PerformerZkWork.TakeTheTask(driver);
        PerformerZkWork.PressForwardWorkflowTask(driver);

        PerformerZkWork.CheckSendToManager(driver);

        PerformerZkWork.EnterText(driver);
        PerformerZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача исполнителя закупок по отправке задачи менеджеру на изменение филиала завершена");
    }

    /*
Работа исполнителя Закупок по вводу нового номера ЗП и отправки на повторный поиск ЗП
*/
    public static void SendToFindNewPoNum(String r_object_id_doc, String processingGroupPerformerWork, String newPoNum) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);
        Assert.assertEquals(processingGroupPerformerWork,result_temp.get(1));
        Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserPerfZk());

        PerformerZkWork.TakeTheTask(driver);
        PerformerZkWork.PressConfirmPO(driver);
        PerformerZkWork.CheckRadioNewPoNum(driver);
        PerformerZkWork.EnterNewPoNum(driver, newPoNum);
        PerformerZkWork.PressOKSelectConfirmPOCard(driver);

        PerformerZkWork.PressForwardWorkflowTask(driver);
        PerformerZkWork.CheckNextStageTask(driver);
        PerformerZkWork.EnterText(driver);
        PerformerZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача исполнителя закупок по вводу нового номера ЗП и отправки на повторный поиск ЗП завершена");
    }

    /*
Работа исполнителя Закупок по подтверждению двух ЗП
*/
    public static void PerformerConfirm2PoWork(String r_object_id_doc, String po_num, String po_num2) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);
        Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
        Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserPerfZk());

        PerformerZkWork.TakeTheTask(driver);
        PerformerZkWork.PressConfirmPO(driver);

        PerformerZkWork.SelectConfirmPO(driver, po_num);
        PerformerZkWork.SelectConfirmPO(driver, po_num2);

        PerformerZkWork.PressOKSelectConfirmPOCard(driver);
        PerformerZkWork.PressForwardWorkflowTask(driver);
        PerformerZkWork.CheckNextStageTask(driver);
        PerformerZkWork.EnterText(driver);
        PerformerZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача исполнителя закупок по подтверждению двух ЗП завершена");
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
        WebDriver driver;
        ArrayList result_temp;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);

        Assert.assertEquals(GetPerformerGroupExternal(),result_temp.get(1));
        Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserPerfZk());
        PerformerZkWork.TakeTheTask(driver);
        PerformerZkWork.PressConfirmPO(driver);
        PerformerZkWork.SelectConfirmPO(driver, po_num);
        PerformerZkWork.SelectConfirmPO(driver, po_num2);
        PerformerZkWork.SpecifyAmount(driver,po_num,sum);
        PerformerZkWork.SpecifyAmount(driver,po_num2,sum);
        PerformerZkWork.PressOKSelectConfirmPOCard(driver);
        PerformerZkWork.PressForwardWorkflowTask(driver);
        PerformerZkWork.CheckNextStageTask(driver);
        PerformerZkWork.EnterText(driver);
        PerformerZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по подтверждению ЗП завершена");
    }

    /*
Работа исполнителя Закупок по подтверждению ЗП для профиля Ар рег дилеры
*/
    public static void PerformerConfirmPoWorkDealer(String r_object_id_doc, String po_Num, String processingGroupInitiatorWork) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(GetUserInitZk(), r_object_id_doc);
        Assert.assertEquals(processingGroupInitiatorWork,result_temp.get(1));
        Assert.assertEquals(GetStateRequestVerifyingCreating(), result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserPerfZk());

        PerformerZkWork.TakeTheTask(driver);
        PerformerZkWork.PressConfirmPO(driver);

        PerformerZkWork.SelectConfirmPORadio(driver, po_Num);

        PerformerZkWork.PressOKSelectConfirmPOCard(driver);
        PerformerZkWork.PressForwardWorkflowTask(driver);
        PerformerZkWork.CheckNextStageTask(driver);
        PerformerZkWork.EnterText(driver);
        PerformerZkWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача исполнителя закупок по подтверждению ЗП завершена");
    }

}
