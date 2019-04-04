package ru.atc.Test.CasesForUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.CBOUserWork;
import ru.atc.WorkingWithBrowser.CboOptionalExpertWork;
import ru.atc.WorkingWithBrowser.OpenBrowser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static ru.atc.GetProperties.*;
import static ru.atc.WorkingWithBrowser.CBOUserWork.*;

public class CBOCase {
    /*
Работа владельцем ЦБО по акцептованию задачи
 */
    public static void AcceptTheTask(String r_object_id_doc, String choiceOption, String previousUser) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetUserCbo(),result_temp.get(1));
        Assert.assertEquals(GetStateCBODoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserCbo());
        CBOUserWork.OpenTaskCard(driver);
        PressButtonDecision(driver);
        CBOUserWork.MakeDecision(driver, choiceOption);
        CBOUserWork.EnterText(driver);
        PressOk(driver);
        ((ChromeDriver) driver).findElementById("MainEx_view_0");
        driver.close();
        driver.quit();
        System.out.println("Задача по акцептованию Владельцем ЦБО завершена");
    }

    /*
    работа владельцем ЦБО по откладыванию задачи и добавления опционального эксперта
     */
    public static void AddOptionalExpert(String r_object_id_doc, String previousUser) throws IOException, SQLException, InterruptedException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetUserCbo(),result_temp.get(1));
        Assert.assertEquals(GetStateCBODoc(),result_temp.get(0));
        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserCbo());

        OpenTaskCard(driver);
        PressButtonDecision(driver);
        chooseAnExpert(driver, GetUserExpertChooseAnCBO());
        driver.switchTo().frame(0).switchTo().frame(0);
        PressOk(driver);

        //доделать проверку того не вылезла ошибка в вебтопе
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);

        PressButtonCancel(driver);

        driver.switchTo().defaultContent();
        ((ChromeDriver) driver).findElementById("MainEx_view_0");

        driver.close();
        driver.quit();
        System.out.println("Задача владельца ЦБО по откладыванию задачи и добавления опционального эксперта завершена");
    }

    /*
Работа опционального эксперта
 */
    public static void OptionalExpertWork(String r_object_id_doc, String choiceOption, String previousUser) throws SQLException, InterruptedException, IOException {
        ArrayList result_temp;
        WebDriver driver;

        result_temp = ParsInBD.WaitNewFW_and_StateNo(previousUser, r_object_id_doc);
        Assert.assertEquals(GetUserExpertChooseAnCBO(),result_temp.get(1));
        Assert.assertEquals(GetStateCBODoc(),result_temp.get(0));

        driver = OpenBrowser.OpenBrowser(r_object_id_doc, GetUserExpertChooseAnCBO());
        CboOptionalExpertWork.OpenTaskCard(driver);
        CboOptionalExpertWork.PressButtonDecision(driver);
        CboOptionalExpertWork.MakeDecision(driver,choiceOption);
        CboOptionalExpertWork.EnterText(driver);
        CboOptionalExpertWork.PressOk(driver);
        driver.close();
        driver.quit();
        System.out.println("Работа опционального эксперта по отклонению задачи завершена");
    }

}
