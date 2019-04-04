package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.atc.WorkingWithBrowser.ExpertRequestInformationWork;
import ru.atc.WorkingWithBrowser.OpenBrowser;

import java.io.IOException;

import static ru.atc.GetProperties.*;

public class ExpertRequestInformationCase {

    //Эксперт принимает открывает задачу "Запрос информации" и отправляет обратно исполнителям закупок
    public static void ReturnWork(String r_object_id_doc) throws IOException {
        WebDriver driver;
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpertRequestInformation());
        ExpertRequestInformationWork.OpenTaskCard(driver);
        ExpertRequestInformationWork.ForwardReturnWorkflowTask(driver);
        ExpertRequestInformationWork.PressOkInWarningWindow(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача Эксперта по отправке задачи -=Запрос информации=- обратно в закупки завершена");
    }
}
