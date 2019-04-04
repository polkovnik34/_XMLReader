package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.ExpertRework;
import ru.atc.WorkingWithBrowser.OpenBrowser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;

public class ExpertReworkCase {
    /*
Отправка пакета экспертом дальше на корректировку
*/
    public static void SendToCorrection(String r_object_id_doc, String previousUser) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(GetUserExpert(),result_temp.get(1));
        Assert.assertEquals(GetStateExpertRework(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpert());
        ExpertRework.OpenTaskCard(driver);
        ExpertRework.ForwardWorkflowTask(driver);
        ExpertRework.SelectTaskOnCorrection(driver);
        ExpertRework.EnterText(driver);
        ExpertRework.PressButtonOKSelectionOFTasks(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по отправке дальше на корректировку завершена");
    }

    /*
Отправка пакета экспертом предыдущему исполнителем завершена
*/
    public static void SendToPreviousPerformer(String r_object_id_doc, String previousUser) throws InterruptedException, IOException, SQLException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);

        Assert.assertEquals(GetUserExpert(),result_temp.get(1));
        Assert.assertEquals(GetStateExpertRework(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpert());
        ExpertRework.OpenTaskCard(driver);
        ExpertRework.ForwardWorkflowTask(driver);
        ExpertRework.SelectPreviousPerformer(driver);
        ExpertRework.EnterText(driver);
        ExpertRework.PressButtonOKSelectionOFTasks(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Отправка экспертом задачи предыдущему исполнителю завершена");
    }


}
