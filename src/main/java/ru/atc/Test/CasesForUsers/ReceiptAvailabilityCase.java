package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.OpenBrowser;
import ru.atc.WorkingWithBrowser.ReceiptAvailabilityControlWork;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;

public class ReceiptAvailabilityCase {
    /*
Работа логиста по заполнению номера поступления
 */
    public static void SendNextWork(String r_object_id_doc, String previousUser) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetReceiptAvailabilityGroupExternal(),result_temp.get(1));
        Assert.assertEquals(GetStateReceiptAvailabilityControlDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserLogist());
        ReceiptAvailabilityControlWork.TakeTheTask(driver);
        ReceiptAvailabilityControlWork.OpenDocumentProperties(driver);
        ReceiptAvailabilityControlWork.FillReceiptNumber(driver);
        ReceiptAvailabilityControlWork.PressOkInDocumentProperties(driver);
        ReceiptAvailabilityControlWork.ForwardWorkflowTask(driver);
        ReceiptAvailabilityControlWork.SelectReceiptAvailabilityOK(driver);
        ReceiptAvailabilityControlWork.EnterText(driver);
        ReceiptAvailabilityControlWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по логиста по заполнению номера поступления завершена");
    }

    /**
     * Работа логиста по по отправке задачи на корректировку
     * @param r_object_id_doc r_object_id документа
     * @param previousUser предыдущиц пользователь
     */
    public static void SendToCorrection(String r_object_id_doc, String previousUser) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetReceiptAvailabilityGroupExternal(),result_temp.get(1));
        Assert.assertEquals(GetStateReceiptAvailabilityControlDoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserLogist());
        ReceiptAvailabilityControlWork.TakeTheTask(driver);
        ReceiptAvailabilityControlWork.ForwardWorkflowTask(driver);
        ReceiptAvailabilityControlWork.SelectTaskOnCorrection(driver);
        ReceiptAvailabilityControlWork.EnterText(driver);
        ReceiptAvailabilityControlWork.PressButtonOK(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по логиста по отправке задачи на корректировку завершена");
    }

}
